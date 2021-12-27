<template>
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
</template>

<script>
export default {
  data: () => ({
    tours:[]
  }),
  methods: {
    retrieveUsers(){
      this.$axios.get("/apitest")
          .then(response=>{
            this.tours = response.data.response.body.items.item;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    }
  },
  mounted(){
    this.retrieveUsers();
  }
}
</script>