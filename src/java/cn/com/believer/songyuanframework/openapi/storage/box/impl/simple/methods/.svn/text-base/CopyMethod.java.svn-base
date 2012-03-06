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
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CopyRequest;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.CopyResponse;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;

/**
 * @author Jimmy
 * 
 */
public class CopyMethod extends BaseBoxMethod {

    /**
     * This method copies a file into another folder.
     * 
     * @param copyRequest
     *            request
     * @return response
     * @throws IOException
     *             io exception
     * @throws BoxException
     *             box exception
     */
    public CopyResponse copy(CopyRequest copyRequest) throws IOException, BoxException {
        CopyResponse baseBoxResponse = BoxResponseFactory.createCopyResponse();

        String apiKey = copyRequest.getApiKey();
        String authToken = copyRequest.getAuthToken();
        String target = copyRequest.getTarget();
        String targetId = copyRequest.getTargetId();
        String destinationId = copyRequest.getDestinationId();

        if (BoxConstant.CONFIG_API_REQUEST_FORMAT_REST.equals(apiRequestFormat)) {
            StringBuffer urlBuff = super.getRestUrl(BoxConstant.ACTION_NAME_COPY);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_API_KEY);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(apiKey);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_AUTH_TOKEN);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(authToken);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TARGET);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(target);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_TARGET_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(targetId);
            urlBuff.append(BoxConstant.AND_SIGN_STRING);
            urlBuff.append(BoxConstant.PARAM_NAME_DESTINATION_ID);
            urlBuff.append(BoxConstant.EQUALS_SIGN_STRING);
            urlBuff.append(destinationId);
            try {
                Document doc = httpManager.doGet(urlBuff.toString());
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
                // if (BoxConstant.STATUS_S_MOVE_NODE.equals(status)) {
                // }
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(baseBoxResponse.getStatus());
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
            Element destinationIdElm = DocumentHelper.createElement(BoxConstant.PARAM_NAME_DESTINATION_ID);
            requestElm.add(actionElm);
            requestElm.add(apiKeyElm);
            requestElm.add(authTokenElm);
            requestElm.add(targetElm);
            requestElm.add(targetIdElm);
            requestElm.add(destinationIdElm);
            //
            actionElm.setText(BoxConstant.ACTION_NAME_COPY);
            apiKeyElm.setText(apiKey);
            authTokenElm.setText(authToken);
            targetElm.setText(target);
            targetIdElm.setText(targetId);
            destinationIdElm.setText(destinationId);
            String result = httpManager.doPostXML(xmlApiUrl, document.asXML());
            try {
                Document doc = DocumentHelper.parseText(result);
                Element responseElm = doc.getRootElement();
                Element statusElm = responseElm.element(BoxConstant.PARAM_NAME_STATUS);
                String status = statusElm.getText();
                baseBoxResponse.setStatus(status);
                // if (BoxConstant.STATUS_S_MOVE_NODE.equals(status)) {
                // }
            } catch (DocumentException e) {
                BoxException be = new BoxException("failed to parse to a document.", e);
                be.setStatus(baseBoxResponse.getStatus());
                throw be;
            }

        } else if (BoxConstant.CONFIG_API_REQUEST_FORMAT_SOAP.equals(apiRequestFormat)) {

        } else {
        }
        return baseBoxResponse;
    }
}
