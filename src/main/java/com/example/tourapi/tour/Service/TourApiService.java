package com.example.tourapi.tour.Service;

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

    public String getTourApi(int pageNo,int areaCode,int subAreaCode, int contentId) {

        log.info("pageNo = " + pageNo);
        log.info("areaCode = " + areaCode);
        log.info("subAreaCode = " + subAreaCode);
        log.info("contentId = " + contentId);

        // 관광타입 x 지역코드 x 시군구코드 x
        if (contentId == 0 & areaCode == 0 & subAreaCode == 0) {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
                    "&numOfRows=9" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&listYN=Y" +
                    "&_type=json";

            return useTourApi(apiUrl);

        }
        // 관광타입 o 지역코드 x 시군구코드 x
        else if (contentId != 0 & areaCode == 0 & subAreaCode == 0) {

            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
                    "&numOfRows=9" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&contentTypeId=" + contentId +
                    "&listYN=Y" +
                    "&_type=json";

            return useTourApi(apiUrl);

        }
        // 관광타입 o 지역코드 o 시군구코드 x
        else if (contentId != 0 & areaCode != 0 & subAreaCode == 0) {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
                    "&numOfRows=9" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&contentTypeId=" + contentId +
                    "&areaCode=" + areaCode +
                    "&listYN=Y" +
                    "&_type=json";

            return useTourApi(apiUrl);

        }
        // 관광타입 o 지역코드 o 시군구코드 o
        else if (contentId != 0 & areaCode != 0 & subAreaCode != 0) {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&pageNo=" + pageNo +
                    "&numOfRows=9" +
                    "&MobileApp=AppTest" +
                    "&MobileOS=ETC" +
                    "&arrange=A" +
                    "&contentTypeId=" + contentId +
                    "&areaCode=" + areaCode +
                    "&sigunguCode=" + subAreaCode +
                    "&listYN=Y" +
                    "&_type=json";

            return useTourApi(apiUrl);

        }

        return null;
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
                "&numOfRows=9" +
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

    public String getDetailImage(int contentId) {
        log.info(String.valueOf(contentId));
        String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage?" +
                "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                "&numOfRows=10" +
                "&pageNo=1" +
                "&MobileOS=ETC" +
                "&MobileApp=AppTest" +
                "&contentId=" + contentId +
                "&imageYN=Y" +
                "&subImageYN=Y" +
                "&_type=json";

        return useTourApi(apiUrl);

    }


    public String getDetailInfo(int contentId, int contentTypeId) {
        String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailInfo?" +
                "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                "&numOfRows=10" +
                "&pageNo=1" +
                "&MobileOS=ETC" +
                "&MobileApp=AppTest" +
                "&contentId=" + contentId +
                "&contentTypeId=" + contentTypeId +
                "&_type=json";

        return useTourApi(apiUrl);
    }

    public String getDetailIntro(int contentId, int contentTypeId) {
        String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?" +
                "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                "&numOfRows=10" +
                "&pageNo=1" +
                "&MobileOS=ETC" +
                "&MobileApp=AppTest" +
                "&contentId=" + contentId +
                "&contentTypeId=" + contentTypeId +
                "&_type=json";

        return useTourApi(apiUrl);

    }
}
