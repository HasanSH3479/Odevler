package frc.robot;

public final class Constants {
    

    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
    
    public static final int ROLLER_FORWARD_BUTTON = 1;
    public static final int ROLLER_REVERSE_BUTTON = 2;


    public static final int LEFT_MOTOR_1_ID = 0;
    public static final int LEFT_MOTOR_2_ID = 1;
    public static final int RIGHT_MOTOR_1_ID = 2;
    public static final int RIGHT_MOTOR_2_ID = 3;
    public static final int ROLLER_MOTOR_ID = 4;

 
    public static final boolean LEFT_MOTORS_INVERTED = false;
    public static final boolean RIGHT_MOTORS_INVERTED = true;
    public static final boolean ROLLER_MOTOR_INVERTED = false;

    public static final int MOTOR_CURRENT_LIMIT = 40; 


    public static final double MAX_DRIVE_SPEED = 1.0; 
    public static final double TURN_SPEED = 0.6; 


    public static final double WHEEL_DIAMETER_METERS = 0.1524; 
    public static final double ENCODER_COUNTS_PER_REV = 4096.0; 
    public static final double DISTANCE_PER_PULSE = 
        (Math.PI * WHEEL_DIAMETER_METERS) / ENCODER_COUNTS_PER_REV;

   
    public static final double ROLLER_SPEED = 0.5;
    public static final double ROLLER_REVERSE_SPEED = -0.5;

  
    public static final double AUTO_TAXI_TIME = 8.0;  
    public static final double AUTO_ROLLER_TIME = 3.0; 

   
    public static final double ROLLER_PID_P = 0.1;
    public static final double ROLLER_PID_I = 0.0;
    public static final double ROLLER_PID_D = 0.0;

}
