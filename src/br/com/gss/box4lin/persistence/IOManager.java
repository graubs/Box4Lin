/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.persistence;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glauber
 */
public class IOManager {

    public static void saveObject(String fileName, Object o) throws IOException{
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(o);
        out.close();
    }
    
    public static Object getObject(String fileName) {
        
        Object o = null;
        
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream(fileName));
            o = in.readObject();
            in.close();
            return o;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IOManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
    
    public static void saveToBDF(AbstractBDF o) throws IOException{
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(o.getSerializedName()));
        out.writeObject(o);
        out.close();
    }
    
    public static AbstractBDF getFromBDF(AbstractBDF obj) throws IOException, ClassNotFoundException, NullPointerException, FileNotFoundException{
        ObjectInput in = new ObjectInputStream(new FileInputStream(obj.getSerializedName()));
        AbstractBDF result = null;
        
        try{
            result = (AbstractBDF)in.readObject();
        }catch(ClassCastException e){
            e.printStackTrace();
        }
        
        in.close();
 
        return result;
    }
}
