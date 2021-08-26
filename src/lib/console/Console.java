package lib.console;

import java.util.Scanner;

public class Console{
    public int yLineCount;
    public Console(){

    }

    /**
     * 	Use this to calibrate the number of line;
     */
    public void calibrate() {
        System.out.println("Calibrating the Y axis...");
        boolean isNotCalibrated = true;
        while (isNotCalibrated) {
            for (int y = 256; y >= 0; y--) {
                System.out.println(y);
            }
            System.out.print("What is the highest number you can see?: ");
            Scanner myScanner = new Scanner(System.in);
            try {
                yLineCount = myScanner.nextInt();
                isNotCalibrated = 0 > yLineCount || yLineCount > 256;
                yLineCount++;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    // Clear the console

    /**
     * Use this to clear the console
     */
    public void clear(){
        for (int y = 0;  y < yLineCount; y++) {
            System.out.println();
        }
    }

    /**
     * Time lol func
     */
    public void delay(long time){
        long targetTime = System.currentTimeMillis() + time;
        long currentTime = System.currentTimeMillis();
        while(targetTime >= currentTime) {
            currentTime = System.currentTimeMillis();
        }
    }
}
