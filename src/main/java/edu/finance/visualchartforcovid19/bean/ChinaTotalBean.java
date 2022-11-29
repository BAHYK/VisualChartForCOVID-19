package edu.finance.visualchartforcovid19.bean;

import lombok.Data;

import java.util.Date;

@Data
public class ChinaTotalBean {
//    Integer highRiskAreaNum;//高风险地区
    Integer nowConfirm;//现存确诊
    Integer localConfirmAdd;//本地新增确诊
    Integer localWzzAdd;//本地新增无症状
//    Integer localConfirm;//本地现存确诊
    Integer dead;//死亡数
//    Integer nowSevere;//风险地区
//    Integer localConfirmH5;
//    Integer local_acc_confirm;
//    Integer confirmAdd;//新增确诊(含港澳台)
//    Integer deadAdd;//新增死亡
//    Integer importedCase;//重症数
//    Integer noInfect;
//    Integer nowLocalWzz;//本地现存无症状
//    String mtime;//病例数据更新日期
//    String mRiskTime;//风险地区更新日期
    Integer confirm;//总确诊数
    Integer heal;//总治愈数


}
