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
		for (int i = 0; i < ecke; i++) {
			Coordinate temp = EinheitsKreis.berechnePositionAufKreis(nDegree * i, this.getRadius());
			instructions.add(new Instruction(true, temp.getxCoord(), temp.getyCoord()));
		}
		Coordinate lastCor = EinheitsKreis.berechnePositionAufKreis(0, this.getRadius());
		instructions.add(new Instruction(true, lastCor.getxCoord(), lastCor.getyCoord()));
		return instructions;
	}

}
