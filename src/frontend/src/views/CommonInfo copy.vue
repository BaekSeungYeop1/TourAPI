<template>
  <v-container
    fluid
  >
    <v-card class="pa-3">
      <v-row dense>
        <v-col>
          <v-card>
            <v-carousel>
              <v-carousel-item
                v-for="(image,i) in images"
                :key="i"
                :src="image.smallimageurl"
                reverse-transition="fade-transition"
                transition="fade-transition"
              />
            </v-carousel>
            <v-card-title>
              {{ tours.title }}
            </v-card-title>
            <v-card-text>
              {{ tours.title }}
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    tours: {},
    images: {},
  }),
  mounted(){
    this.getTourCommonInfo();
    this.getTourDetailImage();
    console.log(this.$refs.map);
    console.log(this.tours.mapx)
    var container = this.$refs.map; //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
	      center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	      level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
  },
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
  }

}
</script>
