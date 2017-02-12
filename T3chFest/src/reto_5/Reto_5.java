package reto_5;

import java.util.ArrayList;

public class Reto_5 {

	public static void main(String[] args) {

		Reto_5 reto_5 = new Reto_5();
		int[] A = {1, -1, 0, 2, 3, 5};
		int[] B = {3, 2, 1};
		int[] C = {1, 2, 3, 4, -1, -1, -1};
		int[] D = {-1, 0, 3, 1, 2, 5, 4, -1, 6, 7};


		System.out.println(reto_5.solution(A, 3));
		System.out.println(reto_5.solution(B, 1));
		System.out.println(reto_5.solution(C, 2));
		System.out.println(reto_5.solution(D, 4));
	}

	public int solution(int[] A, int D) {
		int time = -1;

		if (D > A.length) {
			time = 0;
		} else {
			time = jumpRocks(A, D);
		}
		
		return time;
	}

	private int jumpRocks(int[] A, int D) {
		ArrayList <Integer> times = new ArrayList<>();
		int time = 0;
		int maxNextPosition = D;
		int currentPosition = -1;
		while (maxNextPosition < A.length) {
			int nextPosition = currentPosition + D;
			int index = -1;
			int lowest = 100001;
			while (nextPosition > currentPosition) {
				if ((A[nextPosition] < lowest) && (A[nextPosition] >= 0)) {
					lowest = A[nextPosition];
					index = nextPosition;
				}
				nextPosition = nextPosition - 1;
			}
			if (index != -1) {
				currentPosition = index;
				times.add(A[currentPosition]);
				maxNextPosition = currentPosition + D;
			} else {
				time = -1;
				break;
			}	
		}
		
		if (time != -1) {
			int highest = 0;
			for (int i = 0; i < times.size(); i++) {
				if (times.get(i) > highest){
					highest = times.get(i);
				}
			}
			time = highest;
		}
		return time;
	}
}
