/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface SetDescriptionRequest extends BoxAuthRequest {

    /**
     * @return the target
     */
    public String getTarget();

    /**
     * @param target
     *            the target to set
     */
    public void setTarget(String target);

    /**
     * @return the targetId
     */
    public String getTargetId();

    /**
     * @param targetId
     *            the targetId to set
     */
    public void setTargetId(String targetId);

    /**
     * @return the description
     */
    public String getDescription();

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description);
}
