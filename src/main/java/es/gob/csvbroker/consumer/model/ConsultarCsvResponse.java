
package es.gob.csvbroker.consumer.model;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
/**
 *
 code: Código para indicar el resultado de la operación. Los valores que se deben
    devolver en de este código son:
    0: La operación se ha realizado con éxito, es decir, se devuelve el documento
    asociado al CSV.
    1: El documento no puede recuperarse, pero puede consultarse de nuevo pasado un
    tiempo.
    2: CSV no encontrado.
    3: Se devuelve una lista de organizaciones que pueden contener el documento
    asociado al CSV.
    5: Endpoint no encontrado.
    6: Se ha producido un error al consumir el servicio.

 description: Breve descripción del resultado según el código de respuesta:

    0: “La operación se ha realizado con éxito.”
    1: “El documento no puede recuperarse. Puede consultarse pasado un tiempo.”
    2: “CSV no encontrado.”
    5: “ Endpoint no encontrado.”
    6: “ Se ha producido un error al consumir el servicio.”

 documentResponse: Elemento utilizado para devolver el documento. Se describe con
    detalle en el apartado 5.7. En caso de devolver este elemento, el elemento code deberá
    tener el valor 0. Elemento opcional.

 waitResponse: Elemento utilizado para indicar el número de segundos a esperar para
    tener disponible el documento. Se describe en detalle en el apartado 5.8. En caso de
    devolver este elemento, el elemento code deberá tener el valor 1. Elemento opcional.

 organizationResponse: Elemento utilizado para devolver la lista de organismos que
    pueden contener el documento asociado al CSV. Se describe en detalle en el apartado
    5.10. En caso de devolver este elemento, el elemento code deberá tener el valor 4.
    Elemento opcional.
 *
 *
**/
public class ConsultarCsvResponse {

    public static final String COD_EXITO = "0";

    private final String codigo;
    private final String description;
    private final Documento documento;
    private final List<String> unidadesDir3;
    private final Long segundosEsperaReintento;

    public ConsultarCsvResponse(String codigo, String description, Documento documento, List<String> unidadesDir3, Long segundosEsperaReintento) {
        this.codigo = codigo;
        this.description = description;
        this.documento = documento;
        this.unidadesDir3 = unidadesDir3 == null ? new ArrayList<>() : unidadesDir3;
        this.segundosEsperaReintento = segundosEsperaReintento == null ? 0 : segundosEsperaReintento;
        checkArgument(this.segundosEsperaReintento >= 0, "Los segundos de espera deben ser igual o mayores que 0");
    }

    public static ResponseBuilder builder(){
        return new ResponseBuilder();
    }

    /**
     * La operación se ha realizado con éxito, es decir, se devuelve el documento
     * asociado al CSV
     * @return éxito
     */
    public boolean successful(){
        return COD_EXITO.equals(codigo);
    }

    /**
     * Código para indicar el resultado de la operación
     *
     * @return código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Breve descripción del resultado según el código de respuesta
     *
     * @return Descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Este elemento sirve para contener tanto el documento asociado a un CSV como información de este
     * documento.
     *
     * @return documento
     */
    public Documento getDocumento() {
        return documento;
    }


    /**
     * Este elemento sirve para informar al consumidor de que el documento asociado al CSV lo custodia
     * alguno de los organismos que se devuelve en la respuesta
     *
     * @return lista de DIR3
     */
    public List<String> getUnidadesDir3() {
        return unidadesDir3;
    }

    /**
     * Este elemento sirve para informar al consumidor de que el documento estará disponible en un
     * tiempo especificado en segundos.
     *
     * @return segundos de espera para el reintento
     */
    public Long getSegundosEsperaReintento() {
        return segundosEsperaReintento;
    }
}
