package medicareapi;

import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAntibioticsProducts {
	

	@Test
	public void verifyAnalgesicsProducts() {
		Response response = RestAssured
			.when()
				.get("http://localhost:8080/medicare/json/data/category/3/products")
			.then()
				.assertThat()
				.statusCode(200)
				.time(Matchers.lessThan(1000L))
			.and()
				.body("[0].name", is("Amoxicillin"))
				.body("[1].name", is("Ciprofloxacin"))
			.extract().response();
		
		response.body().prettyPrint();	
	}
}
