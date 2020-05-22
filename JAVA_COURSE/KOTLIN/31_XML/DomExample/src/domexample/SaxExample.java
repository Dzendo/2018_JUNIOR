package domexample;
 
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class SaxExample {
 
    public static void main(String args[]) {
 
        // ��� �����
        final String fileName = "Phonebook.xml";
 
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
 
            // ����� �� ���������� ��������� �����, ����������� ����� DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // ���� ��� ��������, ��� ��� NAME �������
                boolean name = false;
 
                // ����� ���������� ����� SAXParser "����������" �� ������ ����
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // ���� ��� ����� ��� NAME, �� �� ���� ������ �������� - ������� ��� NAME
                    if (qName.equalsIgnoreCase("NAME")) {
                        name = true;
                    }
                }
 
                // ����� ���������� ����� SAXParser ��������� ����� ����� ������
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // ���� ����� ���� �� ��������, ��� ��� ���� NAME - ������ ��� ���� ����� ������������.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                }
            };
 
            // �������� ������ ������� parse, �������� �������� ���������� �� DefaultHandler, ������� ����� ���������� � ������ �������
            saxParser.parse(fileName, handler);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}