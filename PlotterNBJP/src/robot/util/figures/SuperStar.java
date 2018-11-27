/**
 * 
 */
package robot.util.figures;

import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.Instruction;

/**
 * @author Noah Ruben
 * @see <a href="https://github.com/SirMoM/LejosPlotterNBJNP">Github</a>
 */
public class SuperStar extends GeoFig{

	/**
	 * @param mittelpunkt
	 * @param roboter
	 */
	public SuperStar(Coordinate mittelpunkt, Roboter roboter){
		super(mittelpunkt, roboter);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mittelpunkt
	 * @param roboter
	 * @param radius
	 */
	public SuperStar(Coordinate mittelpunkt, Roboter roboter, double radius){
		super(mittelpunkt, roboter, radius);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.util.figures.GeoFig#getInstructionSet()
	 */
	@Override
	public List<Instruction> getInstructionSet(){
		// TODO Auto-generated method stub
		return null;
	}

}
