package robot.main;

import lejos.hardware.Sound;
import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.DisplayHandler;
import robot.util.figures.Line;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Main{

	public static void main(String args[]) throws Exception, Throwable{
		Roboter roboter = new Roboter(); // throws Exception
		Sound.beepSequenceUp();
		roboter.goToStartPos();
		Sound.beepSequence();
		DisplayHandler.writeCurrentCoordinate(roboter.getCurrentCoordinate());
		Line line = new Line(new Coordinate(10, 10));
		roboter.addToQ(line.getInstructionSet());
		roboter.processInstructions();

	}
}