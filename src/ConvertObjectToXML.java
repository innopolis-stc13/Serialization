import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.lang.reflect.Field;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertObjectToXML {

    public static void convertToXML(Object object) throws IOException {
        Document xml = new Document();
        Element root = new Element(object.getClass().getName());
        xml.setRootElement(root);
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Element name = new Element(field.getName());
                name.addContent(field.get(object).toString());
                root.addContent(name);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Format fmt = Format.getPrettyFormat();
        XMLOutputter serializer = new XMLOutputter(fmt);
        serializer.output(xml, System.out);
        serializer.output(xml, new FileOutputStream(new File(object.getClass().getName() + "Info.xml")));
    }
}