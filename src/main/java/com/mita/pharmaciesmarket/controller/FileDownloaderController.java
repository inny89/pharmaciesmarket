/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mita.pharmaciesmarket.controller;

import com.mita.pharmaciesmarket.service.FileDownloaderService;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author milosz
 */
@RestController
@RequestMapping(path = "/download", method = RequestMethod.GET)
public class FileDownloaderController {

    @Autowired
    private FileDownloaderService fileDownloaderService;

    @GetMapping("/ra")
    public Void get() {
        String url = "http://pub.rejestrymedyczne.csioz.gov.pl/Pobieranie_WS/Pobieranie.ashx?filetype=XMLFile&regtype=RA_FILES";
        
        try {

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            
            boolean redirect = false;
            
            int status = conn.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                if (status == HttpURLConnection.HTTP_MOVED_TEMP
                        || status == HttpURLConnection.HTTP_MOVED_PERM
                        || status == HttpURLConnection.HTTP_SEE_OTHER) {
                    redirect = true;
                }
            }

            if (redirect){
                String newUrl = conn.getHeaderField("Location");
                
                conn = (HttpURLConnection) new URL(newUrl).openConnection();
                
                InputStream inputStream = conn.getInputStream();
                String savePathFile = "/home/milosz/NetBeansProjects/PharmaciesMarketAnalysis/testy69.xml";
                
                
                System.out.println(System.getProperty("downloadedfilepath").toString());
                
                FileOutputStream outputStream = new FileOutputStream(savePathFile);
                
                int bytesRead = -1;
                byte[] buffer = new byte[4096];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
               
                outputStream.close();
                inputStream.close();
}           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
