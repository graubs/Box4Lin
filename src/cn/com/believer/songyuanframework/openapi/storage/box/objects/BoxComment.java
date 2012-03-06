/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.objects;

import java.io.Serializable;

/**
 * @author jjia
 * 
 */
public interface BoxComment extends Serializable {

    /**
     * @return the commentId
     */
    public String getCommentId();

    /**
     * @param commentId
     *            the commentId to set
     */
    public void setCommentId(String commentId);

    /**
     * @return the message
     */
    public String getMessage();

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message);

    /**
     * @return the userId
     */
    public String getUserId();

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId);

    /**
     * @return the userName
     */
    public String getUserName();

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName);

    /**
     * @return the created
     */
    public long getCreated();

    /**
     * @param created
     *            the created to set
     */
    public void setCreated(long created);

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl();

    /**
     * @param avatarUrl
     *            the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl);
}
