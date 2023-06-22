package regex.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 */
public class Demo3 {
	public static void main(String[] args) throws Exception {
		LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("file/datajson2.txt"));
		LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader("file/datajson2.txt"));
		TreeMap<String, Object> sortedMap = new TreeMap<>(new JSONDemo.NumericKeyComparator());
		TreeMap<String, Object> sortedMap2 = new TreeMap<>(new JSONDemo.NumericKeyComparator());

		String s;
		while (lineNumberReader.ready()){
			s = lineNumberReader.readLine();
			JSONDemo.getCategory(s,sortedMap);
		}

		String	jsonStr;
		while(lineNumberReader2.ready()){
			jsonStr = lineNumberReader2.readLine();
			List<Object> dataValues = JSONDemo2.findDataValues(jsonStr);
			for(Object name : dataValues){
				JSONObject jsonObject = JSON.parseObject(name.toString());
				for(String key : jsonObject.keySet()){
					sortedMap2.put(key,jsonObject.getJSONObject(key).get("name"));
				}
			}
		}
		System.out.println(sortedMap.size() + ":" + sortedMap2.size());
		Set<String> strings = sortedMap.keySet();
		Set<String> strings1 = sortedMap2.keySet();
		Iterator<String> iterator = strings.iterator();
		Iterator<String> iterator1 = strings1.iterator();
		for (int i = 0; i < sortedMap.size(); i++) {
			String next = iterator.next();
			String next1 = iterator1.next();
			System.out.print(next+":"+sortedMap.get(next)+"==");
			System.out.println(next1+":"+sortedMap2.get(next1));
		}

	}
}
