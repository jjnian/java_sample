package regex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  解析json中的字符串
 *  未知json格式解析json里面的变量
 */
public class PatternDemo3 {
	private final static String SOURCE_FIELD = "source";

	private final static String IMAGE_PATH_FIELD = "path";

	// 匹配以$ref.开头的
	private final static String patternString = "\\$ref\\.";

	public static void main(String[] args) throws Exception{
		LineNumberReader lnr = new LineNumberReader(new FileReader("file/datajson1.txt"));
		String data = lnr.readLine();
		//System.out.println(data);
		Object parse = JSON.parse(data);
		parseVariable(parse,data);
		System.out.println(JSON.toJSONString(parse));
	}

	/**
	 * 获取source下的所有照片路径
	 * @Date 2023/6/19 15:50
	 * @param jsonStr json字符串
	 * @return {@link List< String> }
	 */
	public static List<String> getImagePath(String jsonStr){
		LinkedList<String> imagePathList = new LinkedList<>();
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		JSONObject source = jsonObject.getJSONObject(SOURCE_FIELD);
		Set<String> strings = source.keySet();
		for (String s : strings){
			imagePathList.add(source.getJSONObject(s).get(IMAGE_PATH_FIELD).toString());
		}
		return imagePathList;
	}

	/**
	 * 解析所有引用的字符串变成真正的值
	 * @Date 2023/6/19 15:50
	 * @param jsonStr FastJson解析的对象
	 * @param orginJson  从txt中读取的原始字符串，用于解析到$ref的值时获取真正的值。
	 * @return
	 */
	public static void parseVariable(Object jsonStr,String orginJson){
		if (jsonStr instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject) jsonStr;
			for (String key : jsonObject.keySet()) {
				Object value = jsonObject.get(key);
				if (value instanceof String && hasReflect((String)value)) {
					jsonObject.put(key, getValueByRef((String)value, orginJson));
				} else {
					parseVariable(value,orginJson);
				}
			}
		}else if (jsonStr instanceof JSONArray) {
			JSONArray array = (JSONArray) jsonStr;
			for (int i = 0; i < array.size(); i++) {
				parseVariable(array.get(i),orginJson);
			}
		}
	}

	public static String getValueByRef(String ref,String orginJson){
		Matcher matcher = parseReflect(ref);
		String s = matcher.replaceFirst("");
		String[] path = s.split("\\.");

		JSONObject jsonObject = JSON.parseObject(orginJson);
		for (int i = 0; i < path.length - 1; i++) {
			jsonObject = jsonObject.getJSONObject(path[i]);
		}
		return (String)jsonObject.get(path[path.length - 1]);
	}

	private static Matcher parseReflect(String ref){
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(ref);
		return matcher;
	}

	private static boolean hasReflect(String ref){
		// 使用正则表达式匹配字符串
		Matcher matcher = parseReflect(ref);
		return matcher.find() ? true : false;
	}
}
