package reto_6;

import java.math.BigInteger;

public class Reto_6 {

	public static void main(String[] args) {
		Reto_6 reto_6 = new Reto_6();
		
		int [] A = {5, 4, 7};
		int [] B = {100000, 25};
		System.out.println(reto_6.solution(A));
		System.out.println(reto_6.solution(B));
	}
	
	public int solution(int [] A) {
		BigInteger M = new BigInteger("0");
		int finalResult = 0;
		
		for (int n : A) {
			M = M.add(pm2(new BigInteger("-2"), n));
		}

		if (new BigInteger("10000000").compareTo(M) == -1) {
			finalResult = -1;
		} else if (new BigInteger("-10000000").compareTo(M) == 1) {
			finalResult = -1;
		} else {
			finalResult = M.intValue();
		}
		
		return finalResult;
    }

	private BigInteger pm2 (BigInteger L, int N) {
		if (N == 1) {
			return L;
		} else if (N == 2) {
			return L.multiply(L);
		} else if (N % 2 == 0) {
			return pm2(pm2(L, N/2), 2);
		} else {
			return L.multiply(pm2(pm2(L, (N - 1) / 2), 2));
		}
	}
}
