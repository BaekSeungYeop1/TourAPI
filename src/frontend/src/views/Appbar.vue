<template>
  <v-app>
    <v-app-bar 
      app
      flat
    >
      <v-container class="mx-auto py-0">
        <v-row align="center">
          <v-img
            class="mx-2"
            src="https://i.imgur.com/qgGY4tB.png"
            max-height="40"
            max-width="40"
            contain
            @click="$vuetify.goto(0)"
          />
      
          <v-toolbar-title class="ml-2">
            관광지
          </v-toolbar-title>
          <v-text-field
            v-model="searchKeyword"
            append-icon="mdi-magnify"
            flat
            hide-details
            solo-inverted
            style="max-width: 300px;"
            @keyup.enter="search()"
          />
        </v-row>
      </v-container>
    </v-app-bar>
  </v-app>
</template>
<script>
export default {
  data: () => ({
    searchKeyword: ""
  }),
  methods: {
    search(){
      let keyword = this.searchKeyword
      console.log(keyword)
      this.$router.push({path:"./KeywordTourlist",query:{keyword}});
    }
  }
  
}
</script>
