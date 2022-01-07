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
    path: '/areatourlist',
    name: 'AreaTourlist',
    component: () => import('../views/AreaTourlist.vue')
  },
  {
    path: '/keywordtourlist',
    name: 'KeywordTourlist',
    component: () => import('../views/KeywordTourlist.vue')
  },
  {
    path: '/searchbar',
    name: 'Searchbar',
    component: () => import('../views/Searchbar.vue')
  },
  {
    path: '/appbar',
    name: 'Appbar',
    component: () => import('../views/Appbar.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
