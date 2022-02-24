package algo.PriorityQueue;

//import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		/*
		PriorityQueue<Student> queue = new PriorityQueue<>( new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o1.no - o2.no;
			}
		});
		*/
		PriorityQueue<Student> queue = new PriorityQueue<>(
				(o1, o2) -> {
					if (o1.score != o2.score) return o1.score - o2.score;
					return o1.no - o2.no;
				}
				);
		queue.offer(new Student(1, 65));
		queue.offer(new Student(2, 80));
		queue.offer(new Student(4, 70));
		queue.offer(new Student(3, 80));
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		/*
		// 정렬의 기준점 필요 : Comparable 활용
		PriorityQueue<Student> queue = new PriorityQueue<>();
		queue.offer(new Student(1, 80));
		queue.offer(new Student(2, 70));
		queue.offer(new Student(4, 90));
		queue.offer(new Student(3, 77));
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		/*
		
		/*
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.offer("a");
		queue.offer("d");
		queue.offer("c");
		queue.offer("b");
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		*/
	}
}
