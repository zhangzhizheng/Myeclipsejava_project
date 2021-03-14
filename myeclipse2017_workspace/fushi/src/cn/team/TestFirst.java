package cn.team;

import java.util.Scanner;

/**
 * 两个数之间的偶数和
 * @author Administrator
 *
 */
public class TestFirst {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		    int sum=0;
			int data1=scanner.nextInt();
			int data2=scanner.nextInt();
			if (data1<=data2) {
				for (int i = data1; i <= data2; i++) {
					if (i%2==0) {
						sum=sum+i;
					}
				}
			}
			else {
				for (int i = data2; i <=data1; i++) {
					if (i%2==0) {
						sum=sum+i;
					}
				}
			}
			
		System.out.println("结果："+sum);

	}

}
