<template>
  <v-app>
    <v-container>
      <v-row>
        <v-col>
          <v-data-table
            :headers="headers"
            :items="boardList"
            :loading="loading"
          >
            <template
              slot="items"
              slot-scope="props"
            >
              <td :class="headers[0].class">
                {{ props.item.id }}
              </td>
              <td :class="headers[1].class">
                {{ props.item.subject }}
              </td>
              <td :class="headers[2].class">
                {{ props.item.author }}
              </td>
              <td :class="headers[3].class">
                {{ props.item.writeDate }}
              </td>
              <td :class="headers[4].class">
                {{ props.item.readCount }}
              </td>
            </template>
          </v-data-table>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>
<script>
export default {
  data: () => ({
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
         this.$axios.get("/boardjpa/")
          .then(response=>{
            this.boardList = response.data.data;
            console.log(response.data);
          })
          .catch(e=>{
            console.log(e);
          })
    },
  }
}
</script>
