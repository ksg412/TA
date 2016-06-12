package org.springframework.source.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */
public class CommonUtil {

    /**
     * 카멜케이스 변환
     * @param str - 변환대상 문자
     * @param firstUpper - 첫문자 대문자 여부
     * @return 변환된 문자열
     */
    public static String toCamelCase(String str, boolean firstUpper) {
        String camelCaseString = "";

        String[] parts = StringUtils.split(StringUtils.lowerCase(str), "_");
        for (int i=0; i<parts.length; i++){
            if (i == 0 && !firstUpper) {
                camelCaseString += parts[i];
            } else {
                camelCaseString += StringUtils.capitalize(parts[i]);
            }
        }
        return camelCaseString;
    }

    /*dataTable 에서 serialize해서 가져오는 데이터가 form[id]이런 모양이라 form[]부분을 제거해서 다시 넣어주는 로직*/
    public static void mapFormDataToNomalData(Map commandMap){
        Map compareMap = new HashMap();

        for( Object key : commandMap.keySet() ){
            String key2 = String.valueOf(key);
            if(key2.indexOf("form[") != -1){
                String key3 = key2.replaceAll("form\\[","").replaceAll("\\]","");
                compareMap.put(key3,commandMap.get(key2));
            }
        }

        commandMap.putAll(compareMap);
    }
}
