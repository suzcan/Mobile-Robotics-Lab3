import lejos.nxt.*;
import lejos.robotics.navigation.*;

class Robot {
  private DifferentialPilot pilot;
  private Navigator navbot;

  public Robot() {
    //set up the robot
    pilot = new DifferentialPilot(5.0, 17.5, Motor.A, Motor.B);
    //set up the navigator
    navbot = new Navigator(pilot);
  }
  
  public void moveTo(Node n) {
    this.navbot.goTo(n.xPos, n.yPos);
    this.navbot.waitForStop();
  }
  
}
