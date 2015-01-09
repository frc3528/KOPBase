package org.usfirst.frc.team3528.robot;



/**
 *
 * 
 */
public class Utils {

    //A method used for smooth driving
    public static double rampSpeed(double input) {
        //auto set sensitivity to .5
        return rampSpeed(input, .5);
    }
    
    
    public static double rampSpeed(double input, double sensitivity) {

        if (IsInDeadband(input)) {
            return 0;
        }

        //formula for ramping: f(x) = ax^3 + (1-a)x where a is the sensitivity and x is the input
        return (sensitivity * input * input * input + (1 - sensitivity) * input);
    }
    
    
    private static boolean IsInDeadband(double input) {
        return input > -.1 && input < .1;
    }

    /*
    public static void printToDriverStation(String in) {
        v.addElement(in);
        String clear = "                      ";

        if (v.size() > lcdsize) {
            v.removeElementAt(0);
        } else {
            int add = lcdsize - v.size();

            for (int i = 0; i < add; i++) {
                v.addElement("");
            }
        }   

        dslcd.println(DriverStationLCD.Line.kUser1, 1, (String) v.elementAt(5) + clear);
        dslcd.println(DriverStationLCD.Line.kUser2, 1, (String) v.elementAt(4) + clear);
        dslcd.println(DriverStationLCD.Line.kUser3, 1, (String) v.elementAt(3) + clear);
        dslcd.println(DriverStationLCD.Line.kUser4, 1, (String) v.elementAt(2) + clear);
        dslcd.println(DriverStationLCD.Line.kUser5, 1, (String) v.elementAt(1) + clear);
        dslcd.println(DriverStationLCD.Line.kUser6, 1, (String) v.elementAt(0) + clear);

        dslcd.updateLCD();
    }


    public static void clearDriverStation() {
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
    }
    
    
    private static DriverStationLCD dslcd = DriverStationLCD.getInstance();
    private static Vector v = new Vector();
    private static int lcdsize = 6;
*/
}