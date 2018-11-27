/**
 * 
 */
package robot.util;

import lejos.hardware.lcd.LCD;

/**
 * @author Noah Ruben
 * @see <a href="https://github.com/SirMoM/LejosPlotterNBJNP">Github</a>
 */
public class DisplayHandler{

	// TODO would be nice to show what is drawn ?
	public static void drawLineSymbol(){

	}

	public static void drawProgressbar(int countOfInstructionsToProzess){
		LCD.clear();
		for(int i = 5; i < countOfInstructionsToProzess * 11; i += 11){
			drawBlock(i, 50);
		}

		for(int j = 0; j < countOfInstructionsToProzess; j++){

		}

	}

	public static int writeCurrentCoordinate(Coordinate coordinate){
		return DisplayHandler.writeCurrentCoordinate(coordinate.getxCoord(), coordinate.getyCoord());
	}

	/**
	 * @param xPos the current x-Position of the Robot
	 * @param yPos the current y-Position of the Robot
	 * @return the length of the string to display.
	 */
	public static int writeCurrentCoordinate(double xPos, double yPos){
		String drawCurrentCoordinateString = String.format("Pos: (%.2f, %.2f)", xPos, yPos);
		LCD.clear();
		LCD.drawString(drawCurrentCoordinateString, 0, (int) (LCD.DISPLAY_CHAR_DEPTH * 0.25));
		return drawCurrentCoordinateString.length();
	}

	/**
	 * This overrides the first line of the display.
	 * 
	 * @param whatToWrite the string to write every char that exceeds the limit of
	 *                    17 will be cut off
	 */
	public static void writeFirstLine(String whatToWrite){
		if(whatToWrite.length() <= LCD.DISPLAY_CHAR_WIDTH){
			LCD.drawString(whatToWrite, 0, 1);
		} else{
			LCD.drawString(whatToWrite.substring(0, 16), 0, 0);
		}
	}

	private static void drawBlock(int xPosDisplay, int yPosDisplay){
		for(int x = xPosDisplay; x < xPosDisplay + 10; x++){
			for(int y = yPosDisplay; y < yPosDisplay + 10; y++){
				LCD.setPixel(x, y, 1);
			}
		}
	}

}
