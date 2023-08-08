package modelo;

public class Papeleta {

    private Integer id; // genera automaticamente
    private Integer id_candidato; // id de la persona por la que se vota

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(Integer id_candidato) {
        this.id_candidato = id_candidato;
    }
    
}
