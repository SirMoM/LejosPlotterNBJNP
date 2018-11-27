
package robot.components;

import java.util.ArrayList;
import java.util.List;

import lejos.hardware.Sound;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import robot.util.Coordinate;
import robot.util.DisplayHandler;
import robot.util.Instruction;

/**
 * @author Rene Gerlach, Noah Ruben, Benjamin Wiehmann, Jean-Paul Edoh
 * @see <a href="https://github.com/SirMoM/LejosPlotterNBJNP">Github</a>
 */
public class Roboter{

	// TODO Use the ActualZahnraeder-Enum
	private final MultiPositionAchse xAchse = new MultiPositionAchse(new TouchSensor(SensorPort.S1), MotorPort.A, Einbaurichtung.UMGEKEHRT, new Reifen(40.0), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_KLEIN), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_GROSS)));
	private final MultiPositionAchse yAchse = new MultiPositionAchse(new LichtSensor(SensorPort.S2), MotorPort.B, Einbaurichtung.UMGEKEHRT, new Reifen(43.2), new Zahnradsatz(new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_KLEIN), new Zahnrad(Zahnrad.ANZAHL_ZAEHNE_GROSS)));
	private final DualPositionAchse zAchse = new DualPositionAchse(null, MotorPort.D, Einbaurichtung.REGULAER, null, null);

	private Coordinate currentCoordinate = new Coordinate(0, 0);

	private List<Instruction> instructionQ = new ArrayList<Instruction>();

	public Roboter(){
		DisplayHandler.writeFirstLine("NEW ROBOCOP");
		Sound.buzz();
	}

	/**
	 * @param instruction
	 */
	public void addToQ(Instruction instruction){
		this.instructionQ.add(instruction);
	}

	/**
	 * @param instructions
	 */
	public void addToQ(List<Instruction> instructions){
		this.instructionQ.addAll(instructions);
	}

	/**
	 * @return the currentCoordinate
	 */
	public Coordinate getCurrentCoordinate(){
		return this.currentCoordinate;
	}

	/**
	 * @return the XAchse of this robot
	 */
	public MultiPositionAchse getXAchse(){
		return this.xAchse;
	}

	/**
	 * @return the YAchse
	 */
	public MultiPositionAchse getYAchse(){
		return this.yAchse;
	}

	/**
	 * @return the zAchse
	 */
	public DualPositionAchse getZAchse(){
		return this.zAchse;
	}

	// TODO TEST THIS
	public void goToStartPos(){
		this.goToXNull();
		this.goToYNull();
	}

	// TODO TEST THIS
	public void goToXNull(){
		while (!this.xAchse.getSensor().isAktiv()){
			this.xAchse.forward();
		}

		this.xAchse.rotateMm(-100);
		this.xAchse.stop();
		this.currentCoordinate.setxCoord(0);
	}

	// TODO TEST THIS
	public void goToYNull(){
		while (!this.yAchse.getSensor().isAktiv()){
			this.yAchse.forward();
		}
		this.yAchse.stop();
		this.currentCoordinate.setyCoord(0);
	}

	/**
	 * Call this to tell the robot to execute all instructions.
	 */
	public void processInstructions(){
		this.instructionQ.add(new Instruction(false, 0, 0, 0));
		while (this.hasNextInstruction()){
			DisplayHandler.drawProgressbar(this.instructionQ.size());
			DisplayHandler.writeCurrentCoordinate(this.currentCoordinate);
			this.processInstruction(this.nextInstruction());
		}
	}

	/**
	 * Stops all Achsen
	 */
	public void stop(){
		this.xAchse.stop();
		this.yAchse.stop();
		this.zAchse.stop();
	}

	// TODO TEST THIS
	public void wrapUp() throws Throwable{

		while (!this.yAchse.getSensor().isAktiv()){
			this.yAchse.forward();
		}
		this.yAchse.stop();
		this.finalize();
	}

	/**
	 * @return if there is a Instruction left in the Q.
	 */
	private boolean hasNextInstruction(){
		return !this.instructionQ.isEmpty();
	}

	/**
	 * This Deletes the Instruction it returns from the Q.
	 * 
	 * @return the next Instruction
	 */
	private Instruction nextInstruction(){
		Instruction instruction = this.instructionQ.get(0);
		this.instructionQ.remove(0);
		return instruction;
	}

	/**
	 * Processes one Instruction.
	 * 
	 * @param instruction the Instruction to process.
	 */
	private void processInstruction(Instruction instruction){
		this.getXAchse().getMotor().setAcceleration(Integer.MAX_VALUE);
		this.getYAchse().getMotor().setAcceleration(Integer.MAX_VALUE);

		// TODO the sync should be possible in the MultipositionsAchse
		this.xAchse.getMotor().synchronizeMotor(this.getYAchse().getMotor());

		// TODO TEST IF I FIXED THIS
		if(instruction.isPenDown()){
			this.getZAchse().aktiviere();
		} else{
			this.getZAchse().deaktiviere();
		}

		final int gradToTurnIntX = this.getXAchse().gradToTurnInt(instruction.getxVectorLen() * -1);
		final int gradToTurnIntY = this.getYAchse().gradToTurnInt(instruction.getyVectorLen());

		this.getXAchse().setSpeed((int) (gradToTurnIntX / instruction.getTime()));
		this.getYAchse().setSpeed((int) (gradToTurnIntY / instruction.getTime()));

		this.getXAchse().getMotor().startSync();

		this.getXAchse().rotateDegree(gradToTurnIntX * -1);
		this.getYAchse().rotateDegree(gradToTurnIntY * -1);

		this.getXAchse().getMotor().endSync();
		this.getXAchse().waitComplete();
		this.getYAchse().waitComplete();

		// TODO TEST THIS
		this.currentCoordinate.moveCoordinates(instruction.getxVectorLen(), instruction.getyVectorLen());
		DisplayHandler.writeCurrentCoordinate(this.currentCoordinate);
		// TODO end sync here
	}

	/**
	 * @param currentCoordinate the currentCoordinate to set
	 */
	private void setCurrentCoordinate(Coordinate currentCoordinate){
		this.currentCoordinate = currentCoordinate;
	}

	@Override // TODO Ask what this does
	protected void finalize() throws Throwable{
		super.finalize();
		System.exit(0);
	}

}
