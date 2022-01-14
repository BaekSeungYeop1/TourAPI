package com.example.tourapi.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RequiredArgsConstructor
@Service
@Slf4j
public class TourApiService {

    public String getTourApi(int pageNo,int areaCode,int subAreaCode) {
        StringBuilder result = new StringBuilder();
        log.info("pageNo = " + pageNo);
        log.info("areaCode = " + areaCode);
        log.info("subAreaCode = " + subAreaCode);
        if (areaCode == 0 & subAreaCode == 0) {

                String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                        "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                        "&pageNo=" + pageNo +
                        "&numOfRows=10" +
                        "&MobileApp=AppTest" +
                        "&MobileOS=ETC" +
                        "&arrange=A" +
                        "&contentTypeld=12" +
                        "&listYN=Y" +
                        "&sponsor1telYN=Y" +
                        "&_type=json";

                return useTourApi(apiUrl);

        }else if(areaCode != 0 & subAreaCode == 0) {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
                    "&numOfRows=10" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&contentTypeld=12" +
                    "&areaCode=" + areaCode +
                    "&listYN=Y" +
                    "&sponsor1telYN=Y" +
                    "&_type=json";

            return useTourApi(apiUrl);

        }
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
                    "&numOfRows=10" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&contentTypeld=12" +
                    "&areaCode=" + areaCode +
                    "&sigunguCode=" +subAreaCode +
                    "&listYN=Y" +
                    "&sponsor1telYN=Y" +
                    "&_type=json";

            return useTourApi(apiUrl);
    }


    public String getAreaCode() {

            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&MobileOS=ETC" +
                    "&MobileApp=AppTest" +
                    "&pageNo=1" +
                    "&numOfRows=20" +
                    "&_type=json";

            return useTourApi(apiUrl);
    }

    public String getSubAreaCode(int areaCode) {

            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&numOfRows=50" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&areaCode=" + areaCode +
                    "&MobileApp=AppTest" +
                    "&_type=json";

            return useTourApi(apiUrl);
    }

    public String getKeyword(int pageNo, String Searchkeyword) throws UnsupportedEncodingException {
        String keyword = URLEncoder.encode(Searchkeyword,"UTF-8");
        log.info(keyword);
        String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?" +
                "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                "&MobileApp=AppTest" +
                "&MobileOS=ETC" +
                "&pageNo=" + pageNo +
                "&numOfRows=10" +
                "&listYN=Y" +
                "&arrange=A" +
                "&keyword=" + keyword +
                "&_type=json";

        return useTourApi(apiUrl);


    }

    public String getCommonInfo(int contentId) {
        log.info(String.valueOf(contentId));
        String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?" +
                "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                "&MobileApp=AppTest" +
                "&MobileOS=ETC" +
                "&pageNo=1" +
                "&numOfRows=10" +
                "&contentId=" + contentId +
                "&defaultYN=Y" +
                "&firstImageYN=Y" +
                "&addrinfoYN=Y" +
                "&mapinfoYN=Y" +
                "&overviewYN=Y" +
                "&_type=json";

        return useTourApi(apiUrl);

    }

    private String useTourApi(String apiUrl) {
        StringBuilder result = new StringBuilder();
        try {

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

    public String getCategoryCode() {
        String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode?" +
                "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                "&MobileApp=AppTest" +
                "&MobileOS=ETC" +
                "&pageNo=1" +
                "&numOfRows=10" +
                "&_type=json";

        return useTourApi(apiUrl);
    }
}
