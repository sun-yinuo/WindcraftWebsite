<template>

  <Form :model="formItem" :label-width="80" style="top: 10px">
    <FormItem label="被举报的玩家">
      <Input placeholder="谁开了?" v-model="formItem.reportedPlayer"></Input>
    </FormItem>
    <FormItem label="举报玩家">
      <Input placeholder="你是谁?" v-model="formItem.reportPlayer"></Input>
    </FormItem>
    <FormItem label="qq号">
      <Input placeholder="你qq号是啥?" v-model="formItem.qqCode"></Input>
    </FormItem>
    <FormItem label="外挂功能">
      <Input placeholder="被举报的玩家疑似开了......" v-model="formItem.function"></Input>
    </FormItem>
    <FormItem label="区域" >
      <Select filterable v-model="formItem.place">
        <Option value="ffa">FFA</Option>
        <Option value="原版生存">原版生存</Option>
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
      </Select>
    </FormItem>

    <FormItem>
      <Upload
          multiple
          type="drag"
          action="">
        <div style="padding: 20px 0">
          <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
          <p>上传图片以帮助管理员加快审核</p>
        </div>
      </Upload>
    </FormItem>

    <FormItem>
      <Button type="primary" @click="handleSubmit">提交</Button>
      <Button style="margin-left: 8px">取消</Button>
    </FormItem>
  </Form>
</template>


<script>
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
        time: '',
      },
    }
  },
  methods:{
    handleSubmit(){
      //获取表单提交时间
      this.getData()
      //表单信息
      console.log(this.formItem)
    },

    /**
     * 获取时间
     */
    getData(){
      let date = new Date();
      let d = (date.getFullYear()) + '-' + (date.getMonth()) + '-' + (date.getDate()) + ' ' + (date.getHours()) + ":" +(date.getMinutes()) + ':' + (date.getSeconds());
      this.formItem.date = new Date(d).getTime();
    }

  }
}

</script>


