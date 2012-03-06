/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface GetFileInfoRequest extends BoxAuthRequest {

    /**
     * @return the fileId
     */
    public String getFileId();

    /**
     * @param fileId
     *            the fileId to set
     */
    public void setFileId(String fileId);
}
