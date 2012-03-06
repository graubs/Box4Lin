package cn.com.believer.songyuanframework.openapi.storage.box.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.com.believer.songyuanframework.openapi.storage.box.BoxExternalAPI;
import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountInfoRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountInfoResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountTreeResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAuthTokenResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetTicketResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * 
 * @author Jimmy Jia
 * 
 */
public class ListFilesExample {

    /**
     * @param args
     *            no use
     */
    public static void main(String[] args) {

        // the global API interface
        BoxExternalAPI iBoxExternalAPI = new SimpleBoxImpl();

        // get user's API key
        System.out
                .println(">>>>>>>>>>> Please enter your API key, it should be like 'e7ak8t2je0rxoq97k9sl2fh2mld1xxxx'");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String apiKey = null;
        try {
            apiKey = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // get a ticket by API key.
            GetTicketRequest getTicketRequest = BoxRequestFactory.createGetTicketRequest(apiKey);
            GetTicketResponse getTicketResponse = iBoxExternalAPI.getTicket(getTicketRequest);

            // after you get the ticket, you need to navigate to the URL
            // http://www.box.net/api/1.0/auth/<ticket> to enter the user name and password to authenticate.
            System.out.println(">>>>>>>>>>> Your ticket is " + getTicketResponse.getTicket());
            System.out.println(">>>>>>>>>>> please authenticate from this URL: http://www.box.net/api/1.0/auth/"
                    + getTicketResponse.getTicket());
            System.out.println(">>>>>>>>>>> press enter after you are authenticated from box.net page.");
            br = new BufferedReader(new InputStreamReader(System.in));
            try {
                br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            GetAuthTokenRequest getAuthTokenRequest = BoxRequestFactory.createGetAuthTokenRequest(apiKey,
                    getTicketResponse.getTicket());
            GetAuthTokenResponse getAuthTokenResponse = iBoxExternalAPI.getAuthToken(getAuthTokenRequest);

            if (BoxConstant.STATUS_NOT_LOGGED_IN.equals(getAuthTokenResponse.getStatus())) {
                return;
            }
            String authToken = getAuthTokenResponse.getAuthToken();

            // get account file/folder tree structure
            String[] params = { "nozip", "simple" };
            GetAccountTreeRequest getAccountTreeRequest = BoxRequestFactory.createGetAccountTreeRequest(apiKey,
                    authToken, "0", params);
            GetAccountTreeResponse getAccountTreeResponse = iBoxExternalAPI.getAccountTree(getAccountTreeRequest);

            System.out.println(getAccountTreeResponse.getStatus());

            // test get_account_info
            GetAccountInfoRequest getAccountInfoRequest = BoxRequestFactory.createGetAccountInfoRequest(apiKey,
                    authToken);
            GetAccountInfoResponse getAccountInfoResponse = iBoxExternalAPI.getAccountInfo(getAccountInfoRequest);

            System.out.println(getAccountInfoResponse.getStatus());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BoxException e) {
            e.printStackTrace();
        }

    }

}
