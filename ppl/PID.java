import legos.nxt.*;

public class PID {
    //This evens out the speed of motor regardless of payload, distance from axis, etc
    public static void main(String[] args) {
        NXTMotor right = new NXTMotor(MotorPort.4);

        int setSpeed = 10;
        long lastTime = System.currentTimeMillis();
        int lastError = 0;
        int output = 0;

        //tuning your PID controller
        double P = 2.0;
        double D = -0.1;

        while(!Button.ENTER.isDown()) {
            while(!Button.ESCAPE.isDown()) {
                long dTime = System.currentTimeMillis()  -lastTime;
                lastTime = System.currentTimeMillis();
                
                int degrees = right.getTachoCount(); //number of degrees motor has moved since last time
                right.resetTachoCount();

                int measuredSpeed = (int) (degrees / ((double)dTime / 1000.0));

                int error = setSpeed - measuredSpeed;
                int dError = error - lastError;
                lastError = error; //update last error to our current error

                output += p*error + D * dError;
                output = Math.min(100, Math.max(0, output));
                right.setPower(output);//set power on motor to equal output
            }
            right.stop();
        }
    }
}

