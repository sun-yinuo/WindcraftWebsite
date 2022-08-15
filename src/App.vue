<template>
  <Menu></Menu>
</template>
<script>
import Menu from './components/Menu/Menu';

export default {
  components: {
    Menu
  },
  /**
   * 设置导航栏的颜色:light,dark,primary
   * @returns {{theme: string}}
   */
  data () {
    return {
      theme: 'light',
      value: ''
    }
  },
  methods: {

  },
}
</script>
