package _01_list; //중요! ...진행중

class LinkedList{
	
	private ListNode head; // private로 ListNode 클래스 변수 head 생성
	
	public LinkedList(){
		head = null; // -> head = null;
	}
	
	// ListNode의 클래스 변수 / 문자열 입력받기
	public void insertMiddleNode(ListNode pre, String data){       
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	
	
	public void insertLastNode(String data){ // 문자열 입력받기 1) 119줄: 월 / 2) 120줄: 수 / 3) 121줄: 일 
		ListNode newNode = new ListNode(data); // 1) ListNode 클래스 변수 newNode 생성 -> ListNode(data = 월) 대입
		                                       // 2) ListNode 클래스 변수 newNode 생성 -> ListNode(data = 수) 대입
		                                       // 3) ListNode 클래스 변수 newNode 생성 -> ListNode(data = 일) 대입
		if(head == null){ // 처음에는 head = null 성립
			this.head = newNode; // head에 위의 newNode 값 대입
		}
		else{ // 문자열 입력받기 120줄: 수 / 121줄: 일
			ListNode temp = head; // 2) temp에 기존의 head 값 공유 / 3) temp에 기존의 head값 공유
			while(temp.link != null) temp = temp.link; // temp.link 가 null이 아닐때 성립 2) 성립X // 3) 성립O 
			                                           // temp 에 temp,Link(data = 수(private) / link = null) 공유
			 
			temp.link = newNode; //temp.link에 2)값대입 (data = 수(private) / link = null) 3)값대입 (data = 일(private) / link = null)
		}
	}
	
	
	public void deleteLastNode(){
		ListNode pre, temp;
		if(head == null)  return;
		if(head.link == null){
			head = null;
		}
		else{
			pre = head;
			temp = head.link;
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	
	
	public ListNode searchNode(String data){
		ListNode temp = this.head;
		while(temp != null){
			if(data == temp.getData())  
				return temp;
			else temp = temp.link;
		}
		return  temp;
	}
	
	
	public void reverseList(){
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while(next != null){
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	
	
	public void printList(){
		ListNode temp = this.head;
		System.out.printf("L = (");
		while(temp != null){
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null){
				System.out.printf(", ");
			}			
		}
		System.out.println(")");
	}
}


class ListNode{ 
	
	private String data;
	public ListNode link; // link는 ListNode의 클래스 변수
	
	public ListNode(){
		this.data = null;
		this.link = null;
	}
	public ListNode(String data){ // 119줄 월 대입했을 경우, data = 월(private) / link = null
		                          // 120줄 수 대입했을 경우, data = 수(private) / link = null
		                          // 121줄 일 대입했을 경우, data = 일(private) / link = null
		this.data = data;
		this.link = null;
	}
	public ListNode(String data, ListNode link){
		this.data = data;
		this.link = link;
	}
	public String getData(){
		return  this.data;
	}
}

public class List01{
	
	public static void main(String args[]){ // 메인
		
LinkedList L = new LinkedList(); // LinkedList 클래스 변수 L에 LinkedList객체 대입.. 
		
		System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList();

		System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
		ListNode pre = L.searchNode("수");
		if(pre == null) 
			System.out.println("검색실패>> 찾는 데이터가 없습니다.");
		else{
			L.insertMiddleNode(pre, "금");
			L.printList();
		}

		System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
		L.reverseList();
		L.printList();

		System.out.println("(4) 리스트의 마지막 노드 삭제하기");      
		L.deleteLastNode();
		L.printList();
		
	}
}
