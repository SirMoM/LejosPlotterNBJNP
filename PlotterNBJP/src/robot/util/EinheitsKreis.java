/**
 * 
 */
package robot.util;

/**
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 *      Zur Visualisierung: https://www.matheretter.de/rechner/trigonometrie
 * 
 * @author phitschi
 *
 */
public class EinheitsKreis{

	/**
	 * Fuehrt Berechnungen ueber den Einheitskreis aus. Hier wird von einer
	 * gegebenen Position im Einheitskreis ausgegangen.Es ist darauf zu achten, dass
	 * ein positiver Winkel eine Drehung im Gegenuhrzeigersinn betrachtet.
	 * 
	 * @param winkelInGradImGegenuhrzeigersinn
	 * @param radius
	 * @return
	 */
	public static Coordinate berechnePositionAufKreis(Coordinate positionImEinheitskreis, double drehungInGradImGegenuhrzeigersinn){
		final double radius = MathHelper.getHypothenuse(new Coordinate(0, 0), positionImEinheitskreis);
		final double gradDerPositionImEinheitskreis = Math.toDegrees(Math.acos(positionImEinheitskreis.getxCoord() / radius));
		final double gradAbsolut = gradDerPositionImEinheitskreis + drehungInGradImGegenuhrzeigersinn;
		double xBerechnet = Math.cos(Math.toRadians(gradAbsolut)) * radius;
		double yBerechnet = Math.sin(Math.toRadians(gradAbsolut)) * radius;
		return new Coordinate(xBerechnet, yBerechnet);
	}

	/**
	 * Fuehrt Berechnungen ueber den Einheitskreis aus. Hierbei wird von einem
	 * Startwinkel von 0 ausgegangen. Es ist darauf zu achten, dass ein positiver
	 * Winkel eine Drehung im Gegenuhrzeigersinn betrachtet.
	 * 
	 * @param winkelInGradImGegenuhrzeigersinn
	 * @param radius
	 * @return
	 */
	public static Coordinate berechnePositionAufKreis(double winkelInGradImGegenuhrzeigersinn, double radius){
		double x = Math.cos(Math.toRadians(winkelInGradImGegenuhrzeigersinn)) * radius;
		double y = Math.sin(Math.toRadians(winkelInGradImGegenuhrzeigersinn)) * radius;
		return new Coordinate(x, y);
	}

}
