package es.gob.csvbroker.consumer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public final class RequestBuilder {

    private String csv;
    private List<String> unidadesDir3 = new ArrayList<>();
    private List<String> codigosSia  = new ArrayList<>();
    private String nif;
    private Identificacion identificacion;
    private boolean recuperacionOriginal = false;
    private boolean documentoEni = false;

    private RequestBuilder(String csv) {
        checkArgument(!isNullOrEmpty(csv), "CSV es obligatorio");
        this.csv = csv;
    }

    public static RequestBuilder consultarCsvRequest(String csv) {
        return new RequestBuilder(csv);
    }

    public RequestBuilder withUnidadesDir3(String... unidadesDir3) {
        if(unidadesDir3 != null){
            this.unidadesDir3.addAll(Arrays.asList(unidadesDir3));
        }
        return this;
    }

    public RequestBuilder withCodigosSia(String... codigosSia) {
        if(codigosSia != null){
            this.codigosSia.addAll(Arrays.asList(codigosSia));
        }
        return this;
    }

    public RequestBuilder withNif(String nif) {
        this.nif = nif;
        return this;
    }

    public RequestBuilder withIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
        return this;
    }

    public RequestBuilder recuperarDocumentoEniOriginal() {
        this.recuperacionOriginal = true;
        return this;
    }

    public RequestBuilder recuperarDocumentoEni() {
        this.documentoEni = true;
        return this;
    }

    public ConsultarCsvRequest build() {
        return new ConsultarCsvRequest(csv, unidadesDir3, codigosSia, nif, identificacion, recuperacionOriginal, documentoEni);
    }
}
