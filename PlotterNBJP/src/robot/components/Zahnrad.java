package robot.components;

public class Zahnrad{

	// TODO Delete after test
	public static final int ANZAHL_ZAEHNE_GROSS = 36;
	public static final int ANZAHL_ZAEHNE_KLEIN = 12;
	public static final int ANZAHL_ZAEHNE_MITTEL = 24;

	private int zaehne;

	public Zahnrad(int zaehne){
		super();
		this.zaehne = zaehne;
	}

	public int getZaehne(){
		return this.zaehne;
	}

}
