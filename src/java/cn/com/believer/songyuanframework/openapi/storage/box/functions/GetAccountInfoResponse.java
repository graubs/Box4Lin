package cn.com.believer.songyuanframework.openapi.storage.box.functions;

import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;

/**
 * 
 * @author Jimmy Jia
 *
 */
public interface GetAccountInfoResponse extends BoxResponse {

    /**
     * @return the user
     */
    public BoxUser getUser();

    /**
     * @param user
     *            the user to set
     */
    public void setUser(BoxUser user);
}
