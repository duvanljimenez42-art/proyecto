
package vista;


public class FrmMain extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMain.class.getName());

    
    public FrmMain() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        subMenuSalir = new javax.swing.JMenuItem();
        menuAdministracion = new javax.swing.JMenu();
        subMenuAdminRoles = new javax.swing.JMenuItem();
        subMenuAdminTiposCliente = new javax.swing.JMenuItem();
        subMenuAdminCategoria = new javax.swing.JMenuItem();
        subMenuAdminProveedores = new javax.swing.JMenuItem();
        subMenuAdminEmpleados = new javax.swing.JMenuItem();
        subMenuAdminClientes = new javax.swing.JMenuItem();
        subMenuAdminProductos = new javax.swing.JMenuItem();
        subMenuAdminVentasFacturas = new javax.swing.JMenuItem();
        subMenuAdminDetallesVentas = new javax.swing.JMenuItem();
        subMenuAdminOrdenesCompra = new javax.swing.JMenuItem();
        subMenuAdminDetalleOrdenesCompra = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menuAyuda = new javax.swing.JMenu();
        subMenuAcercade = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Papeleria y Libreria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel1)
                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");
        menuArchivo.addActionListener(this::menuArchivoActionPerformed);

        subMenuSalir.setText("Salir");
        subMenuSalir.addActionListener(this::subMenuSalirActionPerformed);
        menuArchivo.add(subMenuSalir);

        barraMenu.add(menuArchivo);

        menuAdministracion.setText("Administracion");
        menuAdministracion.addActionListener(this::menuAdministracionActionPerformed);

        subMenuAdminRoles.setText("Administrar Roles");
        subMenuAdminRoles.addActionListener(this::subMenuAdminRolesActionPerformed);
        menuAdministracion.add(subMenuAdminRoles);

        subMenuAdminTiposCliente.setText("Administrar Tipos de Cliente");
        subMenuAdminTiposCliente.addActionListener(this::subMenuAdminTiposClienteActionPerformed);
        menuAdministracion.add(subMenuAdminTiposCliente);

        subMenuAdminCategoria.setText("Administrar Categorias");
        subMenuAdminCategoria.addActionListener(this::subMenuAdminCategoriaActionPerformed);
        menuAdministracion.add(subMenuAdminCategoria);

        subMenuAdminProveedores.setText("Administrar Proveedores");
        subMenuAdminProveedores.addActionListener(this::subMenuAdminProveedoresActionPerformed);
        menuAdministracion.add(subMenuAdminProveedores);

        subMenuAdminEmpleados.setText("Administrar Empleados");
        subMenuAdminEmpleados.addActionListener(this::subMenuAdminEmpleadosActionPerformed);
        menuAdministracion.add(subMenuAdminEmpleados);

        subMenuAdminClientes.setText("Administrar Clientes");
        subMenuAdminClientes.addActionListener(this::subMenuAdminClientesActionPerformed);
        menuAdministracion.add(subMenuAdminClientes);

        subMenuAdminProductos.setText("Administrar Productos");
        subMenuAdminProductos.addActionListener(this::subMenuAdminProductosActionPerformed);
        menuAdministracion.add(subMenuAdminProductos);

        subMenuAdminVentasFacturas.setText("Administrar Ventas Facturas");
        subMenuAdminVentasFacturas.addActionListener(this::subMenuAdminVentasFacturasActionPerformed);
        menuAdministracion.add(subMenuAdminVentasFacturas);

        subMenuAdminDetallesVentas.setText("Administrar Detalles Ventas");
        subMenuAdminDetallesVentas.addActionListener(this::subMenuAdminDetallesVentasActionPerformed);
        menuAdministracion.add(subMenuAdminDetallesVentas);

        subMenuAdminOrdenesCompra.setText("Administrar Ordenes Compra");
        subMenuAdminOrdenesCompra.addActionListener(this::subMenuAdminOrdenesCompraActionPerformed);
        menuAdministracion.add(subMenuAdminOrdenesCompra);

        subMenuAdminDetalleOrdenesCompra.setText("Administrar Detalle Oredenes Compra");
        subMenuAdminDetalleOrdenesCompra.addActionListener(this::subMenuAdminDetalleOrdenesCompraActionPerformed);
        menuAdministracion.add(subMenuAdminDetalleOrdenesCompra);

        barraMenu.add(menuAdministracion);

        menuReportes.setText("Reportes");
        barraMenu.add(menuReportes);

        menuAyuda.setText("Ayuda");

        subMenuAcercade.setText("Acerca de...");
        subMenuAcercade.addActionListener(this::subMenuAcercadeActionPerformed);
        menuAyuda.add(subMenuAcercade);

        barraMenu.add(menuAyuda);

        setJMenuBar(barraMenu);

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

    private void subMenuAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAcercadeActionPerformed
        FrmDiaAcercade FDAcercade = new FrmDiaAcercade(this,true);
        
        FDAcercade.setVisible(true);
        FDAcercade.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAcercadeActionPerformed

    private void subMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSalirActionPerformed
        //this.dispose(); //Cierre de la ventana
        System.exit(0); //Terminacion del programa
    }//GEN-LAST:event_subMenuSalirActionPerformed

    private void subMenuAdminRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminRolesActionPerformed
        FrmDiaAdminRoles FDAdminRoles = new FrmDiaAdminRoles(this,true);
        FDAdminRoles.setVisible(true);
        FDAdminRoles.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminRolesActionPerformed

    private void subMenuAdminTiposClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminTiposClienteActionPerformed
        FrmDiaAdminTipoCliente FDAdminTipoCliente = new FrmDiaAdminTipoCliente(this,true);
        FDAdminTipoCliente.setVisible(true);
        FDAdminTipoCliente.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminTiposClienteActionPerformed

    private void subMenuAdminDetallesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminDetallesVentasActionPerformed
        FrmDiaAdminDetalleVentas FDAdminDetalleVentas = new FrmDiaAdminDetalleVentas(this,true);
        FDAdminDetalleVentas.setVisible(true);
        FDAdminDetalleVentas.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminDetallesVentasActionPerformed

    private void subMenuAdminCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminCategoriaActionPerformed
        FrmDiaAdminCategoria FDAdminCategoria = new FrmDiaAdminCategoria(this,true);
        FDAdminCategoria.setVisible(true);
        FDAdminCategoria.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminCategoriaActionPerformed

    private void subMenuAdminProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminProveedoresActionPerformed
        FrmDiaAdminProveedores FDAdminProveedores = new FrmDiaAdminProveedores(this,true);
        FDAdminProveedores.setVisible(true);
        FDAdminProveedores.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminProveedoresActionPerformed

    private void menuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuArchivoActionPerformed

    private void subMenuAdminEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminEmpleadosActionPerformed
        FrmDiaAdminEmpleados FDAdminEmpleados = new FrmDiaAdminEmpleados(this,true);
        FDAdminEmpleados.setVisible(true);
        FDAdminEmpleados.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminEmpleadosActionPerformed

    private void subMenuAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminClientesActionPerformed
        FrmDiaAdminClientes FDAdminClientes = new FrmDiaAdminClientes(this,true);
        FDAdminClientes.setVisible(true);
        FDAdminClientes.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminClientesActionPerformed

    private void menuAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdministracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuAdministracionActionPerformed

    private void subMenuAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminProductosActionPerformed
        FrmDiaAdminProductos FDAdminProductos = new FrmDiaAdminProductos(this,true);
        FDAdminProductos.setVisible(true);
        FDAdminProductos.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminProductosActionPerformed

    private void subMenuAdminVentasFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminVentasFacturasActionPerformed
        FrmDiaAdminVentasFactura FDAdminVentasFactura = new FrmDiaAdminVentasFactura(this,true);
        FDAdminVentasFactura.setVisible(true);
        FDAdminVentasFactura.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminVentasFacturasActionPerformed

    private void subMenuAdminDetalleOrdenesCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminDetalleOrdenesCompraActionPerformed
        FrmDiaAdminDetalleOrdenesCompra FDAdminDetalleOredenesCompra = new FrmDiaAdminDetalleOrdenesCompra(this,true);
        FDAdminDetalleOredenesCompra.setVisible(true);
        FDAdminDetalleOredenesCompra.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminDetalleOrdenesCompraActionPerformed

    private void subMenuAdminOrdenesCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAdminOrdenesCompraActionPerformed
        FrmDiaAdminOrdenesCompra FDAdminOrdenesCompra = new FrmDiaAdminOrdenesCompra(this,true);
        FDAdminOrdenesCompra.setVisible(true);
        FDAdminOrdenesCompra.setLocationRelativeTo(null);
    }//GEN-LAST:event_subMenuAdminOrdenesCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem subMenuAcercade;
    private javax.swing.JMenuItem subMenuAdminCategoria;
    private javax.swing.JMenuItem subMenuAdminClientes;
    private javax.swing.JMenuItem subMenuAdminDetalleOrdenesCompra;
    private javax.swing.JMenuItem subMenuAdminDetallesVentas;
    private javax.swing.JMenuItem subMenuAdminEmpleados;
    private javax.swing.JMenuItem subMenuAdminOrdenesCompra;
    private javax.swing.JMenuItem subMenuAdminProductos;
    private javax.swing.JMenuItem subMenuAdminProveedores;
    private javax.swing.JMenuItem subMenuAdminRoles;
    private javax.swing.JMenuItem subMenuAdminTiposCliente;
    private javax.swing.JMenuItem subMenuAdminVentasFacturas;
    private javax.swing.JMenuItem subMenuSalir;
    // End of variables declaration//GEN-END:variables
}
