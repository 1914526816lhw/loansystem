package com.stu.vo;

import java.util.Date;

/**
 * ClassName：UsersVo
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/10 14:37
 * @version 1.0.0
 */
public class UsersVo {
    //用户主键
    private Integer userId;
    //用户名称
    private String userName;
    //用户省份证号
    private String userIdentity;
    //用户密保问题
    private String userSecurityQuestion;
    //用户密保答案
    private String userSecurityAnswer;
    //用户电话号码
    private String userPhone;
    //用户性别
    private String userSex;
    //用户生日（也是出生日期）
    private Date userBirthday;
    //用户民族id
    private Integer userFamousRaceId;
    //用户民族
    private String userFamousRaceName;
    //用户中学
    private String userMiddleSchool;
    //用户邮箱
    private String userMailBox;
    //用户QQ
    private String userQq;
    //用户微信
    private String userWechat;
    //用户通讯地址
    private String userPostalAddress;
    //用户银行卡号
    private String userBankCardId;
    //用户邮政编码
    private String userPostalCode;
    //用户家庭电话
    private String userFamilyPhone;
    //用户联系人名称
    private String userContactName;
    //用户联系人电话
    private String userContactPhone;
    //用户联系人身份证号
    private String userContactIdentity;
    //大学名称
    private String userUniversity;
    //院系名称
    private String userDepartment;
    //专业
    private String userMajor;
    //学历
    private String userEducation;
    //入学年份
    private Integer userEnrollmentYear;
    //学号
    private String userStudentId;
    //专业类别
    private String userMajorCategory;
    //学制
    private String userEducationalSystem;
    //毕业时间
    private Date userGraduationTime;
    //用户贷款类型
    private String userLoanType;
    //共同贷款人与用户的关系
    private String relation;
    //户口性质id
    private Integer accountCharacterId;
    //户口性质
    private String accountCharacterName;
    //资助中心id
    private Integer fundingCenterId;
    //资助中心名称
    private String fundingCenterName;
    //用户的户籍地址详细地址
    private String userPermanentAddress;
    //省份id
    private String provinceId;
    //省份名称
    private String provinceName;
    //城市id
    private String cityId;
    //城市名称
    private String cityName;
    //区域id
    private String areaId;
    //区域名称
    private String areaName;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity == null ? null : userIdentity.trim();
    }

    public String getUserSecurityQuestion() {
        return userSecurityQuestion;
    }

    public void setUserSecurityQuestion(String userSecurityQuestion) {
        this.userSecurityQuestion = userSecurityQuestion == null ? null : userSecurityQuestion.trim();
    }

    public String getUserSecurityAnswer() {
        return userSecurityAnswer;
    }

    public void setUserSecurityAnswer(String userSecurityAnswer) {
        this.userSecurityAnswer = userSecurityAnswer == null ? null : userSecurityAnswer.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserFamousRaceId() {
        return userFamousRaceId;
    }

    public void setUserFamousRaceId(Integer userFamousRaceId) {
        this.userFamousRaceId = userFamousRaceId;
    }

    public String getUserMiddleSchool() {
        return userMiddleSchool;
    }

    public void setUserMiddleSchool(String userMiddleSchool) {
        this.userMiddleSchool = userMiddleSchool == null ? null : userMiddleSchool.trim();
    }


    public String getUserQq() {
        return userQq;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq == null ? null : userQq.trim();
    }

    public String getUserWechat() {
        return userWechat;
    }

    public void setUserWechat(String userWechat) {
        this.userWechat = userWechat == null ? null : userWechat.trim();
    }


    public String getUserBankCardId() {
        return userBankCardId;
    }

    public void setUserBankCardId(String userBankCardId) {
        this.userBankCardId = userBankCardId == null ? null : userBankCardId.trim();
    }

    public String getUserPostalCode() {
        return userPostalCode;
    }

    public void setUserPostalCode(String userPostalCode) {
        this.userPostalCode = userPostalCode == null ? null : userPostalCode.trim();
    }

    public String getUserFamilyPhone() {
        return userFamilyPhone;
    }

    public void setUserFamilyPhone(String userFamilyPhone) {
        this.userFamilyPhone = userFamilyPhone == null ? null : userFamilyPhone.trim();
    }

    public String getUserContactName() {
        return userContactName;
    }

    public void setUserContactName(String userContactName) {
        this.userContactName = userContactName == null ? null : userContactName.trim();
    }

    public String getUserContactPhone() {
        return userContactPhone;
    }

    public void setUserContactPhone(String userContactPhone) {
        this.userContactPhone = userContactPhone == null ? null : userContactPhone.trim();
    }

    public String getUserContactIdentity() {
        return userContactIdentity;
    }

    public void setUserContactIdentity(String userContactIdentity) {
        this.userContactIdentity = userContactIdentity == null ? null : userContactIdentity.trim();
    }

    public String getUserUniversity() {
        return userUniversity;
    }

    public void setUserUniversity(String userUniversity) {
        this.userUniversity = userUniversity == null ? null : userUniversity.trim();
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment == null ? null : userDepartment.trim();
    }

    public String getUserMajor() {
        return userMajor;
    }

    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor == null ? null : userMajor.trim();
    }

    public String getUserEducation() {
        return userEducation;
    }

    public void setUserEducation(String userEducation) {
        this.userEducation = userEducation == null ? null : userEducation.trim();
    }

    public Integer getUserEnrollmentYear() {
        return userEnrollmentYear;
    }

    public void setUserEnrollmentYear(Integer userEnrollmentYear) {
        this.userEnrollmentYear = userEnrollmentYear;
    }

    public String getUserStudentId() {
        return userStudentId;
    }

    public void setUserStudentId(String userStudentId) {
        this.userStudentId = userStudentId == null ? null : userStudentId.trim();
    }

    public String getUserMajorCategory() {
        return userMajorCategory;
    }

    public void setUserMajorCategory(String userMajorCategory) {
        this.userMajorCategory = userMajorCategory == null ? null : userMajorCategory.trim();
    }


    public Date getUserGraduationTime() {
        return userGraduationTime;
    }

    public void setUserGraduationTime(Date userGraduationTime) {
        this.userGraduationTime = userGraduationTime;
    }

    public String getUserLoanType() {
        return userLoanType;
    }

    public void setUserLoanType(String userLoanType) {
        this.userLoanType = userLoanType == null ? null : userLoanType.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }

    public Integer getAccountCharacterId() {
        return accountCharacterId;
    }

    public void setAccountCharacterId(Integer accountCharacterId) {
        this.accountCharacterId = accountCharacterId;
    }

    public Integer getFundingCenterId() {
        return fundingCenterId;
    }

    public void setFundingCenterId(Integer fundingCenterId) {
        this.fundingCenterId = fundingCenterId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getUserPermanentAddress() {
        return userPermanentAddress;
    }

    public void setUserPermanentAddress(String userPermanentAddress) {
        this.userPermanentAddress = userPermanentAddress == null ? null : userPermanentAddress.trim();
    }

    public String getUserMailBox() {
        return userMailBox;
    }

    public void setUserMailBox(String userMailBox) {
        this.userMailBox = userMailBox;
    }

    public String getUserPostalAddress() {
        return userPostalAddress;
    }

    public void setUserPostalAddress(String userPostalAddress) {
        this.userPostalAddress = userPostalAddress;
    }

    public String getUserEducationalSystem() {
        return userEducationalSystem;
    }

    public void setUserEducationalSystem(String userEducationalSystem) {
        this.userEducationalSystem = userEducationalSystem;
    }

    public String getUserFamousRaceName() {
        return userFamousRaceName;
    }

    public void setUserFamousRaceName(String userFamousRaceName) {
        this.userFamousRaceName = userFamousRaceName;
    }

    public String getAccountCharacterName() {
        return accountCharacterName;
    }

    public void setAccountCharacterName(String accountCharacterName) {
        this.accountCharacterName = accountCharacterName;
    }

    public String getFundingCenterName() {
        return fundingCenterName;
    }

    public void setFundingCenterName(String fundingCenterName) {
        this.fundingCenterName = fundingCenterName;
    }

}
