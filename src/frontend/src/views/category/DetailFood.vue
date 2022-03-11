<template>
  <v-container
    fluid
  >
    <v-card class="pa-3">
      <v-row
        dense
      >
        <v-col>
          <v-card>
            <v-carousel
              :cycle="true"
              :interval="5000"
            >
              <v-carousel-item
                v-for="(image,i) in images"
                :key="i"
                :src="image.originimgurl"
                reverse-transition="fade-transition"
                transition="fade-transition"
              />
            </v-carousel>
            <v-card-title class="text-h4 justify-center">
              {{ tours.title }}
            </v-card-title>
            <hr>
            <v-card-text class="text-h6">
              <p>주소  : {{ tours.addr1 }}</p>
              <p>문의 및 안내 : {{ detailIntro.infocenterfood }}</p>
              <p v-if="detailIntro.opentimefood != null ">
                영업 시간 : {{ detailIntro.opentimefood }}
              </p>
              <p v-if="detailIntro.restdatefood != null ">
                쉬는날 : {{ detailIntro.restdatefood }}
              </p>
              <p v-if="detailIntro.firstmenu != '' ">
                대표 메뉴 : {{ detailIntro.firstmenu }}
              </p>
              <p v-if="detailIntro.kidsfacility != '1' ">
                어린이 놀이방 여부 : O
              </p>
            </v-card-text>
            <hr>
            <v-card-title class="text-h4">
              상세 정보
            </v-card-title>
            <v-card-text class="text-h6">
              {{ tours.overview }}
            </v-card-text>
            <hr>
            <v-card-title class="text-h4">
              위치정보
            </v-card-title>
            <div
              id="kmap"
              ref="map"
              style="width:100%; height:400px"
            />
          </v-card>
        </v-col>
      </v-row>
      <v-row dense>
        <v-col />
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    tours: {},  // 공통정보
    images: {}, // 이미지 정보
    detailInfo: {}, // 반복 정보
    detailIntro: {}, // 소개 정보
    settings: {
      "dots": true,
      "dotsClass": "slick-dots custom-dot-class",
      "edgeFriction": 0.35,
      "infinite": false,
      "speed": 500,
      "slidesToShow": 1,
      "slidesToScroll": 1
    }
  }),
  mounted(){
    this.getTourCommonInfo();
    this.getTourDetailImage();
    this.getTourDetailIntro();
    this.getTourDetailInfo();
    this.initMap();
  },
  // 공통 정보
  methods: {
    getTourCommonInfo(){
      let contentid = this.$route.query.contentid;
      this.$axios.get("/apitest/commonInfo?" + "contentId=" + contentid)
          .then(response=>{
            this.tours = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    // 이미지 정보
    getTourDetailImage(){
      let contentid = this.$route.query.contentid;
      this.$axios.get("/apitest/detailImage?" + "contentId=" + contentid)
          .then(response=>{
            this.images = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    // 반복 정보
    getTourDetailInfo(){
      let contentid = this.$route.query.contentid;
      let contenttypeid = this.$route.query.contenttypeid;
      this.$axios.get("/apitest/detailInfo?" + "contentId=" + contentid + "&contentTypeId=" + contenttypeid)
          .then(response=>{
            this.detailInfo = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })

    },
    // 소개 정보
    getTourDetailIntro(){
      let contentid = this.$route.query.contentid;
      let contenttypeid = this.$route.query.contenttypeid;
      this.$axios.get("/apitest/detailIntro?" + "contentId=" + contentid + "&contentTypeId=" + contenttypeid)
          .then(response=>{
            this.detailIntro = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    initMap(){
      console.log(this.$refs.map);

      let mapx = this.$route.query.mapx;
      let mapy = this.$route.query.mapy;
      var container = this.$refs.map; //지도를 담을 영역의 DOM 레퍼런스
      var options = { //지도를 생성할 때 필요한 기본 옵션
	      center: new kakao.maps.LatLng(mapy, mapx), //지도의 중심좌표.
        level: 3 //지도의 레벨(확대, 축소 정도)
        };
        var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

        // 마커가 표시될 위치
        var markerPosition = new kakao.maps.LatLng(mapy, mapx);

        // 마커를 생성
        var marker = new kakao.maps.Marker({
          position: markerPosition
          });

          // 마커가 지도 위에 표시되도록 설정
          marker.setMap(map)

    }
  }

}
</script>
