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
	private double radius;
	
	public GeoFig(){
	}

	/**
	 * @param mittelpunkt
	 */
	public GeoFig(Coordinate mittelpunkt, Roboter roboter){
		this.mittelpunkt = mittelpunkt;
	
		this.roboter = roboter;
	}

	public GeoFig(Coordinate mittelpunkt, Roboter roboter, double radius){
		this.mittelpunkt = mittelpunkt;
		this.roboter = roboter;
		this.radius = radius;
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
	public Roboter getRoboter() {
		return roboter;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @param roboter the roboter to set
	 */
	public void setRoboter(Roboter roboter) {
		this.roboter = roboter;
	}

	/**
	 * @param mittelpunkt the mittelpunkt to set
	 */
	public void setMittelpunkt(Coordinate mittelpunkt){
		this.mittelpunkt = mittelpunkt;
	}

}