package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.GetAccountInfoRequest;

/**
 * 
 * @author Jimmy Jia
 * 
 */
public class GetAccountInfoRequestImpl extends BoxRequestImpl implements GetAccountInfoRequest {

    /** auth token. */
    private String authToken;

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_GET_ACCOUNT_INFO;
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

}
