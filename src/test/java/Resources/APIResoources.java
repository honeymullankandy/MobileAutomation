package Resources;

public enum APIResoources {
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	APIResoources(String s)
	{
		this.resource=s;
	}
	public String getResource()
	{
		return resource;
	}

}
