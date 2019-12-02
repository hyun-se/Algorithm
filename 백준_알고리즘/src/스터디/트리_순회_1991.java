package 스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리_순회_1991 {
	
	//	기초적인 트리 구조를 익히는데 좋은 문제.
	
	//  접근 방식 :  주어진 대로 트리를 생성한다. 
	
	//  전위 , 중위 , 후위 순회를 재귀를 이용하여 출력한다.
	
	//  전체적인 틀.
	
	//  1. 트리의 기초인 노드 클래스를 먼저 생성한다.
	
	//  2. 트리 클래스를 만든다. 트리 클래스는 아래의 메서드들로 구성된다.
	//   (1) 값을 추가하는 add() 메서드
	//   (2) 어느 위치에 추가할 것인지 위치를 찾아주는 search() 메서드
	//   (3) 전위순회 ( preorder ), 중위순회 ( inorder ), 후위순회 ( postorder ) 메서드
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i,n = Integer.parseInt(in.readLine());
		Tree t = new Tree();
		char data[];
		for (i = 0; i < n; i++) {
			data = in.readLine().replaceAll(" ","").toCharArray();
			t.add(data[0], data[1] ,data[2]);
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		in.close();
	}
}
class Node{ // 노드 클래스.  이진트리 이므로 노드는 left , right 로 구성된다.
	char data;
	Node left , right;
	public Node (char data) {
		this.data = data;
	}
}

class Tree{
	Node root; //루트 노드. 처음엔 null 상태이다.
	
	// add 메서드. 들어온 값이 '.' 이 아닌 경우에만 삽입한다.
	public void add(char data, char leftData , char rightData) {
		if(root == null) { // 루트 노드가 비어있으면 = 아무것도 집어넣지 않은 최초 상태면
			if(data != '.') root = new Node(data); // '.' 이 아니면 노드 생성 후 데이터 삽입
			
			if(leftData != '.') root.left = new Node(leftData); // 생성된 노드의 좌측도 동일
			
			if(rightData != '.') root.right = new Node(rightData); // 생성된 노드의 우측도 동일
		}
		// 만약 최초 상태가 아니면 -> 어디에 들어가야 하는지 찾는다.
		else search(root , data , leftData , rightData);
	}
	
	// search() 메서드. 아래에서 사용된 root 는 매개변수로 들어온 로컬변수임에 유의한다.
	private void search(Node root, char data , char leftData , char rightData) {
		// 재귀를 사용하므로 도착한 노드가 null이면 종료 = 삽입 위치를 찾지못한 경우
		
		if(root == null) return;
		
		// 위치를 찾았으면
		
		else if(root.data == data) {
			
			// '.' 이 아닌 경우에 한해서 좌, 우 노드 생성 후 데이터 삽입
			
			if(leftData != '.') root.left = new Node (leftData);
			if(rightData != '.') root.right = new Node (rightData);
		}
		
		// 아직 찾지 못했고 , 탐색할 노드들이 남아있는 경우
		
		else {
			search(root.left , data , leftData , rightData); // 왼쪽 재귀 탐색
			search(root.right , data , leftData , rightData); // 오른쪽 재귀 탐색
		}
	}
	
	// 전위순회. 순회순서 : 중앙 -> 좌 -> 우
	public void preorder(Node root) {
		System.out.print(root.data); // 먼저 가운데 출력
		if(root.left != null) preorder(root.left); // 그 다음 왼쪽 
		if(root.right != null) preorder(root.right); // 마지막 오른쪽
	}
	// 중위순회. 순회순서 : 좌 -> 중앙 -> 우
	public void inorder(Node root) {
		if(root.left != null) inorder(root.left); // 왼쪽 먼저
		System.out.print(root.data); // 그 다음 중앙 출력
		if(root.right != null) inorder(root.right); // 마지막으로 오른쪽 출력
	}
	// 후위순회. 순회순서 : 좌 -> 우 -> 중앙
	public void postorder(Node root) {
		if(root.left != null) postorder(root.left); // 왼쪽 먼저
		if(root.right != null) postorder(root.right); // 그 다음 오른쪽
		System.out.print(root.data);
	}
}