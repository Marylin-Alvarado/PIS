/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.CuentaDAO;
import controlador.DAO.PersonaDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.enums.Generos;
import vista.modeloTabla.ModeloTablaRegistrados;

/**
 *
 * @author Edison
 */
public class FrmCuenta extends javax.swing.JDialog {

    private CuentaDAO cd = new CuentaDAO();
    private PersonaDAO pc = new PersonaDAO();
    private ModeloTablaRegistrados mdr = new ModeloTablaRegistrados();

    /**
     * Creates new form FrmCuenta
     */
    public FrmCuenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        
        cargarGenero(cbxGenero);

        SetImageLabel(jblIconCrear, "C:\\Users\\Edison\\Desktop\\PIS-main\\PIS\\PIS_PROYECTO\\src\\imagenes\\imagen-removebg-preview(1).png");
        SetImageLabel(lblNombreTitulo, "C:\\Users\\Edison\\Desktop\\PIS-main\\PIS\\PIS_PROYECTO\\src\\imagenes\\imagen-removebg-preview(8).png");
        SetImageLabel(jLabel7, "C:\\Users\\Edison\\Desktop\\PIS-main\\PIS\\PIS_PROYECTO\\src\\imagenes\\imagen-removebg-preview(18).png");

    }
    public FrmCuenta(java.awt.Frame parent, boolean modal,PersonaDAO pd) {
        super(parent, modal);
        initComponents();
        this.pc = pd;
        this.setLocationRelativeTo(this);
        
        cargarGenero(cbxGenero);

        SetImageLabel(jblIconCrear, "C:\\Users\\Edison\\Downloads\\imagen-removebg-preview(1).png");
        SetImageLabel(lblNombreTitulo, "C:\\Users\\Edison\\Downloads\\imagen-removebg-preview(8).png");
        SetImageLabel(jLabel7, "C:\\Users\\Edison\\Downloads\\imagen-removebg-preview(18).png");

    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    }

    private void guardarPersona() {
        try {
            if (!txtNombreApellidos.getText().isEmpty() || !txtCorreoElec.getText().isEmpty()
                    || !txtNumCedula.getText().isEmpty() || !txtCodigoDac.getText().isEmpty()) {
                this.pc.getPersona().setNombres_completos(txtNombreApellidos.getText());
                this.pc.getPersona().setIdentificacion(Integer.parseInt(txtNumCedula.getText()));
                this.pc.getPersona().setCodigoDac(txtCodigoDac.getText());//
                this.pc.getPersona().setFechaNacimiento(dteFechaNacimiento.getDate());
                this.pc.getPersona().setGenero((Generos) cbxGenero.getSelectedItem());
                this.pc.getPersona().setCorreo(txtCorreoElec.getText());
                this.pc.guardar();
                validarEdad();
                limpiar();

                JOptionPane.showMessageDialog(null, "Se ha guardado ", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    private void guardar(){
        try {
            if (!txtUsuario.getText().isEmpty()||!txtContrasenia.getText().isEmpty()) {
                this.cd.getCuenta().setUsuario(txtUsuario.getText());
                this.cd.getCuenta().setContrasenia(txtContrasenia.getText());
                this.cd.guardar();
                limpiar();
                
                JOptionPane.showMessageDialog(null, "Se ha guardado ", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ya existe el usuario ingrese uno usuario diferente", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        }
    }

    private void limpiar() {
        this.cd.setCuenta(null);
        txtNombreApellidos.setText("");
        txtCorreoElec.setText("");
        txtCodigoDac.setText("");
        txtNumCedula.setText("");
        dteFechaNacimiento.setDate(null);
        txtUsuario.setText("");
        txtContrasenia.setText("");
    }

    public static void cargarGenero(JComboBox cbx) {
        cbx.removeAllItems();
        for (Generos genero : Generos.values()) {
            cbx.addItem(genero);
        }

    }

    private void validarEdad() {
        try {
            Date fechaNacimiento = dteFechaNacimiento.getDate();
            boolean esMayorDeEdad = esMayorDeEdad(fechaNacimiento);

            if (esMayorDeEdad) {
                JOptionPane.showMessageDialog(this, "¡Es mayor de 16 años!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Es menor de edad. Debe tener 16 años o más.", "Informacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean esMayorDeEdad(Date fechaNacimiento) {
        Date fechaActual = new Date();
        int edad = calcularEdad(fechaNacimiento, fechaActual);
        return edad >= 16;
    }

    private int calcularEdad(Date fechaNacimiento, Date fechaActual) {
        long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();
        long anios = diferencia / (1000L * 60 * 60 * 24 * 365);
        return (int) anios;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombreApellidos = new javax.swing.JTextField();
        btnCrearCuenta = new javax.swing.JButton();
        btnRegistros = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jblIconCrear = new javax.swing.JLabel();
        lblNombreTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCorreoElec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigoDac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        btnGuardar = new javax.swing.JButton();
        dteFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNombreApellidos.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        txtNombreApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreApellidosKeyTyped(evt);
            }
        });

        btnCrearCuenta.setBackground(new java.awt.Color(187, 134, 252));
        btnCrearCuenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        btnRegistros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegistros.setText("Ver registros");
        btnRegistros.setEnabled(false);
        btnRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrosActionPerformed(evt);
            }
        });
        btnRegistros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnRegistrosKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(241, 238, 217));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jblIconCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jblIconCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(143, 142, 142));
        jLabel1.setText("Nombres Completos");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(143, 142, 142));
        jLabel2.setText("Correo Electronico");
        jLabel2.setFocusTraversalPolicyProvider(true);

        txtCorreoElec.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        txtCorreoElec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoElecKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(143, 142, 142));
        jLabel3.setText("Numero de cedula o Dni");

        txtNumCedula.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        txtNumCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumCedulaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(143, 142, 142));
        jLabel4.setText("Codigo dactilar");

        txtCodigoDac.setFont(new java.awt.Font("Sylfaen", 0, 12)); // NOI18N
        txtCodigoDac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoDacKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(143, 142, 142));
        jLabel5.setText("Fecha de Nacimiento");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(143, 142, 142));
        jLabel6.setText("Genero");

        cbxGenero.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        cbxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGeneroActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(143, 142, 142));
        jLabel8.setText("Usuario: ");

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(143, 142, 142));
        jLabel9.setText("Contraseña: ");

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(143, 142, 142));
        jLabel10.setText("Confirmar contraseña");

        btnGuardar.setBackground(new java.awt.Color(187, 134, 252));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(lblNombreTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(txtNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(79, 79, 79)
                                            .addComponent(jLabel6))
                                        .addComponent(txtCorreoElec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtNumCedula, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(dteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(txtCodigoDac, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistros)
                                    .addComponent(btnCrearCuenta)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(btnGuardar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dteFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoDac, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreoElec, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistros))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel8.getAccessibleContext().setAccessibleName("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGeneroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxGeneroActionPerformed

    private void txtCodigoDacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoDacKeyTyped
        // TODO add your handling code here:
        if (txtCodigoDac.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No puede ingresar más caracteres", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtCodigoDacKeyTyped

    private void txtNumCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumCedulaKeyTyped
        // TODO add your handling code here:
        if (txtNumCedula.getText().length() >= 10) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No puede ingresar más numeros", "Error", JOptionPane.ERROR_MESSAGE);
        }

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No puede ingresar letras", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtNumCedulaKeyTyped

    private void txtCorreoElecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoElecKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != '@' && c != '.' && Character.isLetter(c)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Solo se permiten letras, '@' y '.'", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Al finalizar la entrada del texto, verificar si contiene el formato correcto
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            String texto = txtCorreoElec.getText();
            if (!texto.matches(".*@.*\\.com$")) {
                JOptionPane.showMessageDialog(this, "El correo electrónico debe contener '@' y terminar con '.com'", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtCorreoElecKeyTyped

    private void btnRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnRegistrosActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void txtNombreApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreApellidosKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (txtNombreApellidos.getText().length() >= 50) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No puede ingresar más caracteres", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //        if ((c < 'a'  c > 'z') && (c < 'A'  c > 'Z')) {
        //            evt.consume();
        //            Toolkit.getDefaultToolkit().beep();
        //            JOptionPane.showMessageDialog(this, "No puede ingresar numeros", "Error", JOptionPane.ERROR_MESSAGE);
        //        }
    }//GEN-LAST:event_txtNombreApellidosKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarPersona();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegistrosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrosKeyReleased
        // TODO add your handling code here:
        if (!txtUsuario.getText().isEmpty()) {
            btnRegistros.setEnabled(true);
            new FrmRegistro(null, true, this.pc).setVisible(true);
        }
    }//GEN-LAST:event_btnRegistrosKeyReleased

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
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCuenta dialog = new FrmCuenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistros;
    private javax.swing.JComboBox<String> cbxGenero;
    private com.toedter.calendar.JDateChooser dteFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel jblIconCrear;
    private javax.swing.JLabel lblNombreTitulo;
    private javax.swing.JTextField txtCodigoDac;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreoElec;
    private javax.swing.JTextField txtNombreApellidos;
    private javax.swing.JTextField txtNumCedula;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
