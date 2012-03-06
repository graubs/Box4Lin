/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.controllers;

import br.com.gss.box4lin.constants.ApplicationConstants;
import br.com.gss.box4lin.entities.BoxUserSession;
import br.com.gss.box4lin.factories.BoxExternalFactory;
import br.com.gss.box4lin.persistence.IOManager;
import cn.com.believer.songyuanframework.openapi.storage.box.factories.BoxRequestFactory;
import cn.com.believer.songyuanframework.openapi.storage.box.functions.*;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxUser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glauber
 */
public class BoxInfraController {

    public static final String KEY_SPACE_AMOUNT = "spaceAmount";
    
    public static final String KEY_SPACE_USED = "spaceUsed";
    
    private static BoxInfraController boxController;
    
    private BoxInfraController(){}
    
    public static BoxInfraController getInstance(){
        if(null == boxController){
            boxController = new BoxInfraController();
        }
                
        return boxController;
    }
        
    public RegisterNewUserResponse registerNewUser(String username, String password) throws IOException, BoxException{
        
        RegisterNewUserRequest request = BoxRequestFactory.createRegisterNewUserRequest(
                ApplicationConstants.API_KEY, username, password);
        
        return BoxExternalFactory.getBoxExternalAPI().registerNewUser(request);
    }
    
    public String getTicket() throws IOException, BoxException{
        
        GetTicketRequest request = BoxRequestFactory.createGetTicketRequest(
                ApplicationConstants.API_KEY);
        
        GetTicketResponse response = BoxExternalFactory.getBoxExternalAPI().getTicket(request);
        
        return response == null ? null : response.getTicket();
    }
    
    public GetAuthTokenResponse getAuthToken(String ticket) throws IOException, BoxException{
        
        GetAuthTokenRequest request = BoxRequestFactory.createGetAuthTokenRequest(
                ApplicationConstants.API_KEY, ticket);
        
        return BoxExternalFactory.getBoxExternalAPI().getAuthToken(request);
    }
    
    public Map getStorageInfo(String ticket) throws IOException, BoxException{
        Map result = new HashMap();
        
        GetAuthTokenRequest request = BoxRequestFactory.createGetAuthTokenRequest(
                ApplicationConstants.API_KEY, ticket);
        
        BoxUser user = BoxExternalFactory.getBoxExternalAPI().getAuthToken(request).getUser();
                
        result.put(KEY_SPACE_AMOUNT, user.getSpaceAmount());
        result.put(KEY_SPACE_USED, user.getSpaceUsed());
        
        return result;
    }
    
    public void logout(String authToken) throws IOException, BoxException{
        
        LogoutRequest request = BoxRequestFactory.createLogoutRequest(
                ApplicationConstants.API_KEY, authToken);
        
        BoxExternalFactory.getBoxExternalAPI().logout(request);
    }
    
    public BoxUserSession getLastSession(){
        BoxUserSession result = null;
        try {
            result = (BoxUserSession)IOManager.getObject(ApplicationConstants.LAST_SESSION_FILE);
        } catch (NullPointerException ex) {
            Logger.getLogger(BoxInfraController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return result;
    }
    
}
