<template>
  <div>
    <div>
      <x-header :left-options="{backText: ''}" style="background-color: #3399ff;">创建课程</x-header>
    </div>
    <Row v-if="viewShow">
      <i-col span="24" style="text-align: center;">
        <div class="content">
          <Row>
              <i-col span="24" style="text-align: center;">
                  <group>
                  <x-input title="班级"  placeholder="未设置" v-model="class_b" style="width: 80%;" ></x-input>
                  </group>
              </i-col>
          </Row>
          <Row>
              <i-col span="24" style="text-align: center;">
                  <group>
                  <x-input title="课程"  placeholder="未设置" v-model="coursname" style="width: 80%;" ></x-input>
                  </group>
              </i-col>
          </Row>
          <Row>
              <i-col span="24" style="text-align: center;">
                  <group>
                  <datetime
                      v-model="value1"
                      @on-change="change"
                      title="开始日期"
                      @on-cancel="log('cancel')"
                      @on-confirm="onConfirm"
                      @on-hide="log('hide', $event)"></datetime>
                  </group>
              </i-col>
          </Row>
          <Row>
              <i-col span="24" style="text-align: center;">
                  <group>
                  <datetime
                      v-model="value2"
                      @on-change="change"
                      title="结束日期"
                      @on-cancel="log('cancel')"
                      @on-confirm="onConfirm2"
                      @on-hide="log('hide', $event)"></datetime>
                  </group>
              </i-col>
          </Row>
          <Row>
              <i-col span="24" style="text-align: center;">
                  <group>
                    <x-button plain type="primary" style="border-radius:99px;" @click.native="addcourse">创建</x-button>
                  </group>
              </i-col>
          </Row>
        </div>
      </i-col>
    </Row>
    <Row v-if="!viewShow">
      <i-col span="24" style="text-align: center;">
        <div>
          <Row>
            <i-col span="24" style="text-align: center;">
              <p>恭喜你,成功创建班课，将你的班课告诉学生吧。</p>
            </i-col>
          </Row>
          <Row>
            <i-col span="24" style="text-align: center;">
              <p style="font-size: 40px;color: #ff6600;">{{code.data}}</p>
            </i-col>
          </Row>
          <Row>
            <i-col span="24" style="text-align: center;">
              <img class="course_img" src="../assets/course_img/ML.jpg">
            </i-col>
          </Row>
          <Row>
            <i-col span="24" style="text-align: center;">
              <group>
                <x-button plain type="primary" style="border-radius:99px;" @click.native="startClass">开始班课</x-button>
              </group>
            </i-col>
          </Row>
        </div>
      </i-col>
    </Row>

  </div>

</template>

