package com.stu.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Users {
    private Integer userId;

    private String userName;

    private String userIdentity;

    private String userSecurityQuestion;

    private String userSecurityAnswer;

    private String userPhone;

    private String userSex;

    private String userMiddleSchool;

    private String userFamousRace;

    private Integer accountCharacterId;

    private Integer fundingCenterId;

    private String userPermanentAddress;

    private String userMailAddress;

    private String userMailBox;

    private String userQq;

    private String userWechat;

    private String userPostalAddress;

    private String userFamilyAddress;

    private String userPostalCode;

    private String userFamilyPhone;

    private String userContactName;

    private String contactWorkUnit;

    private String userContactNumber;

    private String userContactPhone;

    private String userContactIdentity;

    private String userUniversity;

    private String userDepartment;

    private String userMajor;

    private String userEducation;

    private String userEnrollmentYear;

    private String userStudentId;

    private String userMajorCategory;

    private String userEducationalSystem;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date userGraduationTime;

    private String userWorkUnit;

    private String userUnitProperty;

    private String userUnitPhone;

    private String userUnitMailAddress;

    private String userUnitAddress;

    private Integer changeReasonId;

    private String userIdphotoFront;

    private String userIdphotoReverse;

    private String userSchoolInfoPhoto;

    private Integer loanId;

    private Integer guardianId;
    private String userLoanType;

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

    public String getUserMiddleSchool() {
        return userMiddleSchool;
    }

    public void setUserMiddleSchool(String userMiddleSchool) {
        this.userMiddleSchool = userMiddleSchool == null ? null : userMiddleSchool.trim();
    }

    public String getUserFamousRace() {
        return userFamousRace;
    }

    public void setUserFamousRace(String userFamousRace) {
        this.userFamousRace = userFamousRace == null ? null : userFamousRace.trim();
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

    public String getUserPermanentAddress() {
        return userPermanentAddress;
    }

    public void setUserPermanentAddress(String userPermanentAddress) {
        this.userPermanentAddress = userPermanentAddress == null ? null : userPermanentAddress.trim();
    }

    public String getUserMailAddress() {
        return userMailAddress;
    }

    public void setUserMailAddress(String userMailAddress) {
        this.userMailAddress = userMailAddress == null ? null : userMailAddress.trim();
    }

    public String getUserMailBox() {
        return userMailBox;
    }

    public void setUserMailBox(String userMailBox) {
        this.userMailBox = userMailBox == null ? null : userMailBox.trim();
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

    public String getUserPostalAddress() {
        return userPostalAddress;
    }

    public void setUserPostalAddress(String userPostalAddress) {
        this.userPostalAddress = userPostalAddress == null ? null : userPostalAddress.trim();
    }

    public String getUserFamilyAddress() {
        return userFamilyAddress;
    }

    public void setUserFamilyAddress(String userFamilyAddress) {
        this.userFamilyAddress = userFamilyAddress == null ? null : userFamilyAddress.trim();
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

    public String getContactWorkUnit() {
        return contactWorkUnit;
    }

    public void setContactWorkUnit(String contactWorkUnit) {
        this.contactWorkUnit = contactWorkUnit == null ? null : contactWorkUnit.trim();
    }

    public String getUserContactNumber() {
        return userContactNumber;
    }

    public void setUserContactNumber(String userContactNumber) {
        this.userContactNumber = userContactNumber == null ? null : userContactNumber.trim();
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

    public String getUserEnrollmentYear() {
        return userEnrollmentYear;
    }

    public void setUserEnrollmentYear(String userEnrollmentYear) {
        this.userEnrollmentYear = userEnrollmentYear == null ? null : userEnrollmentYear.trim();
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

    public String getUserEducationalSystem() {
        return userEducationalSystem;
    }

    public void setUserEducationalSystem(String userEducationalSystem) {
        this.userEducationalSystem = userEducationalSystem == null ? null : userEducationalSystem.trim();
    }

    public Date getUserGraduationTime() {
        return userGraduationTime;
    }

    public void setUserGraduationTime(Date userGraduationTime) {
        this.userGraduationTime = userGraduationTime;
    }

    public String getUserWorkUnit() {
        return userWorkUnit;
    }

    public void setUserWorkUnit(String userWorkUnit) {
        this.userWorkUnit = userWorkUnit == null ? null : userWorkUnit.trim();
    }

    public String getUserUnitProperty() {
        return userUnitProperty;
    }

    public void setUserUnitProperty(String userUnitProperty) {
        this.userUnitProperty = userUnitProperty == null ? null : userUnitProperty.trim();
    }

    public String getUserUnitPhone() {
        return userUnitPhone;
    }

    public void setUserUnitPhone(String userUnitPhone) {
        this.userUnitPhone = userUnitPhone == null ? null : userUnitPhone.trim();
    }

    public String getUserUnitMailAddress() {
        return userUnitMailAddress;
    }

    public void setUserUnitMailAddress(String userUnitMailAddress) {
        this.userUnitMailAddress = userUnitMailAddress == null ? null : userUnitMailAddress.trim();
    }

    public String getUserUnitAddress() {
        return userUnitAddress;
    }

    public void setUserUnitAddress(String userUnitAddress) {
        this.userUnitAddress = userUnitAddress == null ? null : userUnitAddress.trim();
    }

    public Integer getChangeReasonId() {
        return changeReasonId;
    }

    public void setChangeReasonId(Integer changeReasonId) {
        this.changeReasonId = changeReasonId;
    }

    public String getUserIdphotoFront() {
        return userIdphotoFront;
    }

    public void setUserIdphotoFront(String userIdphotoFront) {
        this.userIdphotoFront = userIdphotoFront == null ? null : userIdphotoFront.trim();
    }

    public String getUserIdphotoReverse() {
        return userIdphotoReverse;
    }

    public void setUserIdphotoReverse(String userIdphotoReverse) {
        this.userIdphotoReverse = userIdphotoReverse == null ? null : userIdphotoReverse.trim();
    }

    public String getUserSchoolInfoPhoto() {
        return userSchoolInfoPhoto;
    }

    public void setUserSchoolInfoPhoto(String userSchoolInfoPhoto) {
        this.userSchoolInfoPhoto = userSchoolInfoPhoto == null ? null : userSchoolInfoPhoto.trim();
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getGuardianId() {
        return guardianId;
    }

    public void setGuardianId(Integer guardianId) {
        this.guardianId = guardianId;
    }

    public String getUserLoanType() {
        return userLoanType;
    }

    public void setUserLoanType(String userLoanType) {
        this.userLoanType = userLoanType;
    }
}