package _02_array_stack;  //중요!



class ArrayStack { // 클래스 생성
	private int top; // private 변수 생성
	private int stackSize;
	private char itemArray[];
	
	public ArrayStack(int stackSize){ // Public 생성자 : 클래스 실행 시 무조건 실행
		top = -1;
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize];
	}
	// 1) stckSize=5 대입
	// top=-1
	// stackSize=5
	// itemArray = new char[5]
	
	
	public boolean isEmpty(){
		return (top == -1);
	}
	// 1) top == -1 이 참일 경우 true 출력
	//     1 == -1 거짓  ->  false 반환
	
	public boolean isFull(){
		return (top == this.stackSize-1);
	}
	// 1) top == this.stackSize-1 이 참일경우 true 출력
	//     -1 == 5-1
	//     -1 == 4 거짓 -> false 반환
	// 2)   0 == 4 거짓 -> false 반환
	
	public void push(char item){ // 1)  A대입 // 2) B대입
		if(isFull()){ // isFull이 참일 경우 성립
			System.out.println("Inserting fail! Array Stack is full!!");
		}
		else{ // 1)은 isFull이 false -> else에 성립함.	
			  // 2) isFull이 false -> 성립
			itemArray[++top] = item; // 1) itemArray[-1 +1] = 'A' -> itemArray[0] = 'A' 대입
			                         //    top = -1 -> ++top -> top = top+1 -> top = 0
			                         // 2) itemArray[1 + 0] = 'B' -> itemArray[1] = 'B' 대입
			                         //    top = 0 -> top = top+1 -> top=1
			System.out.println("top: " + top); //확인
			System.out.println("Inserted Item : " + item); // Inserted Item : A 출력됨.
		}
	}
	
	public char pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}
		else{ 
			return itemArray[top--];	
		}				
	}
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Array Stack is empty!!");			
		}
		else {
			top--;
		}
	}
	
	public char peek(){
		if(isEmpty()){ 
			System.out.println("Peeking fail! Array Stack is empty!!");
			return 0;
		}
		else 
			return itemArray[top];		
	}
	
	public void printStack(){
		if(isEmpty()) // isEmpty가 참일 경우 성립 
			System.out.printf("Array Stack is empty!! %n %n");
		else{ // isEmpty가 거짓이므로 성립함.
			System.out.printf("Array Stack>> ");
			for(int i=0; i<=top; i++) // i=0; i<0 i++ -> i=0일때만 성립
				System.out.printf("%c ", itemArray[i]); // itemArry[0] = A
			System.out.println();	System.out.println();
		}
	}
}

public class Stack01{
	public static void main(String args[]){ // 1. 메인찾기
		int stackSize = 5;
		char deletedItem;
		ArrayStack S = new ArrayStack(stackSize); // 클래스 변수 s 생성
		
		//2021/06/21 18:00 ~ 18:42
		S.push('A');     // Inserted Item : A 출력
		S.printStack();  // "Array Stack>> A 출력
		
		//2021/06/21 18:48 ~ 
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();
		
		deletedItem = S.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		S.printStack();		
	}
}