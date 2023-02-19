<template>
   <div>
     <el-input
         type="text"
         placeholder="请输入名字"
         style="width: 150px"
         class="ma"
         v-model="username"
     />
     <el-input
         type="text"
         placeholder="请输入邮箱"
         style="width: 150px"
         class="ma"
         v-model="email"
     />
     <el-button icon="el-icon-search" circle @click="btu_find"></el-button>
     <el-button type="primary" @click="handAdd" icon="el-icon-plus" circle></el-button>
     <el-button type="primary" @click="clearDate" icon="el-icon-refresh" circle></el-button>

     <el-table :data="tableData">
       <el-table-column prop="id" label="id" width="140">
       </el-table-column>
       <el-table-column prop="name" label="姓名" width="240">
       </el-table-column>
       <el-table-column prop="age" label="年龄" width="240">
       </el-table-column>
       <el-table-column prop="phone" label="电话" width="240">
       </el-table-column>
       <el-table-column prop="email" label="邮箱" width="240">
       </el-table-column>
       <el-table-column prop="c" label="操作" width="160">
         <!--    <template slot-scope="scope" scope可以获取 tableData中的值
         通过 Scoped slot 可以获取到 row(行), column（列）, $index 和 store（table 内部的状态管理）的数据
         scope.row 获取当前行的数据
           -->
         <template slot-scope="scope">
           <el-button type="danger" icon="el-icon-edit" @click="updateUser(scope.row)" circle></el-button>
           <!--          由气泡弹框进行触发删除    -->
           <el-popconfirm
               title="这是一段内容确定删除吗？"
               style="margin: 0px 10px"
               @confirm="deleteUser(scope.row.id)"
           >
             <!-- <el-button slot="reference">删除</el-button> -->
             <el-button
                 slot="reference"
                 type="danger"
                 icon="el-icon-delete"
                 circle
             ></el-button>
           </el-popconfirm>
         </template>


       </el-table-column>
     </el-table>

     <div class="block">
       <span class="demonstration"></span>
       <el-pagination
           @size-change="handleSizeChange"
           @current-change="handleCurrentChange"
           :current-page.sync="currentPage2"
           :page-sizes="[2, 5, 8]"
           :page-size="pageSize"
           layout="sizes, prev, pager, next"
           :total="total"
       >
       </el-pagination>
     </div>

     <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="30%">
       <el-form :form="form">
         <el-form-item label="名字" :label-width="formLabelWidth">
           <el-input v-model="form.name" autocomplete="off"></el-input>
         </el-form-item>
         <el-form-item label="年龄" :label-width="formLabelWidth">
           <el-input v-model="form.age" autocomplete="off"></el-input>
         </el-form-item>
         <el-form-item label="邮箱" :label-width="formLabelWidth">
           <el-input v-model="form.email" autocomplete="off"></el-input>
         </el-form-item>
         <el-form-item label="电话" :label-width="formLabelWidth">
           <el-input v-model="form.phone" autocomplete="off"></el-input>
         </el-form-item>
       </el-form>
       <div slot="footer" class="dialog-footer">
         <el-button @click="dialogFormVisible = false">取 消</el-button>
         <el-button type="primary" @click="saveUser">确 定</el-button>
       </div>
     </el-dialog>
   </div>
</template>
<script>
   export  default {
     data() {
       return {
         tableData: [],
         pageNum:1,
         pageSize:2,
         currentPage2: 0,
         total:0,
         username:'',
         email:'',
         form:{},
         dialogTableVisible: false,
         dialogFormVisible: false,
         formLabelWidth: '80px'

       };
     },
     //创建时填充数据 钩子函数
     created() {
       //调用查询方法
       this.load();
     },
     methods: {

       //搜索
       btu_find(){
         console.info(this.username)
         console.info(this.email)
         this.load()
       },

       handAdd(){
         this.dialogFormVisible=true;
         this.form={};
       },
       //添加
       saveUser(){
         this.request.post('http://localhost:9090/user/save',this.form).then(res =>{
           if(res){
             this.$message.success("添加成功");
             console.info(this.form)
             this.dialogFormVisible = false;
           }else{
             this.$message.success("添加失败");
           }
         })
       },
       //重置
       clearDate(){
         this.username = '';
         this.email='';
         //    刷新页面
         this.load()
       },
       //修改
       updateUser(data){
         //将当前行的数据，填充到表格中
         this.form = data
         console.info('接收到row中的数据',data)
         //弹框显示
         this.dialogFormVisible = true;
       },
       //删除
       deleteUser(id){
         console.info('接收到的id',id)
         this.request.delete(`http://localhost:9090/user/delete/${id}`).then(res => {
           if(res){
             this.$message.success("删除成功");
             //  刷新页面
             this.load();
           }else{
             this.$message.success("删除失败");
           }
         })
       },
       //定义一个获取所有user数据的方法
       load(){
         this.request.get('http://localhost:9090/user/page',{
           params:{
             pageNum:this.pageNum,
             pageSize: this.pageSize,
             username: this.username,
             email: this.email
           }
         }).then(res=>{
           console.info(res)
           this.tableData = res.records
           this.total = res.total
         })
       },
       changLoad(pageSize){
         this.request.get('http://localhost:9090/user/page',{
           params:{
             pageNum:this.pageNum,
             pageSize: pageSize,
             username: this.username,
             email: this.email
           }
         }).then(res=>{
           console.info(res)
           this.tableData = res.records
           this.total = res.total
         })
       },
       handleSizeChange(val) {
         //当前页
         this.pageSize=val
         this.changLoad(val)
       },
       handleCurrentChange(val) {
         this.pageNum=val
         console.info('handleCurrentChange',val)
         this.load()
       },
     },
   }
</script>
<style>

.ma {
  margin-right: 5px;
}
</style>