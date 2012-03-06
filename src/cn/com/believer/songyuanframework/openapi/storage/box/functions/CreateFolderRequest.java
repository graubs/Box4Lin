/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

/**
 * @author Jimmy
 * 
 */
public interface CreateFolderRequest extends BoxAuthRequest {

    /**
     * @return the parentFolderId
     */
    public String getParentFolderId();

    /**
     * @param parentFolderId
     *            the parentFolderId to set
     */
    public void setParentFolderId(String parentFolderId);

    /**
     * @return the folderName
     */
    public String getFolderName();

    /**
     * @param folderName
     *            the folderName to set
     */
    public void setFolderName(String folderName);

    /**
     * @return the share
     */
    public boolean isShare();

    /**
     * @param share
     *            the share to set
     */
    public void setShare(boolean share);
}
