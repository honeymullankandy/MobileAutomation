package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.Location;
import Pojo.map;

public class TestDataBuild {
	public map addPlace(String name,String adress,String Phone)
	{
		map p =new map();
		p.setAccuracy(50);
		p.setAdress(name);
		p.setLanguages(adress);
		p.setPhone_number(Phone);
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}

}
