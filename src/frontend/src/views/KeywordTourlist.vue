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
            @click="clickEvent(tour.contentid)"
          >
            <v-img
              aspect-ratio="2"
              :src="tour.firstimage"
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
    tours:[],
    pageNo: 1,
    numOfRows: 9,
    paging:[],
    selectedArea: undefined
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
      let searchKeyword = this.$route.query.keyword
      this.$axios.get("/apitest/searchKeyword?" + "pageNo=" + pageNo + "&Searchkeyword=" + searchKeyword)
          .then(response=>{
            this.tours = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
            console.log(searchKeyword)
          })
    },
    updatePage(pageIndex){
      let searchKeyword = this.$route.query.keyword
      this.pageNo = pageIndex;

      this.$axios.get("/apitest/searchKeyword?" + "pageNo=" + pageIndex + "&Searchkeyword=" + searchKeyword)
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
    clickEvent(contentid){
      //let commonInfo = this.tour.contentid;
      console.log(contentid);
      this.$router.push({path:"./commoninfo1",query:{contentid}});
    },
  }

}
</script>
