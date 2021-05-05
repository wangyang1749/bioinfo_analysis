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

export default router
