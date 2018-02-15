package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;
import es.gob.csvbroker.consumer.model.CsvBrokerConsumerException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsumerByUsernameTokenTest {

    private CsvBrokerConsumer consumer;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private void createConsumerWithValidCredentials() throws IOException {
        InputStream inputProperties = this.getClass().getResourceAsStream("/csvbroker-usernametoken.properties");
        Properties properties = new Properties();
        properties.load(inputProperties);
        this.consumer = CsvBrokerConsumerFactory.createConsumerByUsernameToken(properties);
    }

    private void createConsumerWithInvalidCredentials() throws IOException {
        InputStream inputProperties = this.getClass().getResourceAsStream("/csvbroker-usernametoken.properties");
        Properties properties = new Properties();
        properties.load(inputProperties);
        properties.setProperty(ConsumerProperties.USER_PARAM, "XXX");
        this.consumer = CsvBrokerConsumerFactory.createConsumerByUsernameToken(properties);
    }

    @Test
    public void consultarCsvSinProductorValido() throws Exception {

        createConsumerWithValidCredentials();

        ConsultarCsvResponse response = consumer.consultarCsv(ConsultarCsvRequest.builder("PRU-whatever").build());

        //then
        assertThat(response, is(not(nullValue())));
        assertThat(response.getCodigo(), is("5"));
        assertThat(response.getDocumento(), is(nullValue()));
    }

    @Test
    public void consultarCsvConCredencialesErroneas() throws Exception {

        createConsumerWithInvalidCredentials();

        exception.expect(CsvBrokerConsumerException.class);
        exception.expectMessage("A security error was encountered when verifying the message");

        ConsultarCsvResponse response = consumer.consultarCsv(ConsultarCsvRequest.builder("PRU-whatever").build());

    }

    @Test
    public void consultarCsvInexistente() throws Exception {

        createConsumerWithValidCredentials();
        //PRU-[a-f,A-F,0-9]{32}
        ConsultarCsvResponse response = consumer.consultarCsv(ConsultarCsvRequest.builder("PRU-XXXX-1111-1111-1111-1111-0833-1606-2017").build());

        //then
        assertThat(response, is(not(nullValue())));
        assertThat(response.getCodigo(), is("5"));
        assertThat(response.getDocumento(), is(nullValue()));
    }

    @Test
    public void consultarCsvExistente() throws Exception {

        createConsumerWithValidCredentials();
        //PRU-[a-f,A-F,0-9]{32}
        ConsultarCsvResponse response = consumer.consultarCsv(ConsultarCsvRequest.builder("PRU-1111-1111-1111-1111-1111-0833-1606-2017").build());

        //then
        assertThat(response, is(not(nullValue())));
        assertThat(response.getCodigo(), is("0"));
        assertThat(response.getDocumento(), is(not(nullValue())));
    }
}