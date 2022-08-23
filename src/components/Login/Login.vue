<template>
  <Modal
      v-model="modal"
      title="登陆/注册到WindCraft官方网站"
      @on-ok="ok"
      @on-cancel="cancel"
      ref="login">

    <div class="demo-login">
      <Login @on-submit="handleSubmit">
        <UserName name="username" />
        <Password name="password" />
        <Submit/>
      </Login>
    </div>
  </Modal>
</template>

<script>
import request from "@/utils/request";

export default {
  data () {
    return {
      //登陆窗口状态
      modal: true,
    }
  },
  methods: {
    ok () {
      console.log("login modal is on")
    },
    cancel () {
      console.log("login modal is off")
    },
    handleSubmit (valid ,{ username, password }) {
      if (valid){
        //向后端传参{username,password}
        request.post("/login",{username,password}).then(res =>{
          console.log(res)
        })
      }
    }
  }
}
</script>