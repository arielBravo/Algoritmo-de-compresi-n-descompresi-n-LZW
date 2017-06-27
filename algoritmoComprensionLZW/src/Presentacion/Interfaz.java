/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Logica.*;
        
/**
 *
 * @author ariel
 */
import javax.swing.JOptionPane;
public class Interfaz extends javax.swing.JFrame {
private static String ruta=null;
CompresionLZW objetoCompresion;
DescompresionLZW objetoDescompresion;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArchivoDescomprimido = new java.awt.TextArea();
        botonBuscarArchivoLZW = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rutaArchivoDescomprimir = new javax.swing.JTextField();
        botonComprimir = new javax.swing.JButton();
        botonDescomprimir = new javax.swing.JButton();
        botonBuscarArchivoTXT = new javax.swing.JButton();
        rutaArchivoComprimir = new javax.swing.JTextField();
        textArchivoComprimido = new java.awt.TextArea();
        textArchivo = new java.awt.TextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(textArchivoDescomprimido, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 490, 140));

        botonBuscarArchivoLZW.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        botonBuscarArchivoLZW.setText("Buscar Archivo");
        botonBuscarArchivoLZW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarArchivoLZWActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarArchivoLZW, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 520, 510));

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel2.setText("Algoritmo de compresión LZW");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 400, 40));

        rutaArchivoDescomprimir.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        getContentPane().add(rutaArchivoDescomprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 560, 40));

        botonComprimir.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        botonComprimir.setText("Comprimir");
        botonComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonComprimirActionPerformed(evt);
            }
        });
        getContentPane().add(botonComprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 160, 40));

        botonDescomprimir.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        botonDescomprimir.setText("Descomprimir");
        botonDescomprimir.setToolTipText("");
        botonDescomprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescomprimirActionPerformed(evt);
            }
        });
        getContentPane().add(botonDescomprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 160, 40));

        botonBuscarArchivoTXT.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        botonBuscarArchivoTXT.setText("Buscar Archivo");
        botonBuscarArchivoTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarArchivoTXTActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarArchivoTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 150, 40));

        rutaArchivoComprimir.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        rutaArchivoComprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaArchivoComprimirActionPerformed(evt);
            }
        });
        getContentPane().add(rutaArchivoComprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 570, 40));
        getContentPane().add(textArchivoComprimido, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, 220, 190));
        getContentPane().add(textArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 360, 190));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel3.setText("Archivo a comprimir");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 160, 20));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel4.setText("Codigos generados en el archivo_comprimido.LZW");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jLabel6.setText("Archivo Descomprimido");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 170, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarArchivoLZWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarArchivoLZWActionPerformed
       JFileChooser ventanaBusqueda = new JFileChooser();//Objeto ventana de busqueda
        ventanaBusqueda.setFileSelectionMode(JFileChooser.FILES_ONLY);//Tipo de busqueda
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".LZW", "LZW");
        ventanaBusqueda.setFileFilter(filter);//Extenciones
        //ventanaBusqueda.setMultiSelectionEnabled(true);//Seleccionar varios archivos
        int returnVal = ventanaBusqueda.showOpenDialog(null);//Condicional de aceptacion seleccion
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File archivo = ventanaBusqueda.getSelectedFile();
            ruta = archivo.getAbsolutePath();
            rutaArchivoDescomprimir.setText(ruta);
        }        
    }//GEN-LAST:event_botonBuscarArchivoLZWActionPerformed

    private void botonComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonComprimirActionPerformed
        if(rutaArchivoComprimir.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Primero seleccione la ruta del archivo a comprimir");
        }else{
           objetoCompresion=new CompresionLZW(rutaArchivoComprimir.getText());
            objetoCompresion.comprimir();
            if(objetoCompresion.obtenerTiempo()>0){
               textArchivo.setText(objetoCompresion.getTextoArchivo());
               textArchivoComprimido.setText(objetoCompresion.getValoresCodificados());
               JOptionPane.showMessageDialog(null, "El tiempo que se demora en comprimir es: "+objetoCompresion.obtenerTiempo()+" milisegundos"+" \n"+
                       "Peso del archivo original: "+objetoCompresion.getPesoArchivo()+" KB"+"\n"+
                       "Peso del archivo comprimido: "+objetoCompresion.getPesoArchivoComprimido()+" KB"); 
            }
            
        }
    }//GEN-LAST:event_botonComprimirActionPerformed

    private void botonBuscarArchivoTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarArchivoTXTActionPerformed
        JFileChooser ventanaBusqueda = new JFileChooser();//Objeto ventana de busqueda
        ventanaBusqueda.setFileSelectionMode(JFileChooser.FILES_ONLY);//Tipo de busqueda
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
        ventanaBusqueda.setFileFilter(filter);//Extenciones
        //ventanaBusqueda.setMultiSelectionEnabled(true);//Seleccionar varios archivos
        int returnVal = ventanaBusqueda.showOpenDialog(null);//Condicional de aceptacion seleccion
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File archivo = ventanaBusqueda.getSelectedFile();
            ruta = archivo.getAbsolutePath();
            rutaArchivoComprimir.setText(ruta);
        } 
    }//GEN-LAST:event_botonBuscarArchivoTXTActionPerformed

    private void rutaArchivoComprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaArchivoComprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaArchivoComprimirActionPerformed

    private void botonDescomprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescomprimirActionPerformed
        if(rutaArchivoDescomprimir.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Primero seleccione la ruta del archivo a descomprimir");
        }else{
           objetoDescompresion=new DescompresionLZW(rutaArchivoDescomprimir.getText());
            objetoDescompresion.descomprimir();
            if(objetoDescompresion.obtenerTiempo()>0){
               textArchivoDescomprimido.setText(objetoDescompresion.getTextoArchivoDescomprimido());
               JOptionPane.showMessageDialog(null, "El tiempo que se demora en descomprimir es: "+objetoDescompresion.obtenerTiempo()+" milisegundos"+" \n"+
                       "Peso del archivo comprimido: "+objetoDescompresion.getPesoArchivoComprimido()+" KB"+"\n"+
                       "Peso del archivo descomprimido: "+objetoDescompresion.getPesoArchivoDescomprimido()+" KB"); 
            }
            
        }
    }//GEN-LAST:event_botonDescomprimirActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarArchivoLZW;
    private javax.swing.JButton botonBuscarArchivoTXT;
    private javax.swing.JButton botonComprimir;
    private javax.swing.JButton botonDescomprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField rutaArchivoComprimir;
    private javax.swing.JTextField rutaArchivoDescomprimir;
    private java.awt.TextArea textArchivo;
    private java.awt.TextArea textArchivoComprimido;
    private java.awt.TextArea textArchivoDescomprimido;
    // End of variables declaration//GEN-END:variables
}