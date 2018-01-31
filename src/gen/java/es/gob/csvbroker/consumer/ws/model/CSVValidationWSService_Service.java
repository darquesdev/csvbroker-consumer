
package es.gob.csvbroker.consumer.ws.model;

import es.gob.csvbroker.consumer.ws.CSVValidationWSService;

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
@WebServiceClient(name = "CSVValidationWSService", targetNamespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", wsdlLocation = "file:/home/david/svn/csvbroker/csvbroker/trunk/dev/csvbroker-consumer/src/main/resources/wsdl/CSVValidationWSService.wsdl")
public class CSVValidationWSService_Service
    extends Service
{

    private final static URL CSVVALIDATIONWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException CSVVALIDATIONWSSERVICE_EXCEPTION;
    private final static QName CSVVALIDATIONWSSERVICE_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "CSVValidationWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/david/svn/csvbroker/csvbroker/trunk/dev/csvbroker-consumer/src/main/resources/wsdl/CSVValidationWSService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CSVVALIDATIONWSSERVICE_WSDL_LOCATION = url;
        CSVVALIDATIONWSSERVICE_EXCEPTION = e;
    }

    public CSVValidationWSService_Service() {
        super(__getWsdlLocation(), CSVVALIDATIONWSSERVICE_QNAME);
    }

    public CSVValidationWSService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CSVVALIDATIONWSSERVICE_QNAME, features);
    }

    public CSVValidationWSService_Service(URL wsdlLocation) {
        super(wsdlLocation, CSVVALIDATIONWSSERVICE_QNAME);
    }

    public CSVValidationWSService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CSVVALIDATIONWSSERVICE_QNAME, features);
    }

    public CSVValidationWSService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CSVValidationWSService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CSVValidationWSService
     */
    @WebEndpoint(name = "CSVValidationServiceWSPort")
    public CSVValidationWSService getCSVValidationServiceWSPort() {
        return super.getPort(new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "CSVValidationServiceWSPort"), CSVValidationWSService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CSVValidationWSService
     */
    @WebEndpoint(name = "CSVValidationServiceWSPort")
    public CSVValidationWSService getCSVValidationServiceWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "CSVValidationServiceWSPort"), CSVValidationWSService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CSVVALIDATIONWSSERVICE_EXCEPTION!= null) {
            throw CSVVALIDATIONWSSERVICE_EXCEPTION;
        }
        return CSVVALIDATIONWSSERVICE_WSDL_LOCATION;
    }

}