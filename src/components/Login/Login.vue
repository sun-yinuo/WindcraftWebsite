<template>
  <Modal
      v-model="modal"
      title="登陆/注册到WindCraft官方网站"
      @on-ok="ok"
      @on-cancel="cancel">
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
export default {
  data () {
    return {
      //登陆窗口状态
      modal: false,
    }
  },
  methods: {
    ok () {
      console.log("log modal is on")
    },
    cancel () {
      console.log("log modal is off")
    },
    handleSubmit (valid ,{ username, password }) {
      if (valid){
        //TODO 上线前给老子删掉,别他妈的留着,别他妈到时候看到用户名和密码被打日志里
        console.log(username,password)
      }
    }
  }
}
</script>