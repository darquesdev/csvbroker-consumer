
package es.gob.csvbroker.consumer.model;

public enum Identificacion {

    CLAVE_PERM("CLAVE_PERM"),
    PIN_24("PIN24"),
    DNIE("DNIE"),
    PF_2_CA("PF_2CA"),
    PJ_2_CA("PJ_2CA"),
    COMPONENTESSL("COMPONENTESSL"),
    SEDE_ELECTRONICA("SEDE_ELECTRONICA"),
    SELLO_ORGANO("SELLO_ORGANO"),
    EMPLEADO_PUBLICO("EMPLEADO_PUBLICO"),
    ENTIDAD_NO_PERSONA_JURIDICA("ENTIDAD_NO_PERSONA_JURIDICA"),
    EMPLEADO_PUBLICO_PSEUD("EMPLEADO_PUBLICO_PSEUD"),
    CUALIFICADO_SELLO_ENTIDAD("CUALIFICADO_SELLO_ENTIDAD"),
    CUALIFICADO_AUTENTICACION("CUALIFICADO_AUTENTICACION"),
    CUALIFICADO_SELLO_TIEMPO("CUALIFICADO_SELLO_TIEMPO"),
    REPRESENTACION_PJ("REPRESENTACION_PJ"),
    REPRESENTACION_ENTIDAD_SIN_PF("REPRESENTACION_ENTIDAD_SIN_PF");

    private final String value;

    Identificacion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Identificacion fromValue(String v) {
        for (Identificacion c: Identificacion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
