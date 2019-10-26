
public class Prime {

	/**
	 * 求质数的集中解法
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 1234;
		for(int i = 3 ; i < num ; i++){
			if(isPrime(i)){
				System.out.print(i);
			}
		}
		
		System.out.println("\n==========================分割线=======================");
		
		
		for(int i = 3 ; i < num ; i+=2){
			if(isPrime1(i)){
				System.out.print(i);
			}
		}
		
		System.out.println("\n==========================分割线=======================");
		
		for(int i = 3 ; i < num ; i+=2){
			if(isPrime1(i)){
				System.out.print(i);
			}
		}
		
	}
	
	/**
	 * 判断质数解法一：
	 * 根据定义傻瓜式解法，效率极低
	 */
	public static boolean isPrime(int num){
		
		for(int i = 2 ; i < num ; i++){
			if(num % i == 0){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 判断质数解法二：
	 * 根据定义，推导简化，效率极大提高
	 * 由定义我们可以反推出，如果一个数n不是质数，那么必然存在两个小于n的数相乘等于n（1除外），并且，这两个数必然一个大于等于n的平方根，一个小于等于n的平方根。
	 * 这样，我们在判断的时候，只要判断n的平方根之前的数就可以了，平方根之前的数没有能被n整除的，那个平方根之后的数也必然没有能被n整除的
	 */
	public static boolean isPrime1(int num){
		int sqrt = (int)Math.sqrt(num);
		for(int i = 3 ; i <= sqrt ; i+=2){
			if(num % i == 0){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 判断质数解法三：
	 * 推导质数规律判断
	 * 从6开始，不在6的倍数两侧的数一定不是质数
	 * 证明：令x≥1，将大于等于5的自然数表示如下：
	 * ····· 6x-1，6x，6x+1，6x+2，6x+3，6x+4，6x+5，6(x+1），6(x+1)+1 ······
	 * 可以看到，不在6的倍数两侧，即6x两侧的数为6x+2，6x+3，6x+4，由于2(3x+1)，3(2x+1)，2(3x+2)，所以它们一定不是素数，再除去6x本身，显然，素数要出现只可能出现在6x的相邻两侧。
	 * 这里要注意的一点是，在6的倍数相邻两侧并不是一定就是质数。
	 * 此时判断质数可以6个为单元快进，加快判断速度，原因是，假如要判定的数为n，则n必定是6x-1或6x+1的形式，
	 * 对于循环中6i-1，6i，6i+1,6i+2，6i+3，6i+4，其中如果n能被6i，6i+2，6i+4整除，则n至少得是一个偶数，但是6x-1或6x+1的形式明显是一个奇数，故不成立；
	 * 另外，如果n能被6i+3整除，则n至少能被3整除，但是6x能被3整除，故6x-1或6x+1（即n）不可能被3整除，故不成立。
	 * 综上，循环中只需要考虑6i-1和6i+1的情况，即循环的步长可以定为6，每次判断循环变量k和k+2的情况即可。
	 */
	public static boolean isPrime2(int num){
		//如果这个数不在6的倍数的两侧，那么一定不是质数
		if(num % 6 != 1 || num % 6 != 5){
			return false;
		}
		
		//如果这个数在6的倍数的两侧，再进行判断是否质数
		int sqart = (int)Math.sqrt(num);
		for(int i = 5 ; i <= sqart ; i+=6){
			if(num % i == 0 || num % i+2 == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPrime3(int num){
		
		
		return true;
	}

}





