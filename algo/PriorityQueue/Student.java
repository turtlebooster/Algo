package algo.PriorityQueue;

public class Student implements Comparable<Student>{
	int no;
	int score;
	public Student() {
	}
	public Student(int no, int score) {
		this.no = no;
		this.score = score;
	}
	public String toString() {
		return "Student [no=" + no + ", score=" + score + "]";
	}
	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}	
}
