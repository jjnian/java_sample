package regex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ji_ruixin
 * @Date 2023/6/19
 */
public class PatternDemo {
	public static void main(String[] args) throws Exception{
		String text = "$ref.source.image2.path";
		LineNumberReader lnr = new LineNumberReader(new FileReader("file/datajson1.txt"));
		String data = lnr.readLine();
		System.out.println(data);
		System.out.println(parsePath(data, null));

	}

	public static String[] parseVariable(String origin){
		// 使用正则表达式匹配字符串
		String patternString = "\\$ref\\.";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(origin);

		String replacedText = matcher.replaceAll("");
		String[] split = replacedText.split("\\.");
		return split;
	}

	public static Object parsePath(String jsonStr, List<String> path){
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		for (int i = 0; i < path.size() - 1; i++) {
			jsonObject = jsonObject.getJSONObject(path.get(i));
		}
		return jsonObject.get(path.get(path.size()-1));
	}


	public static Object parse(String jsonStr,List<String> path){
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		JSONObject source = jsonObject.getJSONObject("source");
		Set<String> strings = source.keySet();
		for (String s : strings){
			System.out.println("key:" + s);
			System.out.println("value:" + source.getJSONObject(s).get("path"));
		}
		return null;
	}


}
