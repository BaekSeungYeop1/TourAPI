<template>
<v-app>
  <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex
        xs12
        sm4
        v-for="(tour, index) in tours"
        :key="index">
        <v-card>
            <v-img
            aspect-ratio="2"
            :src="tour.firstimage">
            <v-container fill-height fluid>
          </v-container>
          </v-img>
          <v-card-text>
            <div>{{ tour.title }}</div>
            <div>{{ tour.readcount }}</div>
            <div>주소: {{ tour.addr1 }}</div>
            <div>전화번호: {{ tour.tel }}</div>
          </v-card-text>
          <v-divider/>
          <v-card-actions>
            <v-spacer/>
            <v-icon small class="px-2">mdi-favorite</v-icon><span>0</span>
            <v-icon small class="px-2">mdi-comment</v-icon><span>0</span>
            <v-icon small class="px-2">mdi-visibility</v-icon><span>0</span>
          </v-card-actions>
        </v-card>
      </v-flex>
    </v-layout>
    <v-pagination
      v-model="pageNo"
      :length="numOfPages"
      total-visible="10"
      @input="updatePage">
      </v-pagination>
  </v-container>
</v-app>
</template>

<script>
export default {
  data: () => ({
    tours:[],
    pageNo: 1,
    numOfRows: 10,
    historyList: [],
    area:[],
    paging:[],
    selectedArea: undefined 
  }),
  created(){
    this.updatePage(this.pageNo);
  },
  mounted(){
    this.getTourList(this.pageNo);
  },
  computed: {
    numOfPages () { 
      return Math.ceil(this.paging.totalCount / this.numOfRows);
    }
  },
 
  methods: {
    getTourList(pageNo){
      let areaCode = this.$route.query.areaCode
      let subAreaCode = this.$route.query.subAreaCode
      this.$axios.get("/apitest/?pageNo=" + pageNo + "&areaCode=" + areaCode + "&subAreaCode=" + subAreaCode)
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
      let start = (pageIndex - 1) * this.numOfRows;
      let end = pageIndex * this.numOfRows;
      this.historyList = this.tours.slice(start,end);
      this.pageNo = pageIndex;
      
      this.$axios.get("/apitest/?pageNo=" + pageIndex + "&areaCode=" + areaCode + "&subAreaCode=" + subAreaCode)
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
  }
  
}
</script>