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
            새글 작성
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
      let board = {};
      board.subject = this.subject
      board.content = this.content
      board.author = this.$store.state.userStore.nickname
      this.$axios.post("/boardjpa/", board, {
        headers:{
             Authorization : "Bearer "+ this.$store.state.userStore.token
        }
      })
          .then(response=>{
            console.log(response.data);
            alert("게시글을 성공적으로 등록했습니다.");
            this.$router.push('./qna')
          })
          .catch(e=>{
            console.log(e);
            this.$store.commit('loginCheck', e.response.status)
          })
    }

  }
}
</script>
