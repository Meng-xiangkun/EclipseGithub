package cbsc.cha2;
public class Formula2{
	static String s[][] = new String[50][3];
	public static void main(String[] args) {
		printHeader();
		generateEquations();
		printExcercise();
		printCalculation();
	}  
	//打印标题
	public static  void printHeader() {  
		System.out.println("********************************************************");
		System.out.println("*********程序输出50道100以内的加减法运算*******************");
		System.out.println("******每次运行程序可以得到一套50道题的习题及答案*************");
		System.out.println("***********************************************************");
		System.out.println(); 
		System.out.println();
	}
	//产生算式
	public static  void generateEquations() {
		for (int i = 0; i < 50; i++) {
			int a=(int) (101 * Math.random());
			s[i][0] = String.valueOf(a);//生成0~100的随机数
			if (a<=50) {
				int b=(int) (a* Math.random());
				s[i][1] = String.valueOf(b);//当a<=50时 ，b<a
			}else {
				int b=(int) ((100-a)* Math.random());
				s[i][1] = String.valueOf(b);//当a>50时，b<100-a
			}
			int o = (int) ((int) (2 * Math.random()));//生成随机数1或2 
			if (o == 1) {
				s[i][2] = "+";
			} else {
				s[i][2] = "-";
			}
			int j=0;  
			String Temp1 = s[i][0] + s[i][2]  + s[i][1];//记录本次产生的算式（正序）
			String Temp2 = s[i][1] + s[i][2]  + s[i][0];//记录本次产生的算式 (逆序)
			//判断是否存在重复的算式，如果有则提前跳出循环 即j!=i,则重新产生算式
			for(j = 0;j < i;j++) {
				if((Temp1 == (s[j][0] + s[j][2]  + s[j][1]))||(Temp2 == (s[j][0] + s[j][2]  + s[j][1]) )){
					break;
				}
			}
			if(j!=i) {
				i--;
			}
		}
	}
	//打印题目
	public static void printExcercise() {
		System.out.println("*************************习题*******************************");
		int j=0;//记录打印算式的个数
		for (int i = 0; i < 50; i++) {
			System.out.print("第" + (i+1)+ "题:" + s[i][0] + s[i][2] + s[i][1]+"="+"\t");
			j++;
			if(j%4==0) {
				System.out.println();//每行打印四个
			}
		}
	}
	//打印答案
	public static void printCalculation() {
		System.out.println();
		System.out.println("*************************答案*******************************");
		int j=0;
		for (int i = 0; i < 50; i++) {
			if(s[i][2].equals("+")) {
				int res= Integer.valueOf(s[i][0])+Integer.valueOf(s[i][1]);
				System.out.print("第" + (i+1) + "题答案:" + res+"\t");	
				j++;
			}else {
				int res= Integer.valueOf(s[i][0])-Integer.valueOf(s[i][1]);
				System.out.print("第" + (i+1) + "题答案:" + res+"\t");	
				j++;
			}
			if(j%4==0) {
				System.out.println();
			}
		}	
	}
}
