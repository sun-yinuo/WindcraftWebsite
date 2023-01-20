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
        <img :src=getReportPictureUrl(0,report.pictureUrl) style="width: 280px">
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
      /**
       * 获取举报信息列表
       */
      getReportList() {
        request.get("/auditreportgame/api/getReportMassage").then(res => {
          this.reportMassage = res
        })
      },
      /**
       * 根据索引获取图片url
       * @param index 索引
       * @param pictureUrlList 图片list
       */
      getReportPictureUrl(index,pictureUrlList){
        if (pictureUrlList == null){
          return "";
        }else {
          return pictureUrlList.slice(0,1);
        }
      }
    }
  }
</script>