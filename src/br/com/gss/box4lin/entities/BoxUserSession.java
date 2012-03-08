/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.entities;

import br.com.gss.box4lin.persistence.AbstractBDF;
import java.util.Date;

/**
 *
 * @author glauber
 */
public class BoxUserSession extends AbstractBDF{

    private String userName;    
    private String authToken;
    private String ticket;
    private Date firstLogon;
    private Date lastLogon;
    private String lastDirectory;
    
    public BoxUserSession(){}
    
    public BoxUserSession(String userName){
        this.userName = userName;        
    }
        
    public BoxUserSession(String userName, String ticket, String authToken){
        this.userName = userName;
        this.ticket = ticket;
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Date getFirstLogon() {
        return firstLogon;
    }

    public void setFirstLogon(Date firstLogon) {
        this.firstLogon = firstLogon;
    }

    public String getLastDirectory() {
        return lastDirectory;
    }

    public void setLastDirectory(String lastDirectory) {
        this.lastDirectory = lastDirectory;
    }

    public Date getLastLogon() {
        return lastLogon;
    }

    public void setLastLogon(Date lastLogon) {
        this.lastLogon = lastLogon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getSerializedName() {
        return String.valueOf(this.userName.hashCode());
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
}
