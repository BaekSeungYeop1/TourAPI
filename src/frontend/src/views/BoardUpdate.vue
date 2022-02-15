<template>
  <v-row
    justify="center"
    align="center"
  >
    <v-col
      cols="12"
      sm="8"
      md="6"
    >
      <v-form
        @submit.prevent="onSubmit"
      >
        <v-card>
          <v-card-title class="text-h5">
            글 수정
          </v-card-title>
          <v-card-text>
            <v-text-field
              v-model="subject"
              outlined
              label="제목"
              type="text"
              placeholder="제목"
              required
            />
            <v-textarea
              v-model="content"
              outlined
              label="내용"
              type="text"
              placeholder="내용"
              required
            />
          </v-card-text>
          <v-card-actions>
            <v-spacer />
            <v-btn
              color="secondary"
              type="submit"
              nuxt
            >
              저장
            </v-btn>
            <v-btn
              color="secondary"
              nuxt
              @click="$router.back()"
            >
              취소
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-form>
    </v-col>
  </v-row>
</template>

<script>

export default {
  name: 'NewConsult',
  data: () => ({
    subject : '',
    content : '',
  }),
  computed: {

  },
  methods: {
    onSubmit(){
      let id = this.$route.query.id
      let board = {};
      board.subject = this.subject
      board.content = this.content
      board.author = this.$store.state.userStore.nickname
      this.$axios.put("/boardjpa/" + id, JSON.stringify(board),{
           headers:{
             "Content-Type": `application/json`,
             Authorization : "Bearer "+ this.$store.state.userStore.token
        }
      })
          .then(response=>{
            if(response.data.success === true){
            console.log(response.data);
            alert("게시글을 성공적으로 수정했습니다.");
            this.$router.push('./qna')
            }
            else{
              alert("글을 수정할 권한이 없습니다")
            }
          })
          .catch(e=>{
            console.log(e);
          })
    }

  }
}
</script>
