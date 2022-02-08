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
    loginCheck: function (state) {
      if (!state.token) {
        router.push({
          name: 'Login'
        }).catch(error => { console.log(error)
        })
      }
    }
  }
}
export default userStore

