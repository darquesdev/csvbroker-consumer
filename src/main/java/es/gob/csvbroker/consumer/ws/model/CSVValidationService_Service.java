
package es.gob.csvbroker.consumer.ws.model;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CSVValidationService", targetNamespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", wsdlLocation = "file:/home/david/svn/csvbroker/csvbroker/trunk/dev/csvbroker-consumer/src/main/resources/wsdl/CSVValidationService.wsdl")
public class CSVValidationService_Service
    extends Service
{

    private final static URL CSVVALIDATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException CSVVALIDATIONSERVICE_EXCEPTION;
    private final static QName CSVVALIDATIONSERVICE_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "CSVValidationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/david/svn/csvbroker/csvbroker/trunk/dev/csvbroker-consumer/src/main/resources/wsdl/CSVValidationService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CSVVALIDATIONSERVICE_WSDL_LOCATION = url;
        CSVVALIDATIONSERVICE_EXCEPTION = e;
    }

    public CSVValidationService_Service() {
        super(__getWsdlLocation(), CSVVALIDATIONSERVICE_QNAME);
    }

    public CSVValidationService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CSVVALIDATIONSERVICE_QNAME, features);
    }

    public CSVValidationService_Service(URL wsdlLocation) {
        super(wsdlLocation, CSVVALIDATIONSERVICE_QNAME);
    }

    public CSVValidationService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CSVVALIDATIONSERVICE_QNAME, features);
    }

    public CSVValidationService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CSVValidationService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CSVValidationService
     */
    @WebEndpoint(name = "CSVValidationServicePort")
    public CSVValidationService getCSVValidationServicePort() {
        return super.getPort(new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "CSVValidationServicePort"), CSVValidationService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CSVValidationService
     */
    @WebEndpoint(name = "CSVValidationServicePort")
    public CSVValidationService getCSVValidationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "CSVValidationServicePort"), CSVValidationService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CSVVALIDATIONSERVICE_EXCEPTION!= null) {
            throw CSVVALIDATIONSERVICE_EXCEPTION;
        }
        return CSVVALIDATIONSERVICE_WSDL_LOCATION;
    }

}