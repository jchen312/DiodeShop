
package GUI;

/**
 *
 * @author Jeff Chen
 */
public class normal extends Diode {
    
    private float reverseCurrent;       
    private float forwardVoltage;
    private float forwardCurrent;

    
    
    public normal(float reverseCurrent, float forwardVoltage, float forwardCurrent) {
        this.reverseCurrent = reverseCurrent;
        this.forwardVoltage = forwardVoltage;
        this.forwardCurrent = forwardCurrent;
    }

    public normal(float reverseCurrent, float forwardVoltage, float forwardCurrent, float Quanitity, String type, String mount) {
        super(Quanitity, type, mount);
        this.reverseCurrent = reverseCurrent;
        this.forwardVoltage = forwardVoltage;
        this.forwardCurrent = forwardCurrent;
    }
    
    public normal(float Quanitity, String type, String mount) {
        super(Quanitity, type, mount);
    }
    
    

    public float getReverseCurrent() {
        return reverseCurrent;
    }

    public void setReverseCurrent(float reverseCurrent) {
        this.reverseCurrent = reverseCurrent;
    }

    public float getForwardVoltage() {
        return forwardVoltage;
    }

    public void setForwardVoltage(float forwardVoltage) {
        this.forwardVoltage = forwardVoltage;
    }

    public float getForwardCurrent() {
        return forwardCurrent;
    }

    public void setForwardCurrent(float forwardCurrent) {
        this.forwardCurrent = forwardCurrent;
    }
    
    
    //public String toString() {
        
    //}
    
}
