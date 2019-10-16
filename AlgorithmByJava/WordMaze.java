package lau.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordMaze {

	/**
	 * 题目描述
     * Word Maze 是一个网络小游戏，你需要找到以字母标注的食物，但要求以给定单词字母的顺序吃掉。假设给定单词if，你必须先吃掉i然后才能吃掉f。
                    但现在你的任务可没有这么简单，你现在处于一个迷宫Maze（n×m的矩阵）当中，里面到处都是以字母标注的食物，但你只能吃掉能连成给定单词W的食物。

                    注意区分英文字母大小写,并且你只能上下左右行走。

                    解答要求
	        时间限制：1000ms, 内存限制：64MB
                    输入
                    输入第一行包含两个整数n、m(0<n,m<21)分别表示n行m列的矩阵，第二行是长度不超过100的单词W，从第3行到底n+3行是只包含大小写英文字母的长度为m的字符串。

                    输出
                    如果能在地图中连成给定的单词，则输出“YES”，否则输出“NO”。注意：每个字母只能用一次。
	 * @param args
	 * 输入样例 1 复制

       20 20
       weizengke
       aaaaaaaaaaaaaaaaaaaa
       waeaiazweanagakaeaaa
       eawfthyeweiykkletlee
       weizenwgkzeeeeeeeeee
       eeeeeeeeeeengkwwwwww
       hafgiegqiqeppppppppp
       aaaaaaaaaaaaaaaaaaaa
       waeaiazweanagakaeaaa
       eawfthyewieykkletlee
       weizenwgkezeeeeeeeee
       eeeeeeeeeeengkwwwwww
       hafgiegqiqeppppppppp
       eeeeeeeeeeengkwwwwww
       hafgiegqiqeppppppppp
       aaaaaaaaaaaaaaaaaaaa
       waeaiazweanagakaeaaa
       eawfthyewieykkletlee
 	   weizenwgkezeeeeenezi
	   eeeeeeeeeeengkwwgkee
       hafgiegqiqeppppppppw

       2 4
       solo
       aolf
       esil

	   YES
	   
	   思路：
	   1、将地图变成一个字符型的二维数组char[][] chsArr;
	   2、获取给定单词的第一个字符
	   3、遍历二维数组char[][],查找是否有字符等于给定单词的第一个符，如果有， 做如下操作：
	                       先判断该字符四周是否有和给定单词字符的后一个字符相等的字符（对于查找过的单词坐标，将其变成一个字符串放入到一个list中），如果有：
	                                 判断该字符周围是否有给定单词字符的后一个字符
	                                
	            
	 */
	public static void main(String[] args) {
		String str = "weizengke";
//		String str = "solo";
//		String[] strArr = {"aolf","esil"};
//		String[] strArr = {"aaaaaaaaaaaaaaaaaaaa","waeaiazweanagakaeaaa","eawfthyeweiykkletlee","weizenwgkzeeeeeeeeee","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp",
//				"aaaaaaaaaaaaaaaaaaaa","waeaiazweanagakaeaaa","eawfthyewieykkletlee","weizenwgkezeeeeeeeee","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp",
//				"aaaaaaaaaaaaaaaaaaaa","waeaiazweanagakaeaaa","eawfthyewieykkletlee","weizenwgkezeeeeenezi","eeeeeeeeeeengkwwgkee","hafgiegqiqeppppppppw"};
		String[] strArr = {"aaaaaaaaaaaaaaaaaaaa","waeaiazweanagakaeaaa","eawfthyeweiykkletlee","weizenwgkezeeeeeeeee","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp",
				"aaaaaaaaaaaaaaaaaaaa","waeaiazweanagakaeaaa","eawfthyewieykkletlee","weizenwgkezeeeeeeeee","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp",
				"aaaaaaaaaaaaaaaaaaaa","waeaiazweanagakaeaaa","eawfthyewieykkletlee","weizenwgkezeeeeeeeee","eeeeeeeeeeengkwwwwww","hafgiegqiqeppppppppp"};
		int n = 20;
		int m = 20;
		int index = 0;
		
		char[][] chsArr = new char[n][m];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				chsArr[i][j] = strArr[i].charAt(j);
			}
		}
		
		
				
		char ch = str.charAt(index);
		for(int i = 0 ; i < n ; i++){
			for(int k = 0 ; k < m ; k++){
				if(ch == chsArr[i][k]){
					List<String> list = new ArrayList<String>();
					index = 1;
					list.add(i+""+k);
					if(ifExists(chsArr,i,k,index,str,list)){
						System.out.println("YES");
						return;
					}else{
						System.out.println("NO");
					}
				}
			}
		}
		
	}
	
	public static boolean ifExists(char[][] chsArr,int x,int y,int index1,String str,List<String> list){
		
		int n = chsArr.length;
		int m = chsArr[0].length;
		
		if(index1 == 8 && chsArr[x][y] == 'k'){
			System.out.println("这里做一个断点测试！");
		}
		
		if(index1 == str.length()){
			if(chsArr[x][y] == str.charAt(index1-1)){
				return true;
			}else{
				return false;
			}			
		}
		
		System.out.println(str.charAt(index1)+": "+x+","+y+","+chsArr[x][y]+","+index1+list);
		//判断上
		if(x>0){
			if(!list.contains((x-1)+""+y)&&chsArr[x-1][y] == str.charAt(index1)){
				int index = index1+1;
				list.add((x-1)+""+y);
				if(ifExists(chsArr,x-1,y,index,str,list)){					
					return true;
				}
				list.remove((x-1)+""+y);
			}
		}
		
		//判断下
		if(x<n-1){
			
			if(!list.contains((x+1)+""+y)&&chsArr[x+1][y] == str.charAt(index1)){
				int index = index1+1;	
				list.add((x+1)+""+y);
				if(ifExists(chsArr,x+1,y,index,str,list)){					
					return true;
				}
				list.remove((x+1)+""+y);
			}
		}
		
		//判断左
		if(y>0){
			if(!list.contains(x+""+(y-1))&&chsArr[x][y-1] == str.charAt(index1)){
				int index = index1+1;		
				list.add(x+""+(y-1));
				if(ifExists(chsArr,x,y-1,index,str,list)){					
					return true;
				}
			}
		}
		
		//判断右
		if(y<m-1){
			if(!list.contains(x+""+(y+1))&&chsArr[x][y+1] == str.charAt(index1)){
				int index = index1+1;	
				list.add(x+""+(y+1));
				if(ifExists(chsArr,x,y+1,index,str,list)){					
					return true;
				}
				list.remove(x+""+(y+1));
			}
		}
		
		return false;
	}

}
