package JavaRobot;

public class RobotExt extends Robot
{
    public RobotExt(double x, double y, double course) {
        super(x, y);
        this.course = course;
    }

    public void back(int distance) {
        forward(-distance);
    }
     // Печать координат робота
    public void printCoordinates() {
        System.out.println(getX() + "," + getY() + "Это я переопределил метод");
    }
}
