Package GUI;
Import java.io.*;

/*
 * 
 * @ author Jeff Chen
 */

public class Diode implements Serializable {

	private float Value;
	private String type;
	private float maxVoltage;
	private float maxCurrent;

	public Diode(float Value, String type, float maxVoltage, float maxCurrent) {
		this.Value = Value;
		this.type = type;
		this.maxVoltage = maxVoltage;
		this.maxCurrent = maxCurrent;
	}

	public float getValue() {
		return Value;
	}

	public void setValue(float Value) {
		this.Value = Value
	}



	public String getType() {
		return type;
	}

	public void setType(String Type) {
		this.type = Type;
	}



	public float getMaxVoltage() {
		return maxVoltage;
	}

	public void setMaxVoltage(float maxVoltage) {
		this.maxVoltage = maxVoltage
	}



	public float getmaxCurrent() {
		return maxCurrent;
	}

	public void setmaxCurrent(float maxCurrent) {
		this.maxCurrent = maxCurrent
	}
}