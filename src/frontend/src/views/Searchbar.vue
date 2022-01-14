<template>
  <v-app>
    <v-container>
      <v-row
        no-gutters
        outline
      >
        <v-col
          v-for="(category, index) in categories"
          :key="index"
          align="center"
        >
          <v-card>
            {{ category.type }}
          </v-card>
        </v-col>
      </v-row>

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
          />
        </v-col>
        <v-col>
          <v-select
            v-model="subAreaCode"
            :items="subarea"
            label="군"
            item-text="name"
            item-value="code"
            return-object
          />
        </v-col>
        <v-btn @click="searchEvent(areaCode.code,subAreaCode.code)">
          검색
        </v-btn>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    areaCode: {code: "0", name: "0", rnum: "0"},
    area:[],
    subarea:[],
    subAreaCode:{code: "0", name: "0", rnum: "0"},
     categories : [
       {type : "관광지" , contentid: "12"},
       {type : "문화시설" , contentid: "14"},
       {type : "행사/축제" , contentid: "15"},
       {type : "여행코스" , contentid: "25"},
       {type : "레포츠" , contentid: "28"},
       {type : "숙박" , contentid: "32"},
       {type : "쇼핑" , contentid: "38"},
       {type : "음식점" , contentid: "39"},
     ]
  }),
  computed: {
  },
  created(){

  },
  mounted(){
    this.getAreaCode();
  },

  methods: {
    // 첫번째 지역코드
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
    // 상세 지역 코드(getAreaCode()에서 얻은 지역 코드 값 필요)
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

    }
  }

</script>
