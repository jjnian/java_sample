package regex.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 未知json格式,获取里面某个属性的值
 */
public class JSONDemo2 {
	public static void main(String[] args) throws Exception {
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("file/datajson2.txt"));
		TreeMap<String, Object> sortedMap = new TreeMap<>(new JSONDemo.NumericKeyComparator());

		while(lineNumberReader.ready()){
			String	jsonStr = lineNumberReader.readLine();
			List<Object> dataValues = findDataValues(jsonStr);
			for(Object name : dataValues){
				JSONObject jsonObject = JSON.parseObject(name.toString());
				for(String key : jsonObject.keySet()){
					sortedMap.put(key,jsonObject.getJSONObject(key).get("name"));
				}
			}
		}

		sortedMap.forEach((k,v)->{
			System.out.println(k + ":" + v);
		});
	}
	public static List<Object> findDataValues(String jsonString) {
		List<Object> dataList = new ArrayList<>();
		Object parsedObject = JSON.parse(jsonString);
		if (parsedObject instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject) parsedObject;
			findDataValuesInJSONObject(jsonObject, dataList);
		} else if (parsedObject instanceof JSONArray) {
			JSONArray jsonArray = (JSONArray) parsedObject;
			findDataValuesInJSONArray(jsonArray, dataList);
		}

		return dataList;
	}

	private static void findDataValuesInJSONObject(JSONObject jsonObject, List<Object> dataList) {
		for (String key : jsonObject.keySet()) {
			Object value = jsonObject.get(key);
			if ("category".equals(key)) {
				dataList.add(value);
			} else if (value instanceof JSONObject) {
				findDataValuesInJSONObject((JSONObject) value, dataList);
			} else if (value instanceof JSONArray) {
				findDataValuesInJSONArray((JSONArray) value, dataList);
			}
		}
	}

	private static void findDataValuesInJSONArray(JSONArray jsonArray, List<Object> dataList) {
		for (Object element : jsonArray) {
			if (element instanceof JSONObject) {
				findDataValuesInJSONObject((JSONObject) element, dataList);
			} else if (element instanceof JSONArray) {
				findDataValuesInJSONArray((JSONArray) element, dataList);
			}
		}
	}
}
