<template>
<!--签到内容-->
    <el-form ref="form" :model="form" label-width="180px">
        <el-form-item label="单次签到经验值">
            <el-input v-model="form.qdjyz" style="width:50%"></el-input>
        </el-form-item>
        <el-form-item label="签到允许最大距离">
            <el-input v-model="form.qdzdjl" style="width:50%"></el-input>
        </el-form-item>
        <el-form-item label="单次签到允许时长">
            <el-input v-model="form.qdyxsc" style="width:50%"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">立即保存</el-button>
        </el-form-item>
    </el-form>
</template>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 480px;
  }

  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }

  .clearfix:after {
      clear: both
  }

</style>

<script>
    import util from '../../common/js/util'
    //import NProgress from 'nprogress'
    import { getUserListPage, removeUser, batchRemoveUser, editUser, addUser } from '../../api/api';

    export default {
        data: function(){
            return {
                form: {
                    qdjyz: '',
                    qdzdjl: '',
                    qdyxsc: '',
                },
                objData:[]
            }
        },
        mounted () {
            this.getData();
        },
        methods: {
            getData () {
                this.$axios.get('http://111.231.104.12:8051/index/app/getparam', {
                    emulateJSON: true
                }, {
                    headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    }
                }).then(res => {
                    // console.log(res)
                    // this.objData = res.data;
                    this.form.qdjyz = res.data.qdjyz
                    this.form.qdzdjl = res.data.qdzdjl
                    this.form.qdyxsc = res.data.qdyxsc
                })
            },
            	/*
			findUser() {
				var para = {
					name: this.filters.name
				};
				console.log(para.name);
				this.listLoading = true;  //获取数据成功
				var second_this = this;
				this.$axios.get('http://localhost:8083/User?',{params:{stno:para.name}})
				.then(function (response) {
					console.log(response.data);
					console.log(response.data["data"]);

					second_this.users = response.data["data"]["userinfo"];   //交给前端显示

				})
				.catch(function (error) {
					console.log(error);
				});

			},
			*/
			/*
			DelUser() {
				var para = {
					name: this.filters.name
				};
				console.log(para.name);
				this.listLoading = true;  //获取数据成功
				var second_this = this;
				this.$axios.get('http://localhost:8083/User?',{params:{stno:para.name}})
				.then(function (response) {
					console.log(response.data);
					console.log(response.data["data"]);

					second_this.users = response.data["data"]["userinfo"];   //交给前端显示

				})
				.catch(function (error) {
					console.log(error);
				});

			},
			*/

            onSubmit () {
                this.$axios.get('http://111.231.104.12:8051/index/app/setConfig?qdjyz=' + this.form.qdjyz +
                "&qdzdjl=" + this.form.qdzdjl + "&qdyxsc=" + this.form.qdyxsc, {
                    emulateJSON: true
                }, {
                    headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    }
                }).then(res => {
                    console.log(res)
                })
            }
        }
    }
</script>


