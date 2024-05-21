package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.Almacen;
import modelo.AlmacenDAO;
import modelo.Ciudad;
import modelo.CiudadDAO;
import modelo.Eventos;
import modelo.IngresoPedidos;
import modelo.IngresoPedidosDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.conexion;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ramos
 */
public class Sistema extends javax.swing.JFrame {

    CiudadView ciudad = new CiudadView();
    CiudadDAO ciudadDao = new CiudadDAO();

    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();
    
    Almacen almacen = new Almacen();
    AlmacenDAO almacenDao = new AlmacenDAO();
    
    IngresoPedidos ingresoPedidos = new IngresoPedidos();
    IngresoPedidosDAO ingresoPedidosDao = new IngresoPedidosDAO();

    //eventos de teclado
    Eventos event = new Eventos();

    DefaultTableModel modelo = new DefaultTableModel(); //se crea el modelo para las tablas para listar
    DefaultTableModel tmp = new DefaultTableModel();
    private Connection con;
    
    

    public Sistema() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ObtenerFecha();
        con = conexion.getConnection();

        //para que se pueda completar la información de los combos
        AutoCompleteDecorator.decorate(cbxCiudadProveedor);
        AutoCompleteDecorator.decorate(cbxProveedorIngreso);
        
        cargaComboCompleto(); // Cargar datos de las ciudades en el combo box
        
        cargaComboCompletoIngreso(); //Carga datos de los proveedores en el combo box 
        
