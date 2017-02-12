package reto_1;

public class Reto_1 {

	public static void main(String[] args) {
		Reto_1 reto_1 = new Reto_1();
		
		reto_1.solution(255);
	}
	
	
	public int solution(int N) {
		String binary = Integer.toBinaryString(N);
		
		int maxPValue = binary.length() / 2;
		
		int period = -1;
		
		for (int p = 1; p <= maxPValue && period == -1; p++) {
			period = period(binary, p);
		}
		
		return period;
    }
	
	private int period (String binary, int period){
		int finalPeriod = -1;
		int end = 0;
		boolean checkEnding = false;
		
		if (binary.length() % period != 0) {
			end = (binary.length() - (period + (binary.length() % period)));
			checkEnding = true;
		} else {
			end = (binary.length() - period);
		}
		
		for (int k = 0; k < end; k = k + period) {
			if (binary.substring(k, k+period).equals(binary.substring(k+period, k+(period*2)))) {
				finalPeriod = period;
			} else {
				finalPeriod = -1;
				break;
			}
		}
		
		if (checkEnding && finalPeriod != -1) {
			if(binary.substring(0, binary.length() % period).equals(binary.substring(binary.length() - (binary.length() % period)))) {
				finalPeriod = period;
			} else {
				finalPeriod = -1;
			}
		}
		
		return finalPeriod;
	}

}
