
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminDetalleVentasDB;
import modelo.DetalleVentas;


public class FrmDiaAdminDetalleVentas extends javax.swing.JDialog {
    DefaultTableModel modeloTabla;
    AdminDetalleVentasDB objADMDetalleVentasDB = new AdminDetalleVentasDB();
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmDiaAdminDetalleVentas.class.getName());

    
    public FrmDiaAdminDetalleVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configurarTabla();
        this.refrescarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"ID", "Cantidad", "Precio_unitario", "Porcentaje_iva", "Subtotal_item", "VentasFactura_id", "Productos_id_codigo"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaDeDetalleVentas.setModel(this.modeloTabla);
    }
    
    private void refrescarTabla() {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[9];

        for (Object obj : objADMDetalleVentasDB.listarTodo()) {
            DetalleVentas objDetalleVentas = (DetalleVentas) obj;
            filaDeTabla[0] = Integer.toString(objDetalleVentas.getId());
            filaDeTabla[1] = Integer.toString((int)objDetalleVentas.getCantidad());
            filaDeTabla[2] = Integer.toString((int)objDetalleVentas.getPrecio_unitario());
            filaDeTabla[3] = Integer.toString((int)objDetalleVentas.getPorcentaje_iva());
            filaDeTabla[4] = Integer.toString((int)objDetalleVentas.getSubtotal_item());
            filaDeTabla[5] = Integer.toString(objDetalleVentas.getVentasFactura_id());
            filaDeTabla[6] = Integer.toString(objDetalleVentas.getProductos_id_codigo());

            this.modeloTabla.addRow(filaDeTabla);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaDeDetalleVentas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setText("Acerca de Papeleria y Libreria");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel3.setText("Administrar Detalle Ventas");

        tblListaDeDetalleVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListaDeDetalleVentas);

        btnAgregar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnModificar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);

        btnSalir.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(46, 46, 46)
                .addComponent(btnModificar)
                .addGap(61, 61, 61)
                .addComponent(btnEliminar)
                .addGap(50, 50, 50)
                .addComponent(btnSalir)
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(26, Short.MAX_VALUE))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DetalleVentas objDetalleVentas = new DetalleVentas();

        FrmDiaAdminDetalleVentasAgregar objFDADMDetalleVentasDBAgregar = new FrmDiaAdminDetalleVentasAgregar(null,true,objDetalleVentas);
        objFDADMDetalleVentasDBAgregar.setVisible(true);
        objFDADMDetalleVentasDBAgregar.setLocationRelativeTo(null);

        objADMDetalleVentasDB.insertar(objDetalleVentas);

        this.refrescarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListaDeDetalleVentas.getSelectedRow();

        if(fila>=0){

            int ID = Integer.parseInt(this.tblListaDeDetalleVentas.getValueAt(fila, 0).toString());

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere quitar este Rol?","Quitar Roles",JOptionPane.YES_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                DetalleVentas objDetalleVentas = new DetalleVentas();
                objDetalleVentas.setId(ID);

                objADMDetalleVentasDB.eliminar(objDetalleVentas);
                this.refrescarTabla();
            }

        }else{
            JOptionPane.showConfirmDialog(null, "!!! Por favor, seleccione una fila de la tabla !!!");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = this.tblListaDeDetalleVentas.getSelectedRow();

        if(fila>=0){
            int ID = Integer.parseInt(this.tblListaDeDetalleVentas.getValueAt(fila, 0).toString());

            DetalleVentas objDetalleVentas = new DetalleVentas();
            objDetalleVentas.setId(ID);

            objDetalleVentas = (DetalleVentas)objADMDetalleVentasDB.listarUno(objDetalleVentas);

            FrmDiaAdminDetalleVentasModificar objFDADetalleVentasMod = new FrmDiaAdminDetalleVentasModificar(null,true,objDetalleVentas);
            objFDADetalleVentasMod.setVisible(true);
            objFDADetalleVentasMod.setLocationRelativeTo(null);

            objADMDetalleVentasDB.actualizar(objDetalleVentas);

            this.refrescarTabla();
        }else{
            JOptionPane.showConfirmDialog(null, "!!! Por favor, seleccione una fila de la tabla !!!");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaDeDetalleVentas;
    // End of variables declaration//GEN-END:variables
}
