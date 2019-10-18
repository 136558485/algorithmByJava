package lau.algorithm;

import java.util.Arrays;

public class RedAndGreen {
	

	/**
	 * 红绿砖块问题:
	 * 在广场上有一排方砖是有颜色的，被涂上红色或者绿色，从左到右排列。现在要求重新喷涂颜色，但不一定要每一块方砖都重新喷涂，因为最终目的是：每一块红色的方砖都至少在绿色方砖的左边（也就是每一个红的左边不能有绿的），并且尽量喷涂最少的次数。
	 * @param args
	 */
	public static void main(String[] args) {
		
//		String line = "GRGGGRGGGRRRGGGRGGGGGGRGGRGGRGGRGGRGRGRGRRRGRGGRGGG";
//		String line = "RGGR";
//		String line = "RGRGR";
//		String line = "G";
		String line = "GR";
//		String line = "RGGRRRGGGR";
		
//		System.out.println(line.length());
//		System.out.println(line.toCharArray().length);
		
		System.out.println(getCount(line));
//		getC(line);
		getC3(line);
	
		
		

	}
	
	/**\
	 * 解法一：动态规划
	 * @param line
	 * @return
	 */
	public static int getCount(String line){
		int currentDo = 0;
		int currentUn = 0;
		int lastDo = 1;
		int lastUn = 0;
		
		
		for(int i = 1 ; i < line.length() ; i++){
			
			if(line.charAt(i) == 'R'){//如果当前位置是R
				//当前位置喷涂时，选前面最小的值加一
				currentDo = min(lastDo,lastUn) + 1;
				
				//当前位置不喷涂时，判断
				if(line.charAt(i-1) == 'R'){
					//如果当前位置的前一个位置为‘R’，则前一个位置不喷的值
					currentUn = lastUn;
				}else{
					//如果当前位置的前一个位置为'G'时，则前一个喷的值
					currentUn = lastDo;
				}
				
			}else{//如果当前位置是G
				//当前位置不喷涂时，选前面最小的
				currentUn = min(lastDo,lastUn);
				
				//当前位置喷涂时，判断
				if(line.charAt(i-1) == 'R'){
					//如果前面的为R,则前一个不喷的值
					currentDo = lastUn + 1;
				}else{
					//如果前面为G,则前一个喷的值
					currentDo = lastDo + 1;
				}
			}
			
			lastDo = currentDo;
			lastUn = currentUn;
			
		}
		
		return min(lastDo,lastUn);
	}
	
	public static int min(int a, int b){
		return a > b ? b : a;
	}
	
	/**
	 * 解法二：两相比较
	 * @param s
	 * @return
	 */
	public static int getC(String line){
        char[] ch = line.toCharArray();
        char[] newCh= new char[ch.length];
        int[] a=new int[ch.length+1];
        for (int i = 0; i <line.length() ; i++) {
            newCh[i]='G';
            a[i]=0;
        }
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <ch.length ; j++) {
                if(ch[j]!=newCh[j]){
                    a[i]++;
                }
            }
            if(i<newCh.length){
                newCh[i]='R';
            }else {
                break;
            }
        }
        Arrays.sort(a);
        return a[0];
    
	}
	
	/**
	 * 解法三：
	 * 解法二的变种
	 * 根据题目要求，最终输入的结果一定是左边全是R右边全是G，就行了。
     * 那么可以直接计算，假如从第i个位置开始，左边全是R右边全是G，那么需要涂几次？
	 */
	public static void getC1(String s){
		int sum=10000;
        int leftGreen=0;//初始左边肯定一个绿色都没有
        int rightRed=s.length()-s.replace("R","").length();//一共右边有多少个红色
        for(int i=0;i<s.length();i++){ //每次位置为i
            if(rightRed+leftGreen<sum) sum=rightRed+leftGreen;
            if(s.charAt(i)=='G'){   //如果当前位置是绿色，那么左边的绿色+1，如果是红色，那么右边红色-1
                leftGreen++;    
            } 
            else{
                rightRed--;
            }
            if(rightRed+leftGreen<sum) sum=rightRed+leftGreen;
        }
        System.out.println(sum);
	}
	
	/**
	 * 解法四
	 * 我也说不上是什么牛逼算法
	 * 
	 * @param str
	 */
	public static void getC2(String str){
		int costR = 0;// 左边全红的代价值
		int costRG = 0;// 左边是红绿的代价值（隐含假设最后一个是绿色的，即使是红色的话）
		
		for(int i = 0 ; i < str.length() ; i++){
			if(str.charAt(i) == 'R'){
				costRG++;// 红色的转成红绿的绿色（假设最后一个是绿色）需要+1
			}else{
				costR++;// 全红时需要将绿色转成红色，代价+1
			}
			costRG = costR<costRG?costR:costRG; // 红绿和全红对于红绿场景都适用
		}
		System.out.println("costR:"+costR+", costRG:"+costRG);
	}
	
	/**
	 * 骚解法
	 * @param input
	 */
	public static void getC3(String input){
		int result = 0;
        while(input.contains("GR")) {
        input = input.replaceFirst("GR", "");
        result++;
        }
        System.out.println(result);
	}
	

	
	

}
