<template>
  <div class="userCourseImage">
    <div class="userHeadImage">
      <img :src="userHeadPicture" class="userHeadImage">
    </div>
    <div class="userName">
       <h1>11{{userName}}22</h1>
    </div>
  </div>
  <card dis-hover style="margin: 24px">
    <tabs>
      <TabPane label="用户信息" name="tab1">

      </TabPane>
      <TabPane label="用户设置" name="tab2">
      </TabPane>
      <TabPane label="账户设置" name="tab3">
      </TabPane>
    </tabs>
  </card>
</template>

<style>
.userCourseImage{
  width: auto;height: 200px;
  background: url("/src/assets/CoursePage/image-4.jpg");
}
.userHeadImage{
  margin: auto;
  width: 150px;
  height: 150px;
  border-radius: 50%;
  object-fit: fill;
}
.userName{
  color: white;
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