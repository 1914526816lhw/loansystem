(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-58765edc"],{"5e8a":function(s,a,r){},bcd0:function(s,a,r){"use strict";r.r(a);var e=function(){var s=this,a=s.$createElement,r=s._self._c||a;return r("div",{staticClass:"main"},[r("div",{staticClass:"box"},[r("div",{staticClass:"boxTitle"},[s._v("基本信息")]),r("el-row",{attrs:{gutter:20}},[r("el-col",{attrs:{span:12}},[s._v(" 姓名： "),r("span",[s._v(s._s(s.formUser.userName))])]),r("el-col",{attrs:{span:12}},[s._v(" 身份证号： "),r("span",[s._v(s._s(s.formUser.userIdentity))])]),r("el-col",{attrs:{span:12}},[s._v(" 性别： "),r("span",[s._v(s._s(s.formUser.userSex))])]),r("el-col",{attrs:{span:12}},[s._v(" 毕业中学： "),r("span",[s._v(s._s(s.formUser.userMiddleSchool))])]),r("el-col",{attrs:{span:12}},[s._v(" 民族： "),r("span",[s._v(s._s(s.formUser.userFamousRaceName))])]),r("el-col",{attrs:{span:12}},[s._v(" 户口性质： "),r("span",[s._v(s._s(s.formUser.accountCharacterName))])]),r("el-col",{attrs:{span:24}},[s._v(" 入学前户籍地址： "),r("span",[s._v(s._s(s.formUser.provinceName+s.formUser.cityName+s.formUser.areaName+s.formUser.userPermanentAddress))])])],1)],1),r("div",{staticClass:"box"},[r("div",{staticClass:"boxTitle"},[s._v("通讯信息")]),r("el-row",{attrs:{gutter:20}},[r("el-col",{attrs:{span:12}},[s._v(" 联系电话： "),r("span",[s._v(s._s(s.formUser.userPhone))])]),r("el-col",{attrs:{span:12}},[s._v(" 邮政编码： "),r("span",[s._v(s._s(s.formUser.userPostalCode))])]),r("el-col",{attrs:{span:12}},[s._v(" 电子邮箱： "),r("span",[s._v(s._s(s.formUser.userMailBox))])]),r("el-col",{attrs:{span:12}},[s._v(" QQ号码： "),r("span",[s._v(s._s(s.formUser.userQq))])]),r("el-col",{attrs:{span:12}},[s._v(" 微信： "),r("span",[s._v(s._s(s.formUser.userWechat))])]),r("el-col",{attrs:{span:12}},[s._v(" 家庭联系电话： "),r("span",[s._v(s._s(s.formUser.userFamilyPhone))])]),r("el-col",{attrs:{span:12}},[s._v(" 家庭联系人： "),r("span",[s._v(s._s(s.formUser.userContactName))])]),r("el-col",{attrs:{span:12}},[s._v(" 家庭联系人电话： "),r("span",[s._v(s._s(s.formUser.userContactPhone))])]),r("el-col",{attrs:{span:24}},[s._v(" 通讯地址： "),r("span",[s._v(s._s(s.formUser.userPostalAddress))])])],1)],1),r("div",{staticClass:"box"},[r("div",{staticClass:"boxTitle"},[s._v("就学信息")]),r("el-row",{attrs:{gutter:20}},[r("el-col",{attrs:{span:12}},[s._v(" 高校名称： "),r("span",[s._v(s._s(s.formUser.userUniversity))])]),r("el-col",{attrs:{span:12}},[s._v(" 院系名称： "),r("span",[s._v(s._s(s.formUser.userDepartment))])]),r("el-col",{attrs:{span:12}},[s._v(" 学历： "),r("span",[s._v(s._s(s.formUser.userEducation))])]),r("el-col",{attrs:{span:12}},[s._v(" 专业名称： "),r("span",[s._v(s._s(s.formUser.userMajor))])]),r("el-col",{attrs:{span:12}},[s._v(" 专业类别 "),r("span",[s._v(s._s(s.formUser.userMajorCategory))])]),r("el-col",{attrs:{span:12}},[s._v(" 年级： "),r("span",[s._v(s._s(s.formUser.userEnrollmentYear))])]),r("el-col",{attrs:{span:12}},[s._v(" 学制： "),r("span",[s._v(s._s(s.formUser.userEducationalSystem))])]),r("el-col",{attrs:{span:12}},[s._v(" 毕业时间： "),r("span",[s._v(s._s(s.formUser.userGraduationTime))])]),r("el-col",{attrs:{span:12}},[s._v(" 学号： "),r("span",[s._v(s._s(s.formUser.userStudentId))])])],1)],1),r("div",{staticClass:"box"},[r("div",{staticClass:"boxTitle"},[s._v("共同借款人信息")]),r("el-row",{attrs:{gutter:20}},[r("el-col",{attrs:{span:12}},[s._v(" 姓名： "),r("span",[s._v(s._s(s.formGuardian.guardianName))])]),r("el-col",{attrs:{span:12}},[s._v(" 身份证号： "),r("span",[s._v(s._s(s.formGuardian.guardianIdentity))])]),r("el-col",{attrs:{span:12}},[s._v(" 邮政编码： "),r("span",[s._v(s._s(s.formGuardian.guardianPostalCode))])]),r("el-col",{attrs:{span:12}},[s._v(" 健康状况： "),r("span",[s._v(s._s(s.formGuardian.guardianHealth))])]),r("el-col",{attrs:{span:24}},[s._v(" 手机号码： "),r("span",[s._v(s._s(s.formGuardian.guardianTel))])]),r("el-col",{attrs:{span:24}},[s._v(" 户籍地址： "),r("span",[s._v(s._s(s.formGuardian.provinceName+s.formGuardian.cityName+s.formGuardian.areaName+s.formGuardian.guardianPermanentAddress))])])],1)],1)])},t=[],n={data:function(){return{formUser:{},formGuardian:{}}},created:function(){var s=this;this.$axios.post("/user/getUserDetail",{userLoginAccount:sessionStorage.getItem("userLoginAccount")}).then((function(a){var r=a.status,e=a.data;200==r?(s.formUser=e.user,s.formGuardian=e.guardian):401==r&&s.$message({message:"获取失败",type:"error"})})).catch((function(s){console.log(s)}))}},o=n,l=(r("d31e"),r("2877")),_=Object(l["a"])(o,e,t,!1,null,"2a181537",null);a["default"]=_.exports},d31e:function(s,a,r){"use strict";var e=r("5e8a"),t=r.n(e);t.a}}]);
//# sourceMappingURL=chunk-58765edc.ae9d7d0f.js.map