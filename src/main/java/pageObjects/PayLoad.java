package pageObjects;

public class PayLoad {

	
	public static String addStation(String stationName, String externalID){
		return "{\r\n    \"external_id\": \""+externalID+"\",\r\n    "
				+ "\"name\": \""+stationName+"\",\r\n    "
				+ "\"latitude\": 37.76,\r\n   "
				+ " \"longitude\": -122.43,\r\n   "
				+ " \"altitude\": 150\r\n}";
	}	
}
