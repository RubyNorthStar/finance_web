package com.xsjrw.websit.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.xsjrw.common.util.PropertiesUtil;

/***
 * 自动赋值 
 * 根据properties给ParamUtil 自动赋值（目前支持list、string、map、Integer）
 * hanrb
 * **/
public class EvaluateUtil {
	
	private static final String propName = "param.properties";
	
	@SuppressWarnings({"unchecked"})
	public static void autoEvalVal(){
		try {
			Properties propertie = PropertiesUtil.getInstanceByFileName(propName);
			for(Field field : ParamUtil.class.getFields()){
				//获取修饰字段类型
				String fieldType = field.getType().getSimpleName();
				//获取properties文件里的值
				String value = propertie.getProperty(field.getName());
				//根据字段进行赋值 支持list map integer string
				if("List".equals(fieldType)){
					String arrayStr[] = value.split(",");
					ParameterizedType parameterizedType=(ParameterizedType)field.getGenericType();
					//获取泛型类型
					Class<?> parameterizedClass = (Class<?>)parameterizedType.getActualTypeArguments()[0];
					//对比泛型 目前为integer 与 STRING
					if("String".equals(parameterizedClass.getSimpleName())){
						List<String> list = new ArrayList<String>();
						for(String s:arrayStr){
							list.add(s);
						}
						field.set(new ArrayList<String>(), list);
					}else if("Integer".equals(parameterizedClass.getSimpleName())){
						List<Integer> list = new ArrayList<Integer>();
						for(String s:arrayStr){
							list.add(Integer.parseInt(s));
						}
						field.set(new ArrayList<Integer>(), list);
					}
				}else 
				if("Map".equals(fieldType)){
					//解析json串
					JSONArray array= (JSONArray)JSONValue.parse(value);
					Map<String,String> map = new HashMap<String,String>();
					for(Iterator iterator=array.iterator();iterator.hasNext();){
						JSONObject jsonObj=(JSONObject)iterator.next();
						Set<Map.Entry<String,String>> obj=jsonObj.entrySet();
						String k = null;
						String v = null;
						for(Map.Entry<String,String> entry:obj){
							k=entry.getKey();
							v=entry.getValue();
						}
						map.put(k, v);
					}
					field.set(new HashMap<String,String>(), map);
				}else if("String".equals(fieldType)){
					field.set(String.class, value);
				}else if("Integer".equals(fieldType) || "int".equals(fieldType)){
					field.set(Integer.class, Integer.parseInt(value));
				}					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
