package com.example.tourapi.Controller;

import com.example.tourapi.Service.TourApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/apitest")
@Slf4j
public class TourApiController {

    public final TourApiService tourApiService;
    // https://wildeveloperetrain.tistory.com/62

    // 지역기반 검색
    @GetMapping("/")
    public String getTourApi(@RequestParam int pageNo, int areaCode, int subAreaCode) {
        return tourApiService.getTourApi(pageNo,areaCode,subAreaCode);
    }

    // 지역코드 정보 조회
    @GetMapping("/areacode")
    public String getTourApi() {
        return tourApiService.getAreaCode();
    }

    // 지역 코드가(areaCode=?)인 시군구코드 정보 조회
   @GetMapping("/subareacode")
    public String getSubAreaCode(@RequestParam int areaCode) {
        return tourApiService.getSubAreaCode(areaCode);
    }

    // 키워드 조회
    @GetMapping("/searchKeyword")
    public String getKeyword(@RequestParam String Searchkeyword) throws UnsupportedEncodingException {
        log.info(Searchkeyword);
        return tourApiService.getKeyword(Searchkeyword);
    }

    // 공통정보 조회
    @GetMapping("/commonInfo")
    public String getCommonInfo(@RequestParam int contentId){
        return tourApiService.getCommonInfo(contentId);
    }


    // 상세정보
    @GetMapping("/detailInfo")
    public String ApiTest1(@RequestParam int contentId, int contentTypeId) {
        StringBuilder result = new StringBuilder();
        try {
            String apiUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?" +
                    "serviceKey=SttmOHJrTnbL%2BYGjAeOeUNscrx%2BJsXNqXqnqgRVVZA8pkTaoOaravKjuPByElQKhnXijl0X6yOEbxKV2rPb6iw%3D%3D" +
                    "&numOfRows=10" +
                    "&pageNo=1" +
                    "&MobileOS=ETC" +
                    "&MobileApp=AppTest" +
                    "&contentId=" + contentId +
                    "&contentTypeId=" + contentTypeId +
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
