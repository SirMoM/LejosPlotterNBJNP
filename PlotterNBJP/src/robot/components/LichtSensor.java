package robot.components;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import robot.util.DisplayHandler;

public final class LichtSensor extends Sensor<EV3ColorSensor>{

	final float epsilon = 0.02f;
	private float schwellwert;

	public LichtSensor(Port port){
		super(new EV3ColorSensor(port));
	}

	@Override
	public void kalibriere(float wert){
		this.schwellwert = wert;
		DisplayHandler.writeFirstLine("Kalibrierng Licht: " + this.schwellwert);
	}

	@Override
	protected SensorMode getSensorMode(EV3ColorSensor sensor){
		return sensor.getRedMode();
	}

	@Override
	protected boolean isAktiv(float wert){
		return Math.abs(wert - this.schwellwert) > this.epsilon;
	}

}
