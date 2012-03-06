/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gss.box4lin.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author glauber
 */
public class BoxUtil {

    public static String getFormattedDate(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);        
    }
    
    public static String getFormattedDouble(Double value){
        DecimalFormat f = new DecimalFormat("#.#");
        return f.format(value);
    }
    
    public static String getValueInKiloBytes(long sizeInBytes){
        return String.valueOf(getFormattedDouble((double)sizeInBytes / 1024) ) + " KB";
        //return String.valueOf(sizeInBytes / 1024) + " KB";
    }
    
    public static String getValueInMegaBytes(long sizeInBytes){
        return String.valueOf(getFormattedDouble((double)sizeInBytes / 1048576)) + " MB";
    }
    
    public static String getValueInGigaBytes(long sizeInBytes){
        return String.valueOf(getFormattedDouble((double)sizeInBytes / 1073741824)) + " GB";
    }
    
    public static double bytesToGigaBytes(long sizeInBytes){
        return (double)sizeInBytes / 1073741824;
    }
    
    public static String getRightMeasuring(long sizeInBytes){
        if(sizeInBytes < 1024){
            return String.valueOf(sizeInBytes) + " Bytes";
        }else if(sizeInBytes >=1024 && sizeInBytes < 1048576){
            return getValueInKiloBytes(sizeInBytes);
        }else if (sizeInBytes >= 1048576 && sizeInBytes < 1073741824){
            return getValueInMegaBytes(sizeInBytes);    
        }else{
            return getValueInGigaBytes(sizeInBytes);
        }
    }
    
}