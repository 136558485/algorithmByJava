package lau.algorithm;

public class PrimePlus {

	/**
	 * 求n下面质数的个数
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		//100000001
		int num = 100000001;
		int sum;
		
		int count = 1;
		
		//创建一个逻辑数组，长度为num+1
		boolean[] prims = new boolean[num+1];
		
		//将逻辑数组中下标为奇数的对应逻辑值设置为true
		for(int i = 3 ; i <= num ; i+=2){
			prims[i] = true;
		}
		
		//在下标为奇数的逻辑值中，将每个奇数下标的倍数下标设置为false 使得最后该数组中逻辑值为true值的下标值为质数
		for(int i = 3 ; i <= num ; i+=2){
			
			if(prims[i]){
				prims[i] = true;
			}else{
				continue;
			}
		    
			sum = i*2;
			
			while(sum <= num){
				prims[sum] = false;
				sum += i;
			}
			
//			for(int j = i*2 ; j < num ; j+=i){
//				prims[j] = false;
//			}			
			
		}
		
		for(int i = 3 ; i <= num ; i+=2){
			if(prims[i]){
				count++;
			}
		}
		
		
		
		
		
		
		System.out.println(count);
		long costTime = System.currentTimeMillis()-startTime;
		System.out.println("用时："+costTime);

	}

}
