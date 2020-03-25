
package GUI;

/**
 * This is used to create an object with the traits of a schottkey diode.
 *
 * @author Jeff Chen
 */
public class schottkey extends Diode {
    private float reverseCurrent;       
    private float forwardVoltage;
    private float forwardCurrent;
    private float lfsm;

	
	/**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param reverseCurrent the reverse current (ma) of the diode
	 * @param forwardVoltage the forward voltage drop (v) of the diode.
	 * @param forwardCurrent the forward current drop of the diode. 
	 * @param lfsm the lfsm of the diode.
	 */
    public schottkey(float reverseCurrent, float forwardVoltage, float forwardCurrent, float lfsm) {
        this.reverseCurrent = reverseCurrent;
        this.forwardVoltage = forwardVoltage;
        this.forwardCurrent = forwardCurrent;
        this.lfsm = lfsm;
    }

	
	/**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param reverseCurrent the reverse current (ma) of the diode
	 * @param forwardVoltage the forward voltage drop (v) of the diode.
	 * @param forwardCurrent the forward current drop of the diode.
	 * @param lfsm the lfsm of the diode.
	 * @param Quantity the number of diodes.
	 * @param type the type of the diode (normal, zener, schottkey)
	 * @param mount the type of mount	 
	 */
    public schottkey(float reverseCurrent, float forwardVoltage, float forwardCurrent, float lfsm, float Quanitity, String type, String mount) {
        super(Quanitity, type, mount);
        this.reverseCurrent = reverseCurrent;
        this.forwardVoltage = forwardVoltage;
        this.forwardCurrent = forwardCurrent;
        this.lfsm = lfsm;
    }

	
	
	/**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param Quantity the number of diodes.
	 * @param type the type of the diode (normal, zener, schottkey)
	 * @param mount the type of mount
	 */
    public schottkey(float quantity, String type, String mount) {
        super(quantity, type, mount);
    }
    
	
	/**
	 * Gets the reverse current of the diode. 
	 * @return the reverse current of the diode.
	 */
    public float getReverseCurrent() {
        return reverseCurrent;
    }

	
	/**
	 * Sets the reverse current of the diode
	 * @param reverseCurrent the reverse current of the diode
	 */
    public void setReverseCurrent(float reverseCurrent) {
        this.reverseCurrent = reverseCurrent;
    }

	
	/**
	 * Gets the forward voltage of the diode
	 * @return the forward voltage of the diode.
	 */
    public float getForwardVoltage() {
        return forwardVoltage;
    }

	
	
	/**
	 * Sets the forward voltage of the diode
	 * @param forwardVoltage the forward voltage of the diodes
	 */
    public void setForwardVoltage(float forwardVoltage) {
        this.forwardVoltage = forwardVoltage;
    }

	
	/**
	 * Gets the forward current of the diode
	 * @return the forward current of the diode.
	 */
    public float getForwardCurrent() {
        return forwardCurrent;
    }

	
	
	/**
	 * Sets the forward current of the diodes
	 * @param forwardCurrent the forward current of the diodes.
	 */
    public void setForwardCurrent(float forwardCurrent) {
        this.forwardCurrent = forwardCurrent;
    }

	
	/**
	 * Gets the lfsm of the diode
	 * @return the lfsm of the diode.
	 */
    public float getLfsm() {
        return lfsm;
    }

	
	
	/**
	 * Sets the lfsm of the diodes
	 * @param lfsm the lfsm of the diodes.
	 */
    public void setLfsm(float lfsm) {
        this.lfsm = lfsm;
    }
    
}
