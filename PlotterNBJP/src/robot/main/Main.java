package robot.main;

import lejos.hardware.Sound;
import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.DisplayHandler;
import robot.util.figures.Quadrat;

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
		Quadrat quadrat = new Quadrat(20, 0, new Coordinate(50, 50), roboter);
		roboter.addToQ(quadrat.getInstructionSet());
		roboter.processInstructions();

	}
}