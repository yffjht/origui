<template>
  <el-container style="height: 100%">
    <el-aside
        :width="sidewidth + 'px'"
        style="background-color: rgb(211, 241, 246); height: 100%"
    >
         <Aside :isCollapse="isCollapse"/>
    </el-aside>
    <el-container>

      <el-main >
        <Header :dj="dj"/>
        <router-view style="margin-top: 9px"/>
      </el-main>

    </el-container>
  </el-container>
</template>

<script>
import Aside from "@/components/Aside.vue";
import Header from "@/components/Header.vue"
export default {
  name: "home",
  //注册组件
  components:{
    Aside,
    Header
  },
  data(){
    return {
      sidewidth: 200,
      isCollapse: false,
    }
  },
  methods:{
    dj() {
      this.isCollapse = !this.isCollapse;
      if (this.isCollapse) {
        this.sidewidth = 64;
      } else {
        this.sidewidth = 200;
      }
    },
  }
};
</script>
<style>
.el-aside {
  color: #333;
}
</style>
