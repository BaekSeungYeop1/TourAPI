<template>
  <v-app>
    <v-container outline>
      <v-row>
        <v-col>
          <v-card
            class="mx-auto"
          >
            <v-card-text>
              <div>{{ board.writeDate }}</div>
              <span class="text-h4">
                제목 : {{ board.subject }}
              </span>
            </v-card-text><hr>
            <v-card-text>
              <span class=" text-h6">
                작성자 : {{ board.author }}
              </span>
            </v-card-text><hr>
            <v-card-text>
              <div>
                <p
                  class="text-h6"
                >
                  {{ board.content }}
                </p>
              </div>
            </v-card-text><hr>
            <v-card-title>
              <v-spacer />
              <v-btn class="mr-4">
                수정
              </v-btn>
              <v-btn>삭제</v-btn>
            </v-card-title>
          </v-card>
          <v-card />
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>
<script>
export default {

  data: () => ({
    board: [],
  }),
   mounted(){
     this.getBoard();
  },
  methods:{
    getBoard(){
      let id = this.$route.query.id
      this.$axios.get("/boardjpa/" + id)
        .then(response=>{
            this.board = response.data.data;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    }
  }
}
</script>

