package com.stu.service;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.stu.entity.Guardian;
import com.stu.entity.LoanContract;
import com.stu.entity.Users;
import com.stu.mapper.*;
import com.stu.util.ChineseToFirstLetterUtil;
import com.stu.util.DateUtilCurrent;
import com.stu.util.file.PdfUtil;
import com.stu.vo.AreasVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName：LoanContractServiceImpl
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/4/6 14:03
 * @version 1.0.0
 */
@Service
public class LoanContractServiceImpl implements LoanContractService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private GuardianMapper guardianMapper;
    @Autowired
    private LoanContractMapper loanContractMapper;
    @Autowired
    private FamousRaceMapper famousRaceMapper;
    @Autowired
    private AccountCharacterMapper accountCharacterMapper;
    @Autowired
    private AreasMapper areasMapper;

    @Override
    public JSONObject getUserInfoByLoanInfo(String userIdentity) {
        JSONObject jsonObject = new JSONObject();
        JSONObject data = new JSONObject();
        Users user = usersMapper.selectUserByIdentity(userIdentity);
        if (user != null) {
            data.put("userName", user.getUserName());
            data.put("applicationYear", DateUtilCurrent.getCurrentYear() + "-" + (DateUtilCurrent.getCurrentYear() + 1) + "学年");
            data.put("userLoanType", user.getUserLoanType());
            jsonObject.put("status", 200);
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", 200);
            jsonObject.put("data", null);
        }
        return jsonObject;
    }

    @Override
    public JSONObject fillLoanAppForm(LoanContract loanContract) {
        JSONObject jsonObject = new JSONObject();
        LoanContract fetchLoanYear = loanContractMapper.selectByUserIdentity(loanContract.getUserIdentity());
        if(fetchLoanYear!=null){
//            System.out.println(DateUtil.year(fetchLoanYear.getLoanDate()));
            if(DateUtilCurrent.getCurrentYear()== DateUtil.year(fetchLoanYear.getLoanDate())){
                jsonObject.put("status",401);
                jsonObject.put("message","贷款一年只能一次！");
                return jsonObject;
            }
        }
        //根据userIdentity查询共同贷款人信息
        Guardian guardian = guardianMapper.selectByUserIdentity(loanContract.getUserIdentity());
        if (guardian != null) {
            loanContract.setGuardianIdentity(guardian.getGuardianIdentity());
            Users users = usersMapper.selectUserByIdentity(loanContract.getUserIdentity());
            SimpleDateFormat simpleDateFormat;
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

            //组装合同编号
            String contractId = users.getUserIdentity().substring(0, 6) +
                    users.getUserIdentity().substring(10, 12) +
                    ChineseToFirstLetterUtil.ChineseToFirstToUpper(users.getUserName()).substring(1, 2) +
                    simpleDateFormat.format(new Date());
            loanContract.setContractId(contractId);//生成贷款合同合同编号
            try {
                if (loanContractMapper.insert(loanContract) == 1) {
                    if ("首贷".equals(users.getUserLoanType())) {
                        Users updateUserLoanType = new Users();
                        updateUserLoanType.setUserIdentity(users.getUserIdentity());
                        updateUserLoanType.setUserLoanType("续贷");
                        usersMapper.updateUserLoanType(updateUserLoanType);
                    }
                    //申请贷款成功后根据模板创建贷款申请表
                    createAppForm(users.getUserIdentity(),contractId);
                    jsonObject.put("status", 200);
                    jsonObject.put("message","申请贷款成功！");
                }
            } catch (Exception e) {
                e.printStackTrace();
                jsonObject.put("message","申请贷款失败！");
                jsonObject.put("status", 401);
            }
        } else {
            jsonObject.put("message","申请贷款失败！");
            jsonObject.put("status", 401);
        }
        return jsonObject;
    }

    @Override
    public void createAppForm(String userIdentity,String contractId) {

        //根据 userIdentity 获取用户信息
        Users user = usersMapper.selectUserByIdentity(userIdentity);
        //根据 user_areaId 获取用户籍贯
        AreasVo userAreasVo = areasMapper.selectAreaVoByAreaId(user.getAreaId());
        //根据 userIdentity 获取共同贷款人信息
        Guardian guardian = guardianMapper.selectByUserIdentity(userIdentity);
        AreasVo  guardianAreasVo = areasMapper.selectAreaVoByAreaId(guardian.getAreaId());
        //根据 userIdentity 获取贷款合同信息
        LoanContract loanContract = loanContractMapper.selectByContractId(contractId);
        Map<String,String> map =  new HashMap();
        map.put("userName",user.getUserName());
        map.put("userSex",user.getUserSex());
        //把出生日期按照年月日转换
        map.put("userBirthday",DateUtilCurrent.getDate(user.getUserBirthday()));
        map.put("userIdentity",userIdentity);
        map.put("userFamousRace",famousRaceMapper.selectByFamousRaceId(user.getUserFamousRaceId()).getFamousRaceName());
        map.put("userAccountCharacter",accountCharacterMapper.selectByAccountCharacterId(user.getAccountCharacterId()).getAccountCharacterName());
        map.put("userMiddleSchool",user.getUserMiddleSchool());
        map.put("userPermanentAddress",userAreasVo.getProvinceName()+userAreasVo.getCityName()
                +userAreasVo.getAreaName()+user.getUserPermanentAddress());
        map.put("userPhone",user.getUserPhone());
        map.put("userMailBox",user.getUserMailBox());
        map.put("userPostalAddress",user.getUserPostalAddress());
        map.put("userPostalCode",user.getUserPostalCode());
        map.put("guardianName",guardian.getGuardianName());
        map.put("relation",user.getRelation());
        map.put("guardianIdentity",guardian.getGuardianIdentity());
        map.put("guardianHealth",guardian.getGuardianHealth());
        map.put("guardianPermanentAddress",guardianAreasVo.getProvinceName()+guardianAreasVo.getCityName()
                + guardianAreasVo.getAreaName()+guardian.getGuardianPermanentAddress());
        map.put("guardianTel",guardian.getGuardianTel());
        map.put("guardianPostalCode",guardian.getGuardianPostalCode());
        map.put("userUniversity",user.getUserUniversity());
        map.put("userDepartment",user.getUserDepartment());
        map.put("userMajor",user.getUserMajor());
        map.put("userEnrollmentYear",String.valueOf(user.getUserEnrollmentYear()));
        map.put("userEducationSystem",user.getUserEducationalSystem());
        map.put("userEducation",user.getUserEducation());
        map.put("userGraduationTime", String.valueOf(DateUtil.year(user.getUserGraduationTime())));
        map.put("userStudentId",user.getUserStudentId());
        map.put("userMajorCategory",user.getUserMajorCategory());
        map.put("loanYear", DateUtilCurrent.getCurrentYear() + " - " + (DateUtilCurrent.getCurrentYear() + 1));
        map.put("repaymentDate",String.valueOf(loanContract.getLoanTerm()));
        map.put("loanMoney",String.valueOf(loanContract.getLoanMoney()));
        map.put("userBankCardId",user.getUserBankCardId());
        Map<String,Object> objectMap = new HashMap();
        objectMap.put("dataMap",map);
        PdfUtil.pdfout(objectMap);
    }


    @Override
    public LoanContract selectByUserIdentityAndLoanId(String userIdentity, int loanId) {
        return loanContractMapper.selectByUserIdentityAndLoanId(userIdentity, loanId);
    }

    @Override
    public LoanContract selectByContractId(String contractId) {
        return loanContractMapper.selectByContractId(contractId);
    }
}
