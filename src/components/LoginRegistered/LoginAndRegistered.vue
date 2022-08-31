<template>
  <Modal
      v-model="loginModal"
      title="登陆到WindCraft官方网站"
      ref="login">
    <space class="text" @click="gotoRegistered">没有账号?注册一个</space>
    <div class="login" style="position:relative;">
      <Login @on-submit="loginHandleSubmit">
        <UserName name="username" />
        <Password name="password" />
        <Submit/>
      </Login>
    </div>
  </Modal>

  <Modal
      v-model="registeredModal"
      title="注册WindCraft官方网站"
      ref="login">

    <div class="register">
      <Login ref="form" @on-submit="registeredHandleSubmit">
        <UserName name="username"/>
        <Poptip trigger="focus" placement="right" width="240">
          <Password name="password" :rules="passwordRule" placeholder="至少6位密码，区分大小写" @on-change="registeredHandleChangePassword" />
          <template #content>
            <div class="register-tip">
              <div class="register-tip-title" :class="passwordTip.class">
                强度：{{ passwordTip.strong }}
              </div>
              <Progress :percent="passwordTip.percent" hide-info :stroke-width="6" :stroke-color="passwordTip.color" />
              <div class="register-tip-desc">
                8个字符，至少1个大写字母，1个小写字母和1个数字
              </div>
            </div>
          </template>
        </Poptip>
        <Password name="passwordConfirm" :rules="passwordConfirmRule" placeholder="确认密码" />
        <Submit>注册</Submit>
      </Login>
    </div>
  </Modal>
</template>

<script>
import request from "@/utils/request";

export default {
  data () {
    //注册两次密码不匹配
    const validatePassCheck = (rule, value, callback) => {
      if (value !== this.$refs.form.formValidate.password) {
        callback(new Error('两次输入的密码不匹配！'));
      } else {
        callback();
      }
    }
    return {
      theme: 'light',
      //登陆窗口状态
      loginModal: true,
      //注册窗口状态
      registeredModal: false,

      //注册提示msg
      passwordRule: [
        {
          required: true, message: '密码不能为空！', trigger: 'change'
        },
        {
          min: 8, message: '密码不能少于8位！', trigger: 'change'
        }
      ],
      passwordConfirmRule: [
        {
          required: true, message: '确认密码不能为空！', trigger: 'change'
        },
        { validator: validatePassCheck, trigger: 'change' }
      ],
      // 密码长度，在密码强度提示时作为判断依据
      passwordLen: 0
    }
  },
  methods: {
    notice(title,desc) {
      this.$Notice.open({
        title: title,
        desc: desc,
      });
    },

    //----------goto----------
    gotoRegistered() {
      this.loginModal = false;
      this.registeredModal = true;
    },

    loginHandleSubmit (valid ,{ username, password }) {
      if (valid){
        //向后端传参{username,password}
        request.post("/login",{username,password}).then(res =>{
          this.loginCallBackSwitch(res);
        })
      }
    },
    loginCallBackSwitch(res){
      switch (res) {
        //成功
        case 600:
          this.notice("登陆","登陆成功");
          this.loginModal = false;
          break;
        //用户名或密码错误
        case 610:
          this.notice("登陆","用户名或密码错误");
          break;
        //sql注入
        case 710:
          this.notice("登陆","你是tm真行,给我tm玩这出,你以为我没防啊?")
          break;
      }
    },

    //----------registered----------
    registeredHandleChangePassword (val) {
      this.passwordLen = val.length;
    },
    registeredHandleSubmit (valid, { username, password }) {
      if (valid) {
        //向后端传参{username,password}
        request.post("/registered",{username,password}).then(res =>{
          this.registeredCallBackSwitch(res);
        })
      }
    },
    registeredCallBackSwitch(res){
      switch (res) {
        //成功
        case 700:
          this.notice("注册","注册成功")
          //跳转到登陆页
          this.registeredModal = false;
          this.loginModal = true;
          break;
        //sql注入
        case 710:
          this.notice("注册","你是tm真行,给我tm玩这出,你以为我没防啊?")
          break;
        //注册时用户名或密码不符合规范
        case 770:
          this.notice("注册","用户名或密码不符合规范")
          break;
        //用户名重复
        case 750:
          this.notice("注册","用户名重复")
          break;
        //注册失败
        case 500:
          this.notice("注册","注册失败")
          break;
      }
    },
  },

  computed:{
    // 密码强度提示
    passwordTip () {
      let strong = '强';
      let className = 'strong';
      let percent = this.passwordLen > 10 ? 10 : this.passwordLen;
      let color = '#19be6b';

      if (this.passwordLen < 6) {
        strong = '太短';
        className = 'low';
        color = '#ed4014';
      } else if (this.passwordLen < 10) {
        strong = '中';
        className = 'medium';
        color = '#ff9900';
      }

      return {
        strong,
        class: 'demo-register-tip-' + this.passwordLen < 6 ? 'low' : (this.passwordLen < 10 ? 'medium' : 'strong'),
        percent: percent * 10,
        color
      }
    }
  },

  //自动执行
  created() {

  }
}
</script>

<style>
.register{
  width: 400px;
  margin: 0 auto !important;
}
.register .ivu-poptip, .register .ivu-poptip-rel {
  display: block;
}
.register-tip{
  text-align: left;
}
.register-tip-title{
  font-size: 14px;
}
.register-tip-desc{
  white-space: initial;
  font-size: 14px;
  margin-top: 6px;
}
.text{
  position:absolute;
  bottom: 17px;
  font-size: 15px;
  color: #2d8cf0;
}
</style>