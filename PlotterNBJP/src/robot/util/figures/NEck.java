package robot.util.figures;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.EinheitsKreis;
import robot.util.Instruction;

public class NEck extends GeoFig{

	private double degree;
	private int anzahlEcken;
	private int percentToDraw;

	public NEck(double degree, Coordinate mittelpunkt, Roboter roboter, double radius, int anzahlEcken){
		super(mittelpunkt, roboter, radius);
		this.degree = degree;
		this.anzahlEcken = anzahlEcken;
		this.percentToDraw = 100;
	}

	public NEck(double degree, Coordinate mittelpunkt, Roboter roboter, double radius, int anzahlEcken,int percentToDraw){
		super(mittelpunkt, roboter, radius);
		this.degree = degree;
		this.anzahlEcken = anzahlEcken;
		this.percentToDraw = percentToDraw;
		
	}
	
	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		// goToMittelpunkt
		instructions.add(new Instruction(false, this.getMittelpunkt().getxCoord() - this.getRoboter().getCurrentCoordinate().getxCoord(), this.getMittelpunkt().getyCoord() - this.getRoboter().getCurrentCoordinate().getyCoord()));
		// Prepare the Drawing
		BigDecimal nDegree = new BigDecimal(360).divide(new BigDecimal(this.anzahlEcken));
		Coordinate curCoor = new Coordinate(0, 0);
		// First Coord of the Necks with the degree offset
		Coordinate nextCoor = EinheitsKreis.berechnePositionAufKreis(new Coordinate(this.getRadius(), 0), this.degree);
//		Coordinate nextCoor = EinheitsKreis.berechnePositionAufKreis(this.degree, this.getRadius());
		instructions.add(new Instruction(false, 0, nextCoor.getyCoord()));
		System.out.println("deg: " + nDegree);
		nextCoor = new Coordinate(nextCoor.getxCoord(), 0);
		for(int i = 1; i <= this.anzahlEcken * (percentToDraw/100); i++){
			curCoor = new Coordinate(nextCoor.getxCoord(), nextCoor.getyCoord());
			nextCoor = EinheitsKreis.berechnePositionAufKreis(curCoor, nDegree.doubleValue());
			Coordinate deltaCoor = new Coordinate(curCoor.getxCoord() - nextCoor.getxCoord(), curCoor.getyCoord() - nextCoor.getyCoord());
			instructions.add(new Instruction(true, deltaCoor.getxCoord(), deltaCoor.getyCoord()));

//			instructions.add(new Instruction(true, this.getRadius(),0));
//			Coordinate temp = EinheitsKreis.berechnePositionAufKreis(nDegree * i, this.getRadius());
//			instructions.add(new Instruction(true, temp.getxCoord(), temp.getyCoord()));
		}
		this.getRoboter().setCurrentCoordinate(nextCoor);
		return instructions;
	}

}
