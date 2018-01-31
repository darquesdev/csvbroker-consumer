package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.util.Assert;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import java.util.Properties;

class ConsumerHelper {

    static final String ERROR_MSG_LLAMADA_A_WS = "Error en la llamada a %s con el documento %s: %s";
    static final String LOG_MSJ_RESPUESTA = "Respuesta de {}: {}";
    static final String LOG_MSG_LLAMADA = "Llamando a {}: {}";
    private static final String ERROR_MSG_MANDATORY_PARAM = "El parámetro '%s' es obligatorio";

    ConsumerHelper() {}

    void checkProperties(Properties properties) {
        Assert.notNull(properties, "Las propiedades del consumidor de CSVBROKER son obligatorias");
        Assert.hasLength(properties.getProperty(ConsumerProperties.WSDL_URL_PARAM), String.format(ERROR_MSG_MANDATORY_PARAM, ConsumerProperties.WSDL_URL_PARAM));
        Assert.hasLength(properties.getProperty(ConsumerProperties.USER_PARAM), String.format(ERROR_MSG_MANDATORY_PARAM, ConsumerProperties.USER_PARAM));
        Assert.hasLength(properties.getProperty(ConsumerProperties.PASS_PARAM), String.format(ERROR_MSG_MANDATORY_PARAM, ConsumerProperties.PASS_PARAM));
    }

    void disableChunking(Client client) {
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = httpConduit.getClient();
        policy.setAllowChunking(false);
    }

    void setupTimeouts(Client client, long receiveTimeout, long connectionTimeout) {
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = httpConduit.getClient();
        // set time to wait for response in milliseconds. zero means unlimited
        policy.setReceiveTimeout(receiveTimeout);
        policy.setConnectionTimeout(connectionTimeout);
    }

    LoggingFeature loggingFeature() {
        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);
        return loggingFeature;
    }
}