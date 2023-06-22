package regex.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;

/**
 *
 */
public class JSONDemo {
	public static void main(String[] args) throws IOException {
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("file/datajson2.txt"));
		TreeMap<String, Object> sortedMap = new TreeMap<>(new NumericKeyComparator());
		String s;
		while (lineNumberReader.ready()){
			s = lineNumberReader.readLine();
			getCategory(s,sortedMap);
		}
		sortedMap.forEach((k,v)->{
			System.out.println(k + ":" + v);
		});


	}

	public static List<String> getCategory(String jsonStr,TreeMap<String,Object> treeMap){

		JSONArray jsonArray = JSON.parseObject(jsonStr)
				.getJSONObject("label")
				.getJSONObject("data")
				.getJSONArray("results");

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject category = JSON.parseObject(jsonArray.get(i).toString())
					.getJSONObject("category");
			for (String key : category.keySet()){
				treeMap.put(key,category.getJSONObject(key).get("name"));
			}
		}
		return null;
	}

	public static class NumericKeyComparator implements Comparator<String>{
		@Override
		public int compare(String key1, String key2) {
			// 将字符串转换为整数进行比较
			int num1 = Integer.parseInt(key1);
			int num2 = Integer.parseInt(key2);

			// 比较整数大小
			if (num1 < num2) {
				return -1;
			} else if (num1 > num2) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}


