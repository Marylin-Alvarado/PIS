package vista;

public class pnDignidad extends javax.swing.JPanel {

    public pnDignidad() {
        initComponents();
    }

    public void setInfo(String tipo){
        lbTIpoDignidad.setText(tipo);
    }
    
    public String info(){
        return lbTIpoDignidad.getText();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTIpoDignidad = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 51, 0));

        lbTIpoDignidad.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbTIpoDignidad.setForeground(new java.awt.Color(255, 255, 255));
        lbTIpoDignidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTIpoDignidad.setText("TIPO DE DIGNIDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTIpoDignidad, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTIpoDignidad)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbTIpoDignidad;
    // End of variables declaration//GEN-END:variables
}
