<template>
  <v-app id="inspire">
    <v-main class="blue-grey lighten-4">
      <!-- Login Component -->
      <v-container
        style="max-width: 450px"
        fill-height
      >
        <v-row align="center">
          <v-col cols="12">
            <v-card>
              <div class="pa-10">
                <h1
                  style="text-align: center"
                  class="mb-10"
                >
                  Login
                </h1>
                <v-form>
                  <v-text-field
                    v-model="userId"
                    required
                    label="ID"
                    prepend-inner-icon="mdi-account"
                  />
                  <v-text-field
                    v-model="userPassword"
                    required
                    prepend-inner-icon="mdi-lock"
                    type="password"
                    label="Password"
                  />
                  <v-card-actions>
                    <v-btn
                      color="blue lighten-1 text-capitalize"
                      depressed
                      large
                      block
                      dark
                      class="mb-3"
                      @click="loginSubmit()"
                    >
                      Login
                    </v-btn>
                  </v-card-actions>
                </v-form>
              </div>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data () {
    return {
      userId: '',
      UserPassword: '',
    }
  },

  methods: {
    loginSubmit() {
      if(this.email&&this.password){
        let saveData = {};
        saveData.userPassword = this.userId;
        saveData.userPassword = this.userPassword;
        try {
          this.$axios.post("/authenticate", JSON.stringify(saveData), {
            headers: {
              "Content-Type": `application/json`,
            },
          })
              .then((response) => {
                if (response.status === 200) {
                  alert("로그인 성공")
                  this.$store.commit('login', response.data)
                  this.$router.push({path: './'});
                }
              })
              .catch(error =>{
                console.log(error.response);
                if(error.response.status===401){
                  alert("인증오류. 아이디와 비밀번호를 확인해주세요");
                  this.userId = null;
                  this.userPassword = null;
                }
               });
        } catch (error) {
          console.error(error);
        }
      }else{
        alert("아이디 혹은 비밀번호가 입력되지 않았습니다")
      }
      },
  },




}

</script>


