import router from '@/router'

const userStore = {
  state: {
    userId: '',
    //userName: '',
    token: ''
  },
  mutations: {
    login: function (state, payload) {
      state.email = payload.email
      //state.userName = payload.userName
      state.token = payload.token
    },
    loginCheck: function (state, payload) {
      console.log("payload =" + payload)
      if(payload === 401){
        state.token = null;
      }
      if (!state.token) {
        alert("로그인 후 사용할 수 있습니다.");
        router.push({
          name: 'Login'
        }).catch(error => { console.log(error)
        })
      }
    }
  }
}
export default userStore

