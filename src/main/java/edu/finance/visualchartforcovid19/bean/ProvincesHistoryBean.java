package edu.finance.visualchartforcovid19.bean;

import lombok.Data;

@Data
public class ProvincesHistoryBean {
    String provinceName;
    Integer confirm;
    Integer confirmAdd;
    Integer newConfirm;
    Integer newHeal;
    Integer newDead;
    String mtime;


}
