package edu.finance.visualchartforcovid19.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.finance.visualchartforcovid19.bean.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class SaveTotalData {

    //全国今日累计疫情数据保存到数据库
    public ChinaTotalBean queryChinaTotalData() {

        String uri = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=localCityNCOVDataList,diseaseh5Shelf";
        ResponseEntity<String> stringResponseEntity = TxCovid19DataAPI.queryDataByTx(uri);
        JSONObject jsonObject = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONObject data = jsonObject.getJSONObject("data");
        JSONObject diseaseh5shelf = data.getJSONObject("diseaseh5Shelf");
        ChinaTotalBean chinaTotal = diseaseh5shelf.getObject("chinaTotal", ChinaTotalBean.class);
        return chinaTotal;
    }
    //各个省(直辖市)今日累计数据
    public ArrayList<ProvincesDataBean> queryProvinceTotalData() {

        String uri = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=localCityNCOVDataList,diseaseh5Shelf";
        ResponseEntity<String> stringResponseEntity = TxCovid19DataAPI.queryDataByTx(uri);
        JSONObject jsonObject = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray areaTree = data.getJSONObject("diseaseh5Shelf").getJSONArray("areaTree");
        JSONObject jsonObject1 = areaTree.getJSONObject(0);
        JSONArray children = jsonObject1.getJSONArray("children");
        ArrayList<ProvincesDataBean> provincesDataBeans = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            JSONObject jsonObject2 = children.getJSONObject(i);
            String provinceName = jsonObject2.getString("name");
            JSONObject today = jsonObject2.getJSONObject("today");
            JSONObject total = jsonObject2.getJSONObject("total");
            ProvincesDataBean provincesDataBean = new ProvincesDataBean();
            provincesDataBean.setProvinceName(provinceName);
            provincesDataBean.setConfirm(Integer.valueOf(total.getString("confirm")));
            provincesDataBean.setLocalConfirmAdd(Integer.valueOf(today.getString("local_confirm_add")));
            provincesDataBean.setNowConfirm(Integer.valueOf(total.getString("nowConfirm")));
            provincesDataBean.setWzzAdd(Integer.valueOf(today.getString("wzz_add")));
            provincesDataBean.setDead(Integer.valueOf(total.getString("dead")));
            provincesDataBean.setHeal(Integer.valueOf(total.getString("heal")));
//            System.out.println(provincesDataBean.toString());
            provincesDataBeans.add(provincesDataBean);
        }
        return provincesDataBeans;

    }
    //各个市今日累计数据
    public ArrayList<CitiesDataBean> queryCitiesTotalData() {

        String uri = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=localCityNCOVDataList,diseaseh5Shelf";
        ResponseEntity<String> stringResponseEntity = TxCovid19DataAPI.queryDataByTx(uri);
        JSONObject jsonObject = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray areaTree = data.getJSONObject("diseaseh5Shelf").getJSONArray("areaTree");
        JSONObject jsonObject1 = areaTree.getJSONObject(0);
        JSONArray children = jsonObject1.getJSONArray("children");
        ArrayList<CitiesDataBean> citiesDataBeans = new ArrayList<>();

        for (int i = 0; i < children.size(); i++) {
            JSONObject jsonObject2 = children.getJSONObject(i);
            String provinceName = jsonObject2.getString("name");
            JSONArray children1 = jsonObject2.getJSONArray("children");
            for (int j = 0; j < children1.size(); j++) {
                CitiesDataBean citiesDataBean = new CitiesDataBean();
                citiesDataBean.setProvinceName(provinceName);
                JSONObject jsonObject3 = children1.getJSONObject(j);
                String cityName = jsonObject3.getString("name");
                JSONObject cityToday = jsonObject3.getJSONObject("today");
                JSONObject cityTotal = jsonObject3.getJSONObject("total");
                citiesDataBean.setCityName(cityName);
                citiesDataBean.setConfirm(Integer.valueOf(cityTotal.getString("confirm")));
                citiesDataBean.setNowConfirm(Integer.valueOf(cityTotal.getString("nowConfirm")));
                citiesDataBean.setLocalConfirmAdd(Integer.valueOf(cityToday.getString("local_confirm_add")));
//                citiesDataBean.setWzzAdd(Integer.valueOf(cityToday.getString("wzz_add")));
                citiesDataBean.setWzzAdd(Integer.valueOf(!"".equals(cityToday.getString("wzz_add")) ? cityToday.getString("wzz_add") : "0"));
//                System.out.println(!"".equals(cityToday.getString("wzz_add"))?cityToday.getString("wzz_add"):"0");
                citiesDataBean.setDead(Integer.valueOf(cityTotal.getString("dead")));
                citiesDataBean.setHeal(Integer.valueOf(cityTotal.getString("heal")));
                citiesDataBeans.add(citiesDataBean);
            }
        }
        return citiesDataBeans;

    }

    //国内历史日新增数据
    public  ArrayList<ChinaHistoryAddBean> queryChinaHistoryDailyData(){

        String uri = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=chinaDayListNew,chinaDayAddListNew&limit=30";
        ResponseEntity<String> stringResponseEntity = TxCovid19DataAPI.queryDataByTx(uri);
        JSONObject jsonObject = JSONObject.parseObject(stringResponseEntity.getBody());
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray chinaDayListNew = data.getJSONArray("chinaDayListNew");
        ArrayList<ChinaHistoryAddBean> chinaHistoryAddBeans = new ArrayList<>();
        for (int i = 0; i < chinaDayListNew.size(); i++) {
            JSONObject jsonObject1 = chinaDayListNew.getJSONObject(i);
            String date = jsonObject1.getString("date");
            String replace = date.replace(".", "-");
//            System.out.println(replace);
            JSONObject date2 = chinaDayListNew.getJSONObject(i).fluentPut("date", replace);
            ChinaHistoryAddBean chinaHistoryAddBean = JSON.toJavaObject(date2, ChinaHistoryAddBean.class);
            chinaHistoryAddBeans.add(chinaHistoryAddBean);
        }
        return chinaHistoryAddBeans;

    }

    //各省历史数据
    public ArrayList<ProvincesHistoryBean> queryProvincesHistoryData(){
        ArrayList<ResponseEntity<String>> responseEntities = TxCovid19DataAPI.queryDailyDataByTx();

        ArrayList<ProvincesHistoryBean> provincesHistoryBeans = new ArrayList<>();
        for (int i = 0; i <responseEntities.size(); i++) {
            JSONObject jsonObject = JSONObject.parseObject(responseEntities.get(i).getBody());
            JSONArray data = jsonObject.getJSONArray("data");
            for (int i1 = 0; i1 < data.size(); i1++) {
                JSONObject jsonObject1 = data.getJSONObject(i1);
                String province = jsonObject1.getString("province");
                String confirm = jsonObject1.getString("confirm");
                String newConfirm = jsonObject1.getString("newConfirm");
                String newHeal = jsonObject1.getString("newHeal");
                String newDead = jsonObject1.getString("newDead");
                String mtime = jsonObject1.getString("_mtime");
                String confirm_add = jsonObject1.getString("confirm_add");
                ProvincesHistoryBean provincesHistoryBean = new ProvincesHistoryBean();
                provincesHistoryBean.setMtime(mtime);
                provincesHistoryBean.setProvinceName(province);
                provincesHistoryBean.setConfirm(Integer.valueOf(confirm));
                provincesHistoryBean.setNewConfirm(Integer.valueOf(newConfirm));
                provincesHistoryBean.setNewHeal(Integer.valueOf(newHeal));
                provincesHistoryBean.setNewDead(Integer.valueOf(newDead));
                provincesHistoryBean.setConfirmAdd(Integer.valueOf(confirm_add));
                provincesHistoryBeans.add(provincesHistoryBean);
            }
        }
        return provincesHistoryBeans;


    }


    public static void main(String[] args) {
        SaveTotalData saveTotalData = new SaveTotalData();
//        saveTotalData.queryProvinceTotalData();
//        saveTotalData.queryCitiesTotalData();
//        saveTotalData.queryChinaHistoryDailyData();
        saveTotalData.queryProvincesHistoryData();
    }


}
