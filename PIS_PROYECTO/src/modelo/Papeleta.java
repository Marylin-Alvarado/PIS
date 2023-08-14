package modelo;

public class Papeleta {

    private Integer id; // genera automaticamente
    private Integer id_candidato; // id de la persona por la que se vota
    private Integer id_voto; // id de la persona por la que se vota
    private Integer id_persona; // id de la persona por la que se vota
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

    public Integer getId_voto() {
        return id_voto;
    }

    public void setId_voto(Integer id_voto) {
        this.id_voto = id_voto;
    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }
    
}
