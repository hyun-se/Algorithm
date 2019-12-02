package 스터디;

import java.util.Scanner;

public class 직각삼각형_4153 {

	// 피타고라스 정리를 사용해서 문제를 해결.

	// 직각 삼각형의 두 직각변 a,b를 각각 한 변으로 하는 정사각형 면적의 합은 빗변 c를 한 변으로 하는 정사각형의 면적과 같다. 이를
	// 피타고라스 정리라고 한다.

	// 즉, c의 제곱은 a와 b의 제곱의 합이다.

	// 다시 말해, c를 변으로 하는 정사각형의 넓이는 a를 변으로 하는 정사각형의 넓이와 b를 변으로 하는 정사각형의 넓이의 합이다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a == 0 && b == 0 && c == 0) {
				break;
			} else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
		sc.close();
//		Scanner stdIn = new Scanner(System.in);
//		while(true) {
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			int c = stdIn.nextInt();
//			if (a == 0 && b == 0 && c == 0) {
//				break;
//			}else if ( a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
//				System.out.println("right");
//			}else {
//				System.out.println("wrong");
//			}
//		}
//		stdIn.close();
	}

}
