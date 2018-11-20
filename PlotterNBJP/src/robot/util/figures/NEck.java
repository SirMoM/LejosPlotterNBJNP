package robot.util.figures;

import java.util.ArrayList;
import java.util.List;

import robot.components.Roboter;
import robot.util.Coordinate;
import robot.util.EinheitsKreis;
import robot.util.Instruction;

public class NEck extends GeoFig {

	private double degree;
	private int ecke;

	public NEck(double degree, Coordinate mittelpunkt, Roboter roboter, double radius, int ecke) {
		super(mittelpunkt, roboter, radius);
		this.degree = degree;
		this.ecke = ecke;
	}

	@Override
	public List<Instruction> getInstructionSet() {
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		int nDegree = 360 / ecke;
		Coordinate curCoor = new Coordinate(0, 0);
		Coordinate nextCoor = new Coordinate(getRadius(), 0);
		instructions.add(new Instruction(false, nextCoor.getxCoord(),nextCoor.getyCoord()));
		for (int i = 1; i <= ecke; i++) {
			curCoor = nextCoor;
			nextCoor = EinheitsKreis.berechnePositionAufKreis(curCoor, nDegree);
			Coordinate deltaCoor = new Coordinate(curCoor.getxCoord() - nextCoor.getxCoord(), curCoor.getyCoord() - nextCoor.getyCoord());
			
			instructions.add(new Instruction(true, deltaCoor.getxCoord(),deltaCoor.getyCoord()));
			
//			instructions.add(new Instruction(true, this.getRadius(),0));
//			Coordinate temp = EinheitsKreis.berechnePositionAufKreis(nDegree * i, this.getRadius());
//			instructions.add(new Instruction(true, temp.getxCoord(), temp.getyCoord()));
		}
		return instructions;
	}

}
