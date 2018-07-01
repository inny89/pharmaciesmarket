package com.mita.pharmaciesmarket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmaciesmarketApplicationTests {

    @Test
    public void contextLoads() {
    }

//    @Test
//    public void fetchFile() throws IOException {
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(
//                new ByteArrayHttpMessageConverter());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
//
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        ResponseEntity<byte[]> response = restTemplate.exchange(
//                "https://pub.rejestrymedyczne.csioz.gov.pl/Pobieranie_WS/Pobieranie.ashx?filetype=XMLFile&amp;regtype=RA_FILES",
//                HttpMethod.GET, entity, byte[].class, "1");
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            Files.write(Paths.get("testownik.xml"), response.getBody());
//        }
//    }
}
