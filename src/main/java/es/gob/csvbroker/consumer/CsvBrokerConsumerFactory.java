package es.gob.csvbroker.consumer;


import java.util.Properties;

public final class CsvBrokerConsumerFactory {

    private CsvBrokerConsumerFactory() {
    }

    public static CsvBrokerConsumer createConsumerByCredentials(Properties properties) {
        return new ConsumerByCredentials(properties);
    }

    public static CsvBrokerConsumer createConsumerByUsernameToken(Properties properties) {
        return new ConsumerByUsernameToken(properties);
    }

    public static CsvBrokerConsumer createConsumerByCertificate(Properties properties) {
        return new ConsumerByCertificate(properties);
    }
}
