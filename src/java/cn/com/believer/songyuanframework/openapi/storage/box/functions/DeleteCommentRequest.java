/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author jjia
 * 
 */
public interface DeleteCommentRequest extends BoxAuthRequest {

    /**
     * @return the targetId
     */
    public String getTargetId();

    /**
     * @param targetId
     *            the targetId to set
     */
    public void setTargetId(String targetId);
}
