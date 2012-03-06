/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.persistence;

import java.io.Serializable;

/**
 * Abstract BDF (Box Data File) Class.
 * @author glauber
 */
public abstract class AbstractBDF implements Serializable{
    
    public static final String FILE_EXTENSION = ".bdf";
    
    public abstract String getSerializedName();
}
