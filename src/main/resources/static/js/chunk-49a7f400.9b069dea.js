(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-49a7f400"],{"16c0":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"main"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("div",{staticClass:"leftMain"},[a("el-button",{attrs:{type:"primary"},on:{click:t.postLoan}},[t._v("申请贷款")]),a("el-button",{attrs:{type:"success"}},[t._v("提前还款")]),a("el-button",{attrs:{type:"danger"},on:{click:t.getLoanSchedule}},[t._v("贷款申请进度查询")])],1)]),a("el-col",{attrs:{span:12}},[a("div",{staticClass:"rightMain"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("div",{staticClass:"col6"},[a("el-button",{attrs:{type:"green"}},[t._v("首带申请流程")]),a("el-button",{attrs:{type:"warning"}},[t._v("续待帮助")])],1)]),a("el-col",{attrs:{span:12}},[a("div",{staticClass:"col6"},[a("el-button",{attrs:{type:"green"}},[t._v("常见问题")]),a("el-button",{attrs:{type:"warning"}},[t._v("提前还款帮助")])],1)])],1)],1)])],1),a("div",{staticClass:"bottom"},[a("el-row",{attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"cardLeft"},[a("i",{staticClass:"el-icon-message-solid"})]),a("div",{staticClass:"cardRight"},[a("div",{staticClass:"cardTitle"},[t._v("贷款提醒")]),a("div",[t._v("如果您需要申请贷款，请查看生源地贷款申请流程")]),a("div",[t._v("贷款办理时间：")]),a("div",[t._v("必须在指定的时间内才能申请助学贷款，一般为每年6月-9月，具体以当地县区资助中心办理时间为准，请随时关注。")])])])],1),a("el-col",{attrs:{span:12}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"cardLeft"},[a("i",{staticClass:"el-icon-alarm-clock"})]),a("div",{staticClass:"cardRight"},[a("div",{staticClass:"cardTitle"},[t._v("征信提醒")]),a("div",[t._v("您的贷款、还款记录已报送人民银行个人征信系统，请务必按时还款。")]),a("div",[t._v("如有违约，会影响您的信用记录，有关不良记录将保留至逾期贷款结清后5年，今后在办理信用卡、申请房贷与车贷等其它各类贷款时会有不良影响。")]),a("div",[t._v("请珍惜您的信用记录，及时还款。")])])])],1)],1),a("el-row",{staticStyle:{"margin-top":"2rem"},attrs:{gutter:20}},[a("el-col",{attrs:{span:12}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"cardLeft"},[a("i",{staticClass:"el-icon-date"})]),a("div",{staticClass:"cardRight"},[a("div",{staticClass:"cardTitle"},[t._v("还款提醒")]),a("div",{staticStyle:{color:"#ff0000"}},[t._v("目前助学贷款还款方式仅支持支付宝和POS机还款，根据监管要求，还款后请及时查看还款情况。")]),a("div",[t._v("正常还款日：每年11月1日至12月20日(最后一年为9月1日至20日)。")]),a("div",[t._v("提前还款日：一般每月15日(含)之前提交申请，利息计算至当月20日，请与当月20日前还款；16日以后提交申请，利息计算至次月20日，请于次月20日前还款；其他特殊情况以合同约定为准。")]),a("div",[t._v("逾期还款日：1月至10月的1日至20日，11月1日至12月20日，可以进行逾期还款。")])])])],1),a("el-col",{attrs:{span:12}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"cardLeft"},[a("i",{staticClass:"el-icon-search"})]),a("div",{staticClass:"cardRight"},[a("div",{staticClass:"cardTitle"},[t._v("本人所属资助中心联系方式")]),t.display?a("div",[a("div",[t._v("资助中心名称:锦屏县学生资助管理办公室")]),a("div",[t._v("资助中心地址:贵州省黔东南州锦屏县学生资助管理中心")]),a("div",[t._v("邮政编码:556700 QQ:")]),a("div",[t._v("联系人:李双莲")]),a("div",[t._v("联系电话:08557221310")])]):a("el-button",{attrs:{type:"danger"},on:{click:function(e){t.display=!0}}},[t._v("查看")])],1)])],1)],1)],1),a("el-dialog",{staticStyle:{"text-align":"left"},attrs:{title:"请填写贷款信息-贷款基本信息",visible:t.dialogVisible,width:"780px"},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("el-form",{ref:"Form",attrs:{inline:"",model:t.LoanAppForm,"label-width":"130px","label-position":"right",rules:t.rules}},[a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{attrs:{size:"small",disabled:""},model:{value:t.LoanAppForm.userName,callback:function(e){t.$set(t.LoanAppForm,"userName",e)},expression:"LoanAppForm.userName"}})],1),a("el-form-item",{attrs:{label:"申请学年"}},[a("el-input",{attrs:{size:"small",disabled:""},model:{value:t.LoanAppForm.applicationYear,callback:function(e){t.$set(t.LoanAppForm,"applicationYear",e)},expression:"LoanAppForm.applicationYear"}})],1),a("el-form-item",{attrs:{label:"资助中心"}},[a("el-input",{staticStyle:{width:"540px"},attrs:{size:"small",disabled:""},model:{value:t.LoanAppForm.fundingCenterName,callback:function(e){t.$set(t.LoanAppForm,"fundingCenterName",e)},expression:"LoanAppForm.fundingCenterName"}})],1),a("el-form-item",{attrs:{label:"贷款金额"}},[a("el-input",{attrs:{size:"small",type:"number"},model:{value:t.LoanAppForm.loanMoney,callback:function(e){t.$set(t.LoanAppForm,"loanMoney",e)},expression:"LoanAppForm.loanMoney"}})],1),a("el-form-item",{attrs:{label:"贷款年限"}},[a("el-input-number",{attrs:{size:"small","controls-position":"right",min:1,max:10},model:{value:t.LoanAppForm.loanTerm,callback:function(e){t.$set(t.LoanAppForm,"loanTerm",e)},expression:"LoanAppForm.loanTerm"}})],1),a("el-form-item",{attrs:{label:"申请原因"}},[a("el-input",{staticStyle:{width:"540px"},attrs:{maxlength:"50","show-word-limit":"",type:"textarea",size:"small"},model:{value:t.LoanAppForm.loanReason,callback:function(e){t.$set(t.LoanAppForm,"loanReason",e)},expression:"LoanAppForm.loanReason"}})],1),a("el-form-item",{attrs:{label:t.LoanAppForm.userLoanType+"声明"}},[a("el-input",{staticStyle:{width:"540px"},attrs:{maxlength:"50","show-word-limit":"",size:"small",type:"textarea"},model:{value:t.LoanAppForm.loanStatement,callback:function(e){t.$set(t.LoanAppForm,"loanStatement",e)},expression:"LoanAppForm.loanStatement"}})],1),a("el-form-item",{staticStyle:{"padding-left":"130px"}},[a("el-button",{attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("提交")]),a("el-button",{on:{click:function(e){t.dialogVisible=!1}}},[t._v("取消")])],1)],1)],1),a("el-dialog",{staticStyle:{"text-align":"left"},attrs:{title:"贷款申请进度查询",visible:t.dialogVisible2,width:"780px"},on:{"update:visible":function(e){t.dialogVisible2=e}}},[a("el-steps",{attrs:{active:t.stepsActive,"finish-status":"success",simple:""}},[a("el-step",{attrs:{title:"导出申请表 ",icon:"el-icon-download"}}),a("el-step",{attrs:{title:"管理员审核",icon:"el-icon-s-check"}}),a("el-step",{attrs:{title:"完成贷款",icon:"el-icon-circle-check"}})],1),0==t.stepsActive?a("div",{staticClass:"stepContent"},[a("el-alert",{staticStyle:{"margin-bottom":"20px"},attrs:{title:"恭喜您贷款申请成功！",description:"请将申请表导出打印，并提交给管理员，管理员将进行审核。",type:"success",closable:!1,"show-icon":""}}),a("el-button",{staticStyle:{"margin-right":"10px"},attrs:{slot:"reference",type:"success",plain:""},on:{click:t.exportFile},slot:"reference"},[t._v("导出贷款申请表")]),a("el-popconfirm",{attrs:{confirmButtonText:"确定",cancelButtonText:"还不确定",icon:"el-icon-info",iconColor:"red",title:"您确定已将申请表提交给管理员了吗？"},on:{onConfirm:t.onConfirm}},[a("el-button",{attrs:{slot:"reference",type:"primary",plain:""},slot:"reference"},[t._v("下一步")])],1)],1):t._e(),1==t.stepsActive?a("div",{staticClass:"stepContent"},[a("div",{staticClass:"two"},[a("i",{staticClass:"el-icon-loading"}),t._v(" 请耐心等待管理员审核... ")])]):t._e(),2==t.stepsActive?a("div",{staticClass:"stepContent"},[a("div",{staticClass:"two"},[a("i",{staticClass:"el-icon-success"}),t._v(" 恭喜你,已经完成了贷款! ")])]):t._e()],1)],1)},o=[],i={data:function(){return{userName:"",display:!1,dialogVisible:!1,dialogVisible2:!1,stepsActive:0,contractId:"",LoanAppForm:{userLoanType:"",userName:"",appcationYear:"",loanMoney:"",loanTerm:"",loanReason:"",loanStatement:""},rules:{loanMoney:[{required:!0,message:"请填写贷款金额",trigger:"blur"}],loanTerm:[{required:!0,message:"请填写贷款年限",trigger:"blur"}],loanReason:[{required:!0,message:"请填写贷款原因",trigger:"blur"}],loanStatement:[{required:!0,message:"请填写贷款声明",trigger:"blur"}]}}},methods:{postLoan:function(){var t=this;this.$axios.post("/loan/getStudentInfo",{userLoginAccount:sessionStorage.getItem("userLoginAccount")}).then((function(e){var a=e.status,s=e.data;200==a?(t.dialogVisible=!0,t.LoanAppForm=s):401==a&&t.$message({message:"获取失败",type:"error"})})).catch((function(t){console.log(t)}))},onSubmit:function(){var t=this;this.$refs.Form.validate((function(e){if(!e)return!1;t.$axios.post("/loan/fillLoanAppForm",{userLoginAccount:sessionStorage.getItem("userLoginAccount"),loanMoney:t.LoanAppForm.loanMoney,loanTerm:t.LoanAppForm.loanTerm,loanReason:t.LoanAppForm.loanReason,loanStatement:t.LoanAppForm.loanStatement}).then((function(e){var a=e.status,s=e.message,o=void 0===s?"":s;200==a?(t.$message({message:o,type:"success"}),t.dialogVisible=!1):401==a&&t.$message({message:o,type:"error"})})).catch((function(t){console.log(t)}))}))},getLoanSchedule:function(){var t=this;this.$axios.post("/loan/getLoanSchedule",{userLoginAccount:sessionStorage.getItem("userLoginAccount")}).then((function(e){var a=e.status,s=e.message,o=void 0===s?"":s,i=e.contractId,l=void 0===i?"":i;200==a?(t.contractId=l,t.dialogVisible2=!0):401==a&&t.$message({message:o,type:"error"})})).catch((function(t){console.log(t)}))},onConfirm:function(){this.stepsActive++},exportFile:function(){window.open("http://106.15.203.32:9999/user/downloadFile/".concat(sessionStorage.getItem("userLoginAccount"),"的助学贷款申请表.pdf"))}}},l=i,n=(a("8eec"),a("2877")),r=Object(n["a"])(l,s,o,!1,null,"71f62004",null);e["default"]=r.exports},"581b":function(t,e,a){},"8eec":function(t,e,a){"use strict";var s=a("581b"),o=a.n(s);o.a}}]);
//# sourceMappingURL=chunk-49a7f400.9b069dea.js.map