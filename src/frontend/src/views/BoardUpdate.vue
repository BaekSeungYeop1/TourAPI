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
              v-model="board.subject"
              outlined
              label="제목"
              type="text"
              placeholder="제목"
              required
            />
            <v-textarea
              v-model="board.author"
              outlined
              label="작성자"
              type="text"
              placeholder="작성자"
              required
            />
            <v-textarea
              v-model="board.content"
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
    board: {
    subject : '',
    content : '',
    author : ''
    }
  }),
  computed: {

  },
  methods: {
    onSubmit(){
      let id = this.$route.query.id
      this.$axios.put("/boardjpa/" + id, this.board)
          .then(response=>{
            console.log(response.data);
            alert("게시글을 성공적으로 수정했습니다.");
            this.$router.push('./qna')
          })
          .catch(e=>{
            console.log(e);
          })
    }

  }
}
</script>
