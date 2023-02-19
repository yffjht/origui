<template>

    <el-menu
        :default-openeds="['1', '3']"
        background-color="black"
        style="overflow-x: hidden; min-height: 100%"
        :collapse="isCollapse"
        :collapse-transition="false"
    >
      <el-submenu index="1">
        <template slot="title"
        ><i class="el-icon-message"></i>
          <span>用户菜单</span>
        </template>
        <el-menu-item-group>
          <template slot="title">
            <router-link to="/user">分组一</router-link>
          </template>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"
        ><i class="el-icon-menu"></i><span>导航二</span></template
        >
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="2-4">
          <template slot="title">选项4</template>
          <el-menu-item index="2-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-submenu index="3">
        <template slot="title"
        ><i class="el-icon-setting"></i><span>导航三</span></template
        >
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="3-1">选项1</el-menu-item>
          <el-menu-item index="3-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="3-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="3-4">
          <template slot="title">选项4</template>
          <el-menu-item index="3-4-1">选项4-1</el-menu-item>
        </el-submenu>
      </el-submenu>
    </el-menu>

</template>
<script>
  export default {
    name:'Aside',
    props:{
      isCollapse: Boolean
    }
  }
</script>
<style>
 a{
   text-decoration: none;
   color: whitesmoke;
 }
</style>