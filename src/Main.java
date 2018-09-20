import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        Monkey monkey = new Monkey("Mother monkey", "Monkey zoo", 8, 40, 80, true);
        Serialization.convertObjectToXML(monkey);
        Monkey monkeyFromXML = (Monkey) Serialization.convertXMLToObject("/src/MonkeyInfo.xml");
        System.out.println(monkey.equals(monkeyFromXML));
    }

}
