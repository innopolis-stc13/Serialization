import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.ContentFilter;
import org.jdom2.input.SAXBuilder;
import javax.lang.model.util.ElementFilter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class ConvertXMLToObject {

    public static Object XMLToObject(String path) {
        Object object = null;
        SAXBuilder parser = new SAXBuilder();
        Document xmlDoc;
        try {
            xmlDoc = parser.build(new File("/Users/maksim/IdeaProjects/deSerialize/MonkeyInfo.xml"));
            Class clazz = Class.forName(xmlDoc.getRootElement().getName());
            object = clazz.newInstance();
            List<Element> elements = xmlDoc.getRootElement().getChildren();
            for (Element element : elements) {
                Field field = clazz.getDeclaredField(element.getName());
                field.setAccessible(true);
                switch (field.getType().getName()) {
                    case "boolean": {
                        field.setBoolean(object, Boolean.valueOf(element.getValue()));
                        break;
                    }
                    case "java.lang.String": {
                        field.set(object, element.getValue());
                        break;
                    }
                    case "byte": {
                        field.setByte(object, Byte.valueOf(element.getValue()));
                        break;
                    }
                    case "char": {
                        field.setChar(object, Character.valueOf(element.getValue().charAt(0)));
                        break;
                    }
                    case "double": {
                        field.setDouble(object, Double.valueOf(element.getValue()));
                        break;
                    }
                    case "float": {
                        field.setFloat(object, Float.valueOf(element.getValue()));
                        break;
                    }
                    case "int": {
                        field.setInt(object, Integer.valueOf(element.getValue()));
                        break;
                    }
                    case "long": {
                        field.setLong(object, Long.valueOf(element.getValue()));
                        break;
                    }
                    case "short": {
                        field.setShort(object, Short.valueOf(element.getValue()));
                        break;
                    }
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return object;
    }
}
