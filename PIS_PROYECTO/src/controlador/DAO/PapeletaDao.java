package controlador.DAO;

import modelo.Papeleta;

public class PapeletaDao extends AdaptadorDAO<Papeleta>{
    
    private Papeleta papeleta;
    
    public PapeletaDao(){
        super(Papeleta.class);
    }
    
    public Papeleta getPapeleta() {
        if(papeleta == null){
            papeleta = new Papeleta();
        }
        return papeleta;
    }

    public void setPapeleta(Papeleta papeleta) {
        this.papeleta = papeleta;
    }
    
    public void guardarPapeleta(Integer candidato,Integer voto,Integer persona) throws Exception{
        getPapeleta().setId_candidato(candidato);
        getPapeleta().setId_persona(persona);
        getPapeleta().setId_voto(voto);
        guardar(papeleta);
    }
    
}
