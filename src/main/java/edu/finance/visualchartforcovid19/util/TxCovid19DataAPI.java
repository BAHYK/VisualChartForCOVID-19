package edu.finance.visualchartforcovid19.util;

import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TxCovid19DataAPI {

    public static ResponseEntity<String>  queryDataByTx(String uri){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        String uri = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=localCityNCOVDataList,diseaseh5Shelf";
//        url = "https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=chinaDayListNew,chinaDayAddListNew&limit=30"
       /* url_keys = ["110000", "120000", "130000", "140000", "150000", "210000", "220000", "230000", "310000", "320000", "330000", "340000", "350000",
        "360000", "370000", "410000", "420000", "430000", "440000", "450000", "460000", "500000", "510000", "520000", "530000", "540000",
                "610000", "620000", "630000", "640000", "650000", "710000", "810000", "820000"]
                 url = "https://api.inews.qq.com/newsqa/v1/query/pubished/daily/list?adCode=%s&limit=30";
*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response;
    }

    public static ArrayList<ResponseEntity<String>>  queryDailyDataByTx(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpHeaders headers = new HttpHeaders();
               /* url_keys = ['110000', '120000', '130000', '140000', '150000', '210000', '220000', '230000', '310000', '320000', '330000', '340000', '350000',
        '360000', '370000', '410000', '420000', '430000', '440000', '450000', '460000', '500000', '510000', '520000', '530000', '540000',
                '610000', '620000', '630000', '640000', '650000', '710000', '810000', '820000']
                 url = 'https://api.inews.qq.com/newsqa/v1/query/pubished/daily/list?adCode=%s&limit=30';
*/
        ArrayList<ResponseEntity<String>> responseEntities = new ArrayList<>();
        String url_keys[]={"110000", "120000", "130000", "140000", "150000", "210000", "220000", "230000", "310000", "320000", "330000", "340000", "350000",
                "360000", "370000", "410000", "420000", "430000", "440000", "450000", "460000", "500000", "510000", "520000", "530000", "540000",
                "610000", "620000", "630000", "640000", "650000", "710000", "810000", "820000"};
        for (int i = 0; i < url_keys.length; i++) {
            String url_key = url_keys[i];
            String url = "https://api.inews.qq.com/newsqa/v1/query/pubished/daily/list?adCode="+url_key+"&limit=30";
            headers.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            responseEntities.add(response);
        }
        return responseEntities;

    }

    public static void main(String[] args) {
        String url_keys[]={"110000", "120000", "130000", "140000", "150000", "210000", "220000", "230000", "310000", "320000", "330000", "340000", "350000",
                "360000", "370000", "410000", "420000", "430000", "440000", "450000", "460000", "500000", "510000", "520000", "530000", "540000",
                "610000", "620000", "630000", "640000", "650000", "710000", "810000", "820000"};
        System.out.println(url_keys.length);
    }








}
