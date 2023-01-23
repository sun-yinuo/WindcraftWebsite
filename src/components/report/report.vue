<template>
  <Form :model="formItem" label-width="top" style="margin: 2%">
    <FormItem label="你觉得谁开了？">
      <Input placeholder="被举报玩家名称" v-model="formItem.reportedPlayer"></Input>
    </FormItem>
    <FormItem label="你是？">
      <Input placeholder="你的玩家名称" v-model="formItem.reportPlayer"></Input>
    </FormItem>
    <FormItem label="你的联系方式？">
      <Input placeholder="QQ号/微信号/邮箱/游戏内玩家名称" v-model="formItem.qqCode"></Input>
    </FormItem>
    <FormItem label="他开了什么？">
      <Input placeholder="被举报的玩家疑似开了......" v-model="formItem.function"></Input>
    </FormItem>
    <FormItem label="区域？" >
      <Select filterable v-model="formItem.place">
        <Option value="ffa">FFA</Option>
        <Option value="原版生存">原版生存</Option>
        <!--
        <Option value="竞技场">竞技场</Option>
        <Option value="起床战争">起床战争</Option>
        <Option value="躲猫猫">躲猫猫</Option>
        <Option value="短跑赛手">短跑赛手</Option>
        <Option value="bingo">BINGO</Option>
        <Option value="跑酷">跑酷</Option>
        <Option value="箭有虚发">箭有虚发</Option>
        <Option value="不要做挑战">不要做挑战</Option>
        <Option value="空岛战争">空岛战争</Option>
        <Option value="猎人游戏">猎人游戏</Option>
        <Option value="极限生存冠军">极限生存冠军</Option>
        <Option value="死亡互换">死亡互换</Option>
        <Option value="速通竞赛">速通竞赛</Option>
        <Option value="速通竞赛">街机游戏</Option>
        Windcraft不一样了所以改变了可用选项-->
      </Select>
    </FormItem>

    <FormItem>
      <Upload
          :data="this.formItem"
          multiple
          type="drag"
          action="http://127.0.0.1:9000/reportgame/api/fileUpload">
        <div style="padding: 20px 0">
          <Icon type="ios-cloud-upload" size="56" style="color: dodgerblue"></Icon>
          <p>上传图片以帮助管理员加快审核</p>
        </div>
      </Upload>
    </FormItem>
    <FormItem>
      <Button long type="primary" @click="upload">提交</Button>
    </FormItem>
  </Form>
</template>


<script>
import request from "@/utils/request";

export default {
  data () {
    return {
      formItem: {
        //被举报的玩家
        reportedPlayer: '',
        //举报玩家
        reportPlayer:'',
        //qq号
        qqCode:'',
        //外挂功能
        function:'',
        //地点
        place: '',
        //时间
        date: '',
      },
    }
  },
  methods:{
    handleSubmit(){
      //获取表单提交时间
      this.getData()
      //传递
      request.post("/reportgame/report",this.formItem).then(res =>{
        console.log(res)
        switch (res.code){
          case 200:
            this.$Message.success(res.msg);
            break;
          default:
            this.$Message.warning(res.msg);
            break;
        }
      })
    },

    /**
     * 获取时间
     */
    getData(){
      let date = new Date();
      let d = (date.getFullYear()) + '-' + (date.getMonth()) + '-' + (date.getDate()) + ' ' + (date.getHours()) + ":" +(date.getMinutes()) + ':' + (date.getSeconds());
      this.formItem.date = new Date(d).getTime();
    },

    /**
     * 上传方法
     */
    upload(){
      this.handleSubmit();
    },
  }
}

</script>