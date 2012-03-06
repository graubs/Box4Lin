/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteCommentRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteCommentResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author jjia
 * 
 */
public class DeleteCommentMethod extends BaseBoxMethod {

    /**
     * This method is used to delete a comment.
     * 
     * @param deleteCommentRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public DeleteCommentResponse deleteComment(DeleteCommentRequest deleteCommentRequest) throws IOException,
            BoxException {
        DeleteCommentResponse deleteCommentResponse = BoxResponseFactory.createDeleteCommentResponse();
        String apiKey = deleteCommentRequest.getApiKey();
        String authToken = deleteCommentRequest.getAuthToken();
        String targetId = deleteCommentRequest.getTargetId();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super.getRestUrl(deleteCommentRequest.getActionName());
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_API_KEY, apiKey);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_AUTH_TOKEN, authToken);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_TARGET_ID, targetId);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                deleteCommentResponse.setStatus(status);
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(deleteCommentResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_XML.equals(apiRequestFormat)) {
            Document document = DocumentHelper.createDocument();
            Element requestElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_REQUEST);
            document.add(requestElm);

            Element actionElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_ACTION);
            Element apiKeyElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_API_KEY);
            Element authTokenElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            Element targetIdElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_TARGET_ID);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetIdElm);
            actionElm.setText(deleteCommentRequest.getActionName());
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetIdElm.setText(targetId);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                deleteCommentResponse.setStatus(status);
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(deleteCommentResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP.equals(apiRequestFormat)) {
            //
        } else {
        }

        return deleteCommentResponse;
    }

}
