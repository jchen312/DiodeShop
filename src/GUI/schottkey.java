/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Jeff Chen
 */
public class schottkey extends Diode {
    private float reverseCurrent;       
    private float forwardVoltage;
    private float forwardCurrent;
    private float lfsm;

    public schottkey(float reverseCurrent, float forwardVoltage, float forwardCurrent, float lfsm) {
        this.reverseCurrent = reverseCurrent;
        this.forwardVoltage = forwardVoltage;
        this.forwardCurrent = forwardCurrent;
        this.lfsm = lfsm;
    }

    public schottkey(float reverseCurrent, float forwardVoltage, float forwardCurrent, float lfsm, float Quanitity, String type, String mount) {
        super(Quanitity, type, mount);
        this.reverseCurrent = reverseCurrent;
        this.forwardVoltage = forwardVoltage;
        this.forwardCurrent = forwardCurrent;
        this.lfsm = lfsm;
    }

    public schottkey(float quantity, String type, String mount) {
        super(quantity, type, mount);
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

    public float getLfsm() {
        return lfsm;
    }

    public void setLfsm(float lfsm) {
        this.lfsm = lfsm;
    }
    
}
