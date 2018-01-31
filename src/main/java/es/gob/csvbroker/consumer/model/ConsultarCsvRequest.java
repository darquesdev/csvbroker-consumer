
package es.gob.csvbroker.consumer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

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
