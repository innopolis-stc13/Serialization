import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException {
        Monkey monkey = new Monkey("Mother monkey", "Monkey zoo", 8, 40, 80, true);
        ConvertObjectToXML.convertToXML(monkey);
        Monkey monkeyFromXML = (Monkey) ConvertXMLToObject.XMLToObject("/src/MonkeyInfo.xml");
        System.out.println(monkey.equals(monkeyFromXML));
    }

}
