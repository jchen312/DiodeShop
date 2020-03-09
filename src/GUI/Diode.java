/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.io.*;

/**
 *
 * @author Jeff Chen
 */
public class Diode implements Serializable  {
    
    private float Quanitity;
    private String type;
    private String mount;


    
    public Diode() {}

    public Diode(float Quanitity, String type, String mount) {
        this.Quanitity = Quanitity;
        this.type = type;
        this.mount = mount;
    }

    public float getQuanitity() {
        return Quanitity;
    }

    public void setQuanitity(float Quanitity) {
        this.Quanitity = Quanitity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    
    
    
}
