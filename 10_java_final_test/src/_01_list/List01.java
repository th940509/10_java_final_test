package _01_list; 

class LinkedList{
	
	private ListNode head; // private로 ListNode 클래스 변수 head 생성
	
	public LinkedList(){ // public 생성자: 클래스 실행 시 무조건 실행되어야 함.
		head = null; // -> head = null;
	}
	
	// ListNode의 클래스 변수 / 문자열 입력받기
	public void insertMiddleNode(ListNode pre, String data){ //클래스 변수, 문자열 입력받기 : pre(반환된 temp(data = 수..) , 금 
		ListNode newNode = new ListNode(data); // ListNode 클래스 변수 newNode 생성 -> ListNode(금) => data = 금 / link = null 대입
		System.out.println("newNode : " + newNode);                         //확인
		System.out.println("newNode.getData : " + newNode.getData());       //확인
		System.out.println("newNode.link : " + newNode.link);               //확인
		
		newNode.link = pre.link; // pre.link 주소 공유, 대입
		
		System.out.println("pre.getData : " + pre.getData());               //확인
		System.out.println("pre.link : " + pre.link);                       //확인
		System.out.println("pre.link.getData : " + pre.link.getData());     //확인
		System.out.println("pre.link.link : " + pre.link.link);             //확인
		
		pre.link = newNode; // pre.link = newNode 주소 공유, 대입
		
		System.out.println("pre.link : " + pre.link);                       //확인
	}
	
	
	public void insertLastNode(String data){ // 문자열 입력받기 1) 119줄: 월 / 2) 120줄: 수 / 3) 121줄: 일 
		ListNode newNode = new ListNode(data); // 1) ListNode 클래스 변수 newNode 생성 -> ListNode(data = 월) 대입
		                                       // 2) ListNode 클래스 변수 newNode 생성 -> ListNode(data = 수) 대입
		                                       // 3) ListNode 클래스 변수 newNode 생성 -> ListNode(data = 일) 대입
		System.out.println("newNode : " + newNode);                       //확인
		if(head == null){ // public 생성자 실행.
			this.head = newNode; // head에 위의 newNode 값 대입 -> data = 월, link = null
			System.out.println("head : " + head);                         //확인
		}
		else{ // 문자열 입력받기 120줄: 수 / 121줄: 일
			ListNode temp = head; // 1) 성립X 2) temp에 기존의 head 값 공유 / 3) temp에 기존의 head값 공유
			System.out.println("head : " + head);                         //확인
			System.out.println("head 값: " + head.getData());
				if(head.link != null) {
					System.out.println("/" + head.link.getData());
						if(head.link.link != null) {
							System.out.println("/" + head.link.link.getData());
						}
						else if(head.link.link == null) {
							System.out.println("/ null");
						}
				}
			System.out.println("temp : " + temp);                         //확인
			System.out.println("temp.link : " + temp.link);               //확인
			
			while(temp.link != null) { // temp.link 가 null이 아닐때 성립 2) 성립X // 3)data = 일 경우에만, 성립O 
				System.out.println("temp : " + temp);                     //확인
				System.out.println("head: " + head);                      //확인 (head = temp)
				System.out.println("temp.link : " + temp.link);           //확인
				
				temp = temp.link;                                         //temp = temp.link 공유 -> head 공유 X
				
				System.out.println("temp : " + temp);                     //확인
				System.out.println("*head: " + head);                     //확인
				System.out.println("temp.link : " + temp.link);           //확인
				System.out.println("*head.link : " + head.link);          //확인
			}
			
			temp.link = newNode; // temp.link 에 newNode(data = 수 / link = null) 값 대입
			System.out.println("temp.link : " + temp.link);               //확인
			System.out.println("head : " + head);                         //확인
			System.out.println("temp : " + temp);                         //확인
			
			
			System.out.println("# head 값: " + "#" + head.getData());
				if(head.link != null) {
					System.out.println("#" + head.link.getData());
						if(head.link.link != null) {
							System.out.println("#" + head.link.link.getData());
						}
						else if(head.link.link == null) {
							System.out.println("# null");
						}
				}
//			ListNode abc = head.link;                                     //확인
//			ListNode abc2 = head.link.link;                               //확인
//			System.out.println("abc: " +abc);                             //확인
//			System.out.println("abc.getData(): " + abc.getData());        //확인
//			System.out.println("abc2: " +abc2);                           //확인
			System.out.println("head값 : " + head.getData() + "/" + head.link.getData() + "/" + temp.link.getData());        //확인
			// System.out.println("head값 : " + head.getData() + "/" + head.link.getData() + "/" + head.link.link.getData()); //->  nullpointer 에러?
			
		}
	}
	
	
	public void deleteLastNode(){
		ListNode pre, temp;
		if(head == null)  return;
		if(head.link == null){
			head = null;
		}
		else{                          // head, head.link = null이 아닐떄
			pre = head;                // pre에 head 주소 공유
			temp = head.link;          // temp에 head.link 주소 공유
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
				System.out.println("(4) pre: " + pre);
				System.out.println("(4) temp: " + temp);
				System.out.println("(4) temp.link: " + temp.link);
				System.out.println("------------------------------------------");
			}
			pre.link = null;
			System.out.println("(4) pre: " + pre);
			System.out.println("(4) pre 값: " + pre.getData());
			System.out.println("------------------------------------------");
		}
	}
	
	
	public ListNode searchNode(String data){ // 문자열 입력받기 1) 수
		ListNode temp = this.head; 
		System.out.println("(2) head : " + head);                             //확인
		System.out.println("(2) head값 : " + head.getData() + "/" + head.link.getData() + "/" + head.link.link.getData());  //확인
		while(temp != null){ // 성립O
			if(data == temp.getData()) // 1) temp.getData = 월 -> (월 != 수) 성립 X -> else 이동 
				return temp;           //  2)temp.getData = 수 -> 수 == 수 성립 O -> temp 값 (data = 수..) 반환
			
			else temp = temp.link; // temp.link => data = 수 ... -> temp 에게 주소 공유
			System.out.println("temp : " + temp);                         //확인
			System.out.println("temp.link : " + temp.link);               //확인
		}
		return  temp; // temp 값 반환
	}
	
	
	public void reverseList(){
		System.out.println("(3) head : " + head);                             //확인
		System.out.println("(3) head값 : " + head.getData() + "/" + head.link.getData() + "/" + head.link.link.getData()  + "/" + head.link.link.link.getData());  //확인
		System.out.println("==========================================");
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while(next != null){
			pre = current; // pre=null , current=null ->  주소 공유
			current = next; // current에 next 주소 공유
			System.out.println("(3) pre : " + pre);                            //확인
			System.out.println("(3) current : " + current);                    //확인
			// System.out.println("(3) current 값: " + current.getData() + "/" + current.link.getData() + "/" + current.link.link.getData() + "/" + current.link.link.link.getData());
			System.out.println("(3) next : " + next);                          //확인
			next = next.link;
			current.link = pre;
			System.out.println("------------------------------------------");
		}
		head = current;
		System.out.println("pre");
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
	
	public ListNode(){ // 생성자는 객체가 생성될때 무조건 실행.
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
	
	public static void main(String args[]){ // 메인 찾기
		
LinkedList L = new LinkedList(); // LinkedList 클래스 변수 생성 후 객체 대입.
		
		System.out.println("(1) 공백 리스트에 노드 3개 삽입하기"); //* 분석: 2021/05/13 ~ 2021/05/19 23:46
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList();

		System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기"); //* 분석: 2021/05/25 ~ 2021/05/26 18:07
		ListNode pre = L.searchNode("수");
		System.out.println("pre : " + pre);
		if(pre == null) // null이 아니기 때문에 성립X
			System.out.println("검색실패>> 찾는 데이터가 없습니다.");
		else{ // 성립O
			L.insertMiddleNode(pre, "금");
			L.printList();
		}

		System.out.println("(3) 리스트의 노드를 역순으로 바꾸기"); //* 분석: 2021/05/26 18:10 ~ 2021/05/26 19:10
		L.reverseList();
		L.printList();

		System.out.println("(4) 리스트의 마지막 노드 삭제하기"); //* 분석: 2021/05/31 18:05 ~ 19:30
		L.deleteLastNode();
		L.printList();
		
	}
}
