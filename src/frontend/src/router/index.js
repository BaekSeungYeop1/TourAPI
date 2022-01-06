import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue')
  },
  {
    path: '/tourlist',
    name: 'Tourlist',
    component: () => import('../views/Tourlist.vue')
  },
  {
    path: '/searchbar',
    name: 'Searchbar',
    component: () => import('../views/Searchbar.vue')
  },
  {
    path: '/cc',
    name: 'CC',
    component: () => import('../views/Aboutpaging.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
