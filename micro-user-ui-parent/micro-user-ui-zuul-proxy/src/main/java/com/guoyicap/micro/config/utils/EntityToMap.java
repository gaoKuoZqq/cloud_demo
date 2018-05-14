package com.guoyicap.micro.config.utils;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class EntityToMap {


	/**
	 * 实体类对象转换成Map
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> ConvertObjToMap(Object obj) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		if (obj == null)
			return null;
		Field[] fields = obj.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(
							fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					reMap.put(fields[i].getName(), o);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return reMap;
	}

	/**
	 * 转换的示例方法
	 * @param args
	 */
	public static void main(String[] args) {
		UserEntity user = new UserEntity("219396", "daolin", 23);
		user.setDate(new Date());
		Map<String, Object> map = ConvertObjToMap(user);
		for(int k = 0; k<map.size(); k++) {
			System.out.println(map.get("age").getClass().getSimpleName());
		}
	}

}


/**
 * 测试的实体类
 * @author Wesley
 *
 */
class UserEntity {
	private String code;
	private String name;
	private int age;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserEntity(String code, String name, int age) {
		super();
		this.code = code;
		this.name = name;
		this.age = age;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
