
package es.gob.csvbroker.consumer.model;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Este elemento sirve para contener tanto el documento asociado a un CSV como información de este
 * documento.
 */
public class Documento {

    private final byte[] content;
    private final String name;
    private final String mime;
    private final String url;

    public Documento(String name, String mime, String url, byte[] content) {
        checkArgument(isNullOrEmpty(name), "El nombre del documento es obligatorio");
        checkArgument(isNullOrEmpty(mime), "El tipo Mime del documento es obligatorio");
        checkArgument(!isNullOrEmpty(url) || content != null, "Es obligatorio indicar el contenido del documento (directamente o con una URL)");
        this.name = name;
        this.mime = mime;
        this.content = content;
        this.url = url;
    }

    public byte[] getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getMime() {
        return mime;
    }

    public String getUrl() {
        return url;
    }
}
