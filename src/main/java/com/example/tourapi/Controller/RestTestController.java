package com.example.tourapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class RestTestController {

    @GetMapping(value = "/apitest")
    public String callApi() throws IOException{
        StringBuffer result = new StringBuffer();
        try {
            String urlstr = "http://api.visitkorea.or.kr/openapi/service/?" +
                    "serviceKey= SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "pageNo=1" +
                    "numOfRows=10" +
                    "type= json";
            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null){
                result.append(returnLine+"\n\r");
            }

            urlConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
