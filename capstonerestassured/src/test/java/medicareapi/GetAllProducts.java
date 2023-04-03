package medicareapi;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GetAllProducts {

	@Test
	public void verifyStatusCode() {

		RestAssured
			.when()
				.get("http://localhost:8080/medicare/json/data/all/products")
			.then()
				.assertThat()
				.statusCode(200)
				.time(Matchers.lessThan(1000L))
				.body("size()", is(6));

	}

}
