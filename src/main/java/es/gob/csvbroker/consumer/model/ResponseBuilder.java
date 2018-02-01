package es.gob.csvbroker.consumer.model;

import java.util.List;

public final class ResponseBuilder {

    private String code;
    private String description;
    private List<String> unidadesDir3;
    private Long segundosEsperaReintento;
    private String name;
    private String mime;
    private String url;
    private byte[] content;
    private boolean documentInitialized = false;

    protected ResponseBuilder() {
    }

    public ResponseBuilder withCodigo(String code) {
        this.code = code;
        return this;
    }

    public ResponseBuilder withDescripcion(String description) {
        this.description = description;
        return this;
    }

    public ResponseBuilder withDocumento(String name, String mime, byte[] content, String url) {
        this.name = name;
        this.mime = mime;
        this.content = content;
        this.url = url;
        this.documentInitialized = true;
        return this;
    }

    public ResponseBuilder withUnidadesDir3(List<String> unidadesDir3) {
        this.unidadesDir3 = unidadesDir3;
        return this;
    }

    public ResponseBuilder withSegundosEsperaReintento(Long segundosEsperaReintento) {
        this.segundosEsperaReintento = segundosEsperaReintento;
        return this;
    }

    public ConsultarCsvResponse build() {
        return new ConsultarCsvResponse(
                code,
                description,
                documentInitialized ? new Documento(name, mime, url, content) : null,
                unidadesDir3,
                segundosEsperaReintento);
    }
}