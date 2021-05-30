package _01_list;

/*
 * 
 * # 클래스의 범위
 * 
 * 		- 같은 패키지 안의 클래스는 다른 클래스에서 사용이 가능하다.
 *       ( 구체적인 접근제어자는 객체지향 기법에서 공부 )
 * 
 * */

class Student {
	String name;
	int score;
}

public class test {

	public static void main(String[] args) {

	Student head = new Student();
		head.name = "소영";
		head.score = 100;
		
		Student pre = null;
		Student current = null;
		Student next = head;
		
		current = next;
		pre = current;
		head.score = 200;
		
		
//		System.out.println("head값: " + head.name + head.score);
//		System.out.println("pre값: " + pre.name + pre.score);
//		System.out.println("current값: " + current.name + current.score);
//		System.out.println("next값: " + next.name + next.score);
		System.out.println("head: " + head);
		System.out.println("pre: " + pre);
		System.out.println("current: " + current);
		System.out.println("next: " + next);
		System.out.println("head.score: " + head.score);
		System.out.println("pre.score: " + pre.score);
		System.out.println("next.score: " + next.score);
		System.out.println("current.score: " + current.score);
	}

}
