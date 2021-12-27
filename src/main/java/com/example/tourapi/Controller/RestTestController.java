package com.example.tourapi.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@Slf4j
public class RestTestController {

    // https://wildeveloperetrain.tistory.com/62
    @GetMapping("/apitest")
    public String callApi() {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=1" +
                    "&numOfRows=10" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&contentTypeld=12" +
                    "&areaCode=4" +
                    "&listYN=Y" +
                    "&_type=json";

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine + "\n");
            }
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }

}
