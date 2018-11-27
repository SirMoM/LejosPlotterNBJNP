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
public class SternGerade extends GeoFig{
	
	private double degree;
	private int testAnzahlEcken1 = 3;
 	/**
	 * 
	 */
	public SternGerade(double degree, Coordinate mittelpunkt, Roboter roboter, double radius){
		super(mittelpunkt, roboter, radius);
		this.degree = degree;
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Instruction> getInstructionSet() {
		// TODO Auto-generated method stub
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		int nDegree1 = 360 / testAnzahlEcken1;
		Coordinate curCoor = new Coordinate(0, 0);
		Coordinate nextCoor = EinheitsKreis.berechnePositionAufKreis(new Coordinate(getRadius(),0), this.degree);
		instructions.add(new Instruction(false, 0, nextCoor.getyCoord()));
		System.out.println("deg1: " + nDegree1);
		for(int i = 1; i <= this.testAnzahlEcken1; i++){
			curCoor = new Coordinate(nextCoor.getxCoord(), nextCoor.getyCoord());
			nextCoor = EinheitsKreis.berechnePositionAufKreis(curCoor, nDegree1);
			Coordinate deltaCoor = new Coordinate(curCoor.getxCoord() - nextCoor.getxCoord(), curCoor.getyCoord() - nextCoor.getyCoord());
			instructions.add(new Instruction(true, deltaCoor.getxCoord(), deltaCoor.getyCoord()));
			}
		// goToMittelpunkt
				instructions.add(new Instruction(false,
				this.getMittelpunkt().getxCoord() - this.getRoboter().getCurrentCoordinate().getxCoord(),
				this.getMittelpunkt().getyCoord() - this.getRoboter().getCurrentCoordinate().getyCoord()));
		
		//secondStep --> falsche Verschiebung
		Coordinate nextCoor2 = EinheitsKreis.berechnePositionAufKreis(new Coordinate(getRadius(),0), this.degree+180.0);
		instructions.add(new Instruction(false, 0, nextCoor2.getyCoord()));
		System.out.println("deg1: " + nDegree1);
		for(int i = 1; i <= this.testAnzahlEcken1; i++){
			curCoor = new Coordinate(nextCoor2.getxCoord(), nextCoor2.getyCoord());
			nextCoor2 = EinheitsKreis.berechnePositionAufKreis(curCoor, nDegree1);
			Coordinate deltaCoor = new Coordinate(curCoor.getxCoord() - nextCoor2.getxCoord(), curCoor.getyCoord() - nextCoor2.getyCoord());
			instructions.add(new Instruction(true, deltaCoor.getxCoord(), deltaCoor.getyCoord()));
			}
		return instructions;
	}

}
