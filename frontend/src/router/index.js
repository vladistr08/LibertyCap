import Vue from 'vue'
import VueRouter from 'vue-router'
import Signin from '../views/Sign in'
import Login from '../views/Log in'
import Home from '../views/Home'
import Sell from '../views/Sell'

Vue.use(VueRouter)

const routes = [
  {
    path: '/signin',
    name: 'signin',
    component: Signin
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/sell',
    name: 'Sell',
    component: Sell
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
