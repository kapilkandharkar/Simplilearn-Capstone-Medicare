package medicareapi;

import static org.hamcrest.Matchers.is;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAntipyreticsProducts {
	
	@Test
	public void verifyAnalgesicsProducts() {
		Response response = RestAssured
			.when()
				.get("http://localhost:8080/medicare/json/data/category/1/products")
			.then()
				.assertThat()
				.statusCode(200)
				.time(Matchers.lessThan(1000L))
			.and()
				.body("[0].name", is("Paracetamol"))
				.body("[1].name", is("Combiflame"))
			.extract().response();
		
		response.body().prettyPrint();	
	}

}
