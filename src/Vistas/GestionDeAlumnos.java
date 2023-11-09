package Vistas;

import Datos.AlumnoDatos;
import Entidades.Alumno;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class GestionDeAlumnos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            if (columna != 0) {
                return true;
            } else {
                return false;
            }
        }
    };

    private class JDateChooserCellEditor extends AbstractCellEditor implements TableCellEditor {

        private JDateChooser dateChooser;
        private java.util.Date selectedDate;

        public JDateChooserCellEditor() {
            dateChooser = new JDateChooser();
            dateChooser.setDateFormatString("yyyy-MM-dd"); // Establece el formato de fecha según tus necesidades
            // Agregar un PropertyChangeListener para capturar la fecha seleccionada
            dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals("date")) {
                        selectedDate = (java.util.Date) evt.getNewValue();
                        stopCellEditing();
                    }
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return selectedDate;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof java.util.Date) {
                selectedDate = (java.util.Date) value;
                dateChooser.setDate(selectedDate);
            }
            return dateChooser;
        }
    }

    private class DateRenderer extends DefaultTableCellRenderer {

        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        protected void setValue(Object value) {
            if (value instanceof java.util.Date) {
                setText(dateFormat.format((java.util.Date) value));
            } else {
                super.setValue(value);
            }
        }
    }

    /**
     * Creates new form GestionDeAlumno
     */
    public GestionDeAlumnos() {
        initComponents();
        armarCabezera();
        cargarTabla();
        textmod(false);
        elejirColumanasFechas(4);
         ajustarAlturaDeFilas(40);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/imgEst1.jpg"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jtBuscarXNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdateFechaN = new com.toedter.calendar.JDateChooser();
        jbNuevo = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setTitle("Gestion De Alumnos");

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Busqueda Por Nombre");
        jLabel1.setOpaque(true);

        jtBuscarXNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarXNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtBuscarXNombreKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 153, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Crear Materia");
        jLabel2.setOpaque(true);

        jLabel3.setBackground(new java.awt.Color(0, 153, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 153, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Apellido:");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(0, 153, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Dni:");
        jLabel5.setOpaque(true);

        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidoKeyTyped(evt);
            }
        });

        jtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDniKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 153, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Fecha De Nacimiento:");
        jLabel6.setOpaque(true);

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuev.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agre.png"))); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOpaque(true);

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/conf.png"))); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eli.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jtBuscarXNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtApellido)
                                            .addComponent(jtDni, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                        .addGap(37, 37, 37)
                                        .addComponent(jbNuevo)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbAgregar))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jdateFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 167, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbSalir)
                                        .addGap(48, 48, 48))))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtBuscarXNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addComponent(jdateFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jbNuevo)
                                            .addComponent(jbAgregar)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jbModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminar)
                                .addGap(22, 22, 22)
                                .addComponent(jbSalir))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jtBuscarXNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarXNombreKeyReleased
        // Busqueda de datos y agregarlo en la tabla
        String nombre = this.jtBuscarXNombre.getText();
        modelo.setRowCount(0);
        for (Alumno alu : AlumnoDatos.listarAlumnoActivo()) {
            if (alu.getNombre().toLowerCase().startsWith(nombre.toLowerCase())) {
                int id = alu.getIdAlumno();
                String nom = alu.getNombre();
                String ape = alu.getApellido();
                int dni = alu.getDni();
                Date fNac = Date.valueOf(alu.getFechaN());
                modelo.addRow(new Object[]{id, nom, ape, dni, fNac});
            }
        }
    }//GEN-LAST:event_jtBuscarXNombreKeyReleased

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // Agregar
        try {
            String nom = this.jtNombre.getText();
            String ape = this.jtApellido.getText();
            String dniText = this.jtDni.getText();

            if (nom.isEmpty() || ape.isEmpty() || dniText.isEmpty() || this.jdateFechaN.getDate() == null) {
                JOptionPane.showMessageDialog(null, "No deben quedar campos vacíos");
                limpiar();
            } else {
                int dni = Integer.parseInt(dniText);
                java.util.Date fechaN = this.jdateFechaN.getDate();
                java.sql.Date sqlDateFecha = new java.sql.Date(fechaN.getTime());

                AlumnoDatos.guardarAlumno(new Alumno(dni, ape, nom, sqlDateFecha.toLocalDate(), true));
                modelo.setRowCount(0);
                cargarTabla();
                limpiar();
                textmod(false);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El campo DNI debe ser un número válido.");
            limpiar();
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        // Nuevo
        textmod(true);
        limpiar();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // Salir
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // Eliminar
        int filaSelecionada = this.jTable1.getSelectedRow();
        if (filaSelecionada != -1) {// Verifica si se ha seleccionado una fila válida
            int id = Integer.parseInt(modelo.getValueAt(filaSelecionada, 0).toString());
            AlumnoDatos.eliminarAlumno(id);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la tabla antes de Eliminar un Alumno", "Error", JOptionPane.ERROR_MESSAGE);
        }
        modelo.setRowCount(0);
        cargarTabla();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDniKeyTyped
        char c = evt.getKeyChar();
        // Verifica si el carácter es un dígito (0-9)
        if (!Character.isDigit(c)) {
            evt.consume();  // Si no es un dígito, consumir el evento
        }
    }//GEN-LAST:event_jtDniKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped
        // para que los text field no tome numeros
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped
        // para que los text field no tome numeros
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtBuscarXNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarXNombreKeyTyped
        // para que los text field no tome numeros
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }
    }//GEN-LAST:event_jtBuscarXNombreKeyTyped

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        try {
            int filaSelecionada = this.jTable1.getSelectedRow();
            if (filaSelecionada != -1) { // Verifica si se ha seleccionado una fila válida
                int id = Integer.parseInt(modelo.getValueAt(filaSelecionada, 0).toString());
                String nomb = modelo.getValueAt(filaSelecionada, 1).toString();
                String ape = modelo.getValueAt(filaSelecionada, 2).toString();
                int d = Integer.parseInt(modelo.getValueAt(filaSelecionada, 3).toString());
                // Obtén la fecha como un objeto java.util.Date
                java.util.Date utilDatefechaN = (java.util.Date) modelo.getValueAt(filaSelecionada, 4);
                // Convierte las fechas de java.util.Date a java.sql.Date
                java.sql.Date sqlDatefechaN = new java.sql.Date(utilDatefechaN.getTime());
                if (d < 0) {
                    throw new IllegalArgumentException("Número negativo no permitido");
                }
                AlumnoDatos.modicarAlumno(new Alumno(id, d, ape, nomb, sqlDatefechaN.toLocalDate(), true));
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila antes de intentar actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            modelo.fireTableDataChanged();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar números ", "Error", JOptionPane.ERROR_MESSAGE);
            modelo.setRowCount(0);
            cargarTabla();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar números reales positivos", "Error", JOptionPane.ERROR_MESSAGE);
            modelo.setRowCount(0);
            cargarTabla();
        }
    }//GEN-LAST:event_jbModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdateFechaN;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtBuscarXNombre;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables

    private void armarCabezera() {
        modelo.addColumn("IdAlumno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Dni");
        modelo.addColumn("Fecha de Nacimiento");
        this.jTable1.setModel(modelo);
    }

    private void cargarTabla() {
        for (Alumno alu : AlumnoDatos.listarAlumnoActivo()) {
            int id = alu.getIdAlumno();
            String nom = alu.getNombre();
            String ape = alu.getApellido();
            int dni = alu.getDni();
            Date fNac = Date.valueOf(alu.getFechaN());
            modelo.addRow(new Object[]{id, nom, ape, dni, fNac});
        }
    }

    private void textmod(boolean ok) {
        this.jtNombre.setEnabled(ok);
        this.jtApellido.setEnabled(ok);
        this.jtDni.setEnabled(ok);
        this.jdateFechaN.setEnabled(ok);
        this.jbAgregar.setEnabled(ok);
    }

    private void limpiar() {
        this.jtNombre.setText("");
        this.jtApellido.setText("");
        this.jtDni.setText("");
        this.jdateFechaN.setDate(null);
    }

    private void elejirColumanasFechas(int columna) {
        GestionDeAlumnos.JDateChooserCellEditor fechaN = new GestionDeAlumnos.JDateChooserCellEditor();
        this.jTable1.getColumnModel().getColumn(columna).setCellEditor(fechaN);
        // Configura el renderizador para mostrar las fechas en el formato deseado en la tabla
        this.jTable1.getColumnModel().getColumn(columna).setCellRenderer(new GestionDeAlumnos.DateRenderer());
//        this.jTable1.getColumnModel().getColumn(columna).setPreferredWidth(75);
    }

    private void ajustarAlturaDeFilas(int altura) {
        jTable1.setRowHeight(altura);
    }
}