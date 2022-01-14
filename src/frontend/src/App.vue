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
          v-for="item in items"
          :key="item.title"
          link
          :to="item.to"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
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

