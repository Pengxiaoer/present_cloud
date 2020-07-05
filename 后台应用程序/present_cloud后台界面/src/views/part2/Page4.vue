<template>
	<section>





		<!--工具条 课程-->
		<el-col :span="24" class="toolbar" style="padding-bottom: 0px;">

		<el-select v-model="value" placeholder="请选择课程" @change="currentSel">
			<el-option
				v-for="item in options"
				:key="item.value"
				:label="item.label"
				:value="item.value">
			</el-option>
		</el-select>

		</el-col>

		<!--列表-->
		<el-table :data="signdata" highlight-current-row  style="width: 100%;">
			<el-table-column type="selection" >
			</el-table-column>
			<el-table-column prop="duration" label="持续时间" >
			</el-table-column>
			<el-table-column prop="signInTime" label="签到时间" >
			</el-table-column>
			<el-table-column prop="signId" label="签到序号">
			</el-table-column>
			<!--

				<el-table-column prop="duration" label="持续时间" >
			</el-table-column>
			<el-table-column prop="signInTime" label="签到时间" >
			</el-table-column>
			<el-table-column prop="signId" label="签到序号">
			</el-table-column>
			-->
			<el-table-column prop="courseId" label="所在班级">
			</el-table-column>
			<el-table-column prop="teacherId" label="教师工号">
			</el-table-column>

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

			signdata : [],

				    options: [{
						value: 1,
						label: 'jiqixuexi'
					}, {
						value: 2,
						label: '高等数学'
					}, {
						value: 3,
						label: '代数'
					}, {
						value: 4,
						label: '工程密码学'
					}, {
						value: 5,
						label: '小科目'
					},{
						value: 6,
						label: '1'
					},
					{
						value: 7,
						label: '3'
					},{
						value: 8,
						label: '自然法'
					},{
						value: 9,
						label: '中译史'
					}
					],
					value: ''

            }
        },
        methods: {

		currentSel(val) {
			var para = {
					courseid: val,
				};
				//console.log(response.data);

				//second_this.signdata = response.data["data"];

			var second_this=this;
			this.$axios.get('http://localhost:8083/Teacher/SignIn',{params:{courseid:para.courseid}})
				.then(function (response) {
					console.log(response.data);

					second_this.signdata = response.data["data"];   //交给前端显示


				})
				.catch(function (error) {
					console.log(error);
				});
				//console.log(response.data);

				//second_this.signdata = response.data["data"];
		},

		getlist()
		{
		    var para = {
					courseid: 5,
				};
		    var second_this=this;
		    this.$axios.get('http://localhost:8083/Teacher/SignIn',{params:{courseid:para.courseid}})
				.then(function (response) {
					console.log(response.data);

					second_this.signdata = response.data["data"];   //交给前端显示


				})
				//console.log(response.data);

				//second_this.signdata = response.data["data"];
				.catch(function (error) {
					console.log(error);
				});

		},

        },
        mounted() {
            this.getlist();
        }
    }

</script>

<style scoped>

</style>
