/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import java.util.List;

import cn.com.believer.songyuanframework.openapi.storage.box.functions.SearchResponse;

/**
 * @author jjia
 * 
 */
public class SearchResponseImpl extends BoxResponseImpl implements SearchResponse {

    /** file list. */
    private List fileList;

    /**
     * @return the fileList
     */
    public List getFileList() {
        return this.fileList;
    }

    /**
     * @param fileList
     *            the fileList to set
     */
    public void setFileList(List fileList) {
        this.fileList = fileList;
    }

}
