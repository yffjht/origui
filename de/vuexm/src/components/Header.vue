<template>
    <el-header style="font-size: 12px">
      <i
          class="el-icon-s-unfold"
          @click="dj"
          style="cursor: pointer; font-size: 20px"
      ></i>
      <span style="margin-left: 1160px">王小虎</span>
      <el-dropdown>
        <i class="el-icon-user" style="margin-left: 5px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>个人信息</el-dropdown-item>
          <el-dropdown-item>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-header>

</template>
<script>
  export default {
     name:'Header',
     props:{
       dj: {
         type: Function
       }
     }
  }
</script>
<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}
</style>