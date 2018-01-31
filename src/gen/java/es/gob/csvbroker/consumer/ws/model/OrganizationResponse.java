
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para organizationResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="organizationResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="organizationList" type="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}organizationList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "organizationResponse", propOrder = {
    "organizationList"
})
public class OrganizationResponse {

    @XmlElement(required = true)
    protected OrganizationList organizationList;

    /**
     * Obtiene el valor de la propiedad organizationList.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationList }
     *     
     */
    public OrganizationList getOrganizationList() {
        return organizationList;
    }

    /**
     * Define el valor de la propiedad organizationList.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationList }
     *     
     */
    public void setOrganizationList(OrganizationList value) {
        this.organizationList = value;
    }

}
