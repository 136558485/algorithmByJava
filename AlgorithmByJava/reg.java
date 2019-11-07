
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {

	/**
	 * 
	 * 输入一个英文句子，句子中仅包含英文字母，数字，空格和标点符号，其中数字、空格和标点符号将句子划分成一个个独立的单词，除去句子中的数字、空格和标点符号，将句子中的每个单词的首字母大写，然后输出句子，输出时各个单词之间以一个空格隔开，句子以“.”
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Who-didn't love? SoLo..";
		String reg = "([A-Za-z]){1,}";
		Pattern pat = Pattern.compile(reg);
		Matcher mat = pat.matcher(str);
		boolean flag = false;
		while(mat.find()){
			
			String word = mat.group();
			if(word.charAt(0)>='a'&&word.charAt(0)<='z'){
				word.replaceFirst("", "");
				word = word.replaceFirst(String.valueOf(word.charAt(0)), String.valueOf((char)(word.charAt(0)-32)));
			}
			if(flag){
				System.out.print(" "+word);
			}else{
				System.out.print(word);
			}
			flag = true;
			
			
		}
		System.out.println(".");

	}

}
