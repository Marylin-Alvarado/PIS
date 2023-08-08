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
    
    public void guardarPapeleta(Integer voto) throws Exception{
        getPapeleta().setId_candidato(voto);
        guardar(papeleta);
    }
    
}
