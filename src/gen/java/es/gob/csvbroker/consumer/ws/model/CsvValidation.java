
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para csvValidation complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="csvValidation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="validationRequest" type="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}CSVValidationRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csvValidation", namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", propOrder = {
    "validationRequest"
})
public class CsvValidation {

    @XmlElement(required = true)
    protected CSVValidationRequest validationRequest;

    /**
     * Obtiene el valor de la propiedad validationRequest.
     * 
     * @return
     *     possible object is
     *     {@link CSVValidationRequest }
     *     
     */
    public CSVValidationRequest getValidationRequest() {
        return validationRequest;
    }

    /**
     * Define el valor de la propiedad validationRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSVValidationRequest }
     *     
     */
    public void setValidationRequest(CSVValidationRequest value) {
        this.validationRequest = value;
    }

}
