package edu.finance.visualchartforcovid19;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootTest
class VisualChartForCovid19ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void get() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
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
