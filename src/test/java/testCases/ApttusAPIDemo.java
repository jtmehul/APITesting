package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApttusAPIDemo {
	
	public Properties prop;
	
	
	@Test(dataProvider="getData")
	public void apiDemo(String station, String extId) throws IOException{
		
		prop = new Properties();
		FileInputStream fis  = new FileInputStream(".//data.properties");
		prop.load(fis);
		String apiUrl = prop.getProperty("apiURL");
		RestAssured.baseURI =apiUrl;
		String city = "Pune";
		String keyAPI="e686306e2c24a6ab1821bf94ed870e29";
			
		String invalidAPIkey = given().log().all().queryParam("q", city).
		when().get("data/3.0/stations").
		then().assertThat().log().all().statusCode(401).extract().response().asString();
		
		JsonPath jp = new JsonPath(invalidAPIkey);
		String respCode = jp.getString("cod");
		String respMessage = jp.getString("message");
		System.out.println( "Response Code is "+respCode + " and " + respMessage);	
	
		String strStationName = given().log().all().queryParam("q", city).queryParam("appid", keyAPI).
		header("Content-Type", "application/json").
		body(PayLoad.addStation(extId,station)).
		when().post("data/3.0/stations"). 
		then().log().all().assertThat().statusCode(201).
		extract().response().asString();
			
		JsonPath jPath = new JsonPath(strStationName);
		String stationId = jPath.getString("ID");
		String stationName = jPath.getString("name");
		
		System.out.println(stationId + "and " + stationName);
		
		given().log().all().queryParam("appid", keyAPI).
		header("Content-Type", "application/json").
		when().delete("data/3.0/stations/"+stationId).then().log().all().assertThat().statusCode(204).
		extract().response();
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{ 
				                {"Staton_0022", "Amrav"},
				                {"Staton_0033", "Nagpur" }
		                      };
	}
}
