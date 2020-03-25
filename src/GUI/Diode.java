
package GUI;
import java.io.*;

/**
 * The Diode class will be used to create an object with the basic traits of a diode.
 *
 * @author Jeff Chen
 */
public class Diode implements Serializable  {
    
    private float Quanitity;
    private String type;
    private String mount;


    /**
	 * Basic constructor
	 */
    public Diode() {}

	/**
	 * Constructor taking in multiple values of the diode. 
	 *
	 * @param Quantity the number of diodes.
	 * @param type the type of the diode (normal, zener, schottkey)
	 * @param mount the type of mount
	 */
    public Diode(float Quanitity, String type, String mount) {
        this.Quanitity = Quanitity;
        this.type = type;
        this.mount = mount;
    }

	/**
	 * Gets the quantity of the diode.
	 * @return the quantity of the diodes.
	 */
    public float getQuanitity() {
        return Quanitity;
    }

	
	/**
	 * Sets the quantity of diodes.
	 * @param Quantity the number of diodes.
	 */
    public void setQuanitity(float Quanitity) {
        this.Quanitity = Quanitity;
    }

	
	/**
	 * Gets the diode type. 
	 * @return the diode type.
	 */
    public String getType() {
        return type;
    }

	
	/**
	 * Sets the Type of the diode
	 * @param type of the diode.
	 */
    public void setType(String type) {
        this.type = type;
    }

	
	/**
	 * Gets the diode mount type.
	 * @return the mount type of the diode.
	 */
    public String getMount() {
        return mount;
    }

	
	/**
	 * Sets the Mount of the diode
	 * @param diode mount type.
	 */
    public void setMount(String mount) {
        this.mount = mount;
    }
    
    
}
