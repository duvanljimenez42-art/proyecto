
package vista;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.VentasFactura;
import modelo.AdminVentasFacturaDB;


public class FrmDiaAdminVentasFactura extends javax.swing.JDialog {
    DefaultTableModel modeloTabla;
    AdminVentasFacturaDB objADMVentasFacturaDB = new AdminVentasFacturaDB();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmDiaAdminVentasFactura.class.getName());

    
    public FrmDiaAdminVentasFactura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.configurarTabla();
        this.refrescarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"ID", "Numero_factura", "Fecha_hora", "Metodo_pago", "Costo_servicio_adicional", "Subtotal", "Iva_total", "Total", "Empleado_id", "Clientes_id"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaDeVentasFactura.setModel(this.modeloTabla);
    }
    
    private void refrescarTabla() {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[10];

        for (Object obj : objADMVentasFacturaDB.listarTodo()) {
            VentasFactura objVentasFactura = (VentasFactura) obj;
            filaDeTabla[0] = Integer.toString(objVentasFactura.getId());
            filaDeTabla[1] = objVentasFactura.getNumero_factura();
            filaDeTabla[2] = objVentasFactura.getFecha_hora();
            filaDeTabla[3] = objVentasFactura.getMetodo_pago();
            filaDeTabla[4] = Integer.toString((int) objVentasFactura.getCosto_servicio_adicional());
            filaDeTabla[5] = Integer.toString((int)objVentasFactura.getSubtotal());
            filaDeTabla[6] = Integer.toString((int)objVentasFactura.getIva_total());
            filaDeTabla[7] = Integer.toString((int) objVentasFactura.getTotal());
            filaDeTabla[8] = Integer.toString(objVentasFactura.getEmpleados_id());
            filaDeTabla[9] = Integer.toString(objVentasFactura.getClientes_id());

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
        tblListaDeVentasFactura = new javax.swing.JTable();
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
        jLabel3.setText("Administrar Roles");

        tblListaDeVentasFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListaDeVentasFactura);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(84, 84, 84)
                .addComponent(btnEliminar)
                .addGap(58, 58, 58)
                .addComponent(btnSalir)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        VentasFactura objVentasFactura = new VentasFactura();

        FrmDiaAdminVentasFacturaAgregar objFDADMVentasFacturaAgregar = new FrmDiaAdminVentasFacturaAgregar(null,true,objVentasFactura);
        objFDADMVentasFacturaAgregar.setVisible(true);
        objFDADMVentasFacturaAgregar.setLocationRelativeTo(null);

        objADMVentasFacturaDB.insertar(objVentasFactura);

        this.refrescarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListaDeVentasFactura.getSelectedRow();

        if(fila>=0){

            int ID = Integer.parseInt(this.tblListaDeVentasFactura.getValueAt(fila, 0).toString());

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro que quiere quitar este Rol?","Quitar Roles",JOptionPane.YES_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                VentasFactura objVentasFactura = new VentasFactura();
                objVentasFactura.setId(ID);

                objADMVentasFacturaDB.eliminar(objVentasFactura);
                this.refrescarTabla();
            }

        }else{
            JOptionPane.showConfirmDialog(null, "!!! Por favor, seleccione una fila de la tabla !!!");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        /*int fila = this.tblListaDeVentasFactura.getSelectedRow();

        if(fila>=0){
            int ID = Integer.parseInt(this.tblListaDeVentasFactura.getValueAt(fila, 0).toString());

            VentasFactura objVentasFactura = new VentasFactura();
            objVentasFactura.setId(ID);

            objVentasFactura = (VentasFactura)objADMVentasFacturaDB.listarUno(objVentasFactura);

            FrmDiaAdminVentasFacturaModificar objFDAVentasFacturaMod = new FrmDiaAdminVentasFacturaModificar(null,true,objVentasFactura);
            objFDAVentasFacturaMod.setVisible(true);
            objFDAVentasFacturaMod.setLocationRelativeTo(null);

            objADMVentasFacturaDB.actualizar(objVentasFactura);

            this.refrescarTabla();
        }else{
            JOptionPane.showConfirmDialog(null, "!!! Por favor, seleccione una fila de la tabla !!!");
        }*/
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
    private javax.swing.JTable tblListaDeVentasFactura;
    // End of variables declaration//GEN-END:variables
}
