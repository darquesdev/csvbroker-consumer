
package es.gob.csvbroker.consumer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

/*
 *
    Además del csv y organizationList también contiene los siguientes campos:

    tipoIdentificacion: Tipo con el que se ha identificado el usuario (*).

    nif: NIF del usuario.

    recuperación_original: Si viene informado este campo deberá que venir con el valor ‘S’. En
        este caso, si el csv pertenece a un documento copia y el campo recuperación_original es “S”
        indica que se desea recuperarán el documento original de la copia. En caso de no venir informado
        se devuelve el documento perteneciente al csv.

    documento_eni: Si viene informado este campo tendrá que venir con el valor ‘S’. En este caso, si
        un csv está asociado a un documento ENI y un PDF, si el documento_eni es “S” indica que se
        desea recuperar el documento ENI.
        Si el csv no pertenece a un documento ENI, aunque este campo tenga valor “S” devolverá el PDF.
        En caso de venir informado a “N” o no venir informado, por defecto se devolverá el PDF.

    (*) Tipos de Identificación permitidos:
        CLAVE_PERM : Identificación por Clave
        PIN24 : PIN24
        DNIE: DNI-Electrónico
        PF_2CA: Persona Física 2CA
        PJ_2CA: Persona Jurídica 2CA
        COMPONENTESSL: Componente SSL
        SEDE_ELECTRONICA: Sede Electrónica
        SELLO_ORGANO: Sello Órgano
        EMPLEADO_PUBLICO: Empleado público
        ENTIDAD_NO_PERSONA_JURIDICA: Entidad No Persona Jurídica
        EMPLEADO_PUBLICO_PSEUD: Empleado Público Pseudónimo
        CUALIFICADO_SELLO_ENTIDAD: Cualificado Sello Entidad
        CUALIFICADO_AUTENTICACION: Cualificado Autenticación
        CUALIFICADO_SELLO_TIEMPO: Cualificado Sello Tiempo
        REPRESENTACION_PJ: Representación Persona Jurídica
        REPRESENTACION_ENTIDAD_SIN_PF: Representación Entidad Sin Persona Jurídica
 *
 *
**/
public class ConsultarCsvRequest {

    private final String csv;
    private final List<String> unidadesDir3;
    private final List<String> codigosSia;
    private final String nif;
    private Identificacion identificacion;
    private final boolean recuperacionOriginal;
    private final boolean documentoEni;

    public ConsultarCsvRequest(String csv, List<String> unidadesDir3, List<String> codigosSia, String nif, Identificacion identificacion, boolean recuperacionOriginal, boolean documentoEni) {
        checkArgument(isNullOrEmpty(csv), "CSV es obligatorio");
        this.csv = csv;
        this.unidadesDir3 = unidadesDir3 == null ? new ArrayList<>() : unidadesDir3;
        this.codigosSia = codigosSia == null ? new ArrayList<>() : codigosSia;
        this.nif = nif;
        this.identificacion = identificacion;
        this.recuperacionOriginal = recuperacionOriginal;
        this.documentoEni = documentoEni;
    }

    public static RequestBuilder builder(String csv){
        return new RequestBuilder(csv);
    }

    public String getCsv() {
        return csv;
    }

    public List<String> getUnidadesDir3() {
        return unidadesDir3;
    }

    public List<String> getCodigosSia() {
        return codigosSia;
    }

    public String getNif() {
        return nif;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public boolean isRecuperacionOriginal() {
        return recuperacionOriginal;
    }

    public boolean isDocumentoEni() {
        return documentoEni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultarCsvRequest that = (ConsultarCsvRequest) o;
        return recuperacionOriginal == that.recuperacionOriginal &&
                documentoEni == that.documentoEni &&
                Objects.equals(csv, that.csv) &&
                Objects.equals(unidadesDir3, that.unidadesDir3) &&
                Objects.equals(codigosSia, that.codigosSia) &&
                Objects.equals(nif, that.nif) &&
                identificacion == that.identificacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(csv, unidadesDir3, codigosSia, nif, identificacion, recuperacionOriginal, documentoEni);
    }
}
