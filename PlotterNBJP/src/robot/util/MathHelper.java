package robot.util;

/**
 * @author Rene Gerlach
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public class MathHelper{
	public static double getHypothenuse(Coordinate p1, Coordinate p2){
		double deltaX = p1.getxCoord() - p2.getxCoord();
		double deltaY = p1.getyCoord() - p2.getyCoord();
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}
}
