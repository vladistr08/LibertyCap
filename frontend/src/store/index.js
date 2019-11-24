import Vue from 'vue'
import Vuex from 'vuex'
//import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    authenticated: Boolean,
    token: String,
    token_type: String,
    isSeller: false,
    viewType: true,
    email: String,

    //plugins: [createPersistedState()],

    user: {
      first_name: '',
      last_name: '',
      email: '',
      street_no: '',
      house_no: '',
      psotal_code: '',
      password: '',
      city: '',
      phone: '',
      type: []
    }
  },
  mutations: {
    setViewType (state, s) {
      state.viewType = s;
    },
    setIsSeller (state) {
      state.isSeller=true;
    },
    setIsAuth (state, s) {
      state.authenticated = s;
    },
    setToken(state, s){
      state.token = s;
    },
    setTokenType(state, s){
      state.token_type=s;
    },
    setEmail(state, s){
      state.email=s;
    }
  },
  actions: {
  },
  modules: {
  }
})
