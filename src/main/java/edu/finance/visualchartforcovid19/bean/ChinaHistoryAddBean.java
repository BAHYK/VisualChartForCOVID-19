package edu.finance.visualchartforcovid19.bean;

import lombok.Data;

@Data
public class ChinaHistoryAddBean {
    Integer confirm;
    Integer nowConfirm;
    Integer localConfirm;
    String date;
    Integer importedCase;
    Integer heal;
    Integer dead;


}
