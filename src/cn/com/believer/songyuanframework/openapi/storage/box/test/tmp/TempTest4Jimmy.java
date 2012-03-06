/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.test.tmp;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import cn.com.believer.songyuanframework.openapi.storage.box.BoxExternalAPI;
import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetUpdatesRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetUpdatesResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.core.BoxHTTPManager;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author jimmy
 * 
 */
public class TempTest4Jimmy {

    static String correctTicket;
    static BoxExternalAPI boxExternalAPI = new SimpleBoxImpl();

    /**
     * @param args
     * @throws BoxException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, BoxException {
        String apiKey = "e7ak8t2je0rxoq97k9sl2fh2mld1dn6x";

        GetAuthTokenResponse getAuthTokenResponse;
        GetAuthTokenRequest getAuthTokenRequest;
        getAuthTokenResponse = simAuthentication("paranoid945@gmail.com", "6343011", apiKey);
        String authToken = getAuthTokenResponse.getAuthToken();

        GetAccountTreeResponse getAccountTreeResponse;
        GetAccountTreeRequest getAccountTreeRequest;
        String[] gatActTreeParams = { "nozip" };
        getAccountTreeRequest = BoxRequestFactory.createGetAccountTreeRequest(apiKey, authToken, "0", gatActTreeParams);

        // get account tree
//        getAccountTreeResponse = boxExternalAPI.getAccountTree(getAccountTreeRequest);

        // get updates
        GetUpdatesResponse getUpdatesResponse;
        GetUpdatesRequest getUpdatesRequest;

        getUpdatesRequest = BoxRequestFactory.createGetUpdatesRequest(apiKey, authToken, "0", String.valueOf(System
                .currentTimeMillis()), new String[] { "nozip" });
        getUpdatesResponse = boxExternalAPI.getUpdates(getUpdatesRequest);

        // search
        SearchResponse searchResponse;
        SearchRequest searchRequest;
        searchRequest = BoxRequestFactory.createSearchRequest(apiKey, authToken, "java", 1, 10, "relevance", "asc",
                new String[] { "show_description", "show_path" });
        searchResponse = boxExternalAPI.search(searchRequest);
        System.out.println();
    }

    private static GetAuthTokenResponse simAuthentication(String boxUName, String boxPWord, String apiKey)
            throws IOException, BoxException {
        GetTicketRequest getTicketRequest = BoxRequestFactory.createGetTicketRequest(apiKey);
        GetTicketResponse getTicketResponse = boxExternalAPI.getTicket(getTicketRequest);
        if (!BoxConstant.STATUS_GET_TICKET_OK.equals(getTicketResponse.getStatus())) {
            GetAuthTokenResponse getAuthTokenResponse = BoxResponseFactory.createGetAuthTokenResponse();
            getAuthTokenResponse.setStatus(getTicketResponse.getStatus());
            correctTicket = getTicketResponse.getTicket();
            return getAuthTokenResponse;
        } else {
            Properties config = BoxHTTPManager.getBoxHTTPManager().getConfig();
            String apiUrlPrefix = config.getProperty(BoxConstant.CONFIG_API_URL_PREFIX);
            String apiVersion = config.getProperty(BoxConstant.CONFIG_API_VERSION);

            // first redirect that page
            HttpClient hc = new HttpClient();

            StringBuffer urlBuff = new StringBuffer();
            urlBuff.append(apiUrlPrefix);
            urlBuff.append(BoxConstant.SLASH_STRING);
            urlBuff.append(apiVersion);
            urlBuff.append(BoxConstant.SLASH_STRING);
            urlBuff.append(BoxConstant.AUTH_URL_STRING);
            urlBuff.append(BoxConstant.SLASH_STRING);
            urlBuff.append(getTicketResponse.getTicket());
            GetMethod gMethod = new GetMethod(urlBuff.toString());
            hc.executeMethod(gMethod);

            // login use username/password
            PostMethod pMethod = new PostMethod(urlBuff.toString());

            NameValuePair unamePair = new NameValuePair("login", boxUName);
            NameValuePair pwordPair = new NameValuePair("password", boxPWord);
            NameValuePair dologinPair = new NameValuePair("dologin", "1");
            pMethod.setRequestBody(new NameValuePair[] { unamePair, pwordPair, dologinPair });
            pMethod.addRequestHeader("Referer", urlBuff.toString());
            hc.executeMethod(pMethod);

            GetAuthTokenRequest getAuthTokenRequest = BoxRequestFactory.createGetAuthTokenRequest(apiKey,
                    getTicketResponse.getTicket());
            GetAuthTokenResponse getAuthTokenResponse = boxExternalAPI.getAuthToken(getAuthTokenRequest);
            return getAuthTokenResponse;
        }
    }
}
