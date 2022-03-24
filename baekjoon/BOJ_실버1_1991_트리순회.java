package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_실버1_1991_트리순회 {
	public static HashMap<String, Node> nodeMap;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		nodeMap = new HashMap<>();
		
		// 노드 매핑
		for (int i = 0; i < N; i++) {
			Node node = new Node();
			node.name = sc.next();
			node.left = sc.next();
			node.right = sc.next();
			nodeMap.put(node.name, node);
		}
		
		
		System.out.println(preorder("A"));
		System.out.println(inorder("A"));
		System.out.println(postorder("A"));
		sc.close();
	}
	
	public static String preorder(String n) {
		Node node = nodeMap.get(n);		
		return node.name + (node.left.equals(".") ? "" : preorder(nodeMap.get(node.left).name)) + (node.right.equals(".") ? "" : preorder(nodeMap.get(node.right).name));
	}
	
	public static String inorder(String n) {
		Node node = nodeMap.get(n);		
		return (node.left.equals(".") ? "" : inorder(nodeMap.get(node.left).name)) + node.name + (node.right.equals(".") ? "" : inorder(nodeMap.get(node.right).name));
	}
	
	public static String postorder(String n) {
		Node node = nodeMap.get(n);		
		return (node.left.equals(".") ? "" : postorder(nodeMap.get(node.left).name)) + (node.right.equals(".") ? "" : postorder(nodeMap.get(node.right).name)) + node.name;
	}
	
	public static class Node {
		String name;
		String left;
		String right;
	}
	
}
