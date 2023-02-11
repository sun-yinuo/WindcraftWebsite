<template>
  <Menu></Menu>
  <Login></Login>
  <router-view></router-view>
</template>
<script>

import Menu from './components/menu/Menu';
import Login from './components/loginRegistered/LoginAndRegistered'

export default {
  //控件导入
  components: {
    Menu,
    Login
  },
}
</script>
