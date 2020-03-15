
package GUI;

/**
 *
 * @author Jeff Chen
 */
public class zener extends Diode {
    private float zenerVoltage;
    private float zenerCurrent;
    private float zenerImpedance;

    public zener(float zenerVoltage, float zenerCurrent, float zenerImpedance) {
        this.zenerVoltage = zenerVoltage;
        this.zenerCurrent = zenerCurrent;
        this.zenerImpedance = zenerImpedance;
    }

    public zener(float zenerVoltage, float zenerCurrent, float zenerImpedance, float Quanitity, String type, String mount) {
        super(Quanitity, type, mount);
        this.zenerVoltage = zenerVoltage;
        this.zenerCurrent = zenerCurrent;
        this.zenerImpedance = zenerImpedance;
    }
    
    public zener(float Quanitity, String type, String mount)
    {
        super(Quanitity, type, mount);
    }

    public float getZenerVoltage() {
        return zenerVoltage;
    }

    public void setZenerVoltage(float zenerVoltage) {
        this.zenerVoltage = zenerVoltage;
    }

    public float getZenerCurrent() {
        return zenerCurrent;
    }

    public void setZenerCurrent(float zenerCurrent) {
        this.zenerCurrent = zenerCurrent;
    }

    public float getZenerImpedance() {
        return zenerImpedance;
    }

    public void setZenerImpedance(float zenerImpedance) {
        this.zenerImpedance = zenerImpedance;
    }
    
    
}
