
package ventanas;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;





public class RegistroAlumnos extends javax.swing.JFrame {

  
    public RegistroAlumnos() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_grupo = new javax.swing.JTextField();
        Insertar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        Consultar = new javax.swing.JButton();
        label_status = new javax.swing.JLabel();
        PDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Grupo:");

        Insertar.setText("Registrar");
        Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarActionPerformed(evt);
            }
        });

        Actualizar.setText("Modificar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingresa el codigo del alumno:");

        Consultar.setText("Buscar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        label_status.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        PDF.setText("Generar PDF");
        PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txt_nombre)
                        .addComponent(jLabel2)
                        .addComponent(txt_grupo, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insertar)
                        .addGap(68, 68, 68)
                        .addComponent(Actualizar)
                        .addGap(61, 61, 61)
                        .addComponent(Eliminar)
                        .addGap(50, 50, 50)
                        .addComponent(PDF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label_status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Consultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Insertar)
                            .addComponent(Actualizar)
                            .addComponent(Eliminar)
                            .addComponent(PDF))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addComponent(Consultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(label_status, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarActionPerformed
       try{
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins","root","");
            PreparedStatement pst = cn.prepareStatement("insert into alumnos values(?,?,?)");
       
            pst.setString(1, "0");
            pst.setString(2, txt_nombre.getText().trim());
            pst.setString(3, txt_grupo.getText().trim());
            
            pst.executeUpdate();
            
            txt_nombre.setText("");
            txt_grupo.setText("");
            
            label_status.setText("Registro exitoso");
            
            
            
        }catch(SQLException e){
            
            
            
            
            
        }
    }//GEN-LAST:event_InsertarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        try{
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root","");
            PreparedStatement pst = cn.prepareStatement("select * from alumnos where ID = ?");
            
            pst.setString(1, txt_buscar.getText().trim());
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                txt_nombre.setText(rs.getString("NombreAlumno"));
                txt_grupo.setText(rs.getString("Grupo"));
                
                
            }else{
                
                JOptionPane.showMessageDialog(null,"Alumno no registrado");
                
                
            }
            
            
        }catch(SQLException e){
            
        } 
    }//GEN-LAST:event_ConsultarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
       
        try
        {
            String ID = txt_buscar.getText().trim();
            
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins","root","");
            PreparedStatement pst =cn.prepareStatement("update alumnos set NombreAlumno = ?, Grupo = ? where ID = " + ID);
            pst.setString(1, txt_nombre.getText().trim());
            pst.setString(2, txt_grupo.getText().trim());
            
            pst.executeUpdate();
            
          label_status.setText("Modificacion exitosa");

            
            
            
            
        } catch (SQLException ex)
        {
            Logger.getLogger(RegistroAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        

        try{
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins","root","");
            PreparedStatement pst = cn.prepareStatement("delete from alumnos where ID = ?");
            
            pst.setString(1, txt_buscar.getText().trim());
            
            pst.executeUpdate();
            
           txt_nombre.setText("");
           txt_grupo.setText("");
           txt_buscar.setText("");
           
           label_status.setText("Registro Eliminado");

            
            
            
            
            
        }catch(Exception e){
            
            
            
        }
        

    }//GEN-LAST:event_EliminarActionPerformed

    private void PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PDFActionPerformed

        Document documento = new Document();
        
        try{
            
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Alumnos.pdf"));
            documento.open();
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre del Alumno");
            tabla.addCell("Grupo");
            
            
            
            try{
            

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins","root","");
            PreparedStatement pst = cn.prepareStatement("select * from alumnos");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                
                do{
                    
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    
                }while(rs.next());
                documento.add(tabla);
                
                
            }
            
            }catch(DocumentException | SQLException e){
                
                
                documento.close();
                JOptionPane.showMessageDialog(null,"Reporte creado");
                
                
                
                
            }

            
            
            
            
        }catch(DocumentException | HeadlessException | FileNotFoundException e){
            
            
            
            
        }
        
    

    }//GEN-LAST:event_PDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RegistroAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Consultar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Insertar;
    private javax.swing.JButton PDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel label_status;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_grupo;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
