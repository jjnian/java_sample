package regex;

import cn.hutool.json.JSONUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 *
 */
public class PatternDemo2 {
	public static void main(String[] args) {
		String text = "$ref.source.image2.path";

		// 使用正则表达式匹配字符串
		String patternString = "\\$ref\\.";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);

		// 查找匹配的字符串
		while (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = text.substring(start, end);
			System.out.println("Matched: " + match);
		}

		// 替换匹配的字符串
		String replacedText = matcher.replaceAll("");
		String[] split = replacedText.split("\\.");
		for(String s : split){
			System.out.println(s);
		}
	}
}
