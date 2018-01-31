package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;

public interface CsvBrokerConsumer {

    ConsultarCsvResponse consultarCsv(ConsultarCsvRequest request);

}
