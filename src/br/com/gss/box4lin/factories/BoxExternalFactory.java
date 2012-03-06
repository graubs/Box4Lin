/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.factories;

import cn.com.believer.songyuanframework.openapi.storage.box.BoxExternalAPI;
import cn.com.believer.songyuanframework.openapi.storage.box.impl.simple.SimpleBoxImpl;


/**
 *
 * @author glauber
 */
public class BoxExternalFactory {

    private static BoxExternalAPI boxExternalAPI;
    
    private BoxExternalFactory(){}
    
    public static BoxExternalAPI getBoxExternalAPI(){
        if(null == boxExternalAPI){
            boxExternalAPI = new SimpleBoxImpl();
        }
        return boxExternalAPI;
    }
}
