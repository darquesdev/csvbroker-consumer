
package es.gob.csvbroker.consumer.ws.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para CSVValidationSecurityRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="CSVValidationSecurityRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="csv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="organizationList" type="{urn:es:gob:aapp:csvbroker:webservices:validation:model:v1.0}organizationList" minOccurs="0"/&gt;
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoIdentificacion" type="{urn:es:gob:aapp:csvbroker:webservices:validation:v1.0}tipoIdentificacion" minOccurs="0"/&gt;
 *         &lt;element name="recuperacion_original" type="{urn:es:gob:aapp:csvbroker:webservices:validation:v1.0}recuperacionOriginal" minOccurs="0"/&gt;
 *         &lt;element name="documento_eni" type="{urn:es:gob:aapp:csvbroker:webservices:validation:v1.0}documentoEni" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CSVValidationSecurityRequest", propOrder = {
    "csv",
    "organizationList",
    "nif",
    "tipoIdentificacion",
    "recuperacionOriginal",
    "documentoEni"
})
public class CSVValidationSecurityRequest {

    @XmlElement(required = true)
    protected String csv;
    protected OrganizationList organizationList;
    protected String nif;
    @XmlSchemaType(name = "string")
    protected TipoIdentificacion tipoIdentificacion;
    @XmlElement(name = "recuperacion_original")
    @XmlSchemaType(name = "string")
    protected RecuperacionOriginal recuperacionOriginal;
    @XmlElement(name = "documento_eni")
    @XmlSchemaType(name = "string")
    protected DocumentoEni documentoEni;

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

    /**
     * Obtiene el valor de la propiedad nif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNif() {
        return nif;
    }

    /**
     * Define el valor de la propiedad nif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNif(String value) {
        this.nif = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoIdentificacion.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdentificacion }
     *     
     */
    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Define el valor de la propiedad tipoIdentificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdentificacion }
     *     
     */
    public void setTipoIdentificacion(TipoIdentificacion value) {
        this.tipoIdentificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad recuperacionOriginal.
     * 
     * @return
     *     possible object is
     *     {@link RecuperacionOriginal }
     *     
     */
    public RecuperacionOriginal getRecuperacionOriginal() {
        return recuperacionOriginal;
    }

    /**
     * Define el valor de la propiedad recuperacionOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link RecuperacionOriginal }
     *     
     */
    public void setRecuperacionOriginal(RecuperacionOriginal value) {
        this.recuperacionOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoEni.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoEni }
     *     
     */
    public DocumentoEni getDocumentoEni() {
        return documentoEni;
    }

    /**
     * Define el valor de la propiedad documentoEni.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoEni }
     *     
     */
    public void setDocumentoEni(DocumentoEni value) {
        this.documentoEni = value;
    }

}
