package es.gob.csvbroker.consumer;

import es.gob.csvbroker.consumer.model.ConsultarCsvRequest;
import es.gob.csvbroker.consumer.model.ConsultarCsvResponse;
import es.gob.csvbroker.consumer.model.ResponseBuilder;
import es.gob.csvbroker.consumer.ws.model.*;

import java.util.ArrayList;

class ConsumerMapper {

    private ConsumerMapper() {}

    public static CSVValidationSecurityRequest mapToWsRequest(ConsultarCsvRequest request) {
        CSVValidationSecurityRequest wsRequest = new CSVValidationSecurityRequest();
        wsRequest.setCsv(request.getCsv());
        wsRequest.setDocumentoEni(request.isDocumentoEni() ? DocumentoEni.S : DocumentoEni.N);
        wsRequest.setNif(request.getNif());
        OrganizationList wsOrganizationList = new OrganizationList();
        wsOrganizationList.getOrganization().addAll(request.getUnidadesDir3());
        wsRequest.setOrganizationList(wsOrganizationList);
        wsRequest.setRecuperacionOriginal(request.isRecuperacionOriginal() ? RecuperacionOriginal.S : RecuperacionOriginal.N);
        return wsRequest;
    }

    public static ConsultarCsvResponse mapToResponse(CSVValidationSecurityResponse wsResponse) {
        ResponseBuilder responseBuilder = ConsultarCsvResponse.builder()
                .withCodigo(wsResponse.getCode())
                .withDescripcion(wsResponse.getDescription())
                .withUnidadesDir3(((wsResponse.getOrganizationResponse() == null || wsResponse.getOrganizationResponse().getOrganizationList() == null)
                        ? new ArrayList<>()
                        : wsResponse.getOrganizationResponse().getOrganizationList().getOrganization()));
        if(wsResponse.getDocumentUrlResponse() != null){
            responseBuilder.withDocumento(wsResponse.getDocumentUrlResponse().getName(),
                    wsResponse.getDocumentUrlResponse().getMime(),
                    wsResponse.getDocumentUrlResponse().getContent(),
                    wsResponse.getDocumentUrlResponse().getUrl());
        }
        return responseBuilder.build();
    }
}
