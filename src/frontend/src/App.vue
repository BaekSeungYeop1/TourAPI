<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <v-app-bar-nav-icon @click="drawer = !drawer" />

      <v-spacer />
      <v-text-field
        v-model="searchKeyword"
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
    >
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
          :to="category.to"
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
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  components: {

  },

  data: () => ({
    searchKeyword: "",
    drawer : false,
    categories : [
       {type : "관광지" , contentid: "12", icon: 'mdi-image', to: '/'},
       {type : "문화시설" , contentid: "14", icon: 'mdi-image', to: '/'},
       {type : "행사/축제" , contentid: "15", icon: 'mdi-image', to: '/'},
       {type : "여행코스" , contentid: "25", icon: 'mdi-image', to: '/'},
       {type : "레포츠" , contentid: "28", icon: 'mdi-image', to: '/'},
       {type : "숙박" , contentid: "32", icon: 'mdi-image', to: '/'},
       {type : "쇼핑" , contentid: "38", icon: 'mdi-image', to: '/'},
       {type : "음식점" , contentid: "39", icon: 'mdi-image', to: '/'},
     ],
    items: [
      { title: 'Dashboard', icon: 'mdi-view-dashboard', to: '/' },
      { title: 'Grid System', icon: 'mdi-image', to: '/grid-system' },
      { title: 'Grid List Page', icon: 'mdi-image', to: '/grid-list-page' },
      { title: 'Breakpoints', icon: 'mdi-image', to: '/breakpoints'},
      { title: 'Typography', icon: 'mdi-image', to: '/typography'},
    ],
    right: null,
  }),
  methods: {
    search(){
      let keyword = this.searchKeyword
      console.log(keyword)
      this.$router.push({path:"./KeywordTourlist",query:{keyword}});
    }
  }
};
</script>

