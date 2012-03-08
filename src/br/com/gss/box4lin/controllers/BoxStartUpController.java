/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.controllers;

import br.com.gss.box4lin.constants.ApplicationConstants;
import br.com.gss.box4lin.entities.BoxUserSession;
import br.com.gss.box4lin.factories.BoxUserSessionFactory;
import br.com.gss.box4lin.persistence.IOManager;
import br.com.gss.box4lin.views.BoxFrameMain;
import cn.com.believer.songyuanframework.openapi.storage.box.objects.BoxException;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glauber
 */
public class BoxStartUpController {

    private BoxStartUpController(){}
    
    public static void main(String [] args){
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new BoxFrameMain(startSession()).setVisible(true);
            }
        });
    }
    
    private static String startSession(){
        
        BoxUserSession lastSession = BoxInfraController.getInstance().getLastSession();
        
        if(null == lastSession){
            lastSession = showLoginWizzard();
        }
        
        BoxUserSessionFactory.getInstance().setUserSession(lastSession);
        
        return lastSession == null ? null : lastSession.getAuthToken();
    }
    
    private static BoxUserSession showLoginWizzard(){
        BoxUserSession userSession = null;
        
        System.out.println("Please type your Box username or email address:");
        String userName = new Scanner(System.in).nextLine();
        
        System.out.println("Please type your Box password:");
        String password = new Scanner(System.in).nextLine();
        
        try {
            BoxInfraController.getInstance().registerNewUser(userName, password);
            String ticket = BoxInfraController.getInstance().getTicket();
            System.out.println("Please access the following URL on your browser to continue the authentication process: \r\n"
                    + ApplicationConstants.AUTH_URL + ticket);
            new Scanner(System.in).nextLine();
            
            String authToken = BoxInfraController.getInstance().getAuthToken(ticket).getAuthToken();
            
            userSession = new BoxUserSession(userName, ticket, authToken);
                        
            IOManager.saveObject(ApplicationConstants.LAST_SESSION_FILE, userSession);
            
        } catch (IOException ex) {
            Logger.getLogger(BoxStartUpController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BoxException ex) {
            Logger.getLogger(BoxStartUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userSession;
    }
}
