/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.factories;

import br.com.gss.box4lin.entities.BoxUserSession;

/**
 *
 * @author glauber
 */
public class BoxUserSessionFactory {

    private static BoxUserSessionFactory instance;
    
    private BoxUserSession userSession;
    
    private BoxUserSessionFactory(){
        this.userSession = new BoxUserSession();
    }
    
    public static BoxUserSessionFactory getInstance(){
        if(instance == null){
            instance = new BoxUserSessionFactory();
        }
        return instance;
    }

    public BoxUserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(BoxUserSession userSession) {
        this.userSession = userSession;
    }
    
}