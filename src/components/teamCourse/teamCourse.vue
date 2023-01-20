<template>
  <Tabs value="name1">
    <TabPane icon="md-contact" label="管理员" name="name1">
      <Row>
        <Col span="11">
          <Card>
            <template #title><h2 style="text-align: center">服主</h2></template>
            <img src="" style="align-content: center"/>
            <p>Content of card</p>
            <p>Content of card</p>
            <p>Content of card</p>
          </Card>
        </Col>
        <Col span="11" offset="2">
          <Card>
            <template #title>The standard card</template>
            <p>Content of card</p>
            <p>Content of card</p>
            <p>Content of card</p>
          </Card>
        </Col>
      </Row>
    </TabPane>
    <TabPane icon="md-code-working" label="开发团队" name="name2">

    </TabPane>
  </Tabs>
</template>
<script>
export default {

}
</script>