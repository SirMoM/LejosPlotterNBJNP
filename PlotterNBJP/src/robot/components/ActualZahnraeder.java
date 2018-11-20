/**
 * 
 */
package robot.components;

/**
 * @author Noah Ruben
 * @see <a href="https://github.com/SirMoM/SoftwaretechnikAufgaben">Github</a>
 */
public enum ActualZahnraeder{
	GROSS(new Zahnrad(36)),
	MITTEL(new Zahnrad(24)),
	KLEIN(new Zahnrad(12));

	final Zahnrad zahnrad;

	private ActualZahnraeder(Zahnrad zahnrad){
		this.zahnrad = zahnrad;
	}

}
