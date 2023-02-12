<template>
  <div class="userCourseImage"></div>
    <div class="userHeadImage">
      <img :src="userHeadPicture" class="userHeadImage">
    </div>
    <div class="userName">
      <h1>{{userName}}</h1>
  </div>
  <div style="margin: auto">
      <Button type="primary" icon="ios-create-outline">编辑个人资料</Button>
      <Button type="error" icon="ios-alert-outline">注销账户</Button>
  </div>
</template>

<style>
.userCourseImage{
  margin-bottom: 10px;
  width: auto;height: 250px;
  background: url("/src/assets/CoursePage/image-4.jpg");
}
.userHeadImage{
  margin: auto;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  object-fit: fill;
}
.userName{
  width: auto;
  text-align: center
}
</style>

<script>
import request from "@/utils/request";


export default {
  data(){
    return{
      userName: null,
      userHeadPicture: "",
      userCoverPicture: "",
    }
  },
  methods :{
    getLoginUserName(){
      request.get("userconfig/api/getLoginUserName").then(res => {
        this.userName = res
      })
    },
    getUserHeadPicture(){
      request.get("userconfig/api/getUserHeadPicture").then(res => {
        this.userHeadPicture = res;
      })
    }
  },
  created() {
    this.getLoginUserName();
    this.getUserHeadPicture();
    if (this.userHeadPicture === ""){
      this.userHeadPicture = ""
    }
  }
}
</script>