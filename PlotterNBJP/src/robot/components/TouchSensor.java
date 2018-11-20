package robot.components;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.SensorMode;

public final class TouchSensor extends Sensor<EV3TouchSensor> {

	public TouchSensor(Port port) {
		super(new EV3TouchSensor(port));
	}

	@Override
	protected SensorMode getSensorMode(EV3TouchSensor sensor) {
		return sensor.getTouchMode();
	}

	@Override
	protected boolean isAktiv(float wert) {
		if (wert == 1) {
			return true;
		}
		return false;
	}

}
