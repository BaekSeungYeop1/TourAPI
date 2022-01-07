<template>
<v-app>
    <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex
        xs12
        sm4
        >
        <v-card>
            <v-img
            aspect-ratio="2"
            :src="tours.firstimage">
            <v-container fill-height fluid>
          </v-container>
          </v-img>
          <v-card-text>
            <div>{{ tours.title }}</div>
            <div>{{ tours.readcount }}</div>
            <div>주소: {{ tours.addr1 }}</div>
            <div>전화번호: {{ tours.tel }}</div>
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
  </v-container>
</v-app>    
</template>
<script>
export default {
  data: () => ({
    tours: {}
  }),
  mounted(){
    this.getTourCommonInfo();
  },
  methods: {
    getTourCommonInfo(){
      let contentid = this.$route.query.commonInfo;
      this.$axios.get("/apitest/commonInfo?contentId=" + contentid)
          .then(response=>{
            this.tours = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
  }
  
}
</script>