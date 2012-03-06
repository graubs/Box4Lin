/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.methods;

import java.io.IOException;

import org.apache.commons.codec.net.URLCodec;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxResponseFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddCommentRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.AddCommentResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.utils.ConverterUtils;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxComment;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author jjia
 * 
 */
public class AddCommentMethod extends BaseBoxMethod {

    /**
     * This method is used to add a comment to an item.
     * 
     * @param addCommentRequest
     *            request object
     * @return response object
     * @throws IOException
     *             IO exception
     * @throws BoxException
     *             box exception
     */
    public AddCommentResponse addComment(AddCommentRequest addCommentRequest) throws IOException, BoxException {
        AddCommentResponse addCommentResponse = BoxResponseFactory.createAddCommentResponse();
        String apiKey = addCommentRequest.getApiKey();
        String authToken = addCommentRequest.getAuthToken();
        String target = addCommentRequest.getTarget();
        String targetId = addCommentRequest.getTargetId();
        String message = addCommentRequest.getMessage();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super.getRestUrl(addCommentRequest.getActionName());
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_API_KEY, apiKey);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_AUTH_TOKEN, authToken);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_TARGET, target);
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_TARGET_ID, targetId);
            URLCodec codec = new URLCodec();
            message = codec.encode(message, "ISO-8859-1");
            appendUrlParam(urlBuff, BoxConstant.PARAM_NAME_MESSAGE, message);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                addCommentResponse.setStatus(status);
                Element commentElm = responseElm.element(BoxConstant.PARAM_NAME_COMMENT);
                if (commentElm != null) {
                    BoxComment boxComment = ConverterUtils.toBoxComment(commentElm);
                    addCommentResponse.setComment(boxComment);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(addCommentResponse.getStatus());
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
            Element messageElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_MESSAGE);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            requestElm.add(messageElm);
            actionElm.setText(addCommentRequest.getActionName());
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            messageElm.setText(message);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                addCommentResponse.setStatus(status);
                Element commentElm = responseElm.element(BoxConstant.PARAM_NAME_COMMENT);
                if (commentElm != null) {
                    BoxComment boxComment = ConverterUtils.toBoxComment(commentElm);
                    addCommentResponse.setComment(boxComment);
                }
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(addCommentResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP.equals(apiRequestFormat)) {
            //
        } else {
        }
        return addCommentResponse;
    }

}
