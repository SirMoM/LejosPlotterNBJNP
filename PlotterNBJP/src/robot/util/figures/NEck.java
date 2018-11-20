package robot.util.figures;

import java.util.ArrayList;
import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.EinheitsKreis;
import robot.util.Instruction;

public class NEck extends GeoFig{

	private double degree;
	private int anzahlEcken;

	public NEck(double degree, Coordinate mittelpunkt, Roboter roboter, double radius, int anzahlEcken){
		super(mittelpunkt, roboter, radius);
		this.degree = degree;
		this.anzahlEcken = anzahlEcken;
	}

	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		int nDegree = 360 / this.anzahlEcken;
		Coordinate curCoor = new Coordinate(0, 0);
		Coordinate nextCoor = new Coordinate(this.getRadius(), 0);
		instructions.add(new Instruction(false, 0, nextCoor.getyCoord()));
		System.out.println("deg: " + nDegree);
		for(int i = 1; i <= this.anzahlEcken; i++){
			curCoor = new Coordinate(nextCoor.getxCoord(), nextCoor.getyCoord());
			nextCoor = EinheitsKreis.berechnePositionAufKreis(curCoor, nDegree);
			Coordinate deltaCoor = new Coordinate(curCoor.getxCoord() - nextCoor.getxCoord(), curCoor.getyCoord() - nextCoor.getyCoord());

			instructions.add(new Instruction(true, deltaCoor.getxCoord(), deltaCoor.getyCoord()));

//			instructions.add(new Instruction(true, this.getRadius(),0));
//			Coordinate temp = EinheitsKreis.berechnePositionAufKreis(nDegree * i, this.getRadius());
//			instructions.add(new Instruction(true, temp.getxCoord(), temp.getyCoord()));
		}

		return instructions;
	}

}
