
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CSVValidationRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CSVValidationRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="csv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="procedureList" type="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}procedureList" minOccurs="0"/&gt;
 *         &lt;element name="organizationList" type="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}organizationList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSVValidationRequest", propOrder = {
    "csv",
    "procedureList",
    "organizationList"
})
public class CSVValidationRequest {

    @XmlElement(required = true)
    protected String csv;
    protected ProcedureList procedureList;
    protected OrganizationList organizationList;

    /**
     * Obtiene el valor de la propiedad csv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCsv() {
        return csv;
    }

    /**
     * Define el valor de la propiedad csv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCsv(String value) {
        this.csv = value;
    }

    /**
     * Obtiene el valor de la propiedad procedureList.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureList }
     *     
     */
    public ProcedureList getProcedureList() {
        return procedureList;
    }

    /**
     * Define el valor de la propiedad procedureList.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureList }
     *     
     */
    public void setProcedureList(ProcedureList value) {
        this.procedureList = value;
    }

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
