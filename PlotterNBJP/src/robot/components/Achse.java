package robot.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lejos.hardware.port.Port;

public abstract class Achse {

	protected Reifen antriebsEinheit;

	private Motor motor;

	private Sensor sensor;

	private List<IUebersetzung> uebersetzungsEinheiten = new ArrayList<>();

	public Achse(Sensor sensor, Port port, Einbaurichtung einbaurichtung, Reifen antriebsEinheit, IUebersetzung... uebersetzungsEinheiten) {
		super();
		this.motor = new Motor(port, einbaurichtung);
		this.sensor = sensor;
		if (uebersetzungsEinheiten != null)
			this.uebersetzungsEinheiten = Arrays.asList(uebersetzungsEinheiten);
		this.antriebsEinheit = antriebsEinheit;
	}

	protected Motor getMotor() {
		return this.motor;
	}

	public Sensor getSensor() {
		return sensor;
	}

	protected double getUebersetzungsverhaeltnis() {
		if (uebersetzungsEinheiten.isEmpty())
			return 1;
		return uebersetzungsEinheiten.get(0).getUebersetzungsverhaeltnis();
	}

	public boolean isSensorAktiv() {
		if (sensor == null)
			return true;
		return sensor.isAktiv();
	}

	public void setSpeed(int grad) {
		this.motor.setSpeed(grad);
	}

	public void stop() {
		this.motor.stop();
	}

}
