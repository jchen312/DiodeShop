
package GUI;

import java.io.*;

/**
 * This is used to create an object with the traits of the user
 *
 * @author Jeff Chen
 */
public class User implements Serializable {
    
    private String fName;
    private String lName;
    private String address;
    private String city;
    private String state;
    private String zCode;

	/**
	 * Constructor taking in multiple values of the user. 
	 *
	 * @param fName the user's first name.
	 * @param lName the user's last name.
	 * @param address the user's address.
	 * @param city the user's city.
	 * @param state the user's state.
	 * @param zCode the user's zip code. 
	 */
    public User(String fName, String lName, String address, String city, String state, String zCode) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zCode = zCode;
    }

	
	/**
	 * Gets the  state  of the user
	 * @return the  state  of the user.
	 */
    public String getState() {
        return state;
    }

	
	
	/**
	 * Sets the state
	 * @param state  the  of the user
	 */
    public void setState(String state) {
        this.state = state;
    }


     /**
	 * Gets the  first name  of the user
	 * @return the  first name  of the user.
	 */
    public String getfName() {
        return fName;
    }

	
	/**
	 * Sets the first name
	 * @param fName  the first name of the user
	 */
    public void setfName(String fName) {
        this.fName = fName;
    }

	
	
	/**
	 * Gets the  last name  of the user
	 * @return the  last name  of the user.
	 */
    public String getlName() {
        return lName;
    }

	
	/**
	 * Sets the last name
	 * @param lName  the  last name of the user
	 */
    public void setlName(String lName) {
        this.lName = lName;
    }

	
	/**
	 * Gets the   address  of the user
	 * @return the  address  of the user.
	 */
    public String getAddress() {
        return address;
    }



	/**
	 * Sets the address
	 * @param address  the address of the user
	 */
    public void setAddress(String address) {
        this.address = address;
    }

	
	
	/**
	 * Gets the  city  of the user
	 * @return the   city of the user.
	 */
    public String getCity() {
        return city;
    }

	
	/**
	 * Sets the city
	 * @param  city the  of the user
	 */
    public void setCity(String city) {
        this.city = city;
    }

	
	
	/**
	 * Gets the  zip code  of the user
	 * @return the  zip code  of the user.
	 */
    public String getzCode() {
        return zCode;
    }

	
	/**
	 * Sets the zip code
	 * @param zCode  the zip code of the user
	 */
    public void setzCode(String zCode) {
        this.zCode = zCode;
    }
    
    
}
