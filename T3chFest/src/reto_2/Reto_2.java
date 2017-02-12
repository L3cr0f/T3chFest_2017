package reto_2;

public class Reto_2 {

	public static void main(String[] args) {

		Reto_2 reto_2 = new Reto_2();
		System.out.println(reto_2.solution(4, "1B 2C,2D 4D", "1B 1C 2B 2C 2D 4D 4A"));
		System.out.println(reto_2.solution(12, "1A 2A,12A 12A", "12A"));
		System.out.println(reto_2.solution(3, "1A 1B,2C 4C", "1B"));
		System.out.println(reto_2.solution(5, "1A 1A,5C 5C", "1B"));

	}

	/**
	 * 
	 * @param N
	 *            = size of the map
	 * @param S
	 *            = position of ships (example: A2 A3,F2,G2)
	 * @param T
	 *            = hits (example: B3 A1 D2 H2)
	 * @return = the count of sunken ships and the count of ships that have been
	 *         hit but not sunk (example: 0,0)
	 */
	public String solution(int N, String S, String T) {

		String solution = "";
		int sunkShips = 0;
		int hitShips = 0;

		String[] ships = S.split(",");
		String[] hits = T.split(" ");

		for (int i = 0; i < ships.length; i++) {
			ships[i] = completeFieldsOfAShip(ships[i]);
		}

		for (int i = 0; i < ships.length; i++) {
			String[] ship = ships[i].split(" ");
			int hitCounter = 0;
			for (int j = 0; j < ship.length; j++) {
				for (int k = 0; k < hits.length; k++) {
					if (ship[j].equals(hits[k])) {
						hitCounter = hitCounter + 1;
						break;
					}
				}
			}

			if (hitCounter == ship.length) {
				sunkShips = sunkShips + 1;
			} else if ((hitCounter < ship.length) && (hitCounter != 0)) {
				hitShips = hitShips + 1;
			}
		}

		solution = sunkShips + "," + hitShips;

		return solution;
	}

	private String completeFieldsOfAShip(String ship) {
		String completeShip = "";
		String[] shipFields = ship.split(" ");

		if (shipFields[0].equals(shipFields[1])) {
			completeShip = shipFields[0];
		} else {
			completeShip = shipFields[0] + " ";
			if (((Integer.parseInt(shipFields[1].substring(0, 1)) - 1) + shipFields[1].substring(1, 2))
					.equals((Integer.parseInt(shipFields[0].substring(0, 1)) + 1) + shipFields[0].substring(1, 2))) {
				completeShip = completeShip + (Integer.parseInt(shipFields[1].substring(0, 1)) - 1)
						+ shipFields[1].substring(1, 2) + " ";
			} else {
				completeShip = completeShip + (Integer.parseInt(shipFields[1].substring(0, 1)) - 1)
						+ shipFields[1].substring(1, 2) + " ";
				completeShip = completeShip + (Integer.parseInt(shipFields[0].substring(0, 1)) + 1)
						+ shipFields[0].substring(1, 2) + " ";
			}
			completeShip = completeShip + shipFields[1];
		}

		return completeShip;
	}
}
