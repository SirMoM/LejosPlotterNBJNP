package robot.components;

import java.util.Arrays;
import java.util.List;

public class Reifensatz implements IUebersetzung {
	private List<Reifen> reifen;

	public Reifensatz(Reifen... reifen) {
		this.reifen = Arrays.asList(reifen);
	}

	@Override
	public double getUebersetzungsverhaeltnis() {
		return reifen.get(0).getUmfang() / reifen.get(reifen.size() - 1).getUmfang();
	}

	@Override
	public boolean isAntriebsUmkehrung() {
		return reifen.size()% 2 == 0;
	}
}
