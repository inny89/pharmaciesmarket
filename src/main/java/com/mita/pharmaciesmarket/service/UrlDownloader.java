/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mita.pharmaciesmarket.service;


import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 *
 * @author milosz
 */
public class UrlDownloader {
    
    public void urlDownloader(String fromFile, String toFile){
        try{
        FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 40000, 40000);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
