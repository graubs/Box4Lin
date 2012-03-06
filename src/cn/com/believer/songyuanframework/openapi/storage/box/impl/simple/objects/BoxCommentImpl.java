/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.objects;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxComment;

/**
 * @author jjia
 * 
 */
public class BoxCommentImpl implements BoxComment {

    /**
     * 
     */
    private static final long serialVersionUID = -1297591119948478698L;

    /** comment id. */
    private String commentId;

    /** message. */
    private String message;

    /** user id. */
    private String userId;

    /** user name. */
    private String userName;

    /** created timestamp. */
    private long created;

    /** avatar url. */
    private String avatarUrl;

    /**
     * @return the commentId
     */
    public String getCommentId() {
        return this.commentId;
    }

    /**
     * @param commentId the commentId to set
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the created
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    /**
     * @param avatarUrl the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
