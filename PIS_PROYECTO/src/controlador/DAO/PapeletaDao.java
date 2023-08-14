package controlador.DAO;

import modelo.Papeleta;

public class PapeletaDao extends AdaptadorDAO<Papeleta>{
    
    /**
     * Atributo de papeleta
     */
    private Papeleta papeleta;
    
    /**
     * Constructor de papeleta Dao
     */
    public PapeletaDao(){
        super(Papeleta.class);
    }
    
    /**
     * Metodo de get de papeleta
     * @return 
     */
    public Papeleta getPapeleta() {
        if(papeleta == null){
            papeleta = new Papeleta();
        }
        return papeleta;
    }

    /**
     * Metodo de set de papeleta
     * @param papeleta 
     */
    public void setPapeleta(Papeleta papeleta) {
        this.papeleta = papeleta;
    }
    

    /**
     * Metodo de guardar la papeleta
     * @param candidato
     * @param voto
     * @param persona
     * @throws Exception 
     */

    public void guardarPapeleta(Integer candidato,Integer voto,Integer persona) throws Exception{
        getPapeleta().setId_candidato(candidato);
        getPapeleta().setId_persona(persona);
        getPapeleta().setId_voto(voto);
        guardar(papeleta);
    }
    
}
