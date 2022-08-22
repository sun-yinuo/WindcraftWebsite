<template>
  <!--菜单-->
  <Menu mode="horizontal" :theme="theme" active-name="1" @on-select="onSelectId" width="auto">
    <!--首页-->
    <MenuItem name="1" @click="gotoMainPage">首页</MenuItem>
    <!--介绍-->
    <MenuItem name="2">介绍</MenuItem>
    <!--截图-->
    <MenuItem name="3">截图</MenuItem>
    <!--op-->
    <MenuItem name="4">OP介绍</MenuItem>
    <!--历程-->
    <MenuItem name="5" @click="gotoCoursePage">历程</MenuItem>
    <!--op申请-->
    <MenuItem name="7">OP申请</MenuItem>
    <!--外挂举报-->
    <MenuItem name="8">外挂举报</MenuItem>
    <!--成员动态-->
    <MenuItem name="9">成员动态</MenuItem>
    <!--小黑屋-->
    <MenuItem name="10">小黑屋</MenuItem>
    <!--消息-->
    <MenuItem name="11">消息</MenuItem>
    <!--搜索框-->
    <Input v-model="value" placeholder="随便搜搜呗(≧∇≦)ﾉ" style="width: 400px; margin: 10px" />
    <!--搜索按钮-->
    <Button type="primary" icon="ios-search" style="margin: 10px">Search</Button>

  </Menu>
</template>

<script>
//下次别给老子看到你没导入依赖，草泥马
import router from "@/router";
import request from "@/utils/request";

export default{
  /**传参**/
  data () {
    return {
      //导航栏颜色
      theme: 'light',
      //输入框默认值
      value: '',
    }
  },
  /**获取菜单栏选择项的id**/
  methods:{
    onSelectId (name) {
      console.log(name)
    },
    gotoCoursePage(){
      return router.push("/course")
    },
    gotoMainPage(){
      return router.push("/")
    }
  }
}
</script>