
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.gob.csvbroker.consumer.ws.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CsvValidation_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "csvValidation");
    private final static QName _CsvValidationResponse_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "csvValidationResponse");
    private final static QName _CsvValidationSecurity_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "csvValidationSecurity");
    private final static QName _CsvValidationSecurityResponse_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", "csvValidationSecurityResponse");
    private final static QName _CSVValidationException_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", "CSVValidationException");
    private final static QName _CSVValidationResponse_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", "CSVValidationResponse");
    private final static QName _CSVValidationSecurityResponse_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", "CSVValidationSecurityResponse");
    private final static QName _ErrorInfo_QNAME = new QName("urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", "errorInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.gob.csvbroker.consumer.ws.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CsvValidation }
     * 
     */
    public CsvValidation createCsvValidation() {
        return new CsvValidation();
    }

    /**
     * Create an instance of {@link CsvValidationResponse }
     * 
     */
    public CsvValidationResponse createCsvValidationResponse() {
        return new CsvValidationResponse();
    }

    /**
     * Create an instance of {@link CsvValidationSecurity }
     * 
     */
    public CsvValidationSecurity createCsvValidationSecurity() {
        return new CsvValidationSecurity();
    }

    /**
     * Create an instance of {@link CsvValidationSecurityResponse }
     * 
     */
    public CsvValidationSecurityResponse createCsvValidationSecurityResponse() {
        return new CsvValidationSecurityResponse();
    }

    /**
     * Create an instance of {@link CSVValidationException }
     * 
     */
    public CSVValidationException createCSVValidationException() {
        return new CSVValidationException();
    }

    /**
     * Create an instance of {@link CSVValidationResponse }
     * 
     */
    public CSVValidationResponse createCSVValidationResponse() {
        return new CSVValidationResponse();
    }

    /**
     * Create an instance of {@link CSVValidationSecurityResponse }
     * 
     */
    public CSVValidationSecurityResponse createCSVValidationSecurityResponse() {
        return new CSVValidationSecurityResponse();
    }

    /**
     * Create an instance of {@link WSCredential }
     * 
     */
    public WSCredential createWSCredential() {
        return new WSCredential();
    }

    /**
     * Create an instance of {@link CSVValidationRequest }
     * 
     */
    public CSVValidationRequest createCSVValidationRequest() {
        return new CSVValidationRequest();
    }

    /**
     * Create an instance of {@link ProcedureList }
     * 
     */
    public ProcedureList createProcedureList() {
        return new ProcedureList();
    }

    /**
     * Create an instance of {@link OrganizationList }
     * 
     */
    public OrganizationList createOrganizationList() {
        return new OrganizationList();
    }

    /**
     * Create an instance of {@link DocumentResponse }
     * 
     */
    public DocumentResponse createDocumentResponse() {
        return new DocumentResponse();
    }

    /**
     * Create an instance of {@link OrganizationResponse }
     * 
     */
    public OrganizationResponse createOrganizationResponse() {
        return new OrganizationResponse();
    }

    /**
     * Create an instance of {@link WaitResponse }
     * 
     */
    public WaitResponse createWaitResponse() {
        return new WaitResponse();
    }

    /**
     * Create an instance of {@link CSVValidationSecurityRequest }
     * 
     */
    public CSVValidationSecurityRequest createCSVValidationSecurityRequest() {
        return new CSVValidationSecurityRequest();
    }

    /**
     * Create an instance of {@link DocumentUrlResponse }
     * 
     */
    public DocumentUrlResponse createDocumentUrlResponse() {
        return new DocumentUrlResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CsvValidation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CsvValidation }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", name = "csvValidation")
    public JAXBElement<CsvValidation> createCsvValidation(CsvValidation value) {
        return new JAXBElement<CsvValidation>(_CsvValidation_QNAME, CsvValidation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CsvValidationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CsvValidationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", name = "csvValidationResponse")
    public JAXBElement<CsvValidationResponse> createCsvValidationResponse(CsvValidationResponse value) {
        return new JAXBElement<CsvValidationResponse>(_CsvValidationResponse_QNAME, CsvValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CsvValidationSecurity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CsvValidationSecurity }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", name = "csvValidationSecurity")
    public JAXBElement<CsvValidationSecurity> createCsvValidationSecurity(CsvValidationSecurity value) {
        return new JAXBElement<CsvValidationSecurity>(_CsvValidationSecurity_QNAME, CsvValidationSecurity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CsvValidationSecurityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CsvValidationSecurityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", name = "csvValidationSecurityResponse")
    public JAXBElement<CsvValidationSecurityResponse> createCsvValidationSecurityResponse(CsvValidationSecurityResponse value) {
        return new JAXBElement<CsvValidationSecurityResponse>(_CsvValidationSecurityResponse_QNAME, CsvValidationSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CSVValidationException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CSVValidationException }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", name = "CSVValidationException")
    public JAXBElement<CSVValidationException> createCSVValidationException(CSVValidationException value) {
        return new JAXBElement<CSVValidationException>(_CSVValidationException_QNAME, CSVValidationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CSVValidationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CSVValidationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", name = "CSVValidationResponse")
    public JAXBElement<CSVValidationResponse> createCSVValidationResponse(CSVValidationResponse value) {
        return new JAXBElement<CSVValidationResponse>(_CSVValidationResponse_QNAME, CSVValidationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CSVValidationSecurityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CSVValidationSecurityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", name = "CSVValidationSecurityResponse")
    public JAXBElement<CSVValidationSecurityResponse> createCSVValidationSecurityResponse(CSVValidationSecurityResponse value) {
        return new JAXBElement<CSVValidationSecurityResponse>(_CSVValidationSecurityResponse_QNAME, CSVValidationSecurityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0", name = "errorInfo")
    public JAXBElement<Object> createErrorInfo(Object value) {
        return new JAXBElement<Object>(_ErrorInfo_QNAME, Object.class, null, value);
    }

}
