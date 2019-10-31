
import lejos.nxt.*;
import lejos.robotics.navigation.*;

public class RobotLabNav {

  public static void main(String[] args) {

      DifferentialPilot pilot;
      Navigator navbot;

      pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.C);
      navbot = new Navigator(pilot);

      LCD.clear();
      LCD.drawInt(50, 0, 0);
      LCD.drawInt(50, 5, 0);

      // Robot keeps track of its location
      //Waypoint wp1 = addWaypoint(20, 20);
      // Turns around and tries to go back to 10 10
      //Waypoint wp2 = addWaypoint(10, 10);
      
      // 50 is too much for the short cable
      // 30 is too long as well
      Waypoint a = addWaypoint(0, 0);
      Waypoint auxA = addWaypoint(-10, -10);
      Waypoint b = addWaypoint(10, 10);
      Waypoint c = addWaypoint(-10, 10);
    
      //navbot.goTo(wp1);
      //navbot.goTo(wp2);
      
      
      navbot.goTo(b);
      navbot.waitForStop();
      navbot.goTo(a);
      //navbot.goTo(c);
      //navbot.goTo(a);
      navbot.waitForStop();

  }
  
  public static Waypoint addWaypoint(float x, float y) {
      return new Waypoint(x, y);
  }//end class main
}//end RobotLabNav
