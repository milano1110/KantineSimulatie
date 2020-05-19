public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor
	 * @param dag De dag.
	 * @param maand De maand.
	 * @param jaar Het jaar.
	 */
	public Datum(int dag, int maand, int jaar) {
		if (!bestaatDatum(dag, maand, jaar)) {
			this.dag = 0;
			this.maand = 0;
			this.jaar = 0;
		} else {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public Datum() {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar) {

		int[][] datumArray = {{ 1, 31}, {2, 28, 29}, {3, 31}, {4, 30}, {5, 31}, {6, 30}, {7, 31}, {8, 31}, {9, 30}, {10, 31}, {11, 30}, {12, 31}};

		if (jaar >= 1900 && jaar <= 2100) {
			if (maand >= 1 && maand <= 12) {
				if (dag >= 1 && dag <= datumArray[maand - 1][1]) {
					return true;
				} else if (jaar % 2 == 0 && maand == 2){
					if (dag >= 1 && dag <= datumArray[maand - 1][2]) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		if (getDag() == 0) {
			return "Onbekend";
		}
		return getDag() + "-" + getMaand() + "-" + getJaar();
	}
}
