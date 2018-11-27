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
	
	public List<Instruction> getInstructionSet2(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		// goToMittelpunkt
		instructions.add(new Instruction(false, this.getMittelpunkt().getxCoord() - this.getRoboter().getCurrentCoordinate().getxCoord(), this.getMittelpunkt().getyCoord() - this.getRoboter().getCurrentCoordinate().getyCoord()));
		// Prepare the Drawing
		BigDecimal nDegree = new BigDecimal(360).divide(new BigDecimal(this.anzahlEcken));
		Coordinate curCoor = new Coordinate(0, 0);
		// First Coord of the Necks with the degree offset
		Coordinate nextCoor = EinheitsKreis.berechnePositionAufKreis(new Coordinate(this.getRadius(), 0), this.degree);
//		Coordinate nextCoor = EinheitsKreis.berechnePositionAufKreis(this.degree, this.getRadius());
		instructions.add(new Instruction(false,- nextCoor.getxCoord(), nextCoor.getyCoord()));
		System.out.println("deg: " + nDegree);
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
	
	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		// goToMittelpunkt
		instructions.add(new Instruction(false, this.getMittelpunkt().getxCoord() - this.getRoboter().getCurrentCoordinate().getxCoord(), this.getMittelpunkt().getyCoord() - this.getRoboter().getCurrentCoordinate().getyCoord()));
		// goToFirstPosition
		instructions.add(new Instruction(false, getRadius(), 0));
		
		Coordinate c = EinheitsKreis.berechnePositionAufKreis(360.0d / anzahlEcken, this.getRadius());
		final double schenkelLaenge = Math.sqrt(c.getxCoord() * c.getxCoord() + c.getyCoord() + c.getyCoord());
		
		Coordinate first = EinheitsKreis.berechnePositionAufKreis(((anzahlEcken-2)*180)-180, schenkelLaenge);
		instructions.add(new Instruction(true, first.getxCoord(), first.getyCoord()));
		
		for(int i=2; i<=anzahlEcken; i++) {
			Coordinate next = EinheitsKreis.berechnePositionAufKreis(360.0d / anzahlEcken * i, schenkelLaenge);
			instructions.add(new Instruction(true, next.getxCoord(), next.getyCoord()));
		}
		
		return instructions;
	}

}
