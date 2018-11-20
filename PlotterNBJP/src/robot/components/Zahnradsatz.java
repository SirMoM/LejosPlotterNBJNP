package robot.components;

import java.util.Arrays;
import java.util.List;

public class Zahnradsatz implements IUebersetzung{

	private List<Zahnrad> zahnraeder;

	public Zahnradsatz(Zahnrad... zahnraeder){
		this.zahnraeder = Arrays.asList(zahnraeder);
	}

	@Override
	public double getUebersetzungsverhaeltnis(){
		return ((double) this.zahnraeder.get(0).getZaehne()) / (double) this.zahnraeder.get(this.zahnraeder.size() - 1).getZaehne();
	}

	@Override
	public boolean isAntriebsUmkehrung(){
		return this.zahnraeder.size() % 2 == 0;
	}

}
