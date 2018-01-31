package es.gob.csvbroker.consumer;

public enum ConsumerActions {

    CONSULTAR_CSV {
        @Override
        public String toString() {
            return "consultarCsv";
        }
    }
}
