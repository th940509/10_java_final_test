package _03_list_stack;  //중요!

interface Stack{ // 인터페이스 : 추상클래스보다 더 추상화된 클래스, 실제 구현 X 기본 설계도
	
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
	
}


class StackNode{
	
	char data;
	StackNode link;
	
}


class LinkedStack implements Stack{ // implements 키워드를 사용하여 인터페이스를 구현 (상속X)
	
	private StackNode top; // StackNode 클래스 변수 top 생성
		
	public boolean isEmpty(){
		System.out.println("[확인용] top.data: " + top.data); //확인용
		return (top == null); // 1) top == null -> false 
	}                         //    top와 newNode 주소 공유 -> top.data = A
	                          // 2) top == null -> false
	                          //    top.data = B
	
	
	public void push(char item){ // 1) A 대입  /  2) B 대입
		StackNode newNode = new StackNode();
		newNode.data = item; // 1) newNode.data에 A 대입  2) B대입
		newNode.link = top;  // 1)2) newNOde.link에 top 주소 공유
		System.out.println("[주소 확인용]top : " + top); //확인용
		System.out.println("[주소 확인용]newNode.link : " + newNode.link); //확인용
		System.out.println("[주소 확인용]newNode : " + newNode); //확인용
		top = newNode;       // 1)2) top에 newNode 주소 공유
		System.out.println("[주소 확인용]top : " + top); //확인용
		System.out.println("[주소 확인용]newNode : " + newNode); //확인용
		System.out.println("[확인용2] top.data: " + top.data); //확인용
		System.out.println("[확인용2] newNode.data: " + newNode.data); //확인용
		System.out.println("Inserted Item : " + item); // 1) Inserted Item : A // 2) B
	}
	
	
	public char pop(){
		
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			char item = top.data;
			top = top.link;
			return item;	
		}
		
	}
	
	public void delete(){
		
		if (isEmpty()){
			System.out.println("Deleting fail! Linked Stack is empty!!");			
		}
		else {
			top = top.link;
		}
		
	}
	
	public char peek(){
		
		if (isEmpty()){
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else 
			return top.data;	
		
	}
	
	public void printStack(){
		if(isEmpty()) 
			System.out.printf("Linked Stack is empty!! %n %n");
		else{                                              // 1)2) isEmpty -> false로 else문에 성립함. 
			StackNode temp = top;                          // temp에 top의 주소 공유
			System.out.println("Linked Stack>> "); 
			while(temp != null){                           // 1)2) temp와 top의 주소 공유 -> temp != null 성립하여 while문 성립함.
				System.out.printf("\t %c \n", temp.data);  // 1) temp.data = top.data = 'A' // 2) temp.data = top.data = 'B'
				temp = temp.link;                          //    temp에 temp.link 공유 -> temp = null;
				System.out.println("[주소 확인용]top : " + top);  //확인용
				System.out.println("[주소 확인용]temp : " + temp);//확인용
			}
			System.out.println();	
		}
	}
}

public class ListStack{
	public static void main(String args[]){		
		char deletedItem;
		LinkedStack LS = new LinkedStack(); // LinkedStack 클래스 변수 LS 생성
		
		//2021/06/22/ 14:04 ~ 14:23
		LS.push('A');    // Inserted Item : A
		LS.printStack(); // Linked Stack>> A
		
		System.out.println("----------------------------------------------------");
		
		//2021/06/22 14:23 ~ 
		LS.push('B');    // Inserted Item : B
		LS.printStack();
		
		System.out.println("----------------------------------------------------");
		
		LS.push('C');
		LS.printStack();
		
		System.out.println("----------------------------------------------------");
		
		deletedItem = LS.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LS.printStack();
		
		System.out.println("----------------------------------------------------");
	}
}