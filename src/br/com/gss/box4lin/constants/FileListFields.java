/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.constants;

/**
 *
 * @author Glauber
 */
public enum FileListFields {

    //Attrib name       Arrtib ID   Column Name     Min Column Size     Pref Column Size
    FILE_ID             (0,         "ID",           0,                  0),
    FILE_ICON           (1,         "",             30,                 60),
    FILE_NAME           (2,         "Name",         200,                500),
    FILE_SIZE           (3,         "Size",         100,                100),
    FILE_CREATED        (4,         "Date created", 200,                250),
    FILE_UPDATED        (5,         "Date updated", 200,                250),
    FILE_TAGS           (6,         "Tags",         200,                500),
    FILE_KEYWORD        (7,         "Keywords",     200,                500);
    
    private int id;
    private String value;
    private int minimumSize;
    private int maximumSize;
            
    private FileListFields(int id, String value, int minimumSize, int maximumSize){
        
        this.id = id;
        this.value = value;
        this.minimumSize = minimumSize;
        this.maximumSize = maximumSize;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public int getMaximumSize() {
        return maximumSize;
    }

    public int getMinimumSize() {
        return minimumSize;
    }

}
