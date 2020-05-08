package getRequest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import pojo.Upcoming;
import utilities.ExportToExcel;

public class ContentTest extends ExportToExcel{

	
	Upcoming upcomingMovies = given().when().get("https://apiproxy.paytm.com/v2/movies/upcoming").as(Upcoming.class);
	int size = get("https://apiproxy.paytm.com/v2/movies/upcoming").path("upcomingMovieData.size()");
	
	@Test
	public void verifyContentAvailable_extractMovieName() {
		
		for (int i = 0; i < size; i++) {
			int content = upcomingMovies.getUpcomingMovieData().get(i).getIsContentAvailable();
			if (content == 0) {
				String movieTitle = upcomingMovies.getUpcomingMovieData().get(i).getMovieTitle();
				excelLog("Movies", movieTitle, i);
			} else {
				
			}
			
		}	
	}
}
