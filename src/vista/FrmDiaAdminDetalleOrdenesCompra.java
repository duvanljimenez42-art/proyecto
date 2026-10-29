
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminDetalleOrdenesCompraDB;
import modelo.DetalleOrdenesCompra;


public class FrmDiaAdminDetalleOrdenesCompra extends javax.swing.JDialog {
    DefaultTableModel modeloTabla;
    AdminDetalleOrdenesCompraDB objADMDetalleOrdenesCompraDB = new AdminDetalleOrdenesCompraDB();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmDiaAdminDetalleOrdenesCompra.class.getName());

    
    public FrmDiaAdminDetalleOrdenesCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configurarTabla();
        this.refrescarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"ID", "Cantidad", "Precio_compra", "OrdenesCompra_id", "Productos_id_codigo"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaDeDetalleOrdenesCompra.setModel(this.modeloTabla);
    }
    
    private void refrescarTabla() {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[5];

        for (Object obj : objADMDetalleOrdenesCompraDB.listarTodo()) {
            DetalleOrdenesCompra objDetalleOrdenesCompra = (DetalleOrdenesCompra) obj;
            filaDeTabla[0] = Integer.toString(objDetalleOrdenesCompra.getId());
            filaDeTabla[1] = Integer.toString(objDetalleOrdenesCompra.getCantidad());
            filaDeTabla[2] = Integer.toString((int)objDetalleOrdenesCompra.getPrecio_compra());
            filaDeTabla[3] = Integer.toString(objDetalleOrdenesCompra.getOrdenesCompra_id());
            filaDeTabla[4] = Integer.toString(objDetalleOrdenesCompra.getProductos_id_codigo());

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
        tblListaDeDetalleOrdenesCompra = new javax.swing.JTable();
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

        tblListaDeDetalleOrdenesCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListaDeDetalleOrdenesCompra);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        DetalleOrdenesCompra objDetalleOrdenesCompra = new DetalleOrdenesCompra();

        FrmDiaAdminDetalleOrdenesCompraAgregar objFDADMDetalleOrdenesCompraAgregar = new FrmDiaAdminDetalleOrdenesCompraAgregar(null,true,objDetalleOrdenesCompra);
        objFDADMDetalleOrdenesCompraAgregar.setVisible(true);
        objFDADMDetalleOrdenesCompraAgregar.setLocationRelativeTo(null);

        objADMDetalleOrdenesCompraDB.insertar(objDetalleOrdenesCompra);

        this.refrescarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListaDeDetalleOrdenesCompra.getSelectedRow();

        if(fila>=0){

            int ID = Integer.parseInt(this.tblListaDeDetalleOrdenesCompra.getValueAt(fila, 0).toString());

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere quitar este Rol?","Quitar Roles",JOptionPane.YES_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                DetalleOrdenesCompra objDetalleOrdenesCompra = new DetalleOrdenesCompra();
                objDetalleOrdenesCompra.setId(ID);

                objADMDetalleOrdenesCompraDB.eliminar(objDetalleOrdenesCompra);
                this.refrescarTabla();
            }

        }else{
            JOptionPane.showConfirmDialog(null, "!!! Por favor, seleccione una fila de la tabla !!!");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila = this.tblListaDeDetalleOrdenesCompra.getSelectedRow();

        if(fila>=0){
            int ID = Integer.parseInt(this.tblListaDeDetalleOrdenesCompra.getValueAt(fila, 0).toString());

            DetalleOrdenesCompra objDetalleOrdenesCompra = new DetalleOrdenesCompra();
            objDetalleOrdenesCompra.setId(ID);

            objDetalleOrdenesCompra = (DetalleOrdenesCompra)objADMDetalleOrdenesCompraDB.listarUno(objDetalleOrdenesCompra);

            FrmDiaAdminDetalleOrdenesCompraModificar objFDADetalleOrdenesCompraMod = new FrmDiaAdminDetalleOrdenesCompraModificar(null,true,objDetalleOrdenesCompra);
            objFDADetalleOrdenesCompraMod.setVisible(true);
            objFDADetalleOrdenesCompraMod.setLocationRelativeTo(null);

            objADMDetalleOrdenesCompraDB.actualizar(objDetalleOrdenesCompra);

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
    private javax.swing.JTable tblListaDeDetalleOrdenesCompra;
    // End of variables declaration//GEN-END:variables
}
