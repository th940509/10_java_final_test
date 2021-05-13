package _99_codingtest_sample;
/*
 * # 스네이크 게임

 * 1. 10x10 배열을 0으로 채운다.
 * 2. 스네이크는 1234로 표시한다.
 * 3. 상하좌우로 이동이 가능하며, 꼬리가 따라온다.
 * 4. 자기몸하고 부딪히면, 사망한다.
 * 5. 꼬리는 최대 8개까지 증가할 수 있다.
 */
//2021/05/13 17:05 ~ (분석)

import java.util.Scanner;

public class snake01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int SIZE = 10;
		int[][] map = new int[SIZE][SIZE];
		
		int[] y = new int[4];	// 0 0 0 0  y배열 4
		int[] x = new int[4];	// 0 1 2 3  x배열 4
		int[] snake = new int[4]; // 1 2 3 4   snake배열 4
		
		for (int i=0; i<4; i++) {
			x[i] = i;	 // 0 1 2 3		
			map[y[i]][x[i]] = i+1; // map[0][0] = 1 , map[0][1] = 2, map[0][2] = 3, map[0][3] = 4  ->  4개 값 빼고는 전부 0
			snake[i] = map[y[i]][x[i]]; // snake[0] = 1, snake[1] = 2, snake[2] = 3, snake[3] = 4
		}	
		
		while (true) {
			
			// map 출력
			for (int i=0; i<SIZE; i++) { // int i=0; i<10; i++ -> i = 0,1,2,3,4,5,6,7,8,9
				for (int j=0; j<SIZE; j++) { // int j=0; j<10; j++ -> j = 0,1,2,3,4,5,6,7,8,9
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			
			// 입력 키 출력
			System.out.print("1)left 2)right 3)up 4)down : ");
			int move = scan.nextInt();
		
			int nexty= 0;
			int nextx = 0;
			
			if (move == 1) { //left
				nexty = y[0]; //
				nextx  = x[0] - 1; // 
			}
			else if (move == 2) { //right  
				nexty = y[0]; //
				nextx = x[0] + 1; // 
			}
			else if (move == 3) { //up
				nexty = y[0] - 1;
				nextx = x[0];
			}
			else if (move == 4) { //down (1)
				nexty = y[0] + 1; // nexty = 1
				nextx = x[0]; // nextx = 0
			}
                                                              // 벽에 부딫힐 경우..
			if (nexty < 0 || nextx < 0) 			continue; // nexty, nextx 둘중 하나가 음수가 될 경우 continue;
			if (nexty >= SIZE || nextx >= SIZE) 	continue; // nexty, nextx 둘중 하나가 SIZE(10) 보다 크거나 같을 경우 continue;
			if (map[nexty][nextx] != 0) 		continue;     // 뒤에 몸통이 있는 경우..
			 
			// 꼬리 지우기
			int taily = y[y.length-1]; // taily = y[3]
			int tailx = x[x.length-1]; // tailx = x[3]
			map[taily][tailx ] = 0; // map [3][3] = 0
			

			// 몸통 이동하기(머리빼고)
			for (int i=snake.length-1; i>0; i--) { // int i= 4-1; i>0; i--; -> i=3,2,1
				y[i] = y[i - 1]; // 
				x[i] = x[i - 1]; // 
			}

            // 머리이동
			x[0] = nextx ;
			y[0] = nexty;
			
			// 뱀 그리기 
			for (int i=0; i<snake.length; i++) {
				map[y[i]][x[i]] = i + 1;
			}

		}
		
	}

}
