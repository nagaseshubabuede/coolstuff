package com.example.springboottesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

public class TestClass {

    public <T> T convertStringToGenericObject(String string, Class<T> objectClass) {
        T object = null;

        try {
            object = new ObjectMapper().readValue(string, objectClass);
        } catch (Exception e) {
            return null;
        }

        return object;
    }

    public void compareObjects(Map<String, Object> object1, Map<String, Object> object2) {

        if (object1 == null
                || object2 == null
                || !object1.containsKey("hts_response")
                || !object2.containsKey("hts_response")) {
            return;
        }

        List<Map<String, Object>> obj1HttRes = (List<Map<String, Object>>) object1.get("hts_response");
        List<Map<String, Object>> obj2HttpRes = (List<Map<String, Object>>) object2.get("hts_response");

        //Blank Check
        if (CollectionUtils.isEmpty(obj1HttRes)
                || CollectionUtils.isEmpty(obj2HttpRes)) {

            //Results

            return;
        }


        //Null Check
        if (obj1HttRes.get(0) == null || obj2HttpRes.get(0) == null) {

            return;
        }


        for (int i = 0; i < obj1HttRes.size(); i++) {

            List<Map<String, Object>> obj1ComponentRes =
                    (List<Map<String, Object>>) ((Map<String, Object>) obj1HttRes.get(i)
                            .get("Attributes")).get("components");

            List<Map<String, Object>> obj2ComponentRes =
                    (List<Map<String, Object>>) obj2HttpRes.get(i).get("components");

            for (int j = 0; j < obj1ComponentRes.size(); j++) {

                StringUtils.equals(obj1ComponentRes.get(j).get("customs_description").toString(),
                        obj2ComponentRes.get(j).get("customs_description").toString());


                StringUtils.equals(obj2ComponentRes.get(j).get("detailed_description").toString(),
                        obj2ComponentRes.get(j).get("detailed_description").toString());


                StringUtils.equals(obj1ComponentRes.get(j).get("invoice_description").toString(),
                        obj2ComponentRes.get(j).get("invoice_description").toString());


                String obj1HtcCode =
                        ((Map<String, Object>) ((Map<String, Object>) obj1ComponentRes.get(j)
                                .get("classification")).get("hts")).get("code").toString();

                String obj2HtcCode =
                        ((Map<String, Object>) ((Map<String, Object>) obj2ComponentRes.get(j)
                                .get("classification")).get("hts")).get("code").toString();

                StringUtils.equals(obj1HtcCode, obj2HtcCode);
            }

        }


    }

    public void testMethod() {
        String str1 = "{\"hts_response\":[]}";

        String str2 = "{\"hts_response\":[null]}";


        compareObjects(convertStringToGenericObject(str1, Map.class),
                convertStringToGenericObject(str2, Map.class));

    }


    public static void main(String[] args) {
        new TestClass().testMethod();
    }
}
