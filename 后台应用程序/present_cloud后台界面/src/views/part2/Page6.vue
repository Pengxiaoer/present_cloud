<template>
	<section>
		<!--工具条-->
		<el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
			<el-form :inline="true" :model="filters">
				<el-form-item>
					<el-input v-model="filters.name" placeholder="请输入学号"></el-input>
				</el-form-item>
				<el-select v-model="value" placeholder="请选择课程" @change="currentSel">
			       <el-option
						v-for="item in options"
						:key="item.value"
						:label="item.label"
						:value="item.value">
						</el-option>
					</el-select>
				<el-form-item>
				</el-form-item>
			</el-form>
		</el-col>

		<!--列表-->
		<el-table :data="signdata" highlight-current-row  style="width: 100%;">
			<el-table-column type="selection" >
			</el-table-column>
			<el-table-column prop="studentId" label="学号" >
			</el-table-column>
			<el-table-column prop="signId" label="历史签到序号" >
			</el-table-column>
			<el-table-column prop="signTime" label="签到时间" >
			</el-table-column>
			<el-table-column prop="signRecordId" label="签到记录id">
			</el-table-column>
			<!--<el-table-column prop="signTime" label="签到时间" >
			</el-table-column>
			<el-table-column prop="signRecordId" label="签到记录id">
			</el-table-column>

			-->

		</el-table>



	</section>
</template>

<script>
	import util from '../../common/js/util'
	//import NProgress from 'nprogress'
	import { getUserListPage, removeUser, batchRemoveUser, editUser, addUser } from '../../api/api';

	export default {
		data() {
			return {
				filters: {
					name: ''
				},
				signdata: [],
				options: [{
						value: 1,
						label: '机器学习'
					}, {
						value: 2,
						label: '英语'
					}, {
						value: 3,
						label: '技术'
					}, {
						value: 4,
						label: '密学'
					}, {
						value: 5,
						label: '工训'
					},{
						value: 6,
						label: '英语'
					},
					{
						value: 7,
						label: '语言学'
					},{
						value: 8,
						label: '辩证法'
					},{
						value: 9,
						label: '中译史'
					}
					],
					value: ''

			}
		},
		methods: {

		/*
		findever(val) {
			var para = {
					name: this.filters.name,
					courseid: val,
				};
			console.log(para.name);
			console.log(para.courseid);
			var second_this=this;
			this.$axios.get('http://localhost:8083/Student/SignRecord',{params:{courseid:para.courseid, studentid:para.name}})
				.then(function (response) {
					console.log(response.data);

					second_this.signdata = response.data["data"]; 


				})
				.catch(function (error) {
					console.log(error);
				});

		},
		*/

		currentSel(val) {
			var para = {
					name: this.filters.name,
					courseid: val,
				};
			console.log(para.name);
			console.log(para.courseid);
			var second_this=this;
			this.$axios.get('http://localhost:8083/Student/SignRecord',{params:{courseid:para.courseid, studentid:para.name}})
				.then(function (response) {
					console.log(response.data);

					second_this.signdata = response.data["data"];   //交给前端显示


				})
				.catch(function (error) {
					console.log(error);
				});

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


		},
		mounted() {
		}
	}

</script>

<style scoped>

</style>
