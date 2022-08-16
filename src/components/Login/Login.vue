<template>
  <div class="login">
    <Login @on-submit="handleSubmit">
      <UserName name="username" />
      <Password name="password" />
      <div class="auto-login">
        <Checkbox v-model="autoLogin" size="large">自动登录</Checkbox>
        <a>忘记密码</a>
      </div>
      <Submit />
    </Login>
  </div>
</template>

<script>
export default {
  data () {
    return {
      autoLogin: true
    }
  },
  methods: {
    handleSubmit (valid, { username, password }) {
      if (valid) {
        console.log(username,password)
      }
    }
  }
}
</script>
<style>
  .login{
    width: 400px;
    margin: 0 auto !important;
    left: 50%;
    top: 50%;
    text-align: center;
    background-color: #fff;
    border-radius: 20px;
    height: 350px;
    position: absolute;
    transform: translate(-50%,-50%);
  }
  .auto-login{
    margin-bottom: 24px;
    text-align: left;
  }
  .auto-login a{
    float: right;
  }
</style>