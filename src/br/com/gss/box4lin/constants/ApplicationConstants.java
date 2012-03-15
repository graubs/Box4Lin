/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.constants;

import br.com.gss.box4lin.persistence.AbstractBDF;

/**
 *
 * @author glauber
 */
public interface ApplicationConstants {

    public static final String APPLICATION_NAME = "Box4Lin";
    
    public static final String API_KEY = "zs4ytyoljyhqvxq5greyasfan6y236df";
    
    public static final int LIST_UNIQUE_ITEM = 0;
    
    public static final String PARAM_NO_ZIP = "nozip";
    
    public static final String AUTH_URL = "www.box.net/api/1.0/auth/";
    
    public static final String ROOT_NODE = "0";
    
    public static final String TARGET_FILE = "file";
    
    public static final String TARGET_FOLDER = "folder";
    
    public static final String LAST_SESSION_FILE = "505934872" + AbstractBDF.FILE_EXTENSION;
    
    public static final String IMAGE_DEFAULT_EXTENSION = ".png";
    
    public static final String IMAGE_DEFAULT_PATH = "images/";
    
    public static final String DEFAULT_ICON_FILE = IMAGE_DEFAULT_PATH + "default" + IMAGE_DEFAULT_EXTENSION;
    
    public static final String DEFAULT_FOLDER_FILE = IMAGE_DEFAULT_PATH + "folder" + IMAGE_DEFAULT_EXTENSION;
    
    //Status Constants
    public static final String STATUS_S_DELETE_NODE = "s_delete_node";
    
    public static final String STATUS_E_DELETE_NODE = "e_delete_node"; 
    
    public static final String STATUS_NOT_LOGGED_IN = "not_logged_in"; 
    
    public static final String STATUS_APPLICATION_RESTRICTED = "application_restricted";
}
