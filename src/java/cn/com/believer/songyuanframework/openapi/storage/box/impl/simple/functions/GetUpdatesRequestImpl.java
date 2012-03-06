/**
 * 
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetUpdatesRequest;

/**
 * @author jjia
 * 
 */
public class GetUpdatesRequestImpl extends BoxRequestImpl implements
        GetUpdatesRequest {

    /** auth token. */
    private String   authToken;

    /**
     * a unix_timestamp of the earliest point in time to obtain an update (the
     * time of the oldest update you want to display).
     */
    private String   beginTimestamp;

    /** a unix_timestamp of the latest point in time to obtain an update. */
    private String   endTimestamp;

    /**
     * Allows you to set additional, optional parameters:
     * 
     * 'nozip' - do not zip the tree xml.
     */
    private String[] params;

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_GET_UPDATES;
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
     * @return the beginTimestamp
     */
    public String getBeginTimestamp() {
        return this.beginTimestamp;
    }

    /**
     * @param beginTimestamp
     *            the beginTimestamp to set
     */
    public void setBeginTimestamp(String beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
    }

    /**
     * @return the endTimestamp
     */
    public String getEndTimestamp() {
        return this.endTimestamp;
    }

    /**
     * @param endTimestamp
     *            the endTimestamp to set
     */
    public void setEndTimestamp(String endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    /**
     * @return the params
     */
    public String[] getParams() {
        return this.params;
    }

    /**
     * @param params
     *            the params to set
     */
    public void setParams(String[] params) {
        this.params = params;
    }

}
