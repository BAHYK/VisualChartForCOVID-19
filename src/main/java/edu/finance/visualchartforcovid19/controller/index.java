package edu.finance.visualchartforcovid19.controller;

import com.alibaba.fastjson.JSON;
import edu.finance.visualchartforcovid19.bean.ChinaHistoryAddBean;
import edu.finance.visualchartforcovid19.bean.ChinaTotalBean;
import edu.finance.visualchartforcovid19.bean.ProvincesDataBean;
import edu.finance.visualchartforcovid19.util.SaveTotalData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class index {
    SaveTotalData saveTotalData = new SaveTotalData();

    @GetMapping({"/","/index.html"})
    public String queryData(Model model){

        ChinaTotalBean chinaTotalBean = saveTotalData.queryChinaTotalData();
        model.addAttribute("chinaTotalData", chinaTotalBean);

        ArrayList<ChinaHistoryAddBean> chinaHistoryAddBeans = saveTotalData.queryChinaHistoryDailyData();
        model.addAttribute("chinaHistoryList", JSON.toJSONString(chinaHistoryAddBeans));

        ArrayList<ProvincesDataBean> provincesDataBeans = saveTotalData.queryProvinceTotalData();
        model.addAttribute("provincesDataList", JSON.toJSONString(provincesDataBeans));


        return "index";
    }

/*    @GetMapping("/test")

    public String queryTest(Model model){
        ArrayList<ProvincesDataBean> provincesDataBeans = saveTotalData.queryProvinceTotalData();
        model.addAttribute("provincesDataList", JSON.toJSONString(provincesDataBeans));

        return "test";
    }*/



}
