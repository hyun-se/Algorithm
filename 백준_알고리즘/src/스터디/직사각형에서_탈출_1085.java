package 스터디;

import java.util.Scanner;

public class 직사각형에서_탈출_1085 {
	
	// 꼭지점과 w h 좌표의 꼭지점 으로 직사각형을 만들어 그 안에 x y를 놓고 상하좌우 방향으로 직사각형과 거리가 가장 짧은 것을 구하면 되는 문제이다.
	
	// 직사각형의 특정 점에서 가장 가까운 변까지의 거리를 찾는 문제이다.

	// 가장 가까운 변은 직선이 된다.

	// 뭐 그렇다면 사각형의 중앙을 기준으로 어떤 부분에 점이 있느냐에 따라 결과가 달라질 것이다.

	// 먼저 x축을 보자. x가 0과 w 사이 어딘가에 있을 것이다.

	// 그렇다면 (0 + w) / 2를 기준으로 x가 좌측에 있다면 0~x 사이의 거리가 x~w 사이의 거리보다 짧을 것이고, 우측에 있다면 반대일 것이다.

	// y축 또한 마찬가지 일 것이다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int vert = -1;
		int hori = -1;
		
		if (x > w/2) hori = Math.abs(w-x);
		else hori = x;
		
		if (y > h/2) vert = Math.abs(h-y);
		else vert = y;
		
		System.out.println(hori > vert?vert:hori);

//		Scanner sc = new Scanner(System.in);
//		
//		int x = sc.nextInt();
//		int y = sc.nextInt();
//		int w = sc.nextInt();
//		int h = sc.nextInt();
//		
//		int vert = -1;
//		int hori = -1;
//		
//		if(x > w/2) hori = Math.abs(w-x); 
//		else hori = x;
//		
//		if(y > h/2) vert = Math.abs(h-y); 
//		else vert = y;
//		
//		System.out.println(hori>vert?vert:hori);
		sc.close();
	}

}

