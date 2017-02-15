package reto_3;

public class Reto_3 {

	public static void main(String[] args) {

		Reto_3 reto_3 = new Reto_3();
		int[] cities_1 = { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };

		int [] solution = reto_3.solution(cities_1);
		for (int i = 0; i < solution.length; i++) {
			System.out.println(solution[i]);
		}
	}

	public int[] solution(int[] T) {
		int[] solution = new int[T.length - 1];
		int[] distances = new int[T.length - 1];
		for (int i = 0; i < solution.length; i++) {
			solution[i] = 0;
			distances[i] = 0;
		}
		int capital = capital(T);
		calculateDistances(T, capital, solution, 0);
		return solution;
	}

	private int capital(int[] cities) {
		int capital = 0;
		while (cities[capital] != capital) {
			capital = capital + 1;
		}

		return capital;
	}

	private void calculateDistances(int[] cities, int city, int[] solution, int depth) {
		if(valueInArray(cities, city)) {
			for (int j = 0; j < cities.length; j++) {
				if ((j != city) && (cities[j] == city)) {
					solution[depth] = solution[depth] + 1;
					calculateDistances(cities, j, solution, depth + 1);
				}
			}
		}
	}
	
	private boolean valueInArray (int [] array, int value) {
		boolean isRight = false;
		int i = 0;
		while ((i < array.length) && !isRight) {
			if(array[i] == value) {
				isRight = true;
			}	
			i = i + 1;
		}
		
		return isRight;
	}
}
