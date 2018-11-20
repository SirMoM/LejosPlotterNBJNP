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
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Quadrat extends GeoFig{

	private double sideLength;
	private double degree;
	private double radius;

	// TODO FERTIG IMPL
	public Quadrat(double sideLength, double degree, Coordinate mittelpunkt, Roboter roboter){
		super(mittelpunkt, roboter);
		this.sideLength = sideLength;
		this.degree = degree;
		this.radius = Math.sqrt(Math.pow(sideLength, 2) + Math.pow(sideLength, 2));
	}

	@Override
	public List<Instruction> getInstructionSet(){
		ArrayList<Instruction> instructions = new ArrayList<Instruction>();
		instructions.add(new Instruction(false, this.getRoboter().getCurrentCoordinate().getxCoord() - this.getMittelpunkt().getxCoord(), this.getRoboter().getCurrentCoordinate().getyCoord() - this.getMittelpunkt().getyCoord()));
		Coordinate turnCur = EinheitsKreis.berechnePositionAufKreis(this.degree, this.radius);
		instructions.add(new Instruction(false, -(this.sideLength / 2) + turnCur.getxCoord(), -(this.sideLength / 2) + turnCur.getyCoord()));
		instructions.addAll(new Line(new Coordinate(turnCur.getxCoord(), this.sideLength + turnCur.getyCoord())).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(this.sideLength + turnCur.getxCoord(), turnCur.getyCoord())).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(-turnCur.getxCoord(), -this.sideLength - turnCur.getyCoord())).getInstructionSet());
		instructions.addAll(new Line(new Coordinate(-this.sideLength - turnCur.getxCoord(), -turnCur.getyCoord())).getInstructionSet());
		instructions.add(new Instruction(false, 0, 0));
		return null;
	}

}
