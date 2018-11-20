/**
 * 
 */
package robot.util;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Coordinate{

	private double xCoord;
	private double yCoord;

	/**
	 * @param xCoord the xPos
	 * @param yCoord the yPos
	 */
	public Coordinate(double xCoord, double yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	/**
	 * @return the xCoord
	 */
	public double getxCoord(){
		return this.xCoord;
	}

	/**
	 * @return the yCoord
	 */
	public double getyCoord(){
		return this.yCoord;
	}

	/**
	 * @param xCoord the xPos to move
	 * @param yCoord the yPos to move
	 */
	public void moveCoordinates(double moveXBy, double moveYBy){
		this.xCoord = this.xCoord + moveXBy;
		this.yCoord = this.yCoord + moveYBy;
	}

	/**
	 * @param xCoord the xPos to set
	 * @param yCoord the yPos to set
	 */
	public void setCoordinates(double xCoord, double yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoord(double xCoord){
		this.xCoord = xCoord;
	}

	/**
	 * @param yCoord the yCoord to set
	 */
	public void setyCoord(double yCoord){
		this.yCoord = yCoord;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Coordinate [xCoord=");
		builder.append(this.xCoord);
		builder.append(", yCoord=");
		builder.append(this.yCoord);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @param xCoord
	 * @param yCoord
	 */
	public void update(double xCoord, double yCoord){
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

}
