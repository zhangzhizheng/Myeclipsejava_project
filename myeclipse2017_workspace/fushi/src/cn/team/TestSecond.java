package cn.team;

import java.util.Scanner;

public class TestSecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int target=scanner.nextInt();
		int []a={2,7,11,15};
		String address="1.1.1.1";
		String tempString=address.replace(".","[.]");
		System.out.println("结果"+tempString);
		}

}
