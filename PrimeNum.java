package lau.algorithm;

import java.util.BitSet;

/**
 * 孪生素数问题
 * 筛选法求解
 * @author zWX810514
 *
 */
public class PrimeNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
		
		int a = 100000001;
		int result = 0;
		
		BitSet bs = new BitSet(a);
		
		bs.set(1, a+1, true);
		bs.set(1,false);
		
		for(int i = 2 ; i <= a ; i++){
			if(bs.get(i)){
				for(int j = i*2 ; j <= a ; j += i){
					bs.set(j, false);
				}
			}
		}
		
		for(int i = 3 ; i <= a ; i += 2){
			if(bs.get(i)&&bs.get(i+2)){
				result++;
			}
		}
		
		System.out.println(result);
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
