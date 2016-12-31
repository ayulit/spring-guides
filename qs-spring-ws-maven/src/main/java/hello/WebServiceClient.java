package hello;

import java.io.StringReader;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.WebServiceTemplate;

public class WebServiceClient {

    private static final String MESSAGE =
            "<message xmlns=\"http://tempuri.org\">Hello World</message>";

        // ...that's something important class 
        private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

        // ...it will be injected using bean's property (implicit URI)
        public void setDefaultUri(String defaultUri) {
            webServiceTemplate.setDefaultUri(defaultUri);
        }

        // send to the configured default URI
        public void simpleSendAndReceive() {
            // ...some kind of XML data source
        	StreamSource source = new StreamSource(new StringReader(MESSAGE));
            
            // ...received result will go to syso
        	StreamResult result = new StreamResult(System.out);
            
        	// ...sends source XML message, receives smth and kicks it to result
        	webServiceTemplate.sendSourceAndReceiveToResult(source, result);
        }

        // send to an explicit URI
        public void customSendAndReceive() {
            StreamSource source = new StreamSource(new StringReader(MESSAGE));
            StreamResult result = new StreamResult(System.out);
            webServiceTemplate.sendSourceAndReceiveToResult("http://localhost:8080/AnotherWebService",
                source, result);
        }
	
}
