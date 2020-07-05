<template>
<div>
  <!--学校组织结构-->
    <el-row>
    <el-button type="primary" @click="showBz">添加结构</el-button>
    </el-row>
    <!-- <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree> -->
    <el-tree
    :data="data"
    show-checkbox
    default-expand-all
    node-key="id"
    ref="tree"
    highlight-current
    @node-click="selectNodel"
    :props="defaultProps">
    </el-tree>
    <el-dialog
        title="添加结构"
        :visible.sync="dialogVisible"
        width="30%"
        
        >
        <el-form ref="form" :model="form" label-width="180px">
            <el-form-item label="结构名称">
                <el-input v-model="form.name" style="width:50%"></el-input>
            </el-form-item>
             <!-- <el-form-item label="组织级别">
                <el-select v-model="form.region" placeholder="请选择组织结构">
                    <el-option label="顶级" value="0"></el-option>
                    <el-option v-for="item in orgList" :label="item.name" :value="item.id"></el-option>
                </el-select>
            </el-form-item> -->
        </el-form>
        <div class="block">
        <span class="demonstration">单选选择任意一级选项</span>
        <el-cascader
            :options="options"
            :props="{
                checkStrictly: true}"
            clearable></el-cascader>
        </div>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="save">确 定</el-button>
        </span>
    </el-dialog>
 <!-- <el-form-item label="组织级别">
                <el-select v-model="form.region" placeholder="请选择组织结构">
                    <el-option label="顶级" value="0"></el-option>
                    <el-option v-for="item in orgList" :label="item.name" :value="item.id"></el-option>
                </el-select>
            </el-form-item> -->
</div>
</template>


