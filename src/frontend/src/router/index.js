import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import Footer from '@/views/Footer.vue'
import About from '@/views/About.vue'
import Login from '@/views/Login.vue'
import SignUp from '@/views/Signup.vue'
import AreaTourlist from '@/views/AreaTourlist.vue'
import KeywordTourlist from '@/views/KeywordTourlist.vue'
import Searchbar from '@/views/Searchbar.vue'
import Appbar from '@/views/Appbar.vue'
import CommonInfo from '@/views/CommonInfo.vue'
import CommonInfo1 from '@/views/CommonInfo copy.vue'
import Travel from '@/views/category/Travel.vue'
import Culture from '@/views/category/Culture.vue'
import Festival from '@/views/category/Festival.vue'
import Travelcourse from '@/views/category/Travelcourse.vue'
import Leports from '@/views/category/Leports.vue'
import Accommodation from '@/views/category/Accommodation.vue'
import Shopping from '@/views/category/Shopping.vue'
import Food from '@/views/category/Food.vue'
import QnA from '@/views/QnA.vue'
import Board from '@/views/Board.vue'
import BoardEdit from '@/views/BoardEdit.vue'
import BoardUpdate from '@/views/BoardUpdate.vue'
import DetailCulture from '@/views/category/DetailCulture'
import DetailFestival from '@/views/category/DetailFestival'
import DetailFood from '@/views/category/DetailFood'
import DetailShopping from '@/views/category/DetailShopping'
import DetailLeports from '@/views/category/DetailLeports'
import DetailAccommodation from '@/views/category/DetailAccommodation'

Vue.use(VueRouter)


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/footer',
    name: 'Footer',
    component: Footer
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
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
  },
  {
    path: '/commoninfo1',
    name: 'CommonInfo1',
    component: CommonInfo1
  },
  {
    path: '/travel',
    name: 'Travel',
    component: Travel
  },
  {
    path: '/culture',
    name: 'Culture',
    component: Culture
  },
  {
    path: '/festival',
    name: 'Festival',
    component: Festival
  },
  {
    path: '/travelcourse',
    name: 'Travelcourse',
    component: Travelcourse
  },
  {
    path: '/leports',
    name: 'Leports',
    component: Leports
  },
  {
    path: '/accommodation',
    name: 'Accommodation',
    component: Accommodation
  },
  {
    path: '/shopping',
    name: 'Shopping',
    component: Shopping
  },
  {
    path: '/food',
    name: 'Food',
    component: Food
  },
  {
    path: '/qna',
    name: 'QnA',
    component: QnA
  },
  {
    path: '/board',
    name: 'Board',
    component: Board
  },
  {
    path: '/boardedit',
    name: 'BoardEdit',
    component: BoardEdit
  },
  {
    path: '/boardupdate',
    name: 'BoardUpdate',
    component: BoardUpdate
  },
  {
    path: '/detailculture',
    name: 'DetailCulture',
    component: DetailCulture
  },
  {
    path: '/detailfestival',
    name: 'DetailFestival',
    component: DetailFestival
  },
  {
    path: '/detailfood',
    name: 'DetailFood',
    component: DetailFood
  },
  {
    path: '/detailshopping',
    name: 'DetailShopping',
    component: DetailShopping
  },
  {
    path: '/detailleports',
    name: 'DetailLeports',
    component: DetailLeports
  },
  {
    path: '/detailaccommodation',
    name: 'DetailAccommodation',
    component: DetailAccommodation
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
