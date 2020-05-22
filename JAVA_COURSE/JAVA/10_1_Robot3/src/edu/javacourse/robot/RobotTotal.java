package edu.javacourse.robot;

public class RobotTotal extends Robot
{
    // Вводим поле дляхранения пройденной дистанции
    private double totalDistance = 0;

    // перегруженный конструктор
    public RobotTotal() {
        super(0, 0);
    }
    
    // Конструктор тоже надо переопределить
    public RobotTotal(double x, double y) {
        super(x, y);
    }

    @Override
    public void forward(int distance) {
        // Вызов нашего метода у класса предка.
        // Нужно указать зарезервированное слово super
       totalDistance += distance;
        super.forward(distance);
        System.out.println("RobotTotal");
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
