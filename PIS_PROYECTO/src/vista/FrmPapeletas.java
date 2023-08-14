package vista;

import controlador.DAO.CandidatoDao;
import controlador.DAO.DignidadDao;
import controlador.DAO.PapeletaDao;
import controlador.DAO.PartidoPoliticoDao;
import controlador.ed.listas.ListaEnlazada;
import java.util.Objects;
import javax.swing.JOptionPane;
import modelo.Candidato;
import modelo.Partido_Politico;

public class FrmPapeletas extends javax.swing.JDialog {

    private CandidatoDao daoCandidato = new CandidatoDao();
    private PartidoPoliticoDao dao = new PartidoPoliticoDao();
    private DignidadDao daoDignidad = new DignidadDao();
    private ListaEnlazada<pnCandidatos> paneles = new ListaEnlazada<>();
    private PapeletaDao daoPapeleta = new PapeletaDao();

    public FrmPapeletas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public FrmPapeletas(java.awt.Frame parent, boolean modal, ListaEnlazada<Candidato> candidatos) {
        super(parent, modal);
        initComponents();
    }

    private void agregarCandidatos(ListaEnlazada<Candidato> candidatos, String tipo) throws Exception {
        Partido_Politico[] partidos = dao.listar().toArray();
        Candidato[] aux = candidatos.toArray();
        String dignidad = "";
        if (tipo.equalsIgnoreCase("ejecutiva")) {
            dignidad = "Presidente";
        }
        if (tipo.equalsIgnoreCase("legislativa")) {
            dignidad = "Diputado";
        }
        if (tipo.equalsIgnoreCase("local")) {
            dignidad = "Alcalde";
        }

        for (Partido_Politico partido : partidos) {
            Candidato primer = null;
            Candidato segundo = null;
            for (Candidato c : aux) {
                if (Objects.equals(c.getId_partido_politico(), partido.getId())) {
                    if (daoDignidad.buscarPorId(c.getId_dignidad()).equals(dignidad)) {
                        primer = c;
                    } else {
                        segundo = c;
                    }
                }
            }
            pnCandidatos c = new pnCandidatos();
            c.setInfo(primer, segundo);
            paneles.insertar(c);

            pnPapeletas.add(c);
            pnPapeletas.repaint();
            pnPapeletas.revalidate();
        }
    }
    
    private void mostrarInfo(){
        JOptionPane.showMessageDialog(null, "Se ha registrado su boto");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnPapeletas = new controlador.utiles.PanelItem();
        btnVotar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(btnVotar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitulo)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnVotar)
                .addContainerGap(20, Short.MAX_VALUE))
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
        pnCandidatos[] list = paneles.toArray();
        int aux = 0;
        String nombre = "";
        for (pnCandidatos c : list) {
            if (c.check()) {
                aux++;
                nombre = c.nombreDig();
            }
        }

        if (aux == 0) {
            try {
                daoPapeleta.guardarPapeleta(0);
            } catch (Exception ex) {
            }
        }

        if (aux > 1) {
            try {
                daoPapeleta.guardarPapeleta(-1);
            } catch (Exception ex) {
            }
        }

        if (aux == 1) {
            try {
                daoPapeleta.guardarPapeleta(daoCandidato.buscarPorNombre(nombre).getId());
            } catch (Exception ex) {
            }
        }

    }//GEN-LAST:event_btnVotarActionPerformed

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
                FrmPapeletas dialog = new FrmPapeletas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVotar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitulo;
    private controlador.utiles.PanelItem pnPapeletas;
    // End of variables declaration//GEN-END:variables
}
