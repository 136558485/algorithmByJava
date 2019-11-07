import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorReg {

	/**
   *Solo小学一年级的时候做数学题很莫名奇妙，经常把算术表达式加上很多空格（如：7+ 31    -2），让老师很是头大，于是老师决定雇用你编写一个程序来独立计算Solo的答案。Can you help the teacher?
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "1";
		String regEX1 = "(\\d{1,})";
		String regEX2 = "([+-])";

		
		
		
		Pattern pat1 = Pattern.compile(regEX1);
		Pattern pat2 = Pattern.compile(regEX2);
		Matcher mat1 = pat1.matcher(str);
		Matcher mat2 = pat2.matcher(str);
		
		int a = 0;
		if(mat1.find()){
			a = Integer.parseInt(mat1.group());
		}
		
		while(true){
//			System.out.println("数字："+mat1.group());
			String rex = "";
			if(mat2.find()){
				rex = mat2.group();
			}else{
				break;
			}
			if(mat1.find()){				
				int b = Integer.parseInt(mat1.group());
				System.out.println("b:"+b);
				switch (rex) {
				case "+":
					a += b;
					break;
				case "-":
					a -= b;
					break;
				default:
					break;
				}
				
			}			
		}
		System.out.println(a);
		
	}

}