<script>
    import util from '../../common/js/util'
    //import NProgress from 'nprogress'
    import { getUserListPage, removeUser, batchRemoveUser, editUser, addUser } from '../../api/api';

    export default {
        data: function(){
            return {
                form:{
                    name:'',
                    region: '',
                },
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1',
                        children: [{
                        label: '三级 1-1-1'
                        }]
                    }]
                    }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1',
                        children: [{
                        label: '三级 2-1-1'
                        }]
                    }, {
                        label: '二级 2-2',
                        children: [{
                        label: '三级 2-2-1'
                        }]
                    }]
                    }, {
                    label: '一级 3',
                    children: [{
                        label: '二级 3-1',
                        children: [{
                        label: '三级 3-1-1'
                        }]
                    }, {
                        label: '二级 3-2',
                        children: [{
                        label: '三级 3-2-1'
                        }]
                    }]
                }],
                orgList:[],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                dialogVisible:false,
                options: [{
          value: 'zhinan',
          label: '指南',
          children: [{
            value: 'shejiyuanze',
            label: '设计原则',
            children: [{
              value: 'yizhi',
              label: '一致'
            }, {
              value: 'fankui',
              label: '反馈'
            }, {
              value: 'xiaolv',
              label: '效率'
            }, {
              value: 'kekong',
              label: '可控'
            }]
          }, {
            value: 'daohang',
            label: '导航',
            children: [{
              value: 'cexiangdaohang',
              label: '侧向导航'
            }, {
              value: 'dingbudaohang',
              label: '顶部导航'
            }]
          }]
        }, {
          value: 'zujian',
          label: '组件',
          children: [{
            value: 'basic',
            label: 'Basic',
            children: [{
              value: 'layout',
              label: 'Layout 布局'
            }, {
              value: 'color',
              label: 'Color 色彩'
            }, {
              value: 'typography',
              label: 'Typography 字体'
            }, {
              value: 'icon',
              label: 'Icon 图标'
            }, {
              value: 'button',
              label: 'Button 按钮'
            }]
          }, {
            value: 'form',
            label: 'Form',
            children: [{
              value: 'radio',
              label: 'Radio 单选框'
            }, {
              value: 'checkbox',
              label: 'Checkbox 多选框'
            }, {
              value: 'input',
              label: 'Input 输入框'
            }, {
              value: 'input-number',
              label: 'InputNumber 计数器'
            }, {
              value: 'select',
              label: 'Select 选择器'
            }, {
              value: 'cascader',
              label: 'Cascader 级联选择器'
            }, {
              value: 'switch',
              label: 'Switch 开关'
            }, {
              value: 'slider',
              label: 'Slider 滑块'
            }, {
              value: 'time-picker',
              label: 'TimePicker 时间选择器'
            }, {
              value: 'date-picker',
              label: 'DatePicker 日期选择器'
            }, {
              value: 'datetime-picker',
              label: 'DateTimePicker 日期时间选择器'
            }, {
              value: 'upload',
              label: 'Upload 上传'
            }, {
              value: 'rate',
              label: 'Rate 评分'
            }, {
              value: 'form',
              label: 'Form 表单'
            }]
          }, {
            value: 'data',
            label: 'Data',
            children: [{
              value: 'table',
              label: 'Table 表格'
            }, {
              value: 'tag',
              label: 'Tag 标签'
            }, {
              value: 'progress',
              label: 'Progress 进度条'
            }, {
              value: 'tree',
              label: 'Tree 树形控件'
            }, {
              value: 'pagination',
              label: 'Pagination 分页'
            }, {
              value: 'badge',
              label: 'Badge 标记'
            }]
          }, {
            value: 'notice',
            label: 'Notice',
            children: [{
              value: 'alert',
              label: 'Alert 警告'
            }, {
              value: 'loading',
              label: 'Loading 加载'
            }, {
              value: 'message',
              label: 'Message 消息提示'
            }, {
              value: 'message-box',
              label: 'MessageBox 弹框'
            }, {
              value: 'notification',
              label: 'Notification 通知'
            }]
          }, {
            value: 'navigation',
            label: 'Navigation',
            children: [{
              value: 'menu',
              label: 'NavMenu 导航菜单'
            }, {
              value: 'tabs',
              label: 'Tabs 标签页'
            }, {
              value: 'breadcrumb',
              label: 'Breadcrumb 面包屑'
            }, {
              value: 'dropdown',
              label: 'Dropdown 下拉菜单'
            }, {
              value: 'steps',
              label: 'Steps 步骤条'
            }]
          }, {
            value: 'others',
            label: 'Others',
            children: [{
              value: 'dialog',
              label: 'Dialog 对话框'
            }, {
              value: 'tooltip',
              label: 'Tooltip 文字提示'
            }, {
              value: 'popover',
              label: 'Popover 弹出框'
            }, {
              value: 'card',
              label: 'Card 卡片'
            }, {
              value: 'carousel',
              label: 'Carousel 走马灯'
            }, {
              value: 'collapse',
              label: 'Collapse 折叠面板'
            }]
          }]
        }, {
          value: 'ziyuan',
          label: '资源',
          children: [{
            value: 'axure',
            label: 'Axure Components'
          }, {
            value: 'sketch',
            label: 'Sketch Templates'
          }, {
            value: 'jiaohu',
            label: '组件交互文档'
          }]
        }]
            }
        },
        mounted () {
            this.getDataOrg()
        },
        methods: {
            getDataOrg(){
            this.$axios.get('http://111.231.104.12:8051/index/app/getDataOrg', {
                    emulateJSON: true
                }, {
                    headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    }
                }).then(res => {
                    this.data=res.data
                })
            },
            showBz(){
                this.getOrg()
                this.dialogVisible = true
            },
            save () {
                // this.dialogVisible = false
                console.log(this.form.region)
                this.$axios.get('http://111.231.104.12:8051/index/app/saveOrg?name=' + this.form.name +
                "&id=" + this.form.region, {
                    emulateJSON: true
                }, {
                    headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    }
                }).then(res => {
                    this.$message({
                        message: '创建成功',
                        type: 'success'
                    });
                    this.dialogVisible=false
                })
            },
            /**
             *              })
            },
            getCourse(o){

                console.log(o);
                var para = {
                    courseid: o,
                    //name: this.filters.name
                };
                console.log(para.courseid);
                var second_this = this;
                this.$axios.get('http://localhost:8083/CourseMsg',{params:{courseid:para.courseid}})
                    .then(function (response) {
                        //console.log(response.data["data"]);

                        second_this.gridData = response.data["data"];   //交给前端显示
                        second_this.courseid= response.data["data"]["courseId"];
                        second_this.courseName= response.data["data"]["courseName"];
                        second_this.teacherName= response.data["data"]["teacherName"];
                        second_this.teacherId= response.data["data"]["teacherId"];
                        second_this.examTime= response.data["data"]["examTime"];

                    })
                    .catch(function (error) {
                        console.log(error);
             */
            getOrg(){
                this.$axios.get('http://111.231.104.12:8051/index/app/getorg', {
                    emulateJSON: true
                }, {
                    headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    }
                }).then(res => {
                    // this.options = res.data
                })
            },
            selectNodel (obj1,obj2,obj3) {
              console.log(obj1)
              console.log(obj2)
              console.log(obj3)
              this.$confirm('确认删除该记录吗?', '提示', {
                type: 'warning'
              }).then(() => {
                var _this=this;
                this.$axios.get('http://111.231.104.12:8051/index/app/deleOrg?id='+obj1.id)
                    .then(function (response) {
                    console.log(response.data);
                    _this.$message({
                      message: '删除成功！',
                      type: 'success'
                    });
                    _this.getDataOrg();

                  })
                  .catch(function (error) {
                    console.log(error);
                });


              }).catch(() => {

              });
            }
        }
    }
</script>

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

