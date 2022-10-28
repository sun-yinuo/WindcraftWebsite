<template>
  <Menu></Menu>
  <o></o>
  <router-view/>
</template>
<script>
import Menu from "@/components/menu/Menu";
import o from "@/components/reportMassage/ReportMassage"

export default {
  components: {
    Menu,
    o
  }
}
</script>
