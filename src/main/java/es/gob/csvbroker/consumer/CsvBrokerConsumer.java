package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;

/**
 *   El servicio de validación por CSV debe devolver, o bien el documento asociado a un CSV concreto, o
     bien una lista de organismos que pueden custodiar el documento asociado a ese CSV, o bien el
     tiempo que ha de pasar para que el documento esté disponible.
     Además del CSV, el servicio acepta otros parámetros adicionales, como una lista de procedimientos
     asociados (código SIA) o una lista de organismos asociados (código DIR3).

     El servicio CSVValidationService tiene una operación, csvValidation, que recibe como entrada
     un elemento de tipo validationRequest y otro elemento credential con el que la aplicación
     consumidora presentará sus credenciales y devuelve un elemento de tipo csvValidationResponse.

     Con la operación csvValidation un usuario consumidor de CSV Broker tendría acceso a todos los
     documentos de los Productores dados de alta. Para poder establecer unos permisos de acceso a los
     documentos e identificar quien es el usuario que lo solicita, el servicio CSVValidationService dispone
     de una nueva operación csvValidationSecurity que recibirá el NIF del usuario que desea cotejar un
     CSV y la forma con la que se ha identificado.
 *
 */
public interface CsvBrokerConsumer {

    ConsultarCsvResponse consultarCsv(ConsultarCsvRequest request);

}
