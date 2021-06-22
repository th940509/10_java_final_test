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
	//     0 == -1 거짓  ->  false 반환
	// 2)  1 == -1 거짓  ->  false 반환
	// 3)  2 == -1 거짓  ->  false 반환
	// 4)  1 == -1 거짓  ->  false 반환
	
	public boolean isFull(){
		return (top == this.stackSize-1);
	}
	// 1) top == this.stackSize-1 이 참일경우 true 출력
	//     -1 == 5-1
	//     -1 == 4 거짓 -> false 반환
	// 2)   0 == 4 거짓 -> false 반환
	// 3)   1 == 4 거짓 -> false 반환
	
	public void push(char item){ // 1)  A대입 // 2) B대입 // 3) C대입
		if(isFull()){ // isFull이 참일 경우 성립
			System.out.println("Inserting fail! Array Stack is full!!");
		}
		else{ // 1) 은 isFull이 false -> else에 성립함.	
			  // 2) isFull이 false -> 성립
			  // 3) isFull이 false -> 성립
			itemArray[++top] = item; // 1) itemArray[0] = 'A' -> itemArray[0] = 'A' 대입
			                         //    top = -1 -> ++top -> top = top+1 -> top = 0
			                         // 2) itemArray[1] = 'B' -> itemArray[1] = 'B' 대입
			                         //    top = 0 -> top = top+1 -> top=1
									 // 3) itemArray[2] = 'C' -> itemArray[2] = 'C' 대입
			 						 //    top = 1 -> top = top+1 -> top=2
			System.out.println("[확인용] top: " + top); // 확인용
			System.out.println("Inserted Item : " + item); 
		}
	}
	
	public char pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}
		else{ // 4) isEmpty는 false 이므로 else문에 성립함.
			System.out.println("[확인용2] top: " + top); // 확인용
			return itemArray[top--]; // 현재 top=2 -> itemArray[2] = C
			                         // top 2 - 1 =1
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
		if(isEmpty()) // isEmpty가 true일 경우 성립 
			System.out.printf("Array Stack is empty!! %n %n");
		else{ // 1)2)3) false로 else문에 성립
			System.out.printf("Array Stack>> ");
			for(int i=0; i<=top; i++) // 1) i=0; i<=0 i++ -> i=0일때만 성립 // 2) i=0; i<=1; i++ -> i=0,1일때 성립 // 3) i=0; i<=2; i++ -> i=0,1,2 일때 성립 // 4)i=0; i<=1; i++ -> i=0,1일때 성립
				System.out.printf("%c ", itemArray[i]); // 1) itemArray[0] = A // 2) itemArray[0] = A, [1] = B // 3) itemArray[0] = A, [1] = B, [2]= C // 4)  2) itemArray[0] = A, [1] = B 
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
		
		//2021/06/21 18:48 ~ 19:30
		S.push('B');     // Inserted Item : B 출력
		S.printStack();  // "Array Stack>> A B 출력
		
		//2021/06/21 23:39 ~ 23:55
		S.push('C');     // Inserted Item : C 출력
		S.printStack();  // "Array Stack>> A B C 출력
		
		//2021/06/22 00:03 ~ 00:16
		deletedItem = S.pop(); // Inserted Item : C 출력
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		S.printStack();	 // "Array Stack>> A B C 출력	
	}
}