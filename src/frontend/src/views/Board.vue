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
              <v-btn
                class="mr-4"
                @click="linkToUpdate"
              >
                수정
              </v-btn>
              <v-btn
                @click="deleteBoard"
              >
                삭제
              </v-btn>
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
     this.getCookie();
  },
  methods:{
    getBoard(){
      let id = this.$route.query.id
      this.$axios.get("/boardjpa/" + id,{
           headers:{
             Authorization : "Bearer "+ this.$store.state.userStore.token
        }
      })
        .then(response=>{
            this.board = response.data.data;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
    linkToUpdate(){
      let id = this.$route.query.id
      this.$router.push({path:'./boardupdate',query:{id}})
    },
    deleteBoard(){
      let id = this.$route.query.id
      let author = this.$store.state.userStore.nickname
      this.$axios.delete("/boardjpa/" + id,{
        headers:{
          Authorization : "Bearer "+ this.$store.state.userStore.token
        },
        data: {
          author : author
        }
      })
        .then(response=>{
          if(response.data.success === true){
            console.log(response.data);
            alert("글이 삭제되었습니다.");
            this.$router.push('./qna')
          }
          else{
            alert("글을 삭제할 권한이 없습니다")
          }
          })
          .catch(e=>{
            console.log(e);
            this.$store.commit('loginCheck', e.response.status)
          })
    },
    getCookie(){
      let id = this.$route.query.id;
      this.$axios.get("boardjpa/views/"+ id,{
        headers:{
          Authorization : "Bearer "+ this.$store.state.userStore.token
      },
      })

      const cookie = this.$cookies.get('viewCount');
      console.log(cookie); //testValue
    }
  }
}
</script>

