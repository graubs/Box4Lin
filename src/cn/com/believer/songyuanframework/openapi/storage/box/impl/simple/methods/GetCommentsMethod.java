/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetCommentsRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetCommentsResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils.ConverterUtils;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author jjia
 * 
 */
public class GetCommentsMethod extends BaseBoxMethod {

    /**
     * This method is used to retrieve the comments on an item.
     * 
     * @param getCommentsRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public GetCommentsResponse getComments(GetCommentsRequest getCommentsRequest) throws IOException, BoxException {
        GetCommentsResponse getCommentsResponse = BoxResponseFactory.createGetCommentsResponse();

        String apiKey = getCommentsRequest.getApiKey();
        String authToken = getCommentsRequest.getAuthToken();
        String target = getCommentsRequest.getTarget();
        String targetId = getCommentsRequest.getTargetId();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super.getRestUrl(getCommentsRequest.getActionName());
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_API_KEY, apiKey);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_AUTH_TOKEN, authToken);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_TARGET, target);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_TARGET_ID, targetId);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getCommentsResponse.setStatus(status);
                Element commentsElm = responseElm.element(BoxConstant.PARAM_NAME_COMMENTS);
                if (commentsElm != null) {
                    List boxComments = ConverterUtils.toBoxComments(commentsElm);
                    getCommentsResponse.setComments(boxComments);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(getCommentsResponse.getStatus());
                throw be;
            }
        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_XML.equals(apiRequestFormat)) {
            Document document = DocumentHelper.createDocument();
            Element requestElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_REQUEST);
            document.add(requestElm);

            Element actionElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_ACTION);
            Element apiKeyElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_API_KEY);
            Element authTokenElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            Element targetElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_TARGET);
            Element targetIdElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_TARGET_ID);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            actionElm.setText(getCommentsRequest.getActionName());
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                getCommentsResponse.setStatus(status);
                Element commentsElm = responseElm.element(BoxConstant.PARAM_NAME_COMMENTS);
                if (commentsElm != null) {
                    List boxComments = ConverterUtils.toBoxComments(commentsElm);
                    getCommentsResponse.setComments(boxComments);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(getCommentsResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP.equals(apiRequestFormat)) {
            //
        } else {
        }

        return getCommentsResponse;
    }

}
