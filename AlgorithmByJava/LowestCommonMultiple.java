package lau.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LowestCommonMultiple {

	/**
	 * 求1-n的最小公倍数
	 * @param args
	 */
	public static void main(String[] args) {
		// 输入一个整数n,(1<n<=100) 最小是2
        int num = 6;
        getMinCommonMultiple1(num);
	}
	
	/**
	 * 解法一：分解质因数法
	 * 两个数的最小公倍数等于他们的公有质因数乘以私有质因数
	 * @param num
	 */
	private static void getMinCommonMultiple(int num) {
        List<Integer> baseNumList = new ArrayList<>();
        List<Integer> tempNumList = new ArrayList<>();
        int begin = 2;
        // 放入数字
        for (int i = 2; i <= num; i++) {
            baseNumList.add(i);
        }
        int max = num;
        while (begin <= max) {
            max = 0;
            int counter = 0;
            for (int i = 0; i < baseNumList.size(); i++) {
                if (baseNumList.get(i) % begin == 0) {	
                    baseNumList.set(i, baseNumList.get(i) / begin);
                    if (counter == 0) {
                        tempNumList.add(begin);
                    }
                    counter++;
                }
                if (baseNumList.get(i) > max) {
                    max = baseNumList.get(i);
                }
            }
            if (counter == 0) {
                begin++;
            }
        }
        BigInteger product = BigInteger.valueOf(1L);
        for (int i = 0; i < baseNumList.size(); i++) {
            product = product.multiply(BigInteger.valueOf(baseNumList.get(i)));
        }
        for (int i = 0; i < tempNumList.size(); i++) {
            product = product.multiply(BigInteger.valueOf(tempNumList.get(i)));
        }
        System.out.println(product);
    }
	
	/**
	 * 解法二：公式法
	 * 性质：两个数的的乘积等于这两个数的最小公倍数和最大公因数的乘积
	 * @param num
	 */
	public static void getMinCommonMultiple1(int num){
		BigInteger sum = new BigInteger("1");		
		BigInteger div = new BigInteger("1");
		for(int i = 2 ; i <= num ; i++){
			sum = div.multiply(new BigInteger(i+""));
			div = sum.divide(div.gcd(new BigInteger(i+"")));
		}
		System.out.println(div);
	}
	
	

}
