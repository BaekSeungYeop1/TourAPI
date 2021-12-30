package com.example.tourapi.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping(value = "/apitest")
@Slf4j
public class RestTestController {

    // https://wildeveloperetrain.tistory.com/62

    // 지역기반 검색
    @GetMapping("/")
    public String getTourApi(@RequestParam String pageNo) {
        StringBuilder result = new StringBuilder();
        log.info("pageNo = " + pageNo);
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
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

    // 지역 코드 검색
    @GetMapping("/test")
    public String ApiTest() {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&numOfRows=10" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&areaCode=2" +
                    "&MobileApp=AppTest" +
                    /*"&contentld=2674675" +
                    "&contentTypeld=15" +*/
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

    // 상세정보
    @GetMapping("/detailInfo")
    public String ApiTest1() {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&numOfRows=10" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&MobileApp=AppTest" +
                    "&contentId=2674675" +
                    "&contentTypeId=15" +
                    "&_type=json";
            // http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?
            // serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D
            // &numOfRows=10
            // &pageNo=1
            // &MobileOS=ETC
            // &MobileApp=AppTest
            // &contentId=2674675
            // &contentTypeId=15

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
