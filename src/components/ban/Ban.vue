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
      <Grid :col="6" :hover="true" v-for="ban in banList">
        <GridItem>{{ban.name}}</GridItem>
        <GridItem>{{ban.source}}</GridItem>
        <GridItem>{{ban.reason}}</GridItem>
        <GridItem>{{ban.banType}}</GridItem>
        <GridItem>{{ban.banTime}}</GridItem>
        <GridItem>{{ban.unBanTime}}</GridItem>
      </Grid>
    </TabPane>
    <TabPane label="警告" name="waring">
      <Grid :col="4" :hover="true">
        <GridItem>玩家</GridItem>
        <GridItem>来源</GridItem>
        <GridItem>原因</GridItem>
        <GridItem>时间</GridItem>
      </Grid>
      <Grid :col="4" :hover="true" v-for="waring in waringList">
        <GridItem>{{waring.name}}</GridItem>
        <GridItem>{{waring.source}}</GridItem>
        <GridItem>{{waring.reason}}</GridItem>
        <GridItem>{{waring.time}}</GridItem>
      </Grid>
    </TabPane>
    <TabPane label="禁言" name="prohibit">
      <Grid :col="5" :hover="true">
        <GridItem>玩家</GridItem>
        <GridItem>来源</GridItem>
        <GridItem>原因</GridItem>
        <GridItem>封禁时间</GridItem>
        <GridItem>解禁时间</GridItem>
      </Grid>
      <Grid :col="5" :hover="true" v-for="prohibit in prohibitList">
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
      banList: null,
      prohibitList: null,
      waringList: null,
    }
  },
  created() {
    this.getBanList();
    this.getProhibitList()
    this.getWaringList()
  },
  methods: {
    getBanList(){
      request.get("http://127.0.0.1:9090/api/getBanList").then(res =>{
        this.banList = res
        console.log(this.banList);
      })
    },
    getProhibitList(){
      request.get("http://127.0.0.1:9090/api/getProhibitList").then(res => {
        this.prohibitList = res;
        console.log(this.prohibitList);
      })
    },
    getWaringList(){
      request.get("http://127.0.0.1:9090/api/getWaringList").then(res => {
        this.waringList = res;
        console.log(this.waringList);
      })
    }
  }
}
</script>