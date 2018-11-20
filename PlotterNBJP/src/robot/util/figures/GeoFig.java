/**
 * 
 */
package robot.util.figures;

import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.Instruction;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public abstract class GeoFig{

	private Coordinate mittelpunkt;
	private Roboter roboter;

	public GeoFig(){
	}

	/**
	 * @param mittelpunkt
	 */
	public GeoFig(Coordinate mittelpunkt, Roboter roboter){
		this.mittelpunkt = mittelpunkt;
		this.roboter = roboter;
	}

	/**
	 * @return A list of Instructions which determine what the Robot has does.
	 */
	public abstract List<Instruction> getInstructionSet();

	/**
	 * @return the mittelpunkt
	 */
	public Coordinate getMittelpunkt(){
		return this.mittelpunkt;
	}

	/**
	 * @return the roboter
	 */
	public Roboter getRoboter(){
		return this.roboter;
	}

	/**
	 * @param mittelpunkt the mittelpunkt to set
	 */
	public void setMittelpunkt(Coordinate mittelpunkt){
		this.mittelpunkt = mittelpunkt;
	}

	/**
	 * @param roboter the roboter to set
	 */
	public void setRoboter(Roboter roboter){
		this.roboter = roboter;
	}

}