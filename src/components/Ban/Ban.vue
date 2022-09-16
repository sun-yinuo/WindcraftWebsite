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
      <Grid :col="6" :hover="true" v-for="ban in banMsg">
        <GridItem>{{ban.name}}</GridItem>
        <GridItem>{{ban.source}}</GridItem>
        <GridItem>{{ban.reason}}</GridItem>
        <GridItem>{{ban.banType}}</GridItem>
        <GridItem>{{ban.banTime}}</GridItem>
        <GridItem>{{ban.unBanTime}}</GridItem>
      </Grid>
    </TabPane>
    <TabPane label="警告" name="waring"></TabPane>
    <TabPane label="禁言" name="prohibit">
      <Grid :col="5" :hover="true">
        <GridItem>玩家</GridItem>
        <GridItem>来源</GridItem>
        <GridItem>原因</GridItem>
        <GridItem>封禁时间</GridItem>
        <GridItem>解禁时间</GridItem>
      </Grid>
      <Grid :col="5" :hover="true" v-for="prohibit in prohibitMsg">
        <GridItem>{{prohibit.name}}</GridItem>
        <GridItem>{{prohibit.source}}</GridItem>
        <GridItem>{{prohibit.reason}}</GridItem>
        <GridItem>{{prohibit.banTime}}</GridItem>
        <GridItem>{{prohibit.unBanTime}}</GridItem>
      </Grid>
    </TabPane>
  </Tabs>
</template>

<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      banMsg: null,
      prohibitMsg: null
    }
  },
  created() {
    this.getBanList();
    this.getProhibitList()
  },
  methods: {
    getBanList(){
      request.get("/api/getBanList").then(res =>{
        this.banMsg = res
        console.log(this.banMsg)
      })
    },
    getProhibitList(){
      request.get("/api/getProhibitList").then(res => {
        this.prohibitMsg = res;
        console.log(this.prohibitMsg)
      })
    }
  }
}
</script>