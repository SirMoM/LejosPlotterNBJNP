/**
 * 
 */
package robot.util.figures;

import java.util.ArrayList;
import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.EinheitsKreis;
import robot.util.Instruction;

/**
 * @author jean-
 *
 */
public class SternGerade2 extends GeoFig{
	
	private double degree;
	private int testAnzahlEcken1 = 3;
	private GeoFig erstesDreieck;
	private GeoFig zweitesDreieck;
 	/**
	 * 
	 */
	public SternGerade2(double degree, Coordinate mittelpunkt, Roboter roboter, double radius){
		super(mittelpunkt, roboter, radius);
		erstesDreieck = new NEck(degree, mittelpunkt, roboter, radius, testAnzahlEcken1);
		zweitesDreieck = new NEck(degree+180.0, mittelpunkt, roboter, radius, testAnzahlEcken1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Instruction> getInstructionSet() {
		// TODO Auto-generated method stub
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		instructions.addAll(erstesDreieck.getInstructionSet());
		instructions.addAll(zweitesDreieck.getInstructionSet());
		return instructions;
	}

}
