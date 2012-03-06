/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxObjectFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxFile;

/**
 * @author jjia
 * 
 */
public class SearchMethod extends BaseBoxMethod {

    /**
     * @param searchRequest
     *            search request
     * @return search response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public SearchResponse search(SearchRequest searchRequest) throws IOException, BoxException {
        SearchResponse searchResponse = BoxResponseFactory.createSearchResponse();

        String apiKey = searchRequest.getApiKey();
        String authToken = searchRequest.getAuthToken();
        String query = searchRequest.getQuery();
        long page = searchRequest.getPage();
        long perPage = searchRequest.getPerPage();
        String sort = searchRequest.getSort();
        String direction = searchRequest.getDirection();
        String[] params = searchRequest.getParams();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super.getRestUrl(searchRequest.getActionName());
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_API_KEY, apiKey);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_AUTH_TOKEN, authToken);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_QUERY, query);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_PAGE, String.valueOf(page));
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_PER_PAGE, String.valueOf(perPage));
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_SORT, sort);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_DIRECTION, direction);
            appendUrlParams(urlBuff, BoxConstant.PARAM_NAME_PARAMS, params);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                Element filesElm = responseElm.element(BoxConstant.PARAM_NAME_FILES);
                String status = statusElm.getText();
                searchResponse.setStatus(status);
                List fileList = parseToFileList(filesElm);
                searchResponse.setFileList(fileList);
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(searchResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_XML.equals(apiRequestFormat)) {
            Document document = DocumentHelper.createDocument();
            Element requestElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_REQUEST);
            document.add(requestElm);

            Element actionElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_ACTION);
            Element apiKeyElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_API_KEY);
            Element authTokenElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            Element queryElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_QUERY);
            Element pageElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_PAGE);
            Element perPageElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_PER_PAGE);
            Element sortElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_SORT);
            Element directionElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_DIRECTION);
            Element paramsElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_PARAMS);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(queryElm);
            requestElm.add(pageElm);
            requestElm.add(perPageElm);
            requestElm.add(sortElm);
            requestElm.add(directionElm);
            requestElm.add(paramsElm);
            actionElm.setText(searchRequest.getActionName());
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            queryElm.setText(query);
            pageElm.setText(String.valueOf(page));
            perPageElm.setText(String.valueOf(perPage));
            sortElm.setText(sort);
            directionElm.setText(direction);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    String param = params[i];
                    Element itemElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_ITEM);
                    itemElm.setText(param);
                    paramsElm.add(itemElm);
                }
            }
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                Element filesElm = responseElm.element(BoxConstant.PARAM_NAME_FILES);
                String status = statusElm.getText();
                searchResponse.setStatus(status);
                searchResponse.setStatus(status);
                List fileList = parseToFileList(filesElm);
                searchResponse.setFileList(fileList);
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(searchResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP.equals(apiRequestFormat)) {
            //
        } else {
        }

        return searchResponse;
    }

    /**
     * @param filesElm
     *            files element
     * @return list of file
     */
    private List parseToFileList(Element filesElm) {
        List fileList = new ArrayList();
        for (int i = 0; i < filesElm.nodeCount(); i++) {
            Element fileElm = (Element) filesElm.node(i);
            Element idElm = fileElm.element(BoxConstant.PARAM_NAME_ID);
            Element nameElm = fileElm.element(BoxConstant.PARAM_NAME_NAME);
            String id = idElm.getText();
            String name = nameElm.getText();
            BoxFile file = BoxObjectFactory.createBoxFile();
            file.setFileId(id);
            file.setFileName(name);
            fileList.add(file);
        }
        return fileList;
    }

}
