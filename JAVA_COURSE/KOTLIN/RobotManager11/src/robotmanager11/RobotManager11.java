/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotmanager11;

/**
 *
 * @author LV
 */
public class RobotManager11
{
    public static void main(String[] args) {
        Robot robot1 = new Robot("Test Robot 1");
        Robot robot2 = new Robot("Test Robot 2");
        System.out.println(robot1.toString());
        System.out.println(robot2.toString());
    }
}