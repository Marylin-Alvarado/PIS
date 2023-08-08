package modelo;


public class Dignidad {

    private String tipo;
    private Integer id;
    private Integer nro_dignidad;
    private String categorias;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public Integer getNro_dignidad() {
        return nro_dignidad;
    }

    public void setNro_dignidad(Integer nro_dignidad) {
        this.nro_dignidad = nro_dignidad;
    }
}
