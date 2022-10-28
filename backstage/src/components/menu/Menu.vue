<template>
  <Menu mode="horizontal" :theme="theme" active-name="1">
    <MenuItem name="1">
      <Icon type="ios-paper" />
      留言管理
    </MenuItem>
    <MenuItem name="2">
      <Icon type="ios-people" />
      用户管理
    </MenuItem>
    <Submenu name="3">
      <template #title>
        <Icon type="md-checkmark" />
        审核
      </template>
      <MenuItem name="3-1">举报</MenuItem>
      <MenuItem name="3-2">OP申请</MenuItem>
    </Submenu>
  </Menu>
</template>

<script>
export default {
  data(){
    return{
      theme:"light"
    }
  }
}
</script>