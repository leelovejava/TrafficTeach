package com.bjsxt.spark.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串工具类
 * @author Administrator
 *
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串是否不为空
     * @param str 字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str);
    }

    /**
     * 截断字符串两侧的逗号
     * @param str 字符串
     * @return 字符串
     */
    public static String trimComma(String str) {
        if(str.startsWith(",")) {
            str = str.substring(1);
        }
        if(str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * 补全两位数字
     * @param str
     * @return
     */
    public static String fulfuill(String str) {
    	  if(str.length() == 1) 
            return "0" + str;
    	  return str;
    }
    
    
    /**
     * 补全num位数字
     * 将给定的字符串前面补0，使字符串的长度为num位。
     * 
     * @param str
     * @return
     */
    public static String fulfuill(int num,String str) {
        if(str.length() == num) {
            return str;
        } else {
        	int fulNum = num-str.length();
        	String tmpStr  =  "";
        	for(int i = 0; i < fulNum ; i++){
        		tmpStr += "0";
        	}
            return tmpStr + str;
        }
    }
    

    /**
     * 从拼接的字符串中提取字段
     * @param str 字符串
     * @param delimiter 分隔符
     * @param field 字段
     * @return 字段值
     * name=zhangsan|age=18
     */
    public static String getFieldFromConcatString(String str,String delimiter, String field) {
        try {
            String[] fields = str.split(delimiter);
            for(String concatField : fields) {
                // searchKeywords=|clickCategoryIds=1,2,3
                if(concatField.split("=").length == 2) {
                    String fieldName = concatField.split("=")[0];
                    String fieldValue = concatField.split("=")[1];
                    if(fieldName.equals(field)) {
                        return fieldValue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
//    	System.out.println(getFieldFromConcatString("name=zhangsan|age=18","\\|","age"));
//    	System.out.println(setFieldInConcatString("name=zhangsan|age=12","\\|","age","100"));
    	Map<String, String> keyValuesFromConcatString = getKeyValuesFromConcatString("name=lisi|age=112","\\|");
    	System.out.println(keyValuesFromConcatString);
    }

    /**
     * 从拼接的字符串中给字段设置值
     * @param str 字符串
     * @param delimiter 分隔符
     * @param field 字段名
     * @param newFieldValue 新的field值
     * @return 字段值
     *  name=zhangsan|age=12
     *  |
     *  age
     *  18
     *  name=zhangsan|age=18
     */
    public static String setFieldInConcatString(String str,
                                                String delimiter, 
                                                String field, 
                                                String newFieldValue) {
       
    	  // searchKeywords=iphone7|clickCategoryIds=1,2,3
    	
    	String[] fields = str.split(delimiter);

        for(int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].split("=")[0];
            if(fieldName.equals(field)) {
                String concatField = fieldName + "=" + newFieldValue;
                fields[i] = concatField;
                break;
            }
        }

        StringBuffer buffer = new StringBuffer("");
        for(int i = 0; i < fields.length; i++) {
            buffer.append(fields[i]);
            if(i < fields.length - 1) {
                buffer.append("|");
            }
        }

        return buffer.toString();
    }

    /**
     * 给定字符串和分隔符，返回一个K,V map
     *  name=zhangsan|age=18
     *  
     * @param str
     * @param delimiter
     * @return map<String,String>
     * 
     */
	public static Map<String, String> getKeyValuesFromConcatString(String str,String delimiter) {
		Map<String, String> map = new HashMap<>();
		try {
            String[] fields = str.split(delimiter);
            for(String concatField : fields) {
                // searchKeywords=|clickCategoryIds=1,2,3
                if(concatField.split("=").length == 2) {
                    String fieldName = concatField.split("=")[0];
                    String fieldValue = concatField.split("=")[1];
                    map.put(fieldName, fieldValue);
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	
	/**
	 * String 字符串转Integer数字
	 * @param str
	 * @return
	 */
	public static Integer convertStringtoInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
		
	}

}
