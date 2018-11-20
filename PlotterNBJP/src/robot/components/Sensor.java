package robot.components;

import lejos.hardware.sensor.BaseSensor;
import lejos.hardware.sensor.SensorMode;

public abstract class Sensor<T extends BaseSensor> {
	private float[] sample;
	private T sensor;
	private SensorMode sensorMode;

	public Sensor(T sensor) {
		this.sensor = sensor;
		this.sensorMode = this.getSensorMode(sensor);
		this.sample = new float[sensorMode.sampleSize()];
		this.kalibriere(getWert());
	}

	public void close() {
		sensor.close();
	}

	protected T getSensor() {
		return sensor;
	}

	protected abstract SensorMode getSensorMode(T sensor);

	private float getWert() {
		sensorMode.fetchSample(sample, 0);
		return sample[0];
	}

	public final boolean isAktiv() {
		return this.isAktiv(getWert());
	}

	protected abstract boolean isAktiv(float wert);

	protected void kalibriere(float wert) {
		// Hook
	};

}