        txtCodigoPostalProveedor.setVisible(true);
        
       
    }

    //Parte de carga del combo de  ciudad en la parte de Proveedor
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void cargaComboCompleto() {
        // Cargar datos de las ciudades en el combo box
        cargarCiudades();
        mostrarCodigoPostal();
        // Añadir listener para el cambio de selección en el combo box
        cbxCiudadProveedor.addActionListener(e -> mostrarCodigoPostal());
    }
    // Método para cargar los nombres de las ciudades en el combo box
    private void cargarCiudades() {
        List<Ciudad> ciudades = ciudadDao.obtenerCiudades();
        for (Ciudad ciudad : ciudades) {
            cbxCiudadProveedor.addItem(ciudad.getNombreCiudad());
        }
    }
    // Método para mostrar el código postal correspondiente cuando se selecciona una ciudad
    private void mostrarCodigoPostal() {
        String nombreCiudadSeleccionada = (String) cbxCiudadProveedor.getSelectedItem();
        List<Ciudad> ciudades = ciudadDao.obtenerCiudades();
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getNombreCiudad().equals(nombreCiudadSeleccionada)) {
                txtCodigoPostalProveedor.setText(ciudad.getCodPostal());
                break;
            }
        }
    }
    //Termina la parte de la carga de combo de ciudad en la parte de Proveedor
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    //Carga del combo de Proveedor en la parte de IngresoPedidos
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void cargaComboCompletoIngreso(){
    cargarProveedor();
    mostrarClaveProveedor();
    cbxProveedorIngreso.addActionListener(e -> mostrarClaveProveedor());
    
    cargaMateria();
    mostrarClaveMateria();
    cbxMateriaPrimaIngreso.addActionListener(e -> mostrarClaveMateria());
    }
    private void cargarProveedor(){
      List<Proveedor> proveedores = proveedorDao.obtenerProveedor();
        for (Proveedor proveedor : proveedores) {
            cbxProveedorIngreso.addItem(proveedor.getNombreEmpresa());
        }
    }
    private void mostrarClaveProveedor(){
    String nombreProveedorSeleccionada = (String) cbxProveedorIngreso.getSelectedItem();
        List<Proveedor> proveedores = proveedorDao.obtenerProveedor();
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getNombreEmpresa().equals(nombreProveedorSeleccionada)) {
                txtClaveProveedorIngreso.setText(proveedor.getCveProveedor());
                break;
            }
        }  
    } 
    private void cargaMateria(){
     List<Almacen> materias = almacenDao.obtenerMateria();
        for (Almacen almacen : materias) {
            cbxMateriaPrimaIngreso.addItem(almacen.getNombreMateria());
        }
    }
    private void mostrarClaveMateria(){
     String nombreMateriaSeleccionada = (String) cbxMateriaPrimaIngreso.getSelectedItem();
        List<Almacen> materias = almacenDao.obtenerMateria();
        for (Almacen almacen : materias) {
            if (almacen.getNombreMateria().equals(nombreMateriaSeleccionada)) {
                txtClaveMateriaIngreso.setText(almacen.getClaveMateriaPrima());
                break;
            }
        }  
    }  
    //Termina la parte del combo proveedor parte de IngresoPedidos
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    

    private void ObtenerFecha() {
    // Metodo para obtener la fecha  en tiempo real 
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
    public void limpiarTable() {
//Limpia todas las tablas de manera generica
//para que se pueda refrescar la información de todas las tablas
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    
    /* Inicia el listado de las tablas de todas las clases
    *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
    public void listarProveedor() {
        //para que se puedan listar las ciudades en la tabla ciudad
        List<Proveedor> listarProveedor = proveedorDao.listarProveedor();
        modelo = (DefaultTableModel) tableProveedor.getModel();
        Object[] obj = new Object[10];
        for (int i = 0; i < listarProveedor.size(); i++) {
            obj[0] = listarProveedor.get(i).getCveProveedor();
            obj[1] = listarProveedor.get(i).getNombreEmpresa();
            obj[2] = listarProveedor.get(i).getNombreEncargado();
            obj[3] = listarProveedor.get(i).getApePatEncargado();
            obj[4] = listarProveedor.get(i).getApeMatEncargado();
            obj[5] = listarProveedor.get(i).getTelefonoProveedor();
            obj[6] = listarProveedor.get(i).getCorreoProveedor();
            obj[7] = listarProveedor.get(i).getRfc();
            obj[8] = listarProveedor.get(i).getCiudadProveedor();//Es el coidgo Postal
            obj[9] = listarProveedor.get(i).getNombreCiudadProveedor();//Es el nombre de la ciudad
            modelo.addRow(obj);
        }
        tableProveedor.setModel(modelo);
    }   
    public void listarAlmacen() {      
        //para que se puedan listar las materias primas que hay en el almacén
        List<Almacen> listarAlmacen = almacenDao.listarAlamacen();
        modelo = (DefaultTableModel) tableAlmacen.getModel();
        Object[] obj = new Object[4];
        for (int i = 0; i < listarAlmacen.size(); i++) {
            obj[0] = listarAlmacen.get(i).getClaveMateriaPrima();
            obj[1] = listarAlmacen.get(i).getNombreMateria();
            obj[2] = listarAlmacen.get(i).getStockMinimo();
            obj[3] = listarAlmacen.get(i).getCantidadDisp();         
            modelo.addRow(obj);
        }
        tableAlmacen.setModel(modelo);
    }
    public void listarIngresoPedido(){  
        limpiarTable();
        //para que se puedan listar los ingresos de pedidos que se hicieron
        List<IngresoPedidos> listarIngreso = ingresoPedidosDao.listarIngresoPedido();
        modelo = (DefaultTableModel) tableIngresoPedidos.getModel();
        Object[] obj = new Object[12];
        for (int i = 0; i < listarIngreso.size(); i++) {
            obj[0] = listarIngreso.get(i).getClaveIngresoMaterial();
            obj[1] = listarIngreso.get(i).getDetallePedido();
            obj[2] = listarIngreso.get(i).getEstado();
            obj[3] = listarIngreso.get(i).getEstadoDescripcion();
            obj[4] = listarIngreso.get(i).getCantidadPedido();
            obj[5] = listarIngreso.get(i).getFechaPedido();
            obj[6] = listarIngreso.get(i).getFechaIngreso();
            obj[7] = listarIngreso.get(i).getCostoTotal();
            obj[8] = listarIngreso.get(i).getClaveProveedor();
            obj[9] = listarIngreso.get(i).getNombreProveedor();
            obj[10] = listarIngreso.get(i).getClaveMateria();
            obj[11] = listarIngreso.get(i).getNombreMateria();
           modelo.addRow(obj);
        }
        tableIngresoPedidos.setModel(modelo);
    
    }
    // Termina el listado de las tablas de todas las clases
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnEliminarAlmacen = new javax.swing.JButton();
        btnDescargarAlmacen = new javax.swing.JButton();
        btnCancelarAlmacen = new javax.swing.JButton();
        lblClaveMateria = new javax.swing.JLabel();
        lblCantidadDisp = new javax.swing.JLabel();
        lblNombreMaterial = new javax.swing.JLabel();
        lblStockMinimo = new javax.swing.JLabel();
        txtClaveMateria = new javax.swing.JTextField();
        txtCantidadDisponible = new javax.swing.JTextField();
        txtNombreMateria = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAlmacen = new javax.swing.JTable();
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
        btnEliminarProveedor = new javax.swing.JButton();
        btnAgregarCiudad = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        txtCodigoPostalProveedor = new javax.swing.JTextField();
        cbxCiudadProveedor = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        lblIngresoPedido = new javax.swing.JLabel();
        lblClaveIngreso = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblProveedor = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jPanel9 = new javax.swing.JPanel();
        btnAgregarIngreso = new javax.swing.JButton();
        btnModificarIngreso = new javax.swing.JButton();
        btnCancelarIngreso = new javax.swing.JButton();
        btnDescargarIngreso = new javax.swing.JButton();
        btnEliminarIngreso = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableIngresoPedidos = new javax.swing.JTable();
        txtClaveProveedorIngreso = new javax.swing.JTextField();
        txtClaveMateriaIngreso = new javax.swing.JTextField();
        txtFechaIngreso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        btnAgregarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlmacenActionPerformed(evt);
            }
        });

        btnModificarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btnModificarAlmacen.setText("Modificar");
        btnModificarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAlmacenActionPerformed(evt);
            }
        });

        btnEliminarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarAlmacen.setText("Eliminar");
        btnEliminarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlmacenActionPerformed(evt);
            }
        });

        btnDescargarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descarga.png"))); // NOI18N
        btnDescargarAlmacen.setText("Descarga");
        btnDescargarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarAlmacenActionPerformed(evt);
            }
        });

        btnCancelarAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelarAlmacen.setText("Cancelar");
        btnCancelarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlmacenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAgregarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(btnEliminarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDescargarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(397, Short.MAX_VALUE)
                    .addComponent(btnCancelarAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(369, 369, 369)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnCancelarAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 438, 910, -1));

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

        txtClaveMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveMateriaActionPerformed(evt);
            }
        });
        txtClaveMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClaveMateriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveMateriaKeyTyped(evt);
            }
        });
        jPanel4.add(txtClaveMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 108, 203, 24));

        txtCantidadDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadDisponibleActionPerformed(evt);
            }
        });
        txtCantidadDisponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadDisponibleKeyTyped(evt);
            }
        });
        jPanel4.add(txtCantidadDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 174, 206, 24));

        txtNombreMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreMateriaActionPerformed(evt);
            }
        });
        txtNombreMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreMateriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMateriaKeyTyped(evt);
            }
        });
        jPanel4.add(txtNombreMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 106, 214, 28));

        txtStockMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockMinimoActionPerformed(evt);
            }
        });
        txtStockMinimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMinimoKeyTyped(evt);
            }
        });
        jPanel4.add(txtStockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 172, 222, 28));

        tableAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave materia Prima", "Nombre Materia Prima", "Stock Mínimo", "Cantidad Disponible"
            }
        ));
        tableAlmacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlmacenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAlmacen);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 820, 150));

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

        txtClaveProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClaveProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveProveedorKeyTyped(evt);
            }
        });
        jPanel5.add(txtClaveProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 61, 233, 29));

        txtRFCProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRFCProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRFCProveedorKeyTyped(evt);
            }
        });
        jPanel5.add(txtRFCProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 110, 233, 28));

        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });
        jPanel5.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 159, 232, 29));

        txtNombreEncargado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEncargadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEncargadoKeyTyped(evt);
            }
        });
        jPanel5.add(txtNombreEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 210, 233, 28));

        txtApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMaternoKeyTyped(evt);
            }
        });
        jPanel5.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 258, 233, 29));

        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });
        jPanel5.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 59, 287, 32));
        jPanel5.add(txtCorreoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 109, 287, 30));

        txtApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPaternoKeyTyped(evt);
            }
        });
        jPanel5.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 208, 315, 32));

        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        btnModificarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btnModificarProveedor.setText("Modificar");
        btnModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProveedorActionPerformed(evt);
            }
        });

        btnCancelarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelarProveedor.setText("Cancelar");
        btnCancelarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProveedorActionPerformed(evt);
            }
        });

        btnDescargarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descarga.png"))); // NOI18N
        btnDescargarProveedor.setText("Descarga");
        btnDescargarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancelarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                    .addComponent(btnDescargarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 920, -1));

        btnAgregarCiudad.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        btnAgregarCiudad.setText("+");
        btnAgregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCiudadActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregarCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, 49, 38));

        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave Proveedor", "RFC Proveedor", "NombreProveedor", "Nombre Encargado", "Apellido Paterno", "Apellido Materno", "Correo", "Teléfono", "Ciudad", "Nombre Ciudad"
            }
        ));
        tableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProveedor);
        if (tableProveedor.getColumnModel().getColumnCount() > 0) {
            tableProveedor.getColumnModel().getColumn(8).setMinWidth(0);
            tableProveedor.getColumnModel().getColumn(8).setPreferredWidth(0);
            tableProveedor.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 990, 150));
        jPanel5.add(txtCodigoPostalProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 110, 30));

        jPanel5.add(cbxCiudadProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 210, 30));

        jTabbedPane1.addTab("Proveedor", jPanel5);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngresoPedido.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        lblIngresoPedido.setText("Ingreso Pedidos");
        jPanel8.add(lblIngresoPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, 30));

        lblClaveIngreso.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblClaveIngreso.setText("Clave Ingreso: ");
        jPanel8.add(lblClaveIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblCantidad.setText("Cantidad:");
        jPanel8.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        lblProveedor.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        lblProveedor.setText("Proveedor: ");
        jPanel8.add(lblProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel9.setText("Materia Prima: ");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel10.setText("Detalle Ingreso: ");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel12.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel12.setText("Fecha Ingreso: ");
        jPanel8.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        jLabel13.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel13.setText("Estado: ");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Britannic Bold", 0, 18)); // NOI18N
        jLabel14.setText("Costo Total: ");
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

        txtClaveIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClaveIngresoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveIngresoKeyTyped(evt);
            }
        });
        jPanel8.add(txtClaveIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 226, 30));

        txtCantidadIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadIngresoKeyTyped(evt);
            }
        });
        jPanel8.add(txtCantidadIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 226, 28));

        jPanel8.add(cbxProveedorIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 226, 29));

        jPanel8.add(cbxMateriaPrimaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 226, 31));

        txtDetalleIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDetalleIngresoKeyReleased(evt);
            }
        });
        jPanel8.add(txtDetalleIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 226, 28));

        jdcFechaIngreso.setMinSelectableDate(new java.util.Date(-62135744294000L));
        jPanel8.add(jdcFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 169, 28));
        jPanel8.add(cbEstadoIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 100, 29));

        txtCostoTotalIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoTotalIngresoKeyTyped(evt);
            }
        });
        jPanel8.add(txtCostoTotalIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 169, 31));

        btnAgregarIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnAgregarIngreso.setText("Nuevo Pedido");
        btnAgregarIngreso.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIngresoActionPerformed(evt);
            }
        });

        btnModificarIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btnModificarIngreso.setText("Modificar");
        btnModificarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarIngresoActionPerformed(evt);
            }
        });

        btnCancelarIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btnCancelarIngreso.setText("Cancelar");
        btnCancelarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarIngresoActionPerformed(evt);
            }
        });

        btnDescargarIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descarga.png"))); // NOI18N
        btnDescargarIngreso.setText("Descarga");
        btnDescargarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarIngresoActionPerformed(evt);
            }
        });

        btnEliminarIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminarIngreso.setText("Eliminar");
        btnEliminarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIngresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAgregarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnModificarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancelarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnEliminarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDescargarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelarIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargarIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(444, 444, 444))
        );

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 920, -1));

        tableIngresoPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave Ingreso", "Detalle Pedido", "cve Estado", "Estado", "Cantidad Pedido", "Fecha de Pedido", "Fecha de Ingreso", "Costo Total", "clave Proveedor", "NombreProveedor", "Clave Materia", "Nombre Materia Prima"
            }
        ));
        tableIngresoPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIngresoPedidosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableIngresoPedidos);
        if (tableIngresoPedidos.getColumnModel().getColumnCount() > 0) {
            tableIngresoPedidos.getColumnModel().getColumn(2).setMinWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(2).setPreferredWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(2).setMaxWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(8).setMinWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(8).setPreferredWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(8).setMaxWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(10).setMinWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(10).setPreferredWidth(0);
            tableIngresoPedidos.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 980, 120));
        jPanel8.add(txtClaveProveedorIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 80, 30));
        jPanel8.add(txtClaveMateriaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 80, 30));
        jPanel8.add(txtFechaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 130, 20));

        jTabbedPane1.addTab("Ingreso Pedidos", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 1040, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//BOTONES DE REDIRECCIONAMIENTO HACIA LAS VENTANAS DE VISTA
  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
    private void btnSalidaMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaMaterialActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        limpiarSalidaMaterial();
    }//GEN-LAST:event_btnSalidaMaterialActionPerformed

    private void btnAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlmacenActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        limpiarAlmacen();
        if (tableAlmacen.getRowCount() == 0){
        listarAlmacen();
        }
        
        txtClaveMateria.setEnabled(true);
    }//GEN-LAST:event_btnAlmacenActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        limpiarProveedor();
        if (tableProveedor.getRowCount() == 0) {
            listarProveedor();
        }
        cargarCiudades();  //carga las ciudades al combo box
        mostrarCodigoPostal();//carga los codigos postales al txt
        txtClaveProveedor.setEnabled(true);    //activar txt Proveedor
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCiudadActionPerformed
        CiudadView ciudad = new CiudadView();
        ciudad.setVisible(true);

    }//GEN-LAST:event_btnAgregarCiudadActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        jTabbedPane1.setSelectedIndex(3);
        limpiarIngresoPedidos();
        if(tableIngresoPedidos.getRowCount() == 0){
         listarIngresoPedido();
        }
               
           cargaComboCompletoIngreso();
           jdcFechaIngreso.setEnabled(false);
    }//GEN-LAST:event_btnPedidosActionPerformed
   //TERMINAN BOTONES DE REDIRECCIONAMIENTO +++++++++++++++++++++++++++++++++++++++++++
    
    
 //INICIA EL APARTADO DE PROVEEDOR   
 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Botones de acción
    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed

        if (!"".equals(txtClaveProveedor.getText()) || !"".equals(txtNombreProveedor.getText())) {
            proveedor.setCveProveedor(txtClaveProveedor.getText());
            proveedor.setNombreEmpresa(txtNombreProveedor.getText());
            proveedor.setNombreEncargado(txtNombreEncargado.getText());
            proveedor.setApePatEncargado(txtApellidoPaterno.getText());
            proveedor.setApeMatEncargado(txtApellidoMaterno.getText());
            proveedor.setTelefonoProveedor(txtTelefonoProveedor.getText());
            proveedor.setCorreoProveedor(txtCorreoProveedor.getText());
            proveedor.setRfc(txtRFCProveedor.getText());
            proveedor.setCiudadProveedor(txtCodigoPostalProveedor.getText());

            proveedorDao.registrarProveedor(proveedor); //se manda a traer del DAO proveedor la funcion registrar
            JOptionPane.showMessageDialog(null, "Provedor Registrado con exito!!");
            limpiarProveedor();
            limpiarTable();
            listarProveedor();
            cargaComboCompleto();

        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");

        }

    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProveedorActionPerformed
        
        
        if("".equals(txtClaveProveedor.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{  
        if(!"".equals(txtClaveProveedor.getText())||!"".equals(txtNombreProveedor.getText())){
        proveedor.setCveProveedor(txtClaveProveedor.getText());
        proveedor.setNombreEmpresa(txtNombreProveedor.getText());
        proveedor.setNombreEncargado(txtNombreEncargado.getText());
        proveedor.setApePatEncargado(txtApellidoPaterno.getText());
        proveedor.setApeMatEncargado(txtApellidoMaterno.getText());
        proveedor.setTelefonoProveedor(txtTelefonoProveedor.getText());
        proveedor.setCorreoProveedor(txtCorreoProveedor.getText());
        proveedor.setRfc(txtRFCProveedor.getText());
        proveedor.setCiudadProveedor(txtCodigoPostalProveedor.getText());
        
        proveedorDao.ModificarProveedor(proveedor);
        JOptionPane.showMessageDialog(null,"Modificado con exito");
       
        limpiarTable();
        limpiarProveedor();
        listarProveedor();
        cargaComboCompleto();
        
        }else{
        JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
      } 
        
    }//GEN-LAST:event_btnModificarProveedorActionPerformed

    private void btnCancelarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProveedorActionPerformed
        
        limpiarProveedor();
        cargaComboCompleto();
    }//GEN-LAST:event_btnCancelarProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
         
        if (!"".equals(txtClaveProveedor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                String id = txtClaveProveedor.getText();
               proveedorDao.eliminarProveedor(id);
                limpiarProveedor();
                limpiarTable();
                listarProveedor();  
                cargaComboCompleto();
            }
        }  
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnDescargarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarProveedorActionPerformed

    }//GEN-LAST:event_btnDescargarProveedorActionPerformed

    
    private void txtClaveProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveProveedorKeyReleased
        //Para poder que todo el text se pase a mayusculas
        String texto_Mayuscula = (txtClaveProveedor.getText()).toUpperCase();
        txtClaveProveedor.setText(texto_Mayuscula);
    }//GEN-LAST:event_txtClaveProveedorKeyReleased

    private void txtClaveProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveProveedorKeyTyped
        //para que solo se pueda ingresar 6 valores dentro del txtClaveProveedor
        if (txtClaveProveedor.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClaveProveedorKeyTyped

    private void txtRFCProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCProveedorKeyReleased
        //Para poder que todo el text se pase a mayusculas
        String texto_Mayuscula = (txtRFCProveedor.getText()).toUpperCase();
        txtRFCProveedor.setText(texto_Mayuscula);

    }//GEN-LAST:event_txtRFCProveedorKeyReleased

    private void txtTelefonoProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyReleased
    }//GEN-LAST:event_txtTelefonoProveedorKeyReleased

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        //para que solo se pueda ingresar 6 valores dentro del txtClaveProveedor
        if (txtTelefonoProveedor.getText().length() >= 10) {
            evt.consume();
        }
        //solo números
        event.numberKeyPress(evt);

    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped
    private void txtRFCProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRFCProveedorKeyTyped
        //para que solo se pueda ingresar 13 valores dentro del txtRFCProveedor 
        if (txtRFCProveedor.getText().length() >= 13) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRFCProveedorKeyTyped

    private void txtNombreEncargadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEncargadoKeyReleased
        //Para poder que todo el text se pase a mayusculas
        String texto_Mayuscula = (txtNombreEncargado.getText()).toUpperCase();
        txtNombreEncargado.setText(texto_Mayuscula);
    }//GEN-LAST:event_txtNombreEncargadoKeyReleased

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        //para que solo acepte letras y no números
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void txtNombreProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyReleased
        //Para poder que todo el text se pase a mayusculas
        String texto_Mayuscula = (txtNombreProveedor.getText()).toUpperCase();
        txtNombreProveedor.setText(texto_Mayuscula);
    }//GEN-LAST:event_txtNombreProveedorKeyReleased

    private void txtNombreEncargadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEncargadoKeyTyped
        //para que solo acepte texto y no números
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreEncargadoKeyTyped

    private void txtApellidoPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyReleased
        String texto_mayuscula = txtApellidoPaterno.getText().toUpperCase();
        txtApellidoPaterno.setText(texto_mayuscula);

    }//GEN-LAST:event_txtApellidoPaternoKeyReleased

    private void txtApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPaternoKeyTyped
    //para que solo pueda ingresar texto y no números
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtApellidoPaternoKeyTyped

    private void txtApellidoMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyReleased
            //para convertir el texto minuscula a mayusculas
        String texto_mayuscula = txtApellidoMaterno.getText().toUpperCase();
        txtApellidoMaterno.setText(texto_mayuscula);
    }//GEN-LAST:event_txtApellidoMaternoKeyReleased

    private void txtApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMaternoKeyTyped
        //para que solo se acepte texto y no números
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtApellidoMaternoKeyTyped

    private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedorMouseClicked
       txtClaveProveedor.setEnabled(false);
      //para que cuando se seleccione una fila se muestren
     //en los txt de la parte superior
        int fila = tableProveedor.rowAtPoint(evt.getPoint());
        
        txtClaveProveedor.setText(tableProveedor.getValueAt(fila,0).toString());
        txtNombreProveedor.setText(tableProveedor.getValueAt(fila,1).toString());
        txtNombreEncargado.setText(tableProveedor.getValueAt(fila, 2).toString());
        txtApellidoPaterno.setText(tableProveedor.getValueAt(fila, 3).toString());
        txtApellidoMaterno.setText(tableProveedor.getValueAt(fila, 4).toString());
        txtTelefonoProveedor.setText(tableProveedor.getValueAt(fila,5).toString());
        txtCorreoProveedor.setText(tableProveedor.getValueAt(fila, 6).toString());
        txtRFCProveedor.setText(tableProveedor.getValueAt(fila, 7).toString());
        txtCodigoPostalProveedor.setText(tableProveedor.getValueAt(fila, 8).toString());
        cbxCiudadProveedor.setSelectedItem(tableProveedor.getValueAt(fila, 9).toString());
        
        proveedorMouseClicked();
        
    }//GEN-LAST:event_tableProveedorMouseClicked

    //TERMINA EL APARTADO DE PROVEEDOR 
    //*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    //INICIA EL APARTADO DE ALMACÉN
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void txtClaveMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveMateriaActionPerformed
        
        
    }//GEN-LAST:event_txtClaveMateriaActionPerformed

    private void txtNombreMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMateriaActionPerformed

    private void txtCantidadDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadDisponibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadDisponibleActionPerformed

    private void txtStockMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMinimoActionPerformed

    private void txtClaveMateriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveMateriaKeyReleased
      String texto_mayuscula = txtClaveMateria.getText().toUpperCase();
      txtClaveMateria.setText(texto_mayuscula); 
     
    }//GEN-LAST:event_txtClaveMateriaKeyReleased

    private void txtNombreMateriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMateriaKeyReleased
        String texto_mayuscula = txtNombreMateria.getText().toUpperCase();
        txtNombreMateria.setText(texto_mayuscula);
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreMateriaKeyReleased

    private void txtClaveMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveMateriaKeyTyped
      //para que solo se pueda ingresar 6 valores dentro de la clave de la materia prima
        if (txtClaveMateria.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClaveMateriaKeyTyped

    private void txtCantidadDisponibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadDisponibleKeyTyped
    //para que solo se pueda ingresar 3 valores dentro de la cantidad disponible
        if (txtCantidadDisponible.getText().length() >= 3) {
            evt.consume();
        }
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadDisponibleKeyTyped

    private void txtStockMinimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinimoKeyTyped
        
        //para que solo se pueda ingresar 2 valores dentro de stock minimo
        if (txtStockMinimo.getText().length() >= 2) {
            evt.consume();
        }
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtStockMinimoKeyTyped

    private void txtNombreMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMateriaKeyTyped
     
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreMateriaKeyTyped

    //Botones de acción
    private void btnAgregarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlmacenActionPerformed
        
        if (!"".equals(txtClaveMateria.getText()) || !"".equals(txtNombreMateria.getText())) {
           almacen.setClaveMateriaPrima(txtClaveMateria.getText());
           almacen.setNombreMateria(txtNombreMateria.getText());
           almacen.setStockMinimo(Integer.parseInt(txtStockMinimo.getText()));
           almacen.setCantidadDisp(Integer.parseInt(txtCantidadDisponible.getText()));
            

            almacenDao.registrarAlmacen(almacen); //se manda a traer del DAO almacén la funcion registrar
            JOptionPane.showMessageDialog(null, "Materia Prima Registrada con exito!!");
            limpiarAlmacen();
            limpiarTable();
            listarAlmacen();
            

        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");

        }
        
    }//GEN-LAST:event_btnAgregarAlmacenActionPerformed

    private void btnModificarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAlmacenActionPerformed
       
        if("".equals(txtClaveMateria.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{  
        if(!"".equals(txtClaveMateria.getText())||!"".equals(txtNombreMateria.getText())){
       almacen.setClaveMateriaPrima(txtClaveMateria.getText());
       almacen.setNombreMateria(txtNombreMateria.getText());
       almacen.setStockMinimo(Integer.parseInt(txtStockMinimo.getText()));
       almacen.setCantidadDisp(Integer.parseInt(txtCantidadDisponible.getText()));
       
        almacenDao.ModificarAlmacen(almacen);
        JOptionPane.showMessageDialog(null,"Modificado con exito");
       
        limpiarTable();
        limpiarAlmacen();
        listarAlmacen();        
        }else{
        JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
      }
        
        
    }//GEN-LAST:event_btnModificarAlmacenActionPerformed

    private void btnCancelarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlmacenActionPerformed
      limpiarAlmacen();
    }//GEN-LAST:event_btnCancelarAlmacenActionPerformed

    private void btnEliminarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlmacenActionPerformed
       
         if (!"".equals(txtClaveMateria.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                String id = txtClaveMateria.getText();
               almacenDao.eliminarAlmacen(id);
               JOptionPane.showMessageDialog(null,"Eliminado Correctamente !!");
                limpiarAlmacen();
                limpiarTable();
                listarAlmacen();  
            }
        }
       
    }//GEN-LAST:event_btnEliminarAlmacenActionPerformed

    private void btnDescargarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescargarAlmacenActionPerformed

    private void tableAlmacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlmacenMouseClicked
      txtClaveMateria.setEnabled(false);
      //para que cuando se seleccione una fila se muestren
     //en los txt de la parte superior
        int fila = tableAlmacen.rowAtPoint(evt.getPoint());
        
        txtClaveMateria.setText(tableAlmacen.getValueAt(fila,0).toString());
        txtNombreMateria.setText(tableAlmacen.getValueAt(fila,1).toString());
        txtStockMinimo.setText(tableAlmacen.getValueAt(fila, 2).toString());
        txtCantidadDisponible.setText(tableAlmacen.getValueAt(fila, 3).toString());
        
        almacenMouseClicked();
        
    }//GEN-LAST:event_tableAlmacenMouseClicked
   //TERMINA EL APARTADO DE ALMACEN ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
  /*APARTDO DE INGRESO PEDIDOS 
  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
    private void btnAgregarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngresoActionPerformed
      
      if (!"".equals(txtClaveIngreso.getText()) || !"".equals(txtCantidadIngreso.getText())) {
           ingresoPedidos.setClaveIngresoMaterial(txtClaveIngreso.getText());
           ingresoPedidos.setDetallePedido(txtDetalleIngreso.getText());
           ingresoPedidos.setEstado(cbEstadoIngreso.isSelected() ? 1 : 0); // 1 para activo, 0 para inactivo
           ingresoPedidos.setCantidadPedido(Integer.parseInt(txtCantidadIngreso.getText()));
           
          
          
           ingresoPedidos.setFechaIngreso(txtFechaIngreso.getText());
           ingresoPedidos.setCostoTotal(Float.parseFloat(txtCostoTotalIngreso.getText()));
           ingresoPedidos.setClaveProveedor(txtClaveProveedorIngreso.getText());
           ingresoPedidos.setClaveMateria(txtClaveMateriaIngreso.getText());
           
            ingresoPedidosDao.registrarIngresoPedido(ingresoPedidos); //se manda a traer del DAO Ingreso Pedidos la funcion registrar
            
            
            actualizarCantidadIngreso();
            limpiarTablaIngreso();  
            limpiarIngresoPedidos();
            if (tableIngresoPedidos.getRowCount()==0){
            listarIngresoPedido();
            }else{
            limpiarTable();
            }
            JOptionPane.showMessageDialog(null, "Nuevo Ingreso Registrado con exito!!");
            cargaComboCompletoIngreso();
            
           
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");

        }  
        
        
    }//GEN-LAST:event_btnAgregarIngresoActionPerformed

    private void btnModificarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarIngresoActionPerformed
        if("".equals(txtClaveIngreso.getText())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{  
       if(!"".equals(txtClaveIngreso.getText())||!"".equals(txtCantidadIngreso.getText())){
       ingresoPedidos.setClaveIngresoMaterial(txtClaveIngreso.getText());
       ingresoPedidos.setDetallePedido(txtDetalleIngreso.getText());
       ingresoPedidos.setEstado(cbEstadoIngreso.isSelected() ? 1 : 0);
       ingresoPedidos.setCantidadPedido(Integer.parseInt(txtCantidadIngreso.getText()));
       
       // Para guardar la fecha de ingreso material
        int mes = jdcFechaIngreso.getCalendar().get(Calendar.MONTH) + 1;
        int dia = jdcFechaIngreso.getCalendar().get(Calendar.DAY_OF_MONTH);
        int anio = jdcFechaIngreso.getCalendar().get(Calendar.YEAR);
        String fecha = (anio + "-" + mes + "-" + dia);
        txtFechaIngreso.setText(fecha);        
       ingresoPedidos.setFechaIngreso(txtFechaIngreso.getText());
       
       ingresoPedidos.setCostoTotal(Float.parseFloat(txtCostoTotalIngreso.getText()));
       ingresoPedidos.setClaveProveedor(txtClaveProveedorIngreso.getText());
       ingresoPedidos.setClaveMateria(txtClaveMateriaIngreso.getText());
        
       ingresoPedidosDao.moficarIngresoPedido(ingresoPedidos);
        JOptionPane.showMessageDialog(null,"Modificado con exito");
       
            limpiarTablaIngreso();  
            limpiarIngresoPedidos();
            cargaComboCompletoIngreso();
            if (tableIngresoPedidos.getRowCount()==0){
            listarIngresoPedido();
            }else{
            limpiarTable();
            }
        }else{
        JOptionPane.showMessageDialog(null,"Los campos estan vacios");
        }
      }
        
        
        
    }//GEN-LAST:event_btnModificarIngresoActionPerformed

    private void btnCancelarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarIngresoActionPerformed
       limpiarIngresoPedidos();
       cargaComboCompletoIngreso();
    }//GEN-LAST:event_btnCancelarIngresoActionPerformed

    private void btnDescargarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescargarIngresoActionPerformed

    private void btnEliminarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIngresoActionPerformed
       
         if (!"".equals(txtClaveIngreso.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?");
            if (pregunta == 0) {
                String id = txtClaveIngreso.getText();
              ingresoPedidosDao.eliminarIngresoPedido(id);
               JOptionPane.showMessageDialog(null,"Eliminado Correctamente !!");
           
            limpiarTablaIngreso();  
            limpiarIngresoPedidos();
            cargaComboCompletoIngreso();
            if (tableIngresoPedidos.getRowCount()==0){
            listarIngresoPedido();
            }else{
            limpiarTable();
            }
            }
        }
    }//GEN-LAST:event_btnEliminarIngresoActionPerformed

    
    
    private void txtClaveIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveIngresoKeyTyped
      //para que solo se pueda ingresar 6 valores dentro de la clave de la materia prima
        if (txtClaveIngreso.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClaveIngresoKeyTyped

    private void txtCantidadIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadIngresoKeyTyped
         if (txtCantidadIngreso.getText().length() >= 3) {
            evt.consume();
        }
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantidadIngresoKeyTyped

    private void txtDetalleIngresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleIngresoKeyReleased
        String texto_mayuscula = txtDetalleIngreso.getText().toUpperCase();
        txtDetalleIngreso.setText(texto_mayuscula);
        
    }//GEN-LAST:event_txtDetalleIngresoKeyReleased

    private void txtCostoTotalIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoTotalIngresoKeyTyped
        if (txtCostoTotalIngreso.getText().length() >= 5) {
            evt.consume();
        }
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCostoTotalIngresoKeyTyped

    private void txtClaveIngresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveIngresoKeyReleased
        String texto_mayuscula = txtClaveIngreso.getText().toUpperCase();
        txtClaveIngreso.setText(texto_mayuscula);
    }//GEN-LAST:event_txtClaveIngresoKeyReleased

    private void tableIngresoPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIngresoPedidosMouseClicked
       
        txtClaveIngreso.setEnabled(false);
        jdcFechaIngreso.setEnabled(true);
      //para que cuando se seleccione una fila se muestren
     //en los txt de la parte superior
        int fila = tableIngresoPedidos.rowAtPoint(evt.getPoint());
        
        txtClaveIngreso.setText(tableIngresoPedidos.getValueAt(fila,0).toString());
        txtDetalleIngreso.setText(tableIngresoPedidos.getValueAt(fila,1).toString());
       
        // Obtén el valor del estado
        int estado = Integer.parseInt(tableIngresoPedidos.getValueAt(fila, 2).toString());
        // Establece el estado del checkbox
        cbEstadoIngreso.setSelected(estado == 1);       
        txtCantidadIngreso.setText(tableIngresoPedidos.getValueAt(fila, 4).toString());
        
        
        // Obtén el valor de la celda de la tabla que contiene la fecha de ingreso
        Object fechaValor = tableIngresoPedidos.getValueAt(fila, 6);
        // Verifica si el campo está vacío o es null
        if (fechaValor == null || fechaValor.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hace falta fecha de Ingreso");
            txtFechaIngreso.setText("");
            jdcFechaIngreso.setDate(null);
        } else {
        // El campo no está vacío, continúa con el procesamiento de la fecha
            txtFechaIngreso.setText(fechaValor.toString());
        // Obtén la fecha como texto
         String fechaTexto = fechaValor.toString();
            // Convierte el texto de fecha en un objeto Date
            try {
                Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto);
                // Establece la fecha en el JDateChooser
                jdcFechaIngreso.setDate(fecha);
            } catch (ParseException ex) {
                // Maneja la excepción si ocurre un error al convertir la fecha
                ex.printStackTrace();
            }
        }

        
        
        txtCostoTotalIngreso.setText(tableIngresoPedidos.getValueAt(fila, 7).toString());
        cbxProveedorIngreso.setSelectedItem(tableIngresoPedidos.getValueAt(fila, 9).toString());
        cbxMateriaPrimaIngreso.setSelectedItem(tableIngresoPedidos.getValueAt(fila, 11).toString());

        ingresoPedidosMouseClicked();
        
        
        
    }//GEN-LAST:event_tableIngresoPedidosMouseClicked

    
    
    
    
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
    private javax.swing.JButton btnAgregarIngreso;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnAlmacen;
    private javax.swing.JButton btnCancelarAlmacen;
    private javax.swing.JButton btnCancelarIngreso;
    private javax.swing.JButton btnCancelarProveedor;
    private javax.swing.JButton btnDescargarAlmacen;
    private javax.swing.JButton btnDescargarIngreso;
    private javax.swing.JButton btnDescargarProveedor;
    private javax.swing.JButton btnEliminarAlmacen;
    private javax.swing.JButton btnEliminarIngreso;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnGenerarSalida;
    private javax.swing.JButton btnModificarAlmacen;
    private javax.swing.JButton btnModificarIngreso;
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTable tableAlmacen;
    private javax.swing.JTable tableIngresoPedidos;
    private javax.swing.JTable tableProveedor;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCantidadDisponible;
    private javax.swing.JTextField txtCantidadIngreso;
    private javax.swing.JTextField txtCantidadSalida;
    private javax.swing.JTextField txtClaveIngreso;
    private javax.swing.JTextField txtClaveMateria;
    private javax.swing.JTextField txtClaveMateriaIngreso;
    private javax.swing.JTextField txtClaveProveedor;
    private javax.swing.JTextField txtClaveProveedorIngreso;
    private javax.swing.JTextField txtClaveSalida;
    private javax.swing.JTextField txtCodigoPostalProveedor;
    private javax.swing.JTextField txtCorreoProveedor;
    private javax.swing.JTextField txtCostoTotalIngreso;
    private javax.swing.JTextField txtDetalleIngreso;
    private javax.swing.JTextField txtDetalleSalida;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtNombreEncargado;
    private javax.swing.JTextField txtNombreMateria;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtRFCProveedor;
    private javax.swing.JTextField txtStockMinimo;
    private javax.swing.JTextField txtTelefonoProveedor;
    // End of variables declaration//GEN-END:variables

    // Metodos para la limpieza de cada uno de los apartados
    // Limpieza de salida Material
    private void limpiarSalidaMaterial() {
        txtClaveSalida.setText("");
        cbxClaveMaterialSalida.removeAllItems();
        txtCantidadSalida.setText("");
        txtDetalleSalida.setText("");
    }
    
    
    
    // Inicia Metodos para el apartado de proveedor *************
    private void limpiarProveedor() {
        
        txtClaveProveedor.setText("");
        txtRFCProveedor.setText("");
        txtNombreProveedor.setText("");
        txtCorreoProveedor.setText("");
        cbxCiudadProveedor.removeAllItems();
        txtTelefonoProveedor.setText("");
        txtNombreEncargado.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        agregarProveedor();
        
    }
    private void agregarProveedor(){ // metodo para que los botones se acomenden
        txtClaveProveedor.setEnabled(true);
        
        btnAgregarProveedor.setEnabled(true);
        btnModificarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(true);
        btnEliminarProveedor.setEnabled(false);
        btnDescargarProveedor.setEnabled(true);
        
    }
    private void proveedorMouseClicked(){
        btnAgregarProveedor.setEnabled(false);
        btnModificarProveedor.setEnabled(true);
        btnCancelarProveedor.setEnabled(true);
        btnEliminarProveedor.setEnabled(true);
        btnDescargarProveedor.setEnabled(false);
    }
    // Termina Metodos para el apartado de proveedor ***********
    
    //Inicia metodos para el apartado de Almacén ***********
    private void limpiarAlmacen() {
        txtClaveMateria.setText("");
        txtNombreMateria.setText("");
        txtCantidadDisponible.setText("");
        txtStockMinimo.setText("");
        
        agregarAlmacen();
    }
    private void agregarAlmacen(){
        txtClaveMateria.setEnabled(true);
        
        btnAgregarAlmacen.setEnabled(true);
        btnModificarAlmacen.setEnabled(false);
        btnCancelarAlmacen.setEnabled(true);
        btnEliminarAlmacen.setEnabled(false);
        btnDescargarAlmacen.setEnabled(true);
    
    }
    private void almacenMouseClicked(){
   
        btnAgregarAlmacen.setEnabled(false);
        btnModificarAlmacen.setEnabled(true);
        btnCancelarAlmacen.setEnabled(true);
        btnEliminarAlmacen.setEnabled(true);
        btnDescargarAlmacen.setEnabled(false);
    
    }
    //Termina metodos para el apartado de proveedor****************
   
    //Inicia metodos para el apartado de Ingreso Pedidos+++++++++++++++++++
    private void limpiarIngresoPedidos() {
        txtClaveIngreso.setText("");
        txtCantidadIngreso.setText("");
        cbxProveedorIngreso.removeAllItems();
        cbxMateriaPrimaIngreso.removeAllItems();
        txtDetalleIngreso.setText("");
        jdcFechaIngreso.setDate(null);
        txtFechaIngreso.setText("");
        txtCostoTotalIngreso.setText("");
        cbEstadoIngreso.setSelected(false);
        
        agregarIngresoPedidos();
    }
    private void agregarIngresoPedidos(){
        txtClaveIngreso.setEnabled(true);
        jdcFechaIngreso.setEnabled(false);
        
        btnAgregarIngreso.setEnabled(true);
        btnModificarIngreso.setEnabled(false);
        btnCancelarIngreso.setEnabled(true);
        btnEliminarIngreso.setEnabled(false);
        btnDescargarIngreso.setEnabled(true);
    
    }
    private void ingresoPedidosMouseClicked(){
   
        btnAgregarIngreso.setEnabled(false);
        btnModificarIngreso.setEnabled(true);
        btnCancelarIngreso.setEnabled(true);
        btnEliminarIngreso.setEnabled(true);
        btnDescargarIngreso.setEnabled(false);
    
    }
    private void limpiarTablaIngreso() {
    DefaultTableModel model = (DefaultTableModel) tableIngresoPedidos.getModel();
    model.setRowCount(0); // Esta línea vacía la tabla
    }
    //Termina metodos para el apartado de ingreso pedidos+++++++++++++++++++
    
    //Metodo para actualizar cantidad Disponible en el almacén
    //Con los datos de cantidad Ingreso 
    private void actualizarCantidadIngreso(){
     int cant = Integer.parseInt(txtCantidadIngreso.getText());
     String cod = txtClaveMateriaIngreso.getText();
        almacen = almacenDao.BuscarMateria(cod);
        int stockActual = almacen.getCantidadDisp()+cant;
        ingresoPedidosDao.actualizasStock(stockActual, cod);
    }
    
    
    
}
