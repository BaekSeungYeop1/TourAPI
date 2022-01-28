/* eslint-disable vue/attribute-hyphenation */
<template>
  <v-app>
    <v-app-bar
      app
      color="dark"
      dark
    >
      <v-app-bar-nav-icon @click="drawer = !drawer" />

      <v-spacer />
      <v-btn
        flat
        color="dark"
        style="margin-right:5px;"
        @click="PageLink()"
      >
        <span>Q&A</span>
      </v-btn>
      <v-text-field
        v-model="searchKeyword"
        label="검색어를 입력하세요"
        placeholder="검색어를 입력하세요"
        append-icon="mdi-magnify"
        flat
        hide-details
        solo-inverted
        style="max-width: 300px;"
        @keyup.enter="search()"
      />
    </v-app-bar>
    <v-navigation-drawer
      v-model="drawer"
      app
      dark
      :src="require('@/assets/sidebar.jpg')"
    >
      <template
        #img="props"
      >
        <v-img
          :gradient="gradient"
          v-bind="props"
        />
      </template>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">
            우리나라 관광지
          </v-list-item-title>
          <v-list-item-subtitle>
            소개
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider />

      <v-list
        dense
        nav
      >
        <v-list-item
          v-for="category in categories"
          :key="category.type"
          link
          :to="{name : category.to, query:{ contentId : category.contentid, areaCode: 0, subAreaCode: 0}}"
          active-class="primary"
          class="py-1"
          @click="clickEvent(category.to,category.contentid)"
        >
          <v-list-item-icon>
            <v-icon>{{ category.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ category.type }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <v-container fluid>
        <Searchbar
          v-if="disableRouter.includes($route.name)"
          :childurl="clickedUrl"
          :childcontentid="clickedContentId"
        />
        <router-view :key="$route.fullPath" />
        <Footer />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import Searchbar from './views/Searchbar.vue';
import Footer from './views/Footer.vue';

export default {
  name: 'App',

  components: {
    Searchbar,
    Footer,
  },

  data: () => ({
    searchKeyword: "",
    drawer : false,
    disableRouter : ["Travel","Culture","Festival","Travelcourse","Leports","Accommodation","Shopping","Food"],
    gradient: 'rgba(0, 0, 0, .7), rgba(0, 0, 0, .7)',
    categories : [
       {type : "관광지" , contentid: "12", icon: 'mdi-image', to: 'Travel'},
       {type : "문화시설" , contentid: "14", icon: 'mdi-image', to: 'Culture'},
       {type : "행사/축제" , contentid: "15", icon: 'mdi-image', to: 'Festival'},
       {type : "여행코스" , contentid: "25", icon: 'mdi-image', to: 'Travelcourse'},
       {type : "레포츠" , contentid: "28", icon: 'mdi-image', to: 'Leports'},
       {type : "숙박" , contentid: "32", icon: 'mdi-image', to: 'Accommodation'},
       {type : "쇼핑" , contentid: "38", icon: 'mdi-image', to: 'Shopping'},
       {type : "음식점" , contentid: "39", icon: 'mdi-image', to: 'Food'},
     ],
     clickedUrl : "",
     clickedContentId : "",
     right: null,

  }),
  methods: {
    search(){
      let keyword = this.searchKeyword
      console.log(keyword)
      this.$router.push({path:"./KeywordTourlist",query:{keyword}});
    },
    clickEvent(to,contentid){
      this.clickedUrl = to;
      this.clickedContentId = contentid
      console.log("clickedUrl=" + to);
      console.log("clickedContentId=" + contentid)
    },
    PageLink(){
       this.$router.push({path:"./qna"});
    }
  }
};
</script>

