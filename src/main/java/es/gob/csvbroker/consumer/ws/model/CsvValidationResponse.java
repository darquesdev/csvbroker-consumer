
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para csvValidationResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="csvValidationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}CSVValidationResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csvValidationResponse", namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:v1.0", propOrder = {
    "csvValidationResponse"
})
public class CsvValidationResponse {

    @XmlElement(name = "CSVValidationResponse", namespace = "urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0")
    protected CSVValidationResponse csvValidationResponse;

    /**
     * Obtiene el valor de la propiedad csvValidationResponse.
     * 
     * @return
     *     possible object is
     *     {@link CSVValidationResponse }
     *     
     */
    public CSVValidationResponse getCSVValidationResponse() {
        return csvValidationResponse;
    }

    /**
     * Define el valor de la propiedad csvValidationResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link CSVValidationResponse }
     *     
     */
    public void setCSVValidationResponse(CSVValidationResponse value) {
        this.csvValidationResponse = value;
    }

}
