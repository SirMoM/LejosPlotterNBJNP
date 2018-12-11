/**
 * 
 */
package robot.util.buchstaben;

import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.Instruction;
import robot.util.figures.GeoFig;

/**
 * @author Noah Ruben
 * @see <a href="https://github.com/SirMoM/LejosPlotterNBJNP">Github</a>
 */
public class Buchstabe extends GeoFig{

	public Buchstabe(Coordinate mittelpunkt, Roboter roboter){
		super(mittelpunkt, roboter);

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
