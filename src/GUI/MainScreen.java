/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Jeff Chen
 */
public class MainScreen extends javax.swing.JFrame {

    
    
    ArrayList<normal> normals;
    ArrayList<schottkey> schottkeys;
    ArrayList<zener> zeners;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        
        //not sure if necessary
        normals = new ArrayList<normal>();
        schottkeys = new ArrayList<schottkey>();
        zeners = new ArrayList<zener>();
        
        
        
        
        
        
        //the plan is to write some code that can read off of the arraylist and display everything in a chart.
        //from what i've seen it should be possible? but I need to implement a lot more work lmao.
        // In the future: add a drop down list. This list will have like "zener" "normal" and "schottkey"
        // at the side of the drop down list, there will be a update button.
        // upon clickin this button, the populateArrayList() method will be run.
        // then i'll update the table with the values with my *two dimensional array*. 
        populateArrayList();
        
        
        
        String[][] data = new String[normals.size()][6];
        
        for (int i = 0; i< normals.size() ; i++)
        {
            String type = normals.get(i).getType();
            String mount = normals.get(i).getMount();
            String rCurrent = Float.toString(normals.get(i).getReverseCurrent());
            String fVoltage = Float.toString(normals.get(i).getForwardVoltage());
            String fCurrent = Float.toString(normals.get(i).getForwardCurrent());
            String quantity = Float.toString(normals.get(i).getQuanitity());
            
            data[i][0] = type;
            data[i][1] = mount;
            data[i][2] = rCurrent;
            data[i][3] = fVoltage;
            data[i][4] = fCurrent;
            data[i][5] = quantity;
            
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String [] {
                "Diode Type", "Mount Type", "Reverse Current", "Forward Voltage", "Forward Current", "Quantity"
            }
        ));
        
        
        
        
        String[][] data2 = new String[zeners.size()][6];
        
        for (int k = 0; k< zeners.size(); k++) 
        {
            String type = zeners.get(k).getType();
            String mount = zeners.get(k).getMount();
            String zVoltage = Float.toString(zeners.get(k).getZenerVoltage());
            String zCurrent = Float.toString(zeners.get(k).getZenerCurrent());
            String zImpedance = Float.toString(zeners.get(k).getZenerImpedance());
            String quantity = Float.toString(zeners.get(k).getQuanitity());
            
            data2[k][0] = type;
            data2[k][1] = mount;
            data2[k][2] = zVoltage;
            data2[k][3] = zCurrent;
            data2[k][4] = zImpedance;
            data2[k][5] = quantity;
        }
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            data2,
            new String [] {
                "Diode Type", "Mount Type", "Zener Voltage", "Zener Current" , "Zenner Impedance", "Quantity"
            }
        ));
        
        
        
        String[][] data3 = new String[schottkeys.size()][7];
        
        for (int i = 0; i < schottkeys.size(); i++)
        {
            data3[i][0] = schottkeys.get(i).getType();
            data3[i][1] = schottkeys.get(i).getMount();
            data3[i][2] = Float.toString(schottkeys.get(i).getReverseCurrent());
            data3[i][3] = Float.toString(schottkeys.get(i).getForwardVoltage());
            data3[i][4] = Float.toString(schottkeys.get(i).getForwardCurrent());
            data3[i][5] = Float.toString(schottkeys.get(i).getLfsm());
            data3[i][6] = Float.toString(schottkeys.get(i).getQuanitity());
        }
        
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            data3,
            new String [] {
                "Diode Type", "Mount Type", "Reverse Current", "Forward Voltage", "Forward Current", "LFSM", "Quantity"
            }
        ));
    }

    
    public void populateArrayList() 
    {
        
        try
        {
            FileInputStream file = new FileInputStream("Normals.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            
            boolean endOfFile = false;
            
            while(!endOfFile)
            {
                try
                {
                    normals.add((normal) inputFile.readObject());
                }
                
                catch (EOFException e)
                {
                    endOfFile = true;
                }
                catch (Exception f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }    
            }
            
            file.close(); //inputFile.close(); probably unnecessary?
            inputFile.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        
        try
        {
            FileInputStream file2 = new FileInputStream("Zeners.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            
            boolean endOfFile = false;
            
            while(!endOfFile)
            {
                try
                {
                    zeners.add((zener) inputFile2.readObject());
                }
                
                catch (EOFException e)
                {
                    endOfFile = true;
                }
                catch (Exception f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }    
            }
            
            file2.close();
            inputFile2.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        try
        {
            FileInputStream file3 = new FileInputStream("Schottkeys.dat");
            ObjectInputStream inputFile3 = new ObjectInputStream(file3);
            
            
            boolean endOfFile = false;
            
            while(!endOfFile)
            {
                try
                {
                    schottkeys.add((schottkey) inputFile3.readObject());
                }
                
                catch (EOFException e)
                {
                    endOfFile = true;
                }
                catch (Exception f)
                {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }    
            }
            
            file3.close();
            inputFile3.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
        
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Diode Shop");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jButton1.setText("Add New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(jTable1);

        jTabbedPane1.addTab("Normal", jScrollPane2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane3.setViewportView(jTable2);

        jTabbedPane1.addTab("Zener", jScrollPane3);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane4.setViewportView(jTable3);

        jTabbedPane1.addTab("Schottkey", jScrollPane4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel1))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        //open the NewDiode Jframe Screen
        new newDiode().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
