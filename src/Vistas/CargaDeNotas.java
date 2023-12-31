package Vistas;

import Datos.AlumnoDatos;
import Datos.InscripcionDatos;
import Entidades.Alumno;
import Entidades.Inscripcion;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CargaDeNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return columna == 2;
        }
    };

    /**
     * Creates new form CargaDeNotas
     */
    public CargaDeNotas() {
        initComponents();
        armarCabezera();
        cargarCombox();
        modelo.setRowCount(0);
        cargarTabla();
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/imgN.jpg"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jcAlu = new javax.swing.JComboBox<>();
        jbInsc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Carga de Notas");

        jPanel1.setPreferredSize(new java.awt.Dimension(571, 571));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Selecionar Alumno");
        jLabel1.setOpaque(true);

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

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jcAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAluActionPerformed(evt);
            }
        });

        jbInsc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbInsc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/saveN.png"))); // NOI18N
        jbInsc.setText("Guardar");
        jbInsc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 153, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Actualización de Notas");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jcAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jbInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbInsc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // Salir
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAluActionPerformed
//        // combox cargar tabla
        modelo.setRowCount(0);
        cargarTabla();
    }//GEN-LAST:event_jcAluActionPerformed

    private void jbInscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscActionPerformed
        // Guardar
        try {
            int filaSelecionada = this.jTable1.getSelectedRow();
            if (filaSelecionada != -1) { // Verifica si se ha seleccionado una fila válida
                int idA = Integer.parseInt(modelo.getValueAt(filaSelecionada, 0).toString());
                String nom = modelo.getValueAt(filaSelecionada, 1).toString();
                double not = Double.parseDouble(modelo.getValueAt(filaSelecionada, 2).toString());
                if (not < 0) {
                    throw new IllegalArgumentException("Número negativo no permitido");
                }
                Inscripcion ins = InscripcionDatos.buscarInscripcionPorIdAyNOM(idA, nom);
                InscripcionDatos.modificarInscripcion(new Inscripcion(ins.getIdInscripcion(), not, ins.getAlumno(), ins.getMateria()));
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila antes de intentar Guardar La Nota", "Error", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_jbInscActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbInsc;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcAlu;
    // End of variables declaration//GEN-END:variables

    private void armarCabezera() {
        modelo.addColumn("IdAlumno");
        modelo.addColumn("Nombre de la Materia");
        modelo.addColumn("Nota");
        this.jTable1.setModel(modelo);
    }

    private void cargarCombox() {
        for (Alumno alu : AlumnoDatos.listarAlumnoActivo()) {
            this.jcAlu.addItem(alu);
        }
    }

    private void cargarTabla() {
        Alumno alu = (Alumno) this.jcAlu.getSelectedItem();
        for (Inscripcion insc : InscripcionDatos.obtenerMateriasCursadasNotas(alu.getIdAlumno())) {
            int idAlu = alu.getIdAlumno();
            String nom = insc.getMateria().getNombre();
            double not = insc.getNota();
            modelo.addRow(new Object[]{idAlu, nom, not});
        }
    }
    
    private void ajustarAlturaDeFilas(int altura) {
        jTable1.setRowHeight(altura);
    }

}
