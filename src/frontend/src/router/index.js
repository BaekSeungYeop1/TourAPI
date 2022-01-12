import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import About from '@/views/About.vue'
import AreaTourlist from '@/views/AreaTourlist.vue'
import KeywordTourlist from '@/views/KeywordTourlist.vue'
import Searchbar from '@/views/Searchbar.vue'
import Appbar from '@/views/Appbar.vue'
import CommonInfo from '@/views/CommonInfo.vue'

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
    component: About
  },
  {
    path: '/areatourlist',
    name: 'AreaTourlist',
    component: AreaTourlist
  },
  {
    path: '/keywordtourlist',
    name: 'KeywordTourlist',
    component: KeywordTourlist
  },
  {
    path: '/searchbar',
    name: 'Searchbar',
    component: Searchbar
  },
  {
    path: '/appbar',
    name: 'Appbar',
    component: Appbar
  },
  {
    path: '/commoninfo',
    name: 'CommonInfo',
    component: CommonInfo
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
