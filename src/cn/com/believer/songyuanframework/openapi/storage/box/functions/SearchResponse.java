/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import java.util.List;

/**
 * @author jjia
 *
 */
public interface SearchResponse extends BoxResponse {

    /**
     * @return the fileList
     */
    public List getFileList();

    /**
     * @param fileList
     *            the fileList to set
     */
    public void setFileList(List fileList);
}
