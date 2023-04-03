package medicareapi;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.*;

public class GetAnalgesicsProducts {
	
	@Test
	public void verifyAnalgesicsProducts() {
		Response response = RestAssured
			.when()
				.get("http://localhost:8080/medicare/json/data/category/2/products")
			.then()
				.assertThat()
				.statusCode(200)
				.time(Matchers.lessThan(1000L))
			.and()
				.body("[0].name", is("Diclofenac"))
				.body("[1].name", is("Aceclofenac"))
			.extract().response();
		
		response.body().prettyPrint();		

		
	}

}
