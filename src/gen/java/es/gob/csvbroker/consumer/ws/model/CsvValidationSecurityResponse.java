
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para csvValidationSecurityResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="csvValidationSecurityResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}CSVValidationSecurityResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csvValidationSecurityResponse", namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", propOrder = {
    "csvValidationSecurityResponse"
})
public class CsvValidationSecurityResponse {

    @XmlElement(name = "CSVValidationSecurityResponse", namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0")
    protected CSVValidationSecurityResponse csvValidationSecurityResponse;

    /**
     * Obtiene el valor de la propiedad csvValidationSecurityResponse.
     * 
     * @return
     *     possible object is
     *     {@link CSVValidationSecurityResponse }
     *     
     */
    public CSVValidationSecurityResponse getCSVValidationSecurityResponse() {
        return csvValidationSecurityResponse;
    }

    /**
     * Define el valor de la propiedad csvValidationSecurityResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link CSVValidationSecurityResponse }
     *     
     */
    public void setCSVValidationSecurityResponse(CSVValidationSecurityResponse value) {
        this.csvValidationSecurityResponse = value;
    }

}
