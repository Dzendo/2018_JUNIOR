public class RobotManager
{
 
    public static void main(String[] args) {
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
}
