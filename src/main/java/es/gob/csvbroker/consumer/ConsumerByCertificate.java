package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;
import es.gob.csvbroker.consumer.security.ClientKeystorePasswordCallback;
import es.gob.csvbroker.consumer.ws.model.CSVValidationCertificateService;
import es.gob.csvbroker.consumer.model.CsvBrokerConsumerException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.DefaultCryptoCoverageChecker;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static es.gob.csvbroker.consumer.ConsumerActions.CONSULTAR_CSV;
import static es.gob.csvbroker.consumer.ConsumerHelper.ERROR_MSG_LLAMADA_A_WS;
import static es.gob.csvbroker.consumer.ConsumerHelper.LOG_MSG_LLAMADA;
import static es.gob.csvbroker.consumer.ConsumerHelper.LOG_MSJ_RESPUESTA;


public final class ConsumerByCertificate implements CsvBrokerConsumer{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final String SIG_PROP_REF_ID = "cryptoProperties";
    private static final boolean SIGNED_RESPONSE_REQUIRED = false;
    private final String username;
    private final String pass;
    private final ConsumerHelper consumerHelper = new ConsumerHelper();

    private CSVValidationCertificateService service;

    ConsumerByCertificate(Properties properties) {

        logger.info("Creando CSVValidationCertificateService...");

        consumerHelper.checkProperties(properties);
        String wsdlURL = properties.getProperty(ConsumerProperties.WSDL_URL_PARAM);
        username = properties.getProperty(ConsumerProperties.USER_PARAM);
        pass = properties.getProperty(ConsumerProperties.PASS_PARAM);

        try {
            createClient(wsdlURL);
            configureChunking();
            configureSecurity(properties);

        } catch (Exception e) {
            throw new CsvBrokerConsumerException(String.format("Error creando el cliente WS de la URL %s : %s", wsdlURL, e.getLocalizedMessage()), e);
        }
        logger.info("CSVValidationCertificateService creado");
    }

    private void configureChunking() {
        consumerHelper.disableChunking(ClientProxy.getClient(service));
    }

    private void createClient(String wsdlURL){
        logger.info("Creando cliente CSVValidationCertificateService...");
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(CSVValidationCertificateService.class);
        jaxWsProxyFactoryBean.setAddress(wsdlURL);
        jaxWsProxyFactoryBean.setFeatures(new ArrayList<>(Collections.singletonList(consumerHelper.loggingFeature())));
        service = (CSVValidationCertificateService) jaxWsProxyFactoryBean.create();
        logger.info("Cliente CSVValidationCertificateService creado");
    }

   private void configureSecurity(Properties cryptoProperties){

        logger.info("Configurando seguridad WS-SEC x.509 Certificate");

        Client c = ClientProxy.getClient(service);
        Endpoint cxfEndpoint = c.getEndpoint();

        cxfEndpoint.getOutInterceptors().add(wss4JOutInterceptor(cryptoProperties));

        //Si está a true se exigiría que la respuesta del servidor estuviera firmada. Actualmente
        //se acepta cualquier tipo de respuesta
        if(SIGNED_RESPONSE_REQUIRED){
            if(logger.isDebugEnabled()){
                logger.debug("Requerimos que la respuesta esté firmada");
            }
            cxfEndpoint.getInInterceptors().add(wss4JInInterceptor(cryptoProperties));
            cxfEndpoint.getInInterceptors().add(new DefaultCryptoCoverageChecker());
        }

        logger.info("Seguridad WS-SEC x.509 Certificate configurada");
    }

    private WSS4JInInterceptor wss4JInInterceptor(Properties cryptoProperties) {
        Map<String, Object> inProps = new HashMap<>();
        inProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        inProps.put(WSHandlerConstants.USER, username);
        inProps.put(WSHandlerConstants.SIG_PROP_REF_ID, SIG_PROP_REF_ID);
        inProps.put(SIG_PROP_REF_ID, cryptoProperties);
        inProps.put(WSHandlerConstants.PW_CALLBACK_REF, new ClientKeystorePasswordCallback(username, pass));
        return new WSS4JInInterceptor(inProps);
    }

    private WSS4JOutInterceptor wss4JOutInterceptor(Properties cryptoProperties) {
        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        outProps.put(WSHandlerConstants.USER, username);
        outProps.put(WSHandlerConstants.SIG_PROP_REF_ID, SIG_PROP_REF_ID);
        outProps.put(SIG_PROP_REF_ID, cryptoProperties);
        outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, new ClientKeystorePasswordCallback(username, pass));

        return new WSS4JOutInterceptor(outProps);
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