<script>
import { Datetime, Group, Cell, XHeader, XInput, XButton, TransferDomDirective as TransferDom, Alert, Toast } from 'vux'
// eslint-disable-next-line no-unused-vars
import axios from 'axios'
// eslint-disable-next-line no-unused-vars
import qs from 'qs'
export default {
  name: 'SignIn',
  data () {
    return {
        value1: '2020-06-23',
        coursname: '',
        class_b: '',
        userid: '',
        username: '',
        viewShow:true,
        code: '',
        lat:'',
        lng:'',
        dizhi:'',
        date: '',
        value2:'',
      show: false,
    }
  },
  directives: {
    TransferDom
  },
  mounted () {
    this.userId = localStorage.getItem('userId')
    this.username = localStorage.getItem('username')
    this.getDZ()
  },
  components: {
    Group,
    Cell,
    XHeader,
    XInput,
    XButton,
    Alert,
    Toast,
    Datetime,
  },
  methods: {
     formatDate(date) {
      return `${date.getMonth() + 1}/${date.getDate()}`;
    },
    onConfirm(date) {
      const [start, end] = date;
      this.show = false;
      this.date = `${this.formatDate(start)} - ${this.formatDate(end)}`;
    },
    getDZ () {
      var data = {
          key: "PQABZ-CUKEX-CRE4P-7DEQJ-QHVVH-X7FRX"  
      }; 
      var url = "https://apis.map.qq.com/ws/location/v1/ip";
      data.output = "jsonp";
      this.$jsonp(url, data)
        .then(res => {
          this.lat = res.result.location.lat;
          this.lng = res.result.location.lng;
          var datas = {
              key: "PQABZ-CUKEX-CRE4P-7DEQJ-QHVVH-X7FRX",  
              location: this.lat+","+this.lng
          }; 
          var urls = "http://apis.map.qq.com/ws/geocoder/v1/"; 
          datas.output = "jsonp";
          // datas.output = "jsonp";
          this.$jsonp(urls, datas)
            .then(res => {
              this.dizhi = res.result.address
            })
            .catch(error => {
                console.log(error);
            });

        })
        .catch(error => {
            console.log(error);
        });
    },
    change (value) {
        console.log('change', value)
    },
    log (str1, str2 = '') {
      console.log(str1, str2)
    },
    onConfirm (val) {
      this.value1 = val
      console.log('on-confirm arg', val)
      console.log('current value', this.value1)
    },
    onConfirm2 (val) {
      this.value2 = val
      console.log('on-confirm arg', val)
      console.log('current value', this.value1)
    },
    addcourse () {
      if (this.coursname == '') {
        this.$Message.warning('课程名称不能为空')
        return false
      }
      if (this.class_b == '') {
        this.$Message.warning('班级不能为空')
        return false
      }
      console.log(this.value2)
      console.log(this.value1)
      if (this.value2 == '' || this.value1 == '') {
        this.$Message.warning('开始日期/结束日期不能为空')
        return false
      }
      var riqi = this.value1 + "/" + this.value2
      axios.post('http://111.231.104.12:8051/index/app/addcourse', qs.stringify({
        coursname: this.coursname,
        class_b: this.class_b,
        user_id: this.userId,
        ExamTime: riqi,
        username: this.username,
        lat : this.lng,
        lng : this.lng,
        dizhi : this.dizhi

      }), {
        emulateJSON: true
      }, {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
      }).then(res => {
        // eslint-disable-next-line eqeqeq
        // if (res == 'ok')
        //   this.$Message.success('创建成功')
        this.code = res;
        this.viewShow = false
      })
    },
    startClass () {
      localStorage.setItem('courseid', this.code.data)
      this.$router.push('/bkxq')
    }
  }
}
</script>

<style lang="less" scoped>
  .content{
    position: absolute;
    background-color: #fafbf9;
    height: 93%;
    width: 100%;
  }
  .signinButton{
    position: relative;
    background-color: white;
    height: 80px;
    width: 100%;
    margin: 0;
    padding: 0;
    text-align:center;
    line-height: 80px;
    color: #1abc9c;
  }
  .button{
    background-color: white;
    height: 100%;
    width: 100%;
    font-size: 16px;
    color: #1abc9c;
  }
  button::after{
    border:none;// 去除边框
  }
  .signinTitle{
    position: relative;
    margin-top: 5px;
    margin-bottom: 5px;
    margin-left: 10px;
    padding: 0px;
    width: 100%;
    color: #333333;
  }
  .signinInfo{
    position: relative;
    background-color: white;
    border-top: 1px solid #ececec;
    margin-top: 0px;
    height: 400px;
    width: 100%;
  }
  .record{
    position: relative;
    margin: 0px;
    border-bottom: 1px solid #ececec;
    height: 60px;
    width: 100%;
    font-size: 14px;
  }
  .item1{
    display:inline-block;
    float: left;
    position: relative;
    margin-top: 8px;
    margin-left: 10px;
    padding: 0px;
    width: 80%;
    font-size: 14px;
    background-color: #ffffff;
  }
  .item2{
    display:inline-block;
    position: relative;
    margin-top: 5px;
  }
  .item3{
    display:inline-block;
    float: right;
    position: relative;
    margin-top: 20px;
    margin-right: 10px;
    color: #b2b2b2;
  }
  .course_img{
    position: relative;
    margin-left: 20px;
    margin-top: 15px;
    width: 70px;
    height: 70px;
  }
</style>
