<template>
  <v-app>
    <v-container>
      <v-row>
        <v-col
          v-for="(tour, index) in tours"
          :key="index"
          cols="12"
          sm="4"
        >
          <v-card
            @click="clickEvent(tour.contentid,tour.contenttypeid,tour.mapx,tour.mapy)"
          >
            <v-img
              v-if="tour.firstimage"
              aspect-ratio="2"
              :src="tour.firstimage"
            >
              <v-container
                fill-height
                fluid
              />
            </v-img>
            <v-img
              v-else
              aspect-ratio="2"
              src="@/assets/noImage.png"
            >
              <v-container
                fill-height
                fluid
              />
            </v-img>
            <v-card-text>
              <div class="text-h6 pa-2 font-weight-black">
                {{ tour.title }}
              </div>
              <div class="pa-2">
                {{ tour.addr1 }}
              </div>
            </v-card-text>
            <v-divider />
            <v-card-actions>
              <v-spacer />
              <v-icon
                small
                class="px-2"
              >
                mdi-favorite
              </v-icon><span>0</span>
              <v-icon
                small
                class="px-2"
              >
                mdi-comment
              </v-icon><span>0</span>
              <v-icon
                small
                class="px-2"
              >
                mdi-visibility
              </v-icon><span>0</span>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
      <v-pagination
        v-model="pageNo"
        :length="numOfPages"
        total-visible="10"
        @input="updatePage"
      />
    </v-container>
  </v-app>
</template>

<script>


export default {
  data: () => ({
    tours:[],             // 관광지 정보
    pageNo: 1,            // 페이징하기위한 페이지 번호
    numOfRows: 9,        // 페이지 당 출력되는 개수
    paging:[],            // 출력되는 관광지 총 갯수를 알기위해 paging.totalcount
    selectedArea: undefined,
  }),
  computed: {
    numOfPages () {
      return Math.ceil(this.paging.totalCount / this.numOfRows);
    }
  },
  mounted(){
    this.getTourList();
    this.updatePage(this.pageNo);
  },

  methods: {
    getTourList(){
      let pageNo = 1
      let areaCode = this.$route.query.areaCode
      let subAreaCode = this.$route.query.subAreaCode
      let contentId = this.$route.query.contentId
      this.$axios.get("/apitest/areaBasedList?" + "pageNo=" + pageNo + "&areaCode=" + areaCode + "&subAreaCode=" + subAreaCode + "&contentId=" + contentId)
          .then(response=>{
            this.tours = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    updatePage(pageIndex){
      let areaCode = this.$route.query.areaCode
      let subAreaCode = this.$route.query.subAreaCode
      let contentId = this.$route.query.contentId
      this.pageNo = pageIndex;

      this.$axios.get("/apitest/areaBasedList?" + "pageNo=" + pageIndex + "&areaCode=" + areaCode + "&subAreaCode=" + subAreaCode + "&contentId=" + contentId)
          .then(response=>{
            this.tours = response.data.response.body.items.item;
            this.paging = response.data.response.body;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          }),


      console.log(this.pageNo)
    },
    clickEvent(contentid,contenttypeid,mapx,mapy){
      console.log("contentid = " + contentid);
      console.log("contenttypeid =" + contenttypeid);
      this.$router.push({path:"./detailleports",query:{contentid,contenttypeid,mapx,mapy}});
    },
  }

}
</script>
