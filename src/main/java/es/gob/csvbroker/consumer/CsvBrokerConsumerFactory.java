package es.gob.csvbroker.consumer;


import java.util.Properties;

public final class CsvBrokerConsumerFactory {

    private CsvBrokerConsumerFactory() {
    }

    public static CsvBrokerConsumer createConsumerByCredentials(Properties properties) {
        return new ConsumerByCredentials(properties);
    }
}
