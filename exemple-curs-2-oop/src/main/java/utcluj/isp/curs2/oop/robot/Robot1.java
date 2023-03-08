package utcluj.isp.curs2.oop.robot;

/**
 * A simple class.
 */
public class Robot1 {

    public int name;
    public int position;

    public static void main(String[] args) {
        Robot1 robot = new Robot1();
        robot.name = 1234;
        robot.position = 0;
        System.out.println("Robot name: " + robot.name);
        System.out.println("Robot position: " + robot.position);
    }
}
