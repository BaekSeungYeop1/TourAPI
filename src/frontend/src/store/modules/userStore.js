import router from '@/router'

const userStore = {
  state: {
    email: '',
    nickname: '',
    token: '',
    isLogin: false
  },
  mutations: {
    login: function (state, payload) {
      state.email = payload.email
      state.nickname = payload.nickname
      state.token = payload.token
      state.isLogin = true
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
    },
    logout: function (state) {
      state.email = ''
      state.nickname = ''
      state.token = ''
      state.isLogin = false

      console.log(state)
    },
  }
}
export default userStore

