<template>
  <Menu mode="horizontal" :theme="theme" active-name="1">
    <!--首页-->
    <MenuItem name="1">首页</MenuItem>
    <!--介绍-->
    <MenuItem name="2">介绍</MenuItem>
    <!--截图-->
    <MenuItem name="3">截图</MenuItem>
    <!--op-->
    <MenuItem name="4">op</MenuItem>
    <!--历程-->
    <MenuItem name="5">历程</MenuItem>
    <!--公告-->
    <MenuItem name="6">公告</MenuItem>
    <!--op申请-->
    <MenuItem name="7">op申请</MenuItem>
    <!--外挂举报-->
    <MenuItem name="8">外挂举报</MenuItem>
    <!--成员动态-->
    <MenuItem name="9">成员动态</MenuItem>
    <!--小黑屋-->
    <MenuItem name="10">小黑屋</MenuItem>
    <!--消息-->
    <MenuItem name="11">消息</MenuItem>
    <!--搜索框-->
    <Input v-model="value" placeholder="随便搜搜呗" style="width: 400px" />
  </Menu>
</template>

<script>
export default {
  /**
   * 设置导航栏的颜色:light,dark,primary
   * @returns {{theme: string}}
   */
  data () {
    return {
      theme: 'light',
      value: ''
    }
  }
}
</script>