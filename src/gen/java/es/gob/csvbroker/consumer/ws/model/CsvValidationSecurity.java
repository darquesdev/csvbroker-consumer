
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para csvValidationSecurity complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="csvValidationSecurity"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="validationSecurityRequest" type="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}CSVValidationSecurityRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csvValidationSecurity", namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", propOrder = {
    "validationSecurityRequest"
})
public class CsvValidationSecurity {

    @XmlElement(required = true)
    protected CSVValidationSecurityRequest validationSecurityRequest;

    /**
     * Obtiene el valor de la propiedad validationSecurityRequest.
     * 
     * @return
     *     possible object is
     *     {@link CSVValidationSecurityRequest }
     *     
     */
    public CSVValidationSecurityRequest getValidationSecurityRequest() {
        return validationSecurityRequest;
    }

    /**
     * Define el valor de la propiedad validationSecurityRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSVValidationSecurityRequest }
     *     
     */
    public void setValidationSecurityRequest(CSVValidationSecurityRequest value) {
        this.validationSecurityRequest = value;
    }

}
