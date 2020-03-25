
package GUI;

import javax.swing.*;
import java.util.*;
import java.io.*;

/**
 * This initializes the GUI elements to create a new Schottkey type diode. It can create and write to a new data file
 *
 * @author Jeff Chen
 */
public class newSchottkey extends javax.swing.JFrame {

    
    
    ArrayList<schottkey> schottkeys;
    
    private float QUANTITY;
    private String TYPE;
    private String MOUNT;
    /**
     * Creates new form newSchottkey
	 *
	 * @param quantity number of diodes
	 * @param Type the type of diode
	 * @param Mount the type of the mount
     */
    public newSchottkey(float quantity, String Type, String Mount) {
        
        this.QUANTITY = quantity;
        this.TYPE = Type;
        this.MOUNT = Mount;
        
        initComponents();
        
        schottkeys = new ArrayList<schottkey>();
        populateArrayList();
    }
    
	/**
     * Creates new form newSchottkey
	 */
    public newSchottkey() {
    }
    
    /**
	 * This will read from a data file that has all of the previous orders for Schottkey diodes
	 */
    public void populateArrayList() {
        try
        {
            FileInputStream file = new FileInputStream("Schottkeys.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            
            boolean endOfFile = false;
            
            while(!endOfFile)
            {
                try
                {
                    schottkeys.add((schottkey) inputFile.readObject());
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
	 * @throws exception if there is no data file.
	 */
    public void saveSchottkeysToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("Schottkeys.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i = 0; i < schottkeys.size() ; i++)
            {
                outputFile.writeObject(schottkeys.get(i));
                
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
        jLabel5 = new javax.swing.JLabel();
        rCurrent = new javax.swing.JTextField();
        fVoltage = new javax.swing.JTextField();
        fCurrent = new javax.swing.JTextField();
        LFSM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        jLabel1.setText("New Schottkey Diode");

        jLabel2.setText("Reverse Current:");

        jLabel3.setText("Forward Voltage:");

        jLabel4.setText("Forward Current:");

        jLabel5.setText("LFSM:");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rCurrent)
                            .addComponent(fVoltage)
                            .addComponent(fCurrent)
                            .addComponent(LFSM, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fVoltage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LFSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        pack();
    }

	/**
	 * Checks if user input is valid and saves it to a data file. 
	 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        
        if (rCurrent.getText().isEmpty() || fVoltage.getText().isEmpty() || fCurrent.getText().isEmpty() || LFSM.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Enter all fields!");
        }
        else 
        {
            String RCURRENT = rCurrent.getText().trim();
            String FVOLTAGE = fVoltage.getText().trim();
            String FCURRENTDROP = fCurrent.getText().trim();
            String lfsm = LFSM.getText().trim();
            
            //float reverseCurrent, float forwardVoltage, float forwardCurrent, float lfsm, float Quanitity, String type, String mount
            schottkey Schottkey = new schottkey(Float.parseFloat(RCURRENT), Float.parseFloat(FVOLTAGE), Float.parseFloat(FCURRENTDROP), Float.parseFloat(lfsm), QUANTITY, TYPE, MOUNT );
            
            //Diode diode = new Diode(Float.parseFloat(quantity), Type, Mount);
            
            schottkeys.add(Schottkey);
            saveSchottkeysToFile();
            
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
            java.util.logging.Logger.getLogger(newSchottkey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newSchottkey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newSchottkey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newSchottkey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newSchottkey().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JTextField LFSM;
    private javax.swing.JTextField fCurrent;
    private javax.swing.JTextField fVoltage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField rCurrent;
   
}
