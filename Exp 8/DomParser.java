import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  
public class DomParser 
{  
	public String[] searchstudent(String search){
		String[] str=new String[5];
	try {  
	//creating a constructor of file class and parsing an XML file  
	File file = new File("\\input_xml.xml");  
	//an instance of factory that gives a document builder  
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
	//an instance of builder to parse the specified xml file  
	DocumentBuilder db = dbf.newDocumentBuilder();  
	Document doc = db.parse(file);  
	doc.getDocumentElement().normalize();  
	System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  
	NodeList nodeList = doc.getElementsByTagName("student");  
	// nodeList is not iterable, so we are using for loop  
	for (int itr = 0; itr < nodeList.getLength(); itr++)   
	{  
			Node node = nodeList.item(itr);  
			System.out.println("\nNode Name :" + node.getNodeName());  
			if (node.getNodeType() == Node.ELEMENT_NODE)   
				{  
						Element eElement = (Element) node;
						if(eElement.getAttribute("roll").equals(search)){
							str[0]=eElement.getAttribute("roll");
							str[1]=eElement.getElementsByTagName("name").item(0).getTextContent();  
							str[2]=eElement.getElementsByTagName("dept").item(0).getTextContent();  
							str[3]=eElement.getElementsByTagName("email").item(0).getTextContent(); 
							return str;
						}
				}  
		}  
	}   
catch (Exception e)   
{  
	e.printStackTrace();  
}  
return null;
}
}
  