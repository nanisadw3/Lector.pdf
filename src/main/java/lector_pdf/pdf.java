package lector_pdf;

import com.itextpdf.text.BaseColor;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author inaki
 */
public class pdf extends javax.swing.JFrame {

    public pdf() {
        initComponents();
        initComponents();
        setVisible(true);
        setSize(470, 290);
        setTitle("Lector");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

    }
    String ruta_1 = "";
    String ruta_2 = "";
    int bandera_1 = 0;
    String[] palabras = null;
    String[] palabras2 = null;

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        BT_doc1 = new javax.swing.JButton();
        BT_doc2 = new javax.swing.JButton();
        BT_crear = new javax.swing.JButton();
        BT_borrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iñaki Sobera Sotomayor© ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        BT_doc1.setIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Doc_n.png")); // NOI18N
        BT_doc1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        BT_doc1.setContentAreaFilled(false);
        BT_doc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BT_doc1.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Doc_s.png")); // NOI18N
        BT_doc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_doc1ActionPerformed(evt);
            }
        });
        getContentPane().add(BT_doc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 80, 100));

        BT_doc2.setIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Doc_n.png")); // NOI18N
        BT_doc2.setBorder(null);
        BT_doc2.setContentAreaFilled(false);
        BT_doc2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BT_doc2.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Doc_s.png")); // NOI18N
        BT_doc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_doc2ActionPerformed(evt);
            }
        });
        getContentPane().add(BT_doc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 80, 100));

        BT_crear.setIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Crear_n.png")); // NOI18N
        BT_crear.setBorder(null);
        BT_crear.setContentAreaFilled(false);
        BT_crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BT_crear.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Crear_h.png")); // NOI18N
        BT_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_crearActionPerformed(evt);
            }
        });
        getContentPane().add(BT_crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 130, 60));

        BT_borrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\B_c.png")); // NOI18N
        BT_borrar.setBorder(null);
        BT_borrar.setContentAreaFilled(false);
        BT_borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BT_borrar.setRolloverIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\B_a.png")); // NOI18N
        BT_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_borrarActionPerformed(evt);
            }
        });
        getContentPane().add(BT_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 70, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\inaki\\OneDrive\\Documentos\\NetBeansProjects\\L_PDF\\src\\Imagenes\\Fondo.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_doc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_doc1ActionPerformed

        bandera_1 = 0;

        JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("PDF", "pdf");
        buscador.setFileFilter(filtrado);

        int respuesta = buscador.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {

            ruta_1 = buscador.getSelectedFile().getPath();
            ImageIcon paloma = new ImageIcon("C:/Users/inaki/OneDrive/Documentos/NetBeansProjects/L_PDF/src/Imagenes/Doc_c");
            BT_doc1.setIcon(paloma);

            JOptionPane.showMessageDialog(null, ruta_1);
            System.out.println(ruta_1);
        }
        try {
            PDDocument documento = PDDocument.load(new File(ruta_1)); // ruta_1 es la ruta del primer documento PDF
            PDFTextStripper stripper = new PDFTextStripper();
            String contenido = stripper.getText(documento);

            palabras = contenido.split("\\s+|(?<=,)|(?=,)|\\?"); // Divide por espacios, comas y signos de interrogación

            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = palabras[i].toLowerCase(); // Convertir cada palabra a minúsculas
                System.out.println(palabras[i]);
            }

            documento.close();
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this, "Debes seleccionar un documento", "Error en el documento 1", 3);

        }
        System.out.println(palabras);
    }//GEN-LAST:event_BT_doc1ActionPerformed

    private void BT_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_crearActionPerformed

        System.out.println("============================================================================");
        if (bandera_1 == 1) {

            JOptionPane.showMessageDialog(this, "Estos Dos Dopumentos ya fueron relacionados", "Relacion", 1);

        } else {

            if (ruta_1.equals("") || ruta_2.equals("")) {

                JOptionPane.showMessageDialog(this, "No se ha seleccionado la ruta de algun documento", "Error de seleccion", 3);

            } else {

                if (palabras != null && palabras2 != null) {

                    Set<String> setPalabras = new HashSet<>(Arrays.asList(palabras));
                    String[] palabras_c = null;

                    System.out.println("Palabras comunes:");
                    for (String palabras : palabras2) {
                        if (setPalabras.contains(palabras)) {
                            System.out.println(palabras);
                        }
                    }

                    //-------------------------Cuarta parte------------------------
                    String rutaEscritorio = System.getProperty("user.home");

                    try {
                        Document doc = new Document();
                        PdfWriter.getInstance(doc, new FileOutputStream(rutaEscritorio + "/Desktop/Coinsidencias.pdf"));

                        Paragraph parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                        parrafo.add("Las palabras coinsidentes son: \n\n");

                        for (String palabra : palabras2) {
                            if (setPalabras.contains(palabra)) {
                                parrafo.add(palabra + "\n ");
                            }
                        }
                        parrafo.setFont(FontFactory.getFont("Tahoma", 20, BaseColor.BLACK));

                        doc.open();
                        doc.add(parrafo);
                        doc.close();

                        JOptionPane.showMessageDialog(this, "El documento fue creado con exito en la ruta: " + rutaEscritorio + " con el nombre de Coinsidencias.pdf", "Informacion", 1);

                    } catch (DocumentException ex) {

                        JOptionPane.showMessageDialog(this, "Error en la creacion del documento de coinsidencias", "Error en el documento 2", 0);

                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, "Error en el llenado del documento", "Error en el documento 2", 0);
                    }
                    bandera_1 = 1;
                    System.out.println(ruta_1);
                    System.out.println(ruta_2);
                } else {

                    JOptionPane.showMessageDialog(this, "Los documentos se encuentran vacios", "Estado de los documentos", 2);

                }
            }
        }
    }//GEN-LAST:event_BT_crearActionPerformed

    private void BT_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_borrarActionPerformed

        bandera_1 = 0;
        ruta_1 = "";
        ruta_2 = "";
        JOptionPane.showMessageDialog(this, "Las rutas se han vaciado", "Estado", 1);
        ImageIcon normal = new ImageIcon("C:/Imagenes/Doc_n");
        BT_doc1.setIcon(normal);
        BT_doc1.setIcon(normal);

    }//GEN-LAST:event_BT_borrarActionPerformed

    private void BT_doc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_doc2ActionPerformed
        bandera_1 = 0;

        JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("PDF", "pdf");
        buscador.setFileFilter(filtrado);

        int respuesta = buscador.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {

            ruta_2 = buscador.getSelectedFile().getPath();

            JOptionPane.showMessageDialog(null, ruta_2);
            System.out.println(ruta_1);
        }
        try {
            PDDocument documento = PDDocument.load(new File(ruta_2)); // ruta_1 es la ruta del primer documento PDF
            PDFTextStripper stripper = new PDFTextStripper();
            String contenido = stripper.getText(documento);

            palabras2 = contenido.split("\\s+|(?<=,)|(?=,)|\\?"); // Divide por espacios, comas y signos de interrogación

            for (int i = 0; i < palabras2.length; i++) {
                palabras2[i] = palabras2[i].toLowerCase();
                System.out.println(palabras2[i]);
            }

            documento.close();
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this, "Debes seleccionar un documento", "Error en el documento 1", 3);

        }
        System.out.println(palabras);
    }//GEN-LAST:event_BT_doc2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pdf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_borrar;
    private javax.swing.JButton BT_crear;
    private javax.swing.JButton BT_doc1;
    private javax.swing.JButton BT_doc2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
