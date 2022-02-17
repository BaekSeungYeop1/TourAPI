<template>
  <v-app>
    <v-card>
      <v-card-title>
        Q&A
        <v-spacer />

        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        />
      </v-card-title>

      <v-data-table
        :headers="headers"
        :items="boardList"
        :loading="loading"
        :search="search"
      >
        <template
          v-slot:item="{item}"
        >
          <tr @click="clickRow(item.id)">
            <td :class="headers[0].class">
              {{ item.id }}
            </td>
            <td :class="headers[1].class">
              {{ item.subject }}
            </td>
            <td :class="headers[2].class">
              {{ item.author }}
            </td>
            <td :class="headers[3].class">
              {{ item.writeDate }}
            </td>
            <td :class="headers[4].class">
              {{ item.readCount }}
            </td>
          </tr>
        </template>

        <v-alert
          slot="no-results"
          :value="true"
          color="error"
          icon="warning"
        >
          입력하신 검색어 "{{ search }}"를 찾지 못했습니다.
        </v-alert>
      </v-data-table>
      <v-card-title>
        <v-spacer />
        <v-btn
          depressed
          small
          class="mx-auto gray"
          @click="linkToEdit()"
        >
          <v-icon> mdi-border-color</v-icon>
        </v-btn>
      </v-card-title>
    </v-card>
  </v-app>
</template>
<script>
export default {
  data: () => ({
    search: '',
    boardList: [],
    loading: false,
    headers: [
      { text: '번호', value: 'id', sortable: true },
      { text: '제목', value: 'subject', sortable: true },
      { text: '글쓴이', value: 'author', sortable: false },
      { text: '등록일', value: 'writeDate', sortable: true },
      { text: '조회', value: 'readCount', sortable: true }
    ]
  }),
   mounted(){
    this.getBoardList();
  },
  methods:{
    getBoardList(){
         this.$axios.get("/boardjpa/",{
           headers:{
             Authorization : "Bearer "+ this.$store.state.userStore.token
        }
         })
          .then(response=>{
            this.boardList = response.data.data;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
            this.$store.commit('loginCheck', e.response.status)
          })
    },
    clickRow(id){
      this.$router.push({path:'./board',query:{id}})
    },
    linkToEdit(){
      this.$router.push({path:'./boardedit'})
    },
  }
}
</script>
