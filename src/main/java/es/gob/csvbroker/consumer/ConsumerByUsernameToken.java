package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;
import es.gob.csvbroker.consumer.ws.CSVValidationWSService;
import es.gob.csvbroker.consumer.ws.model.CsvBrokerConsumerException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.*;

import static es.gob.csvbroker.consumer.ConsumerActions.CONSULTAR_CSV;
import static es.gob.csvbroker.consumer.ConsumerHelper.ERROR_MSG_LLAMADA_A_WS;
import static es.gob.csvbroker.consumer.ConsumerHelper.LOG_MSG_LLAMADA;
import static es.gob.csvbroker.consumer.ConsumerHelper.LOG_MSJ_RESPUESTA;

public final class ConsumerByUsernameToken implements CsvBrokerConsumer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ConsumerHelper helper = new ConsumerHelper();
    private final String username;
    private final String pass;

    private CSVValidationWSService service;

    ConsumerByUsernameToken(Properties properties) {

        logger.info("Creando ConsumerByUsernameToken...");

        helper.checkProperties(properties);
        String wsdlURL = properties.getProperty(ConsumerProperties.WSDL_URL_PARAM);
        pass = properties.getProperty(ConsumerProperties.PASS_PARAM);
        username = properties.getProperty(ConsumerProperties.USER_PARAM);

        try {
            createClient(wsdlURL);
            configureSecurity();
            configureChunking();

        } catch (Exception e) {
            throw new CsvBrokerConsumerException(String.format("Error creando el cliente WS de la URL %s : %s", wsdlURL, e.getLocalizedMessage()), e);
        }
        logger.info("ConsumerByUsernameToken creado");
    }

    private void createClient(String wsdlURL){
        logger.info("Creando cliente CSVValidationWSService...");
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(CSVValidationWSService.class);
        jaxWsProxyFactoryBean.setAddress(wsdlURL);
        jaxWsProxyFactoryBean.setFeatures(new ArrayList<>(Collections.singletonList(helper.loggingFeature())));
        service = (CSVValidationWSService) jaxWsProxyFactoryBean.create();
        logger.info("Cliente CSVValidationWSService creado");
    }

    private void configureSecurity() {

        logger.info("Configurando seguridad WS-SEC UsernameToken");

        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.USER, username);
        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, new CallbackHandler() {
            @Override
            public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
                pc.setPassword(pass);
            }
        });
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);// Password type : plain text

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);

        Client c = ClientProxy.getClient(service);
        Endpoint cxfEndpoint = c.getEndpoint();

        cxfEndpoint.getOutInterceptors().add(wssOut);

        logger.info("Seguridad WS-SEC UsernameToken configurada");
    }

    private void configureChunking() {
        helper.disableChunking(ClientProxy.getClient(service));
    }

    @Override
    public ConsultarCsvResponse consultarCsv(ConsultarCsvRequest request) {
        logger.info(LOG_MSG_LLAMADA, CONSULTAR_CSV, request);
        try {
            ConsultarCsvResponse response = ConsumerMapper.mapToResponse(service.csvValidationSecurity(ConsumerMapper.mapToWsRequest(request)));
            logger.info(LOG_MSJ_RESPUESTA, CONSULTAR_CSV, response);
            return response;
        } catch (Exception e) {
            throw new CsvBrokerConsumerException(String.format(ERROR_MSG_LLAMADA_A_WS, CONSULTAR_CSV, request.getCsv(), e.getLocalizedMessage()), e);
        }
    }
}
