package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * All rights reserved.
 */

public interface MoveRequest extends BoxAuthRequest {

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
     * @return the destinationId
     */
    public String getDestinationId();

    /**
     * @param destinationId
     *            the destinationId to set
     */
    public void setDestinationId(String destinationId);
}
