import { createRouter, createWebHistory } from "vue-router";
import UserHome from "../views/UserHome.vue";

const routes = [
  {
    path: "/",
    redirect: "/userHome",
  },
  {
    path: "/userHome",
    name: "UserHome",
    component: UserHome,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
