<template>
  <Tabs value="name1">
    <TabPane icon="md-contact" label="服主" name="servingMaster">
      <Row>
        <Col type="flex" justify="space-between" span="12" v-for="master in servingMasterList" offset='1'>
          <Card>
            <template #title>
              <h2 style="text-align: center">{{master.name}}</h2>
            </template>
            <h3>类型:{{master.type}}</h3>
            <p>个人简介:{{master.introduction}}</p>
          </Card>
        </Col>
      </Row>
    </TabPane>

    <TabPane icon="md-contact" label="管理员" name="ops">
      <Row>
        <Col type="flex" justify="space-between" span="12" v-for="op in opList" offset="1">
          <Card>
            <template #title>
              <h2 style="text-align: center">{{op.name}}</h2>
            </template>
            <h3>类型:{{op.type}}</h3>
            <p>个人简介:{{op.introduction}}</p>
          </Card>
        </Col>
      </Row>
    </TabPane>

    <TabPane icon="md-code-working" label="开发团队" name="developers">
      <Row>
        <Col type="flex" justify="space-between" span="12" v-for="developer in developerList" >
          <Card>
            <template #title>
              <h2 style="text-align: center">{{developer.name}}</h2>
            </template>
            <h3>类型:{{developer.type}}</h3>
            <p>个人简介:{{developer.introduction}}</p>
          </Card>
        </Col>
      </Row>
    </TabPane>
  </Tabs>
</template>
<script>
import request from "@/utils/request";

export default {
  data() {
    return {
      teamMemberList: null,
      servingMasterList: null,
      developerList: null,
      opList: null,
      servingMasterOffset: 0,
      developerOffset: 0,
      oPOffset :0
    }
  },
  created() {
    this.getTeamMemberList();
  },
  methods: {
    async getTeamMemberList() {
      request.get("/opcrud/api/getTeamMemberList").then(res => {
        this.teamMemberList = res
        this.setServingMasterList()
        this.setOpList()
        this.setDeveloperList()
        console.log(this.teamMemberList);
        console.log(this.opList);
        console.log(this.developerList);
        console.log(this.servingMasterList);
      })
    },
    async setServingMasterList() {
      this.servingMasterList = this.teamMemberList.filter(element => {
        return element.type === 'ServingMaster';
      })
    },
    async setOpList() {
      this.opList = this.teamMemberList.filter(element => {
        return element.type === 'Op';
      })
    },
    async setDeveloperList() {
      this.developerList = this.teamMemberList.filter(element => {
        return element.type === 'Developer';
      })
    },
  }
}
</script>