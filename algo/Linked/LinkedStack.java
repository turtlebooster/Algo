package algo.Linked;

public class LinkedStack {
	private Node top;
	public void push(String data) {
//		Node newNode = new Node(data);
//		newNode.link = top;
		
//		Node newNode = new Node(data, top);
//		top = newNode;
		
		top = new Node(data, top);
	}
	public String pop() {
		String data = peek();
		if (data != null) {
			top = top.link;
		}
		return data;
	}
	public String peek() {
		if (empty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return top.data;
	}
	public boolean empty() {
		return top == null;
	}
	public static void main(String[] args) {
		LinkedStack s = new LinkedStack();
		s.push("a");
		s.push("b");
		s.push("c");
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
