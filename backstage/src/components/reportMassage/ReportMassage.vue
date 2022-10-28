<template>
  <List item-layout="vertical">
    <ListItem v-for="report in reportMassage" :key="report.fromReportMassage.reportPlayer">
      <ListItemMeta :title="report.fromReportMassage.reportPlayer"/>
      <h5>
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp地点:{{ report.fromReportMassage.place }}<br>
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp功能:{{ report.fromReportMassage.function }}<br>
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp被举报人:{{report.fromReportMassage.reportedPlayer}}
      </h5>
      <template #extra>
        <img :src="report.pictureUrl.slice(0,1)" style="width: 280px">
      </template>
    </ListItem>
  </List>
</template>

<script>

  import request from "../../../../src/utils/request";

  export default {
    data() {
      return {
        reportMassage:[],
      }
    },
    created() {
      this.getReportList();
    },
    methods: {
      getReportList() {
        request.get("http://localhost:9092/api/getReportMassage").then(res => {
          this.reportMassage = res
        })
      },
    }
  }
</script>