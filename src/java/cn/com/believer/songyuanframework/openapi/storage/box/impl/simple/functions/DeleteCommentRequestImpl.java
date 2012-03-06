/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.DeleteCommentRequest;

/**
 * @author jjia
 * 
 */
public class DeleteCommentRequestImpl extends BoxRequestImpl implements
        DeleteCommentRequest {

    /** auth token. */
    private String authToken;

    /** target id, could be file id or folder id. */
    private String targetId;

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_DELETE_COMMENT;
    }

    /**
     * @return the authToken
     */
    public String getAuthToken() {
        return this.authToken;
    }

    /**
     * @param authToken
     *            the authToken to set
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * @return the targetId
     */
    public String getTargetId() {
        return this.targetId;
    }

    /**
     * @param targetId
     *            the targetId to set
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

}
