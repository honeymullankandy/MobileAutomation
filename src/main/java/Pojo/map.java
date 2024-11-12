package Pojo;

import java.util.List;

public class map {

    Location location;
    int Accuracy;
	String Name;
	String phone_number;
	String adress;
	List <String> Types;
	String Website;
	String Languages;
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getAccuracy() {
		return Accuracy;
	}
	public void setAccuracy(int accuracy) {
		Accuracy = accuracy;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public List getTypes() {
		return Types;
	}
	public void setTypes(List types) {
		Types = types;
	}
	public String getWebsite() {
		return Website;
	}
	public void setWebsite(String website) {
		Website = website;
	}
	public String getLanguages() {
		return Languages;
	}
	public void setLanguages(String languages) {
		Languages = languages;
	}
	
}
