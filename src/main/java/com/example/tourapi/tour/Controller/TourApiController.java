package com.example.tourapi.tour.Controller;

import com.example.tourapi.tour.Service.TourApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/apitest")
@Slf4j
public class TourApiController {

    public final TourApiService tourApiService;
    // https://wildeveloperetrain.tistory.com/62

    // 지역기반 검색
    @GetMapping("/areaBasedList")
    public String getTourApi(@RequestParam int pageNo, int areaCode, int subAreaCode, int contentId) {
        return tourApiService.getTourApi(pageNo, areaCode, subAreaCode, contentId);
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

    // 서비스 분류 정보 조회
    @GetMapping("/categorycode")
    public String getCategoryCode() {
        return tourApiService.getCategoryCode();
    }

    // 키워드 조회
    @GetMapping("/searchKeyword")
    public String getKeyword(@RequestParam int pageNo, String Searchkeyword) throws UnsupportedEncodingException {
        log.info(Searchkeyword);
        return tourApiService.getKeyword(pageNo, Searchkeyword);
    }

    // 공통정보 조회
    @GetMapping("/commonInfo")
    public String getCommonInfo(@RequestParam int contentId) {
        return tourApiService.getCommonInfo(contentId);
    }

    // 이미지정보 조회
    @GetMapping("/detailImage")
    public String getDetailImage(@RequestParam int contentId) {
        return tourApiService.getDetailImage(contentId);
    }


    // 반복정보 조회
    @GetMapping("/detailInfo")
    public String getDeatailInfo(@RequestParam int contentId, int contentTypeId) {
        return tourApiService.getDetailInfo(contentId, contentTypeId);
    }

    // 소개정보 조회
    @GetMapping("/detailIntro")
    public String getDetailIntro(@RequestParam int contentId, int contentTypeId) {
        return tourApiService.getDetailIntro(contentId, contentTypeId);
    }
}

