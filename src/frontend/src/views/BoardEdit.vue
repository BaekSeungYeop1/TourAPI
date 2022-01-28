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
              v-model="consult.title"
              outlined
              label="제목"
              type="text"
              placeholder="제목"
              required
            />
            <v-textarea
              v-model="consult.desc"
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
    consult: {
      title: '',
      desc: '',
    }
  }),
  computed: {

  },
  methods: {


  }
}
</script>
