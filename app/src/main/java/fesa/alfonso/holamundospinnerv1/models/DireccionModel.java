package fesa.alfonso.holamundospinnerv1.models;
public class DireccionModel {
    private EstadoModel estado;
    private String municipio;
    private String colonia;
    private String calleNumero;
    private String referencia;

    public DireccionModel(EstadoModel estado, String municipio, String colonia, String calleNumero, String referencia) {
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        this.calleNumero = calleNumero;
        this.referencia = referencia;
    }

    public EstadoModel getEstado() {
        return estado;
    }

    public void setEstado(EstadoModel estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalleNumero() {
        return calleNumero;
    }

    public void setCalleNumero(String calleNumero) {
        this.calleNumero = calleNumero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public String toString() {
        return "DireccionModel{" +
                "estado=" + (estado != null ? estado.getNombre() : "null") +
                ", municipio='" + municipio + '\'' +
                ", colonia='" + colonia + '\'' +
                ", calleNumero='" + calleNumero + '\'' +
                ", referencia='" + referencia + '\'' +
                '}';
    }
}