package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue_1021 { // 백준 알고리즘 회전하는 큐. 1021 ( 출처 https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221471360636 )

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] numArr_str = br.readLine().split(" ");

//		 //@1 - 기초 변수 선언
//
//		n : 원소 개수
//
//		m : 뽑아낼 원소 개수
		int n = Integer.parseInt(input.split(" ")[0]);
		int m = Integer.parseInt(input.split(" ")[1]);
		
		
//		@2 - 뽑아낼 원소 리스트 선언
//
//		가독성을 위해 String 타입으로 담겨져 있는 원소 리스트를 int 형 타입으로 변환하여 저장

		int[] numArr = new int[numArr_str.length];
		for (int i = 0; i < numArr_str.length; i++) 
			numArr[i] = Integer.parseInt(numArr_str[i]);
		
//		@3 - deQ(덱) 선언
//
//		입력한 원소 개수(n) 만큼 덱에 원소 삽입

		LinkedList<Integer> deQ = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) deQ.offer(i);

		int cnt = 0, half = 0; // @4 - 카운트 변수 cnt 와 중간지점을 구하기 위한 변수 half 선언
		for (int i = 0; i < numArr.length; i++) { // @5 - 뽑아낼 원소의 개수 만큼 반복
			// @6  - 전체 원소 리스트의 개수의 중간 지점을 구하기 위해 짝수이냐 홀수인지 구분하여 중간지점을 구한다.
			if (deQ.size() % 2 == 0) half = (deQ.size() / 2) - 1; 
			else half = deQ.size() / 2; 
			
			int idxDeQ = 0; // @7  - 뽑아내고자 하는 원소의 위치를 찾을아 담고 있을 변수 idxDeq 선언
			for (int j = 0; j < deQ.size(); j++) {
				if (deQ.get(j) == numArr[i]) {
					idxDeQ = j;
					break;
				}
			}
			
			if (half - idxDeQ >= 0) { // @8- 왼쪽으로 한 칸 이동(회전)

                                      //뽑아내고자 하는 원소가 중간지점이거나 중간지점보다 왼쪽에 위치한다면 왼쪽으로 이동(회전)한다.
                                      //
                                      //맨 앞에 위치한 원소를 빼내서 마지막에 삽입한다.
				for (int j = 0; j < idxDeQ; j++) {
					int first = deQ.pollFirst();
					deQ.addLast(first);
					cnt++;
				}
				deQ.poll();
			} else { // @9 - 오른쪽으로 한 칸 이동(회전)

                     //뽑아내고자 하는 원소가 중간지점보다 오른쪽에 위치한다면 오른쪽으로 이동(회전)한다.
                     //
                     //마지막에 위치한 원소를 빼내서 맨 앞에 삽입한다.

				for (int j = 0; j < deQ.size() - idxDeQ; j++) {
					int last = deQ.pollLast();
					deQ.addFirst(last);
					cnt++;
				}
				deQ.poll();
			}
		}
		System.out.println(cnt);
		br.close();
	}

}


