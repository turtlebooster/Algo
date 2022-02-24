package algo.Linked;

public class LinkedQueue {
	int size;
	Node head, tail;
	public void enQueue (String data) {
		Node newNode = new Node(data);
		if (empty()) {
			head = tail = newNode;
		} else {
			tail.link = newNode;
			tail = newNode;
		}
		size++;
	}	
	public String deQueue () {
		if (empty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		String data = head.data;
		head = head.link;
		--size;
		if (empty()) {
			tail = null;
		}
		return data;
	}
	public boolean empty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		LinkedQueue q = new LinkedQueue();
		q.enQueue("a");
		q.enQueue("b");
		q.enQueue("c");
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}
