package com.example.tourapi.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RequiredArgsConstructor
@Service
@Slf4j
public class TourApiService {

    public String getTourApi(int pageNo) {
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

    public String getAreaCode() {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&MobileOS=ETC" +
                    "&MobileApp=AppTest" +
                    "&pageNo=1" +
                    "&numOfRows=20" +
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

    public String getSubAreaCode(int areaCode) {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&numOfRows=50" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&areaCode=" + areaCode +
                    "&MobileApp=AppTest" +
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

    public String getKeyword(String Searchkeyword) {
        StringBuilder result = new StringBuilder();
        try {
            String keyword = URLEncoder.encode(Searchkeyword,"UTF-8");
            log.info(keyword);
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&pageNo=1" +
                    "&numOfRows=10" +
                    "&listYN=Y" +
                    "&arrange=A" +
                    "&keyword=" + keyword +
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
