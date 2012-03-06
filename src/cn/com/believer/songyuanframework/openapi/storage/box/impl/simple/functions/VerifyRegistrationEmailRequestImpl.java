/**
 * All rights reserved.
 */
package cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.constant.BoxConstant;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.VerifyRegistrationEmailRequest;

/**
 * @author Jimmy
 * 
 */
public class VerifyRegistrationEmailRequestImpl extends BoxRequestImpl
        implements VerifyRegistrationEmailRequest {

    /** the email to verify. */
    private String loginName;

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return this.loginName;
    }

    /**
     * @param loginName
     *            the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return action name
     */
    public String getActionName() {
        return BoxConstant.ACTION_NAME_VERIFY_REGISTRATION_EMAIL;
    }
}
