package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;
import es.gob.csvbroker.consumer.ws.CSVValidationService;
import es.gob.csvbroker.consumer.ws.model.CsvBrokerConsumerException;
import es.gob.csvbroker.consumer.ws.model.WSCredential;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import static es.gob.csvbroker.consumer.ConsumerActions.CONSULTAR_CSV;
import static es.gob.csvbroker.consumer.ConsumerHelper.ERROR_MSG_LLAMADA_A_WS;
import static es.gob.csvbroker.consumer.ConsumerHelper.LOG_MSG_LLAMADA;
import static es.gob.csvbroker.consumer.ConsumerHelper.LOG_MSJ_RESPUESTA;

public final class ConsumerByCredentials implements CsvBrokerConsumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private CSVValidationService validationService;
    private WSCredential wsCredentials;
    private ConsumerHelper consumerHelper = new ConsumerHelper();

    ConsumerByCredentials(Properties properties) {

        logger.info("Iniciando ConsumerByCredentials...");

        consumerHelper.checkProperties(properties);

        String wsdlURL = properties.getProperty(ConsumerProperties.WSDL_URL_PARAM);
        String idApp = properties.getProperty(ConsumerProperties.USER_PARAM);
        String passApp = properties.getProperty(ConsumerProperties.PASS_PARAM);

        try {
            createClient(wsdlURL);
            createCredentials(idApp, passApp);
            configureChunking();

        } catch (Exception e) {
            throw new CsvBrokerConsumerException(String.format("Error creando el cliente WS de la URL %s : %s", wsdlURL, e.getLocalizedMessage()), e);
        }
    }

    private void createClient(String wsdlURL){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(CSVValidationService.class);
        jaxWsProxyFactoryBean.setAddress(wsdlURL);
        jaxWsProxyFactoryBean.setFeatures(new ArrayList<>(Collections.singletonList(consumerHelper.loggingFeature())));
        validationService = (CSVValidationService) jaxWsProxyFactoryBean.create();
    }

    private void createCredentials(String idApp, String passApp) {
        this.wsCredentials = new WSCredential();
        this.wsCredentials.setIdaplicacion(idApp);
        this.wsCredentials.setPassword(passApp);
    }

    private void configureChunking() {
        consumerHelper.disableChunking(ClientProxy.getClient(validationService));
    }

    @Override
    public ConsultarCsvResponse consultarCsv(ConsultarCsvRequest request) {
        logger.info(LOG_MSG_LLAMADA, CONSULTAR_CSV, request);
        try {
            ConsultarCsvResponse response = ConsumerMapper.mapToResponse(validationService.csvValidationSecurity(wsCredentials, ConsumerMapper.mapToWsRequest(request)));
            logger.info(LOG_MSJ_RESPUESTA, CONSULTAR_CSV, response);
            return response;
        } catch (Exception e) {
            throw new CsvBrokerConsumerException(String.format(ERROR_MSG_LLAMADA_A_WS, CONSULTAR_CSV, request.getCsv(), e.getLocalizedMessage()), e);
        }
    }
}
