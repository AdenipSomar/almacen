/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Ciudad;
import modelo.CiudadDAO;

/**
 *
 * @author ramos
 */
public class CiudadView extends javax.swing.JFrame {
  Ciudad ciudad = new Ciudad(); //importar los datos de ciudad
  CiudadDAO ciudadDao = new CiudadDAO();//importando los metodos de ciudadDAO

 private Sistema sistema;
 
     DefaultTableModel modelo = new DefaultTableModel(); //se crea el modelo para las tablas para listar
     DefaultTableModel tmp = new DefaultTableModel();
     
  public CiudadView(Sistema sistema) {
        initComponents();
        this.sistema = sistema ;
        this.setTitle("Ciudad Proveedor");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
        listarCiudad(); //mostrando la tabla ciudad listada desde el inicio
        limpiarCiudad(); //Mostrando metodo para limpiar la ciudad
        
  
  }

    private CiudadView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public void limpiarTable(){ 
// para que no se repitan los datos del cliente al mostrarse en las tablas
    for (int i=0; i<modelo.getRowCount();i++){
        modelo.removeRow(i);
        i= i-1;
    }
    }
  public void listarCiudad(){
       //para que se puedan listar las ciudades en la tabla ciudad
   List<Ciudad> listarCiudad = ciudadDao.listarCiudad();
   modelo = (DefaultTableModel) tableCiudad.getModel();
   Object[] obj = new Object[2];
   for (int i=0; i < listarCiudad.size(); i++ ){
   obj[0]=listarCiudad.get(i).getCodPostal();
   obj[1]=listarCiudad.get(i).getNombreCiudad();
   modelo.addRow(obj);
        }
   tableCiudad.setModel(modelo);
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCiudadProveedor = new javax.swing.JLabel();
        lblCodigoPostal = new javax.swing.JLabel();
        lblNombreCiudad = new javax.swing.JLabel();
        txtCodigoPostal = new javax.swing.JTextField();
        txtNombreCiudad = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarCiudad = new javax.swing.JButton();
        btnModificarCiudad = new javax.swing.JButton();
        btnCancelarCiudad = new javax.swing.JButton();
        btnEliminarCiudad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCiudad = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCiudadProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblCiudadProveedor.setText("Ciudad Proveedor");

        lblCodigoPostal.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblCodigoPostal.setText("Codigo Postal: ");

        lblNombreCiudad.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblNombreCiudad.setText("Nombre Ciudad:");

        txtCodigoPostal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoPostalKeyTyped(evt);
            }
        });

        txtNombreCiudad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreCiudadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCiudadKeyTyped(evt);
            }
        });

        btnAgregarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarCiudad.setText("Agregar");
        btnAgregarCiudad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCiudadActionPerformed(evt);
            }
        });

        btnModificarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btnModificarCiudad.setText("Modificar");
        btnModificarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarCiudadActionPerformed(evt);
            }
        });

        btnCancelarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelarCiudad.setText("Cancelar");
        btnCancelarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCiudadActionPerformed(evt);
            }
        });

        btnEliminarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarCiudad.setText("Eliminar");
        btnEliminarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tableCiudad.setFont(new java.awt.Font("Britannic Bold", 0, 14)); // NOI18N
        tableCiudad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Postal", "Nombre de la Ciudad"
            }
        ));
        tableCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCiudadMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCiudad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigoPostal)
                            .addComponent(lblNombreCiudad))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigoPostal)
                            .addComponent(txtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(173, 173, 173))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblCiudadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCiudadProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPostal)
                    .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCiudad)
                    .addComponent(txtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCiudadActionPerformed
  
        if(!"".equals(txtCodigoPostal.getText())&&!"".equals(txtNombreCiudad.getText())){
        ciudad.setCodPostal(txtCodigoPostal.getText());
        ciudad.setNombreCiudad(txtNombreCiudad.getText());     
        ciudadDao.registrarCiudad(ciudad); //se manda a traer del DAO ciudad la funcion registrar
        JOptionPane.showMessageDialog(null, "Ciudad Registrado con exito!!");
        limpiarCiudad();
        limpiarTable();
        listarCiudad();    
        sistema.cargaComboCompleto();
        
        
        }else{
        JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        
    }                    
    }//GEN-LAST:event_btnAgregarCiudadActionPerformed

    private void btnModificarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarCiudadActionPerformed
       if("".equals(txtCodigoPostal.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{  
        if(!"".equals(txtCodigoPostal.getText())&& !"".equals(txtNombreCiudad.getText())){
        ciudad.setCodPostal(txtCodigoPostal.getText());
        ciudad.setNombreCiudad(txtNombreCiudad.getText());
        ciudadDao.ModificarCiudad(ciudad);
        JOptionPane.showMessageDialog(null,"Modificado con exito");
        limpiarTable();
        limpiarCiudad();
        listarCiudad();
        sistema.cargaComboCompleto();
        }else{
        JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
      }     
    }//GEN-LAST:event_btnModificarCiudadActionPerformed

    private void tableCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCiudadMouseClicked
     //para que cuando se seleccione una fila se muestren
     //en los txt de la parte superior
        int fila = tableCiudad.rowAtPoint(evt.getPoint());
        
        txtCodigoPostal.setText(tableCiudad.getValueAt(fila,0).toString());
        txtNombreCiudad.setText(tableCiudad.getValueAt(fila,1).toString());
        
        btnAgregarCiudad.setEnabled(false);
        btnModificarCiudad.setEnabled(true);
        txtCodigoPostal.setEnabled(false);
        btnCancelarCiudad.setEnabled(true);
        btnEliminarCiudad.setEnabled(true);
    }//GEN-LAST:event_tableCiudadMouseClicked

    private void txtNombreCiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCiudadKeyReleased
       //Para poder que todo el text se pase a mayusculas
        String texto_Mayuscula= (txtNombreCiudad.getText()).toUpperCase();
        txtNombreCiudad.setText(texto_Mayuscula);
    }//GEN-LAST:event_txtNombreCiudadKeyReleased

    private void txtCodigoPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoPostalKeyTyped
        //para que solo se pueda ingresar 5 valores dentro del txtCodigo Postal
        if(txtCodigoPostal.getText().length() >= 5)evt.consume();
        // declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
        
    }//GEN-LAST:event_txtCodigoPostalKeyTyped

    private void txtNombreCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCiudadKeyTyped
       // declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCiudadKeyTyped

    private void btnCancelarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCiudadActionPerformed
       limpiarCiudad();
    }//GEN-LAST:event_btnCancelarCiudadActionPerformed

    private void btnEliminarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCiudadActionPerformed
         
        if (!"".equals(txtCodigoPostal.getText())) {
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar?");
        
        if (pregunta == 0) {
            String id = txtCodigoPostal.getText();
            boolean eliminado = ciudadDao.eliminarCiudad(id);
            limpiarCiudad();
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "Eliminado correctamente!!");
                limpiarCiudad();
                limpiarTable();
                listarCiudad();
                sistema.cargaComboCompleto();
            } else {
                // No es necesario un mensaje adicional aquí porque el DAO ya muestra el mensaje de error
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un registro para eliminar.");
    } 
    }//GEN-LAST:event_btnEliminarCiudadActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ciudad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CiudadView().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCiudad;
    private javax.swing.JButton btnCancelarCiudad;
    private javax.swing.JButton btnEliminarCiudad;
    private javax.swing.JButton btnModificarCiudad;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCiudadProveedor;
    private javax.swing.JLabel lblCodigoPostal;
    private javax.swing.JLabel lblNombreCiudad;
    private javax.swing.JTable tableCiudad;
    private javax.swing.JTextField txtCodigoPostal;
    private javax.swing.JTextField txtNombreCiudad;
    // End of variables declaration//GEN-END:variables
private void limpiarCiudad(){
txtCodigoPostal.setText("");
txtNombreCiudad.setText("");
 agregarCiudad();
}
private void agregarCiudad(){
    txtCodigoPostal.setEnabled(true);
    btnAgregarCiudad.setEnabled(true);
    btnModificarCiudad.setEnabled(false);
    btnCancelarCiudad.setEnabled(true);
    btnEliminarCiudad.setEnabled(false);
}
 
}
