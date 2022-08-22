<template>
  <Menu></Menu>
  <Login></Login>
  <router-view></router-view>
</template>
<script>
import Menu from './components/Menu/Menu';
import Login from './components/Login/Login'

export default {
  //控件导入
  components: {
    Menu,
    Login
  },
}
</script>
