package 기본_알고리즘;

import java.util.Scanner;

public class 연습문제_2 {
	static int min3(int a, int b, int c) {
		int min = a;
		if ( b < min) min = b;
		if ( c < min) min = c;
		
		return min;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int a,b,c;
		System.out.println("세 값의 최솟값을 구합니다.");
		System.out.println("a의 값은 : "); a = stdIn.nextInt();
		System.out.println("b의 값은 : "); b = stdIn.nextInt();
		System.out.println("c의 값은 : "); c = stdIn.nextInt();
		
		int min = min3(a,b,c);
		System.out.println("최솟값은 " + min + "입니다.");
		stdIn.close();
	}

}
