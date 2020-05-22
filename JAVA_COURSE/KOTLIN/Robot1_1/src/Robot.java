public class Robot
{
    // Текущая координата X
    private double x = 0;
    // Текущая координата Y
    private double y = 0;
    // Текущий курс (в градусах)
    private double course = 0;
    
    public static void main(String[] args) {   // Тестовый вызов
        // Создаем объекта класса Robot - теперь с параметрами
       
        Robot robot = new Robot(20, 20);
         
        // Вперед на 20 метров
        robot.forward(20);
        // Напечатать координаты
        robot.printCoordinates();
 
        // Это более корректный способ менять курс.
        // Реализация внутри робота не сильно отличается, но
        // мы в любой момент сможем сделать более продвинутую версию
        // Но класс RobotManager об этом даже не узнает
        robot.setCourse(90);
        // Вперед на 20 метров
        robot.forward(20);
        // Напечатать координаты
        robot.printCoordinates();
 
        // Курс 45 градусов
        robot.setCourse(45);
        // Вперед на 20 метров
        robot.forward(20);
        // Напечатать координаты
        robot.printCoordinates();
    }
 
    // Теперь конструктор выполняет присваивание. Это удобно.
    public Robot(double x, double y) {
        this.x = x;
        this.y = y;
    }
 
    // Передвижение на дистанцию distance
    public void forward(int distance) {
        // Обращение к полю объекта X
        x = x + distance * Math.cos(course / 180 * Math.PI);
        // Обращение к полю объекта Y
        y = y + distance * Math.sin(course / 180 * Math.PI);
    }
 
    // Печать координат робота
    public void printCoordinates() {
        System.out.println(x + "," + y);
    }
 
    public double getX() {
        return x;
    }
 
    public double getY() {
        return y;
    }
 
    public double getCourse() {
        return course;
    }
 
    public void setCourse(double course) {
        this.course = course;
    }
}