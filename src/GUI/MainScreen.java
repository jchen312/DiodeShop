
package GUI;

import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
/**
 * This initializes all of the main GUI elements and displays previous diode orders.
 *
 * @author Jeff Chen
 */
public class MainScreen extends javax.swing.JFrame {

    
    
    ArrayList<normal> normals;
    ArrayList<schottkey> schottkeys;
    ArrayList<zener> zeners;
    private DefaultTableModel dataModel;
    
    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        
        
        normals = new ArrayList<normal>();
        schottkeys = new ArrayList<schottkey>();
        zeners = new ArrayList<zener>();
        
        
        
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
        
        normals.clear();
        zeners.clear();
        schottkeys.clear();
    }

    
	/**
	 * Reads the data files and populates each ArrayList with the values in the data files. 
	 *
	 *
	 * @throws exception if there is no data file.
	 */
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
	 * Initializes all of the GUI components.
	 */
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); 
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

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Billing");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(122, 122, 122))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
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
    }

	
	/**
	 * Upon user interaction, this will display a screen to create a new diode order.
	 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        //open the NewDiode Jframe Screen
        new newDiode().setVisible(true);
    }

	/**
	 * Upon user interaction, this updates each of the tables displaying the diode orders.
	 */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        
        //clear the contents of each table. 
        jTable1.setModel(new DefaultTableModel());
        jTable2.setModel(new DefaultTableModel());
        jTable3.setModel(new DefaultTableModel());
        
       
        populateArrayList();

        
        String[][] data11 = new String[normals.size()][6];
        
        for (int i = 0; i< normals.size() ; i++)
        {
            String type = normals.get(i).getType();
            String mount = normals.get(i).getMount();
            String rCurrent = Float.toString(normals.get(i).getReverseCurrent());
            String fVoltage = Float.toString(normals.get(i).getForwardVoltage());
            String fCurrent = Float.toString(normals.get(i).getForwardCurrent());
            String quantity = Float.toString(normals.get(i).getQuanitity());
            
            data11[i][0] = type;
            data11[i][1] = mount;
            data11[i][2] = rCurrent;
            data11[i][3] = fVoltage;
            data11[i][4] = fCurrent;
            data11[i][5] = quantity;
            
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            data11,
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
        
        
        normals.clear();
        zeners.clear();
        schottkeys.clear();
        
        
        
    }

	
	/**
	 * Upon user interaction, this will display a screen showing the user's information.
	 */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        new userScreen().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    
}
