<template>
  <!--菜单-->
  <Menu mode="horizontal" :theme="theme" active-name="1" width="auto">
    <!--首页-->
    <MenuItem name="1" @click="gotoMainPage">首页</MenuItem>
    <!--介绍-->
    <MenuItem name="2">介绍</MenuItem>
    <!--截图-->
    <MenuItem name="3">截图</MenuItem>
    <!--op-->
    <MenuItem name="4" @click="gotoOPCoursePage">团队介绍</MenuItem>
    <!--历程-->
    <MenuItem name="5" @click="gotoCoursePage">历程</MenuItem>
    <!--op申请-->
    <!--<MenuItem name="7">OP申请</MenuItem>-->
    <!--外挂举报-->
    <MenuItem name="7" @click="gotoReportPage">外挂举报</MenuItem>
    <!--成员动态-->
    <MenuItem name="8">成员动态</MenuItem>
    <!--小黑屋-->
    <MenuItem name="9" @click="gotoBanPage">封神榜</MenuItem>
    <!--消息-->
    <MenuItem name="10">消息</MenuItem>
    <!--搜索框-->
    <Input style="width: auto" placeholder="随便搜搜呗(≧∇≦)ﾉ" />
    <!--搜索按钮-->
    <Button type="primary" icon="ios-search"></Button>
    <!--Q:这里为什么不用input现成的search?
    A:因为合起来的话上边距会直接变为0 尝试过解决但是效果都不满意
    索性拆成两个单独的组件 刚好他俩中间的小地方可以撑下高度 就神奇的垂直置中了-->
  </Menu>
</template>

<script>
import router from "@/router";

export default{
  /**传参**/
  data () {
    return {
      //导航栏颜色
      theme: 'light',
    }
  },
  /**获取菜单栏选择项的id**/
  methods:{
    gotoMainPage(){
      return router.push("/")
    },
    gotoCoursePage(){
      return router.push("/course")
    },
    gotoOPCoursePage(){
      return router.push("/teamCourse")
    },
    gotoReportPage(){
      return router.push("/report")
    },
    gotoBanPage(){
      return router.push("/ban")
    }
  }
}
</script>