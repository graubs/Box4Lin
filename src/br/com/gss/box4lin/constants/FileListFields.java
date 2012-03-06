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

//    FILE_CHECK                  (0, "Select"),
//    FILE_ICON                   (1, " ", 30, 50),
//    FILE_NAME                   (2, "Name", 30, 500),
//    FILE_DESCRIPTION            (3, "Description", 30, 500),
//    FILE_SIZE                   (4, "Size", 30, 500),
//    FILE_CREATION_DATE          (5, "Creation date", 30, 500),
//    FILE_LAST_MODIFIED_DATE     (6, "Last modified date", 30, 500);
    FILE_ID (0, "ID", 10, 30),
    FILE_NAME (1, "Name", 100, 500),
    FILE_SIZE (2, "Size", 10, 30),
    FILE_CREATED (3, "Date created", 50, 100),
    FILE_UPDATED (4, "Date updated", 50, 100),
    FILE_TAGS (5, "Tags", 100, 500),
    FILE_KEYWORD (6, "Keywords", 100, 500);
    
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
