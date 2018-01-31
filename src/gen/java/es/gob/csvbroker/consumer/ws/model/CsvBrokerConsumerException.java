package es.gob.csvbroker.consumer.ws.model;

public class CsvBrokerConsumerException extends RuntimeException {

    public CsvBrokerConsumerException(String message) {
        super(message);
    }

    public CsvBrokerConsumerException(String message, Throwable cause) {
        super(message, cause);
    }
}
