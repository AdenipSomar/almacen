
package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;
import modelo.conexion;

/**
 *
 * @author ramos
 */
public class Sistema extends javax.swing.JFrame {

   private Connection con;
    
    public Sistema() {
        initComponents();
      
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ObtenerFecha();
        
        con = conexion.getConnection();
    }
    
    private void ObtenerFecha(){
         // Actualiza la fecha cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene la fecha actual en el calendario del sistema
                Calendar calendario = Calendar.getInstance();

                // Obtiene el día, mes y año actual
                int dia = calendario.get(Calendar.DAY_OF_MONTH);
                int mes = calendario.get(Calendar.MONTH) + 1; // Se suma 1 porque los meses empiezan desde 0
                int anio = calendario.get(Calendar.YEAR);

                // Formatea la fecha como "dd/MM/yyyy"
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = String.format("%02d/%02d/%d", dia, mes, anio);

                // Actualiza el texto del JLabel con la fecha formateada
                labelFecha.setText("FECHA: " + fechaFormateada);
            }
        });
        timer.start();
    }
    
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSalidaMaterial = new javax.swing.JButton();
        btnAlmacen = new javax.swing.JButton();
        btnProveedor = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblClaveSalida = new javax.swing.JLabel();
        lblClaveMaterialSalida = new javax.swing.JLabel();
        lblCantidadSalida = new javax.swing.JLabel();
        lblDetalleSalida = new javax.swing.JLabel();
        txtClaveSalida = new javax.swing.JTextField();
        txtCantidadSalida = new javax.swing.JTextField();
        cbxClaveMaterialSalida = new javax.swing.JComboBox<>();
        txtDetalleSalida = new javax.swing.JTextField();
        btnGenerarSalida = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnAgregarAlmacen = new javax.swing.JButton();
        btnModificarAlmacen = new javax.swing.JButton();
        btnCancelarAlmacen = new javax.swing.JButton();
        btnDescargarAlmacen = new javax.swing.JButton();
        lblClaveMateria = new javax.swing.JLabel();
        lblCantidadDisp = new javax.swing.JLabel();
        lblNombreMaterial = new javax.swing.JLabel();
        lblStockMinimo = new javax.swing.JLabel();
        txtClaveMateria = new javax.swing.JTextField();
        txtCantidadDisponible = new javax.swing.JTextField();
        txtNombreMateria = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblClaveProveedor = new javax.swing.JLabel();
        lblRFCProveedor = new javax.swing.JLabel();
        lblTelefonoProveedor = new javax.swing.JLabel();
        lblNombreEncargado = new javax.swing.JLabel();
        lblMaternoEncargado = new javax.swing.JLabel();
        lblNombreProveedor = new javax.swing.JLabel();
        lblCorreoProveedor = new javax.swing.JLabel();
        lblCiudadProveedor = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        txtClaveProveedor = new javax.swing.JTextField();
        txtRFCProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtNombreEncargado = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtCorreoProveedor = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarProveedor = new javax.swing.JButton();
        btnModificarProveedor = new javax.swing.JButton();
        btnCancelarProveedor = new javax.swing.JButton();
        btnDescargarProveedor = new javax.swing.JButton();
        cbxCiudadProveedor = new javax.swing.JComboBox<>();
        btnAgregarCiudad = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblIngresoPedido = new javax.swing.JLabel();
        lblClaveIngreso = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtClaveIngreso = new javax.swing.JTextField();
        txtCantidadIngreso = new javax.swing.JTextField();
        cbxProveedorIngreso = new javax.swing.JComboBox<>();
        cbxMateriaPrimaIngreso = new javax.swing.JComboBox<>();
        txtDetalleIngreso = new javax.swing.JTextField();
        jdcFechaIngreso = new com.toedter.calendar.JDateChooser();
        cbEstadoIngreso = new javax.swing.JCheckBox();
        txtCostoTotalIngreso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("final");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 670, -1, -1));

        jPanel1.setBackground(new java.awt.Color(170, 250, 230));

        btnSalidaMaterial.setText("Salida Material");
        btnSalidaMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaMaterialActionPerformed(evt);
            }
        });

        btnAlmacen.setText("Almacén");
        btnAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlmacenActionPerformed(evt);
            }
        });

        btnProveedor.setText("Proveedor");
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        btnPedidos.setText("Ingreso Pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalidaMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(btnSalidaMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 690));

        jPanel2.setBackground(new java.awt.Color(170, 250, 230));

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 48)); // NOI18N
        jLabel1.setText("TORTILLERÍA \"SHTII DXII JMA\"");

        labelFecha.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        labelFecha.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1090, 110));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Britannic Bold", 0, 36)); // NOI18N
        jLabel3.setText("SALIDA DE MATERIAL");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 27, -1, 31));

        lblClaveSalida.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblClaveSalida.setText("Clave Salida: ");
        jPanel3.add(lblClaveSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 113, -1, -1));

        lblClaveMaterialSalida.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblClaveMaterialSalida.setText("Clave Material: ");
        jPanel3.add(lblClaveMaterialSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 195, -1, -1));

        lblCantidadSalida.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblCantidadSalida.setText("Cantidad: ");
        jPanel3.add(lblCantidadSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 264, -1, -1));

        lblDetalleSalida.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblDetalleSalida.setText("Detalle: ");
        jPanel3.add(lblDetalleSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 349, -1, -1));
        jPanel3.add(txtClaveSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 104, 222, 33));
        jPanel3.add(txtCantidadSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 263, 222, 35));

        cbxClaveMaterialSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxClaveMaterialSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 195, 221, 33));
        jPanel3.add(txtDetalleSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 347, 222, 36));

        btnGenerarSalida.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        btnGenerarSalida.setText("Generar Salida");
        jPanel3.add(btnGenerarSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 427, 206, 43));

        jTabbedPane1.addTab("Salida Material", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel4.setText("ALMACÉN");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 11, 135, 38));

        btnAgregarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarAlmacen.setText("Agregar");
        btnAgregarAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnModificarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btnModificarAlmacen.setText("Modificar");

        btnCancelarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelarAlmacen.setText("Cancelar");

        btnDescargarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descarga.png"))); // NOI18N
        btnDescargarAlmacen.setText("Descarga");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAgregarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnCancelarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnDescargarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 438, -1, -1));

        lblClaveMateria.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblClaveMateria.setText("Clave Materia:");
        jPanel4.add(lblClaveMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 104, 171, -1));

        lblCantidadDisp.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblCantidadDisp.setText("Catidad Disponible:");
        jPanel4.add(lblCantidadDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 170, -1, -1));

        lblNombreMaterial.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblNombreMaterial.setText("Nombre Material: ");
        jPanel4.add(lblNombreMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 104, -1, -1));

        lblStockMinimo.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblStockMinimo.setText("Stock Mínimo: ");
        jPanel4.add(lblStockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));
        jPanel4.add(txtClaveMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 108, 203, 24));
        jPanel4.add(txtCantidadDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 174, 206, 24));
        jPanel4.add(txtNombreMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 106, 214, 28));
        jPanel4.add(txtStockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 172, 222, 28));

        jTabbedPane1.addTab("Almacén", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel5.setText("Proveedor");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 11, 133, 30));

        lblClaveProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblClaveProveedor.setText("Clave Proveedor: ");
        jPanel5.add(lblClaveProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 64, -1, -1));

        lblRFCProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblRFCProveedor.setText("RFC Proveedor: ");
        jPanel5.add(lblRFCProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 113, -1, -1));

        lblTelefonoProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblTelefonoProveedor.setText("Teléfono Proveedor: ");
        jPanel5.add(lblTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 162, -1, -1));

        lblNombreEncargado.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblNombreEncargado.setText("Nombre Encargado: ");
        jPanel5.add(lblNombreEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 213, -1, -1));

        lblMaternoEncargado.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblMaternoEncargado.setText("Apellido Materno: ");
        jPanel5.add(lblMaternoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 269, -1, -1));

        lblNombreProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblNombreProveedor.setText("Nombre Proveedor: ");
        jPanel5.add(lblNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 64, -1, -1));

        lblCorreoProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblCorreoProveedor.setText("Correo Proveedor: ");
        jPanel5.add(lblCorreoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 113, -1, -1));

        lblCiudadProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblCiudadProveedor.setText("Ciudad Proveedor: ");
        jPanel5.add(lblCiudadProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 162, -1, -1));

        lblApellidoPaterno.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno: ");
        jPanel5.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 213, -1, -1));
        jPanel5.add(txtClaveProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 61, 233, 29));
        jPanel5.add(txtRFCProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 110, 233, 28));
        jPanel5.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 159, 232, 29));
        jPanel5.add(txtNombreEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 210, 233, 28));
        jPanel5.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 258, 233, 29));
        jPanel5.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 59, 287, 32));
        jPanel5.add(txtCorreoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 109, 287, 30));
        jPanel5.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 208, 315, 32));

        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btnModificarProveedor.setText("Modificar");

        btnCancelarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelarProveedor.setText("Cancelar");

        btnDescargarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descarga.png"))); // NOI18N
        btnDescargarProveedor.setText("Descarga");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnCancelarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnDescargarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 448, -1, -1));

        cbxCiudadProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cbxCiudadProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 157, 189, 33));

        btnAgregarCiudad.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        btnAgregarCiudad.setText("+");
        btnAgregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCiudadActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, 49, 38));

        jTabbedPane1.addTab("Proveedor", jPanel5);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngresoPedido.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblIngresoPedido.setText("Ingreso Pedidos");
        jPanel8.add(lblIngresoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 24, -1, -1));

        lblClaveIngreso.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblClaveIngreso.setText("Clave Ingreso: ");
        jPanel8.add(lblClaveIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 70, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblCantidad.setText("Cantidad:");
        jPanel8.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 133, -1, -1));

        lblProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblProveedor.setText("Proveedor: ");
        jPanel8.add(lblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 195, -1, -1));

        jLabel9.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel9.setText("Materia Prima: ");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 262, -1, -1));

        jLabel10.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel10.setText("Detalle Ingreso: ");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 328, -1, -1));

        jLabel11.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel11.setText("Fecha Pedido: ");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 70, -1, -1));

        jLabel12.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel12.setText("Fecha Ingreso: ");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 133, -1, -1));

        jLabel13.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel13.setText("Estado: ");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 195, -1, -1));

        jLabel14.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel14.setText("Costo Total: ");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 262, -1, -1));
        jPanel8.add(txtClaveIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 66, 226, 30));
        jPanel8.add(txtCantidadIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 130, 226, 28));

        cbxProveedorIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(cbxProveedorIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 192, 226, 29));

        cbxMateriaPrimaIngreso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(cbxMateriaPrimaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 258, 226, 31));
        jPanel8.add(txtDetalleIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 325, 226, 28));
        jPanel8.add(jdcFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 130, 169, 28));
        jPanel8.add(cbEstadoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 192, 29, 29));
        jPanel8.add(txtCostoTotalIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 258, 169, 31));

        jTabbedPane1.addTab("Ingreso Pedidos", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 1040, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalidaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaMaterialActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        limpiarSalidaMaterial();
    }//GEN-LAST:event_btnSalidaMaterialActionPerformed

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
       jTabbedPane1.setSelectedIndex(1);
       limpiarAlmacen();
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
     jTabbedPane1.setSelectedIndex(2);
     limpiarProveedor();
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCiudadActionPerformed
        Ciudad ciudad  = new Ciudad();
        ciudad.setVisible(true);
        
    }//GEN-LAST:event_btnAgregarCiudadActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
      jTabbedPane1.setSelectedIndex(3);
      limpiarIngresoPedidos();
    }//GEN-LAST:event_btnPedidosActionPerformed

   
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
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlmacen;
    private javax.swing.JButton btnAgregarCiudad;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnCancelarAlmacen;
    private javax.swing.JButton btnCancelarProveedor;
    private javax.swing.JButton btnDescargarAlmacen;
    private javax.swing.JButton btnDescargarProveedor;
    private javax.swing.JButton btnGenerarSalida;
    private javax.swing.JButton btnModificarAlmacen;
    private javax.swing.JButton btnModificarProveedor;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProveedor;
    private javax.swing.JButton btnSalidaMaterial;
    private javax.swing.JCheckBox cbEstadoIngreso;
    private javax.swing.JComboBox<String> cbxCiudadProveedor;
    private javax.swing.JComboBox<String> cbxClaveMaterialSalida;
    private javax.swing.JComboBox<String> cbxMateriaPrimaIngreso;
    private javax.swing.JComboBox<String> cbxProveedorIngreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFechaIngreso;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadDisp;
    private javax.swing.JLabel lblCantidadSalida;
    private javax.swing.JLabel lblCiudadProveedor;
    private javax.swing.JLabel lblClaveIngreso;
    private javax.swing.JLabel lblClaveMateria;
    private javax.swing.JLabel lblClaveMaterialSalida;
    private javax.swing.JLabel lblClaveProveedor;
    private javax.swing.JLabel lblClaveSalida;
    private javax.swing.JLabel lblCorreoProveedor;
    private javax.swing.JLabel lblDetalleSalida;
    private javax.swing.JLabel lblIngresoPedido;
    private javax.swing.JLabel lblMaternoEncargado;
    private javax.swing.JLabel lblNombreEncargado;
    private javax.swing.JLabel lblNombreMaterial;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblProveedor;
    private javax.swing.JLabel lblRFCProveedor;
    private javax.swing.JLabel lblStockMinimo;
    private javax.swing.JLabel lblTelefonoProveedor;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCantidadDisponible;
    private javax.swing.JTextField txtCantidadIngreso;
    private javax.swing.JTextField txtCantidadSalida;
    private javax.swing.JTextField txtClaveIngreso;
    private javax.swing.JTextField txtClaveMateria;
    private javax.swing.JTextField txtClaveProveedor;
    private javax.swing.JTextField txtClaveSalida;
    private javax.swing.JTextField txtCorreoProveedor;
    private javax.swing.JTextField txtCostoTotalIngreso;
    private javax.swing.JTextField txtDetalleIngreso;
    private javax.swing.JTextField txtDetalleSalida;
    private javax.swing.JTextField txtNombreEncargado;
    private javax.swing.JTextField txtNombreMateria;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtRFCProveedor;
    private javax.swing.JTextField txtStockMinimo;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables

    
    // Metodos para la limpieza de cada uno de los apartados
    
    // Limpieza de salida Material
    private void limpiarSalidaMaterial(){
    txtClaveSalida.setText("");
    cbxClaveMaterialSalida.removeAllItems();
    txtCantidadSalida.setText("");
    txtDetalleSalida.setText("");
    }
    private void limpiarAlmacen(){
    txtClaveMateria.setText("");
    txtNombreMateria.setText("");
    txtCantidadDisponible.setText("");
    txtStockMinimo.setText("");
    }
    private void limpiarProveedor(){
    txtClaveProveedor.setText("");
    txtRFCProveedor.setText("");
    txtNombreProveedor.setText("");
    txtCorreoProveedor.setText("");
    cbxCiudadProveedor.removeAllItems();
    txtTelefonoProveedor.setText("");
    txtNombreEncargado.setText("");
    txtApellidoPaterno.setText("");
    txtApellidoMaterno.setText("");
    }
    private void limpiarIngresoPedidos(){
    txtClaveIngreso.setText("");
    txtCantidadIngreso.setText("");
    cbxProveedorIngreso.removeAllItems();
    cbxMateriaPrimaIngreso.removeAllItems();
    txtDetalleIngreso.setText("");
    jdcFechaIngreso.setDate(null);
    txtCostoTotalIngreso.setText("");  
    }
    


}
