package vista;

import controlador.DAO.CandidatoDao;
import controlador.DAO.DignidadDao;
import controlador.DAO.PapeletaDao;
import controlador.DAO.PartidoPoliticoDao;
import controlador.DAO.PersonaDAO;
import controlador.DAO.VotoDao;
import controlador.ed.listas.ListaEnlazada;
import controlador.ed.listas.exception.ListaNullException;
import controlador.ed.listas.exception.PosicionNoEncontradaException;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import modelo.Candidato;
import modelo.Partido_Politico;
import vista.Utilidades.Utilidades;

public class FrmPapeletas extends javax.swing.JDialog {

    
    private CandidatoDao daoCandidato = new CandidatoDao();
    private VotoDao vd = new VotoDao();
    private PartidoPoliticoDao dao = new PartidoPoliticoDao();
    private DignidadDao daoDignidad = new DignidadDao();
    private ListaEnlazada<pnCandidatos> paneles = new ListaEnlazada<>();
    private PapeletaDao daoPapeleta = new PapeletaDao();
    private Map<String, Integer> partidoIdMap;
    private int id_candidato=0;
    private int id_partido=0;
    private String nombre="";
    private Integer id_persona=0;
    private PersonaDAO pd = new PersonaDAO();
   
    public FrmPapeletas(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        agregarCandidatos();
    }

    public FrmPapeletas(java.awt.Frame parent, boolean modal, ListaEnlazada<Candidato> candidatos,Integer id) throws Exception {
        super(parent, modal);
        initComponents();
         agregarCandidatos();
        id_persona = id;
       
    }

    private void agregarCandidatos() throws Exception {
        partidoIdMap = new HashMap<>(); // Mapa para almacenar nombres de partido y sus id correspondientes

        Partido_Politico[] partidos = dao.listar().toArray();
        
       DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (Partido_Politico partido : partidos) {
            comboBoxModel.addElement(partido.getNombre_partido_politico()); // Suponiendo que Partido_Politico tiene un método getNombre()
         partidoIdMap.put(partido.getNombre_partido_politico(), partido.getId());
       
        }

        jComboPartido.setModel(comboBoxModel);

    }
    
    private void mostrarInfo(){
        JOptionPane.showMessageDialog(null, "Se ha registrado su voto");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboPartido = new javax.swing.JComboBox<>();
        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnPapeletas = new controlador.utiles.PanelItem();
        btnVotar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jComboPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("CATEGORIA");

        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportView(pnPapeletas);

        btnVotar.setText("Votar");
        btnVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVotarActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Candidatos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelPrincipal.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(284, 284, 284)
                                .addComponent(btnVotar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jComboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitulo)
                .addGap(27, 27, 27)
                .addComponent(jComboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnVotar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   
    private void btnVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVotarActionPerformed
        // TODO add your handling code here:
        PapeletaDao daopapeleta = new PapeletaDao();
        
      if(id_candidato==0 && id_partido==0){
          JOptionPane.showMessageDialog(null, "Primero escoja un candidato");
      }else{
          
            try {
               
                daopapeleta.guardarPapeleta(id_candidato,Utilidades.generarNumeroAleatorio(1,pd.listar().size() ),id_persona);
            } catch (Exception ex) {
                Logger.getLogger(FrmPapeletas.class.getName()).log(Level.SEVERE, null, ex);
            }
          dispose();
           new FrmCertificados(null, true,id_persona).setVisible(true);
      }
      
               
//        pnCandidatos[] list = paneles.toArray();
//        int aux = 0;
//        String nombre = "";
//        for (pnCandidatos c : list) {
//            if (c.check()) {
//                aux++;
//                nombre = c.nombreDig();
//            }
//        }
//
//        if (aux == 0) {
//            try {
//                daoPapeleta.guardarPapeleta(0);
//            } catch (Exception ex) {
//            }
//        }
//
//        if (aux > 1) {
//            try {
//                daoPapeleta.guardarPapeleta(-1);
//            } catch (Exception ex) {
//            }
//        }
//
//        if (aux == 1) {
//            try {
//                daoPapeleta.guardarPapeleta(daoCandidato.buscarPorNombre(nombre).getId());
//            } catch (Exception ex) {
//            }
//        }

    }//GEN-LAST:event_btnVotarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        crearPanelesCandidatos();
        
    }//GEN-LAST:event_jButton1ActionPerformed
private void crearPanelesCandidatos() {
    panelPrincipal.removeAll();
    Partido_Politico[] partidos = dao.listar().toArray();
    String partidoSeleccionado = (String) jComboPartido.getSelectedItem();
    
    if (partidoSeleccionado != null) {
        Integer idSeleccionado = partidoIdMap.get(partidoSeleccionado);
        
        if (idSeleccionado != null) {
            ListaEnlazada<Candidato> aux1 = daoCandidato.buscarCandidatoPorPartidoPolitico(idSeleccionado);
            
            try {
                for (int i = 0; i < aux1.size(); i++) {
                    Candidato candidato = aux1.obtener(i);
                    JPanel panelCandidato = crearPanelCandidato(candidato, partidos);
                    panelPrincipal.add(panelCandidato);
                }
            } catch (PosicionNoEncontradaException e) {
                System.err.println("Posición no encontrada en la lista");
            } catch (ListaNullException e) {
                System.err.println("La lista está vacía");
            }
            
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        } else {
            System.err.println("No existen candidatos");
        }
    }
}

private JPanel crearPanelCandidato(Candidato candidato, Partido_Politico[] partidos) {
    JPanel panelCandidato = new JPanel();
    panelCandidato.setBorder(BorderFactory.createTitledBorder(candidato.getNombre_candidato()));
    
    String nombrePartido = buscarNombrePartidoPorId(candidato.getId_partido_politico(), partidos);
    
    JLabel labelPartido = new JLabel("Partido: " + nombrePartido);
    JLabel labelIdCandidato = new JLabel("ID Candidato: " + candidato.getId());
    
    panelCandidato.add(labelPartido);
    panelCandidato.add(labelIdCandidato);
    
    panelCandidato.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
           // Desresaltar todos los paneles primero
for (Component component : panelPrincipal.getComponents()) {
    if (component instanceof JPanel) {
        ((JPanel) component).setBorder(BorderFactory.createEmptyBorder());
    }
}

            
            // Resaltar el panel seleccionado con un borde
panelCandidato.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            
            // Imprimir ID del candidato y del partido
//            System.out.println("ID Candidato: " + candidato.getId());
            id_candidato=candidato.getId();
            id_partido=candidato.getId_partido_politico();
            //System.out.println("ID Partido: " + candidato.getId_partido_politico());
        }
    });
    
    return panelCandidato;
}

private String buscarNombrePartidoPorId(Integer idPartido, Partido_Politico[] partidos) {
    for (Partido_Politico partido : partidos) {
        if (partido.getId().equals(idPartido)) {
            return partido.getNombre_partido_politico();
        }
    }
    return "Partido no encontrado";
}



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmPapeletas dialog = new FrmPapeletas(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPapeletas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVotar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboPartido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelPrincipal;
    private controlador.utiles.PanelItem pnPapeletas;
    // End of variables declaration//GEN-END:variables
}
