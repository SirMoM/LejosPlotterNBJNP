/**
 * 
 */
package robot.util;

/**
 * @author Noah Ruben, Benjamin Wiemann, J-P Edoh
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class Instruction{

	private boolean isPenDown;

	private double xVectorLen;
	private double yVectorLen;
	private double time;

	/**
	 * @param isPenDown
	 * @param xVectorLen
	 * @param yVectorLen
	 */
	public Instruction(boolean isPenDown, double xVectorLen, double yVectorLen){
		this(isPenDown, xVectorLen, yVectorLen, Math.sqrt(xVectorLen * xVectorLen + yVectorLen * yVectorLen) / 10);
	}

	/**
	 * @param isPenDown
	 * @param xVectorLen
	 * @param yVectorLen
	 */
	public Instruction(boolean isPenDown, double xVectorLen, double yVectorLen, double mmSec){
		this.isPenDown = isPenDown;
		this.xVectorLen = xVectorLen;
		this.yVectorLen = yVectorLen;
		this.time = mmSec;
	}

	public double getTime(){
		return this.time;
	}

	/**
	 * @return the xVectorLen
	 */
	public double getxVectorLen(){
		return this.xVectorLen;
	}

	/**
	 * @return the yVectorLen
	 */
	public double getyVectorLen(){
		return this.yVectorLen;
	}

	/**
	 * @return the isPenDown
	 */
	public boolean isPenDown(){
		return this.isPenDown;
	}

	/**
	 * @param isPenDown the isPenDown to set
	 */
	public void setPenDown(boolean isPenDown){
		this.isPenDown = isPenDown;
	}

	/**
	 * @param xVectorLen the xVectorLen to set
	 */
	public void setxVectorLen(double xVectorLen){
		this.xVectorLen = xVectorLen;
	}

	/**
	 * @param yVectorLen the yVectorLen to set
	 */
	public void setyVectorLen(double yVectorLen){
		this.yVectorLen = yVectorLen;
	}

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Instruction: isPenDown=");
		builder.append(this.isPenDown);
		builder.append(", xVectorLen=");
		builder.append(this.xVectorLen);
		builder.append(", yVectorLen=");
		builder.append(this.yVectorLen);
		return builder.toString();
	}

}
