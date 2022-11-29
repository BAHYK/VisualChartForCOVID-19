package edu.finance.visualchartforcovid19;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.finance.visualchartforcovid19.bean.*;
import edu.finance.visualchartforcovid19.dao.chinaTotalMapper;
import edu.finance.visualchartforcovid19.util.SaveTotalData;
import edu.finance.visualchartforcovid19.util.TxCovid19DataAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SpringBootTest
class VisualChartForCovid19ApplicationTests {
    @Autowired
    chinaTotalMapper chinaTotalMapper;


    @Test
    void contextLoads() {
    }

    @Test
    void get1() {
     /*   RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String uri = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=localCityNCOVDataList,diseaseh5Shelf";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        */
/*        ResponseEntity<String> response = TxCovid19DataAPI.queryDataByTx();
        JSONObject jsonObject = JSONObject.parseObject(response.getBody());
        //获取data部分
        JSONObject data = jsonObject.getJSONObject("data");
        //获取高风险地区数据
        JSONArray localCityNCOVDataList = data.getJSONArray("localCityNCOVDataList");
        Object o = localCityNCOVDataList.get(0);

        JSONObject jsonObject1 = data.getJSONObject("diseaseh5Shelf");
        ChinaTotalBean chinaTotal = jsonObject1.getObject("chinaTotal", ChinaTotalBean.class);
        chinaTotalMapper.InsertDataWithChinaTotal(chinaTotal);*/


//        System.out.println(localCityNCOVDataList.get(0));

//        System.out.println(response);
//        System.out.println(response.getBody());
        SaveTotalData saveTotalData = new SaveTotalData();

       /* ChinaTotalBean chinaTotalBean = saveTotalData.queryChinaTotalData();
        chinaTotalMapper.InsertDataWithChinaTotal(chinaTotalBean);*/
      /*  ArrayList<ProvincesDataBean> provincesDataBeans = saveTotalData.queryProvinceTotalData();
        for (int i = 0; i < provincesDataBeans.size(); i++) {
            ProvincesDataBean provincesDataBean = provincesDataBeans.get(i);
            chinaTotalMapper.InsertDataWithProvinceData(provincesDataBean);
        }*/
/*        ArrayList<CitiesDataBean> citiesDataBeans = saveTotalData.queryCitiesTotalData();
        for (CitiesDataBean citiesDataBean : citiesDataBeans) {
            chinaTotalMapper.InsertDataWithCitiesData(citiesDataBean);
//            System.out.println(citiesDataBean.toString());
        }*/
     /*   ArrayList<ChinaHistoryAddBean> chinaHistoryAddBeans = saveTotalData.queryChinaHistoryDailyData();
        for (ChinaHistoryAddBean chinaHistoryAddBean : chinaHistoryAddBeans) {
            chinaTotalMapper.InsertChinaHistoryAdd(chinaHistoryAddBean);
        }*/
        ArrayList<ProvincesHistoryBean> provincesHistoryBeans = saveTotalData.queryProvincesHistoryData();
        for (int i = 0; i < provincesHistoryBeans.size(); i++) {
            ProvincesHistoryBean provincesHistoryBean = provincesHistoryBeans.get(i);
            chinaTotalMapper.InsertProvincesHistory(provincesHistoryBean);
        }

    }

    @Test
    public void get() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        String uri = "http://apis.juhe.cn/springTravel/risk?key=f356614cb42ac6a903a914c95bb834ef";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        JSONObject jsonObject = JSONObject.parseObject(response.getBody());
//        花括号保存对象
//        方括号保存数组
        System.out.println(JSON.parseObject(jsonObject.getString("result")).getString("updated_date"));
        String string = JSON.parseObject(jsonObject.getString("result")).getString("updated_date");

        /*System.out.println(response);
        System.out.println(response.getBody());*/


    }

}
