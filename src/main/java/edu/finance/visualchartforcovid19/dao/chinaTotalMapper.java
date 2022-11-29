package edu.finance.visualchartforcovid19.dao;

import edu.finance.visualchartforcovid19.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface chinaTotalMapper {


    @Insert("insert into china_total(confirm,nowConfirm,localWzzAdd,localConfirmAdd,heal,dead) " +
            "values(#{confirm},#{nowConfirm},#{localWzzAdd},#{localConfirmAdd},#{heal},#{dead})")
    void InsertDataWithChinaTotal(ChinaTotalBean chinaTotal);

    @Insert("insert into provinces_data(province_name,confirm,nowConfirm,local_confirm_add,wzz_add,heal,dead)" +
            "values(#{provinceName},#{confirm},#{nowConfirm},#{localConfirmAdd},#{wzzAdd},#{heal},#{dead})")
    void InsertDataWithProvinceData(ProvincesDataBean provincesDataBean);

    @Insert("insert into cities_data(province_name,confirm,nowConfirm,local_confirm_add,wzz_add,heal,dead,city_name)" +
            "values(#{provinceName},#{confirm},#{nowConfirm},#{localConfirmAdd},#{wzzAdd},#{heal},#{dead},#{cityName})")
    void InsertDataWithCitiesData(CitiesDataBean citiesDataBean);

    @Insert("insert into china_history_add(confirm,nowConfirm,localConfirm,date,importedCase,heal,dead)" +
            "values(#{confirm},#{nowConfirm},#{localConfirm},#{date},#{importedCase},#{heal},#{dead})")
    void InsertChinaHistoryAdd(ChinaHistoryAddBean chinaHistoryAddBean);

    @Insert("insert into provinces_history(province_name,confirm,confirm_add,newConfirm,newHeal,newDead,mtime)" +
            "values(#{provinceName},#{confirm},#{confirmAdd},#{newConfirm},#{newHeal},#{newDead},#{mtime})")
    void InsertProvincesHistory(ProvincesHistoryBean provincesHistoryBean);


}
