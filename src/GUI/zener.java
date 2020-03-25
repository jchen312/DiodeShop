
package GUI;

/**
 * This is used to create an object with the traits of a normal diode.
 *
 * @author Jeff Chen
 */
public class zener extends Diode {
    private float zenerVoltage;
    private float zenerCurrent;
    private float zenerImpedance;

	
	/**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param zenerVoltage the zener Voltage  of the diode
	 * @param zenerCurrent the zener Current of the diode.
	 * @param zenerImpedance the zenerImpedance of the diode. 
	 */
    public zener(float zenerVoltage, float zenerCurrent, float zenerImpedance) {
        this.zenerVoltage = zenerVoltage;
        this.zenerCurrent = zenerCurrent;
        this.zenerImpedance = zenerImpedance;
    }

	
	/**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param zenerVoltage the zener Voltage  of the diode
	 * @param zenerCurrent the zener Current of the diode.
	 * @param zenerImpedance the zenerImpedance of the diode. 
	 * @param Quantity the number of diodes.
	 * @param type the type of the diode (normal, zener, schottkey)
	 * @param mount the type of mount	
	 */
    public zener(float zenerVoltage, float zenerCurrent, float zenerImpedance, float Quanitity, String type, String mount) {
        super(Quanitity, type, mount);
        this.zenerVoltage = zenerVoltage;
        this.zenerCurrent = zenerCurrent;
        this.zenerImpedance = zenerImpedance;
    }
	
	
    /**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param Quantity the number of diodes.
	 * @param type the type of the diode (normal, zener, schottkey)
	 * @param mount the type of mount
	 */
    public zener(float Quanitity, String type, String mount)
    {
        super(Quanitity, type, mount);
    }

	
	/**
	 * Gets the reverse current of the diode. 
	 * @return the reverse current of the diode.
	 */
    public float getZenerVoltage() {
        return zenerVoltage;
    }

	
	
	/**
	 * Sets the zener Voltage of the diode
	 * @param zenerVoltage the zener Voltage of the diode
	 */
    public void setZenerVoltage(float zenerVoltage) {
        this.zenerVoltage = zenerVoltage;
    }

	
	/**
	 * Gets the zener Current of the diode. 
	 * @return the zener Current of the diode.
	 */
    public float getZenerCurrent() {
        return zenerCurrent;
    }

	
	
	
	/**
	 * Sets the zener Current of the diode
	 * @param zenerCurrent the zener Current of the diode
	 */
    public void setZenerCurrent(float zenerCurrent) {
        this.zenerCurrent = zenerCurrent;
    }

	
	
	/**
	 * Gets the zener Impedance of the diode. 
	 * @return the zener Impedance of the diode.
	 */
    public float getZenerImpedance() {
        return zenerImpedance;
    }

	
	
	/**
	 * Sets the zener Impedance of the diode
	 * @param zenerImpedance the zener Impedance of the diode
	 */
    public void setZenerImpedance(float zenerImpedance) {
        this.zenerImpedance = zenerImpedance;
    }
    
    
}
