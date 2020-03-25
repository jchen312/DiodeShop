
package GUI;

import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * This initializes the GUI elements to create a new Zener type diode. It can create and write to a new data file
 *
 * @author Jeff Chen
 */
public class newZener extends javax.swing.JFrame {

    
    ArrayList<zener> zeners;
    
    private float QUANTITY;
    private String TYPE;
    private String MOUNT;
    
    /**
     * Creates new form newZener
	 *
	 * @param quantity number of diodes
	 * @param Type the type of diode
	 * @param Mount the type of the mount
     */
    public newZener(float quantity, String Type, String Mount) {
        this.QUANTITY = quantity;
        this.TYPE = Type;
        this.MOUNT = Mount;
        
        initComponents();
        
        zeners = new ArrayList<zener>();
        populateArrayList();
    }

	/**
     * Creates new form newZener
	 */
     public newZener() {
        initComponents();
    }
     
     
     /**
	 * This will read from a data file that has all of the previous orders for Zener diodes
	 * 
	 * @throws exception if there is no data file.
	 */
     public void populateArrayList() {
        try
        {
            FileInputStream file = new FileInputStream("Zeners.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            
            boolean endOfFile = false;
            
            while(!endOfFile)
            {
                try
                {
                    zeners.add((zener) inputFile.readObject());
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
            
            inputFile.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        
        
     /**
	 * This method saves the user input into a data file. 
	 *
	 * @throws exception if there is no data file.
	 */
    public void saveZenersToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("Zeners.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i = 0; i < zeners.size() ; i++)
            {
                outputFile.writeObject(zeners.get(i));
                
            }
            
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Successfully Saved!");
            
            this.dispose();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     
    
    
    /**
	 * This intiializes all of the GUI components. 
	 */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        zVoltage = new javax.swing.JTextField();
        zCurrent = new javax.swing.JTextField();
        zImpedance = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("New Zener Diode");

        jLabel2.setText("Zener Voltage:");

        jLabel3.setText("Zener Current:");

        jLabel4.setText("Zener Impedance:");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(zVoltage, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(zCurrent)
                            .addComponent(zImpedance)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(121, 121, 121))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(zVoltage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(zCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(zImpedance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );

        pack();
    }

	
	
	/**
	 * Checks if user input is valid and saves it to a data file. 
	 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        if (zVoltage.getText().isEmpty() || zCurrent.getText().isEmpty() || zImpedance.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Enter all fields!");
        }
        else 
        {
            String ZVOLTAGE = zVoltage.getText().trim();
            String ZCURRENT = zCurrent.getText().trim();
            String ZIMPEDANCE = zImpedance.getText().trim();
            
            //float zenerVoltage, float zenerCurrent, float zenerImpedance, float Quanitity, String type, String mount
            
            zener Zener = new zener(Float.parseFloat(ZVOLTAGE), Float.parseFloat(ZCURRENT), Float.parseFloat(ZIMPEDANCE), QUANTITY, TYPE, MOUNT );
            
            //Diode diode = new Diode(Float.parseFloat(quantity), Type, Mount);
            
            zeners.add(Zener);
            saveZenersToFile();
            
        }
        
        
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
            java.util.logging.Logger.getLogger(newZener.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newZener.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newZener.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newZener.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newZener().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField zCurrent;
    private javax.swing.JTextField zImpedance;
    private javax.swing.JTextField zVoltage;
    
}
