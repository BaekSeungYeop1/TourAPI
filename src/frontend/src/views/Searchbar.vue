<template>
<v-app>
  <v-container grid-list-xl>
      <v-row>
          <v-col>
        <v-select
          v-model="areaCode"
          :items="area"
          label="시"
          item-text="name"
          item-value="code"
          return-object
          @change="getSubAreaCode()"
        ></v-select>
      </v-col>
      <v-col>
        <v-select
          v-model="subAreaCode"
          :items="subarea"
          label="군"
          item-text="name"
          item-value="code"
          return-object
        ></v-select>
      </v-col>
      <v-text-field>{{Searchkeyword}}</v-text-field>
      <v-btn @click="searchEvent(areaCode.code,subAreaCode.code)">검색</v-btn>
      <v-btn @click="searchEvent2()">확인</v-btn>
      </v-row>
  </v-container>
</v-app>
</template>

<script>
export default {
  data: () => ({
     areaCode: {code: "0", name: "0", rnum:"0"},
     area:[],
     subarea:[],
     subAreaCode: {code: "0", name: "0", rnum:"0"},
     Searchkeyword: ""
  }),
  created(){
    
  },
  mounted(){
    this.getAreaCode();
  },
  computed: {
  },
 
  methods: {
    getAreaCode(){
      this.$axios.get("/apitest/areacode")
          .then(response=>{
            this.area = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    getSubAreaCode(){
      this.$axios.get("/apitest/subareacode?areaCode=" + this.areaCode.code)
          .then(response=>{
            this.subarea = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    searchEvent(areaCode,subAreaCode){
      this.$router.push({path:"./areatourlist", query:{areaCode,subAreaCode}});
    },
    searchEvent2(){
      console.log(this.areaCode)
    }
    
    }
  } 

</script>