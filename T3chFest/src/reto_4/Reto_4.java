package reto_4;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Reto_4 {

	public static void main(String[] args) {
		Reto_4 reto_4 = new Reto_4();
		
		System.out.println(reto_4.solution(12, 3));
		System.out.println(reto_4.solution(1, 2));
		System.out.println(reto_4.solution(5, 4));
		System.out.println(reto_4.solution(1, 3));
		System.out.println(reto_4.solution(3, 28));
		System.out.println(reto_4.solution(2, 3));
		System.out.println(reto_4.solution(1, 7));
		System.out.println(reto_4.solution(2, 27));
		System.out.println(reto_4.solution(7, 12));
		System.out.println(reto_4.solution(100, 3));
	}

	public String solution(int A, int B) {
		String finalResult = "";

		if (A % B == 0) {
			finalResult = Integer.toString(A / B);
		} else {
			DecimalFormat formatter = new DecimalFormat("0.00000000000000");
			formatter.setRoundingMode(RoundingMode.DOWN);
			double fraction = (double) A / (double) B;

			String[] result = formatter.format(fraction).split(",");
			String value = "-1";

			int maxPValue = result[1].length() / 2;
			for (int p = 1; p <= maxPValue && value.equals("-1"); p++) {
				value = shiftAndPeriod(result[1], p);
			}

			if (!value.equals("-1")) {
				int shift = Integer.parseInt(value.split("-")[0]);
				int period = Integer.parseInt(value.split("-")[1]);
				
				if (result[1].substring(shift, shift + period).equals("0")) {
					finalResult = Double.toString(Double.parseDouble(result[0] + "." + result[1]));
				} else if(!result[1].substring(shift, shift + period).equals("9")){
					finalResult = result[0] + "." + result[1].substring(0, shift) + "(" + result[1].substring(shift, shift + period) + ")";
				} else {
					if (shift != 0) {
						long auxResult = Long.parseLong(result[1]) + 1;
						finalResult = Double.toString(Double.parseDouble(result[0] + "." + auxResult));
					} else {
						int auxResult = Integer.parseInt(result[0]) + 1;
						finalResult = Integer.toString(auxResult);
					}
				}
			} else {
				finalResult = result[0] + "." + result[1];
			}
		}
		return finalResult;
	}

	private String shiftAndPeriod(String initialValue, int period) {
		int finalPeriod = -1;
		int end = 0;
		boolean checkEnding = false;
		String value = "";
		int shift = 0;
		while (shift - 1 < initialValue.length() && finalPeriod == -1) {
			value = initialValue.substring(shift);
			shift = shift + 1;
			
			if (value.length() % period != 0) {
				end = (value.length() - (period + (value.length() % period)));
				checkEnding = true;
			} else {
				end = (value.length() - period);
			}

			for (int k = 0; k < end; k = k + period) {
				if (value.substring(k, k + period).equals(value.substring(k + period, k + (period * 2)))) {
					finalPeriod = period;
				} else {
					finalPeriod = -1;
					break;
				}
			}

			if (checkEnding && finalPeriod != -1) {
				if (value.substring(0, value.length() % period)
						.equals(value.substring(value.length() - (value.length() % period)))) {
					finalPeriod = period;
				} else {
					finalPeriod = -1;
				}
			}
		}

		String finalValue = "-1";
		if (finalPeriod != -1){
			finalValue = (shift - 1) + "-" + finalPeriod;
		} else {
			finalValue = "-1";
		}
		
		return finalValue;
	}
}
