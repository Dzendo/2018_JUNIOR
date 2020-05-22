package robotmanager11;
public class Robot
{
    private String name;
 
    public Robot(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "name=" + name;
    }
}