<template>
  <Tabs value="tabs" type="card" style="bottom: -10px">
    <TabPane label="封禁" name="ban">
      <Grid :col="6" :hover="true">
        <GridItem>玩家</GridItem>
        <GridItem>来源</GridItem>
        <GridItem>原因</GridItem>
        <GridItem>封禁类型</GridItem>
        <GridItem>封禁时间</GridItem>
        <GridItem>解禁时间</GridItem>
      </Grid>
      <Grid :col="6" :hover="true" v-for="ban in msg">
        <GridItem>{{ban.name}}</GridItem>
        <GridItem>{{ban.source}}</GridItem>
        <GridItem>{{ban.reason}}</GridItem>
        <GridItem>{{ban.banType}}</GridItem>
        <GridItem>{{ban.banTime}}</GridItem>
        <GridItem>{{ban.unBanTime}}</GridItem>
      </Grid>
    </TabPane>
    <TabPane label="警告" name="waring"></TabPane>
    <TabPane label="禁言" name="prohibit"></TabPane>
  </Tabs>
</template>

<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      msg: null,
    }
  },
  created() {
    this.getBanList();
  },
  methods: {
    getBanList(){
      request.get("/api/getBanList").then(res =>{
        this.msg = res
        console.log(this.msg)
      })
    }
  }
}
</script>