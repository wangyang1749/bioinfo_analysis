import Vue from 'vue'
import VueRouter from 'vue-router'
//import Home from '../views/Home.vue'
import BasicLayout from '@/layout/BasicLayout.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "Login" */ '../views/Login.vue'),
  },
  {
    path: '/',
    name: 'Home',
    component: BasicLayout
  },
  {
    path: '/TCGA',
    name: 'TCGA',
    component: () => import(/* webpackChunkName: "TCGA" */ '../views/TCGA.vue'),
    children: [
      {
        path: 'count',
        name: 'TCGA_count',
        component: () => import(/* webpackChunkName: "TCGA_count" */ '../views/TCGA/count.vue'),
      }, {
        path: 'Test',
        name: 'TCGA_test',
        component: () => import(/* webpackChunkName: "Test" */ '../views/TCGA/Test.vue'),
      }
    ]
  },
  {
    path: '/user',
    name: 'User',
    component: () => import(/* webpackChunkName: "TCGA" */ '../views/User.vue'),
    children: [
      {
        path: 'user_list',
        name: 'user_list',
        component: () => import(/* webpackChunkName: "user_list" */ '../views/User/user_list.vue'),
      },  {
        path: 'role_list',
        name: 'role_list',
        component: () => import(/* webpackChunkName: "role_list" */ '../views/User/role_list.vue'),
      },{
        path: 'Test',
        name: 'TCGA_test',
        component: () => import(/* webpackChunkName: "Test" */ '../views/User/Test.vue'),
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]



const router = new VueRouter({
  // mode: 'history',
  base: process.env.BASE_URL,
  routes
})
// 全局路由守卫
router.beforeEach((to, from, next) => {
  var token = localStorage.getItem("jwtToken");

  if(token == null && to.name != 'Login'){
    next('/login')
    return      
  } 
  // 已登录状态；当路由到 UserLogIn 时，跳转至 Home
  if (to.name === 'Login') {
    if (token != null) {
      next('/')
      return
    }
  }
  next() // 必须使用 next ,执行效果依赖 next 方法的调用参数
})

export default router
