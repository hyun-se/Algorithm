package 스터디;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Deque_10866 {	// 백준 알고리즘 10866 덱 ( 출처 https://oper6210.tistory.com/72 )   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Deque<Integer> deque = new LinkedList<>();
		   Scanner sc = new Scanner(System.in);
		   int cnt = sc.nextInt();
		   for(int i=0; i<cnt; i++) {
			   String a = sc.next();
			   if(a.equals("push_back")) {
				   int b = sc.nextInt();
				   deque.addLast(b);
			   }else if(a.equals("push_front")) {
				   int b = sc.nextInt();
				   deque.addFirst(b);
			   }else if(a.equals("pop_front")) {
				   System.out.println(deque.isEmpty()?-1:deque.pop());
			   }else if(a.equals("pop_back")) {
				   System.out.println(deque.isEmpty()?-1:deque.removeLast());
			   }else if(a.equals("size")) {
				   System.out.println(deque.size());
			   }else if(a.equals("empty")) {
				   System.out.println(deque.isEmpty()?1:0);
			   }else if(a.equals("front")) {
				   System.out.println(deque.isEmpty()?-1:deque.peek());
			   }else if(a.equals("back")) {
				   System.out.println(deque.isEmpty()?-1:deque.peekLast());
			   }
		   }
		   sc.close();
	}

}
