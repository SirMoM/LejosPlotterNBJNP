package robot.components;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;

public class Motor{

	private Einbaurichtung einbaurichtung;

	private RegulatedMotor regulatedMotor;

	public Motor(Port port, Einbaurichtung einbaurichtung){
		this.regulatedMotor = new EV3LargeRegulatedMotor(port);
		this.einbaurichtung = einbaurichtung;
	}

	public void backward(){
		if(this.einbaurichtung == Einbaurichtung.UMGEKEHRT){
			this.regulatedMotor.forward();
			return;
		}
		this.regulatedMotor.backward();
	}

	public void endSync(){
		this.regulatedMotor.endSynchronization();
	}

	public void forward(){
		if(this.einbaurichtung == Einbaurichtung.UMGEKEHRT){
			this.regulatedMotor.backward();
			return;
		}
		this.regulatedMotor.forward();
	}

	public int getTachoCount(){
		return this.regulatedMotor.getTachoCount();
	}

	public void resetTachoCount(){
		this.regulatedMotor.resetTachoCount();
	}

	public void rotate(int grad){
		this.regulatedMotor.rotate(grad);
	}

	public void rotateTo(int limitAngle){
		this.regulatedMotor.rotateTo(limitAngle);

	}

	public void setAcceleration(int acceleration){
		this.regulatedMotor.setAcceleration(acceleration);
	}

	public void setSpeed(int speed){
		this.regulatedMotor.setSpeed(speed);
	}

	public void startSync(){
		this.regulatedMotor.startSynchronization();

	}

	public void stop(){
		this.regulatedMotor.stop();
	}

	public void synchronizeMotor(Motor motor){
		RegulatedMotor[] motors = { motor.regulatedMotor };
		this.regulatedMotor.synchronizeWith(motors);
	}

	@Override
	protected void finalize() throws Throwable{
		super.finalize();
		this.regulatedMotor.close();
	}

	protected Einbaurichtung getEinbaurichtung(){
		return this.einbaurichtung;
	}

	protected void waitComplete(){
		this.regulatedMotor.waitComplete();
	}

}
