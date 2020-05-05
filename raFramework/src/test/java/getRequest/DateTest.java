package getRequest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.io.Files;

import junit.framework.Assert;
import pojo.Upcoming;
import pojo.UpcomingMovieDatum;

public class DateTest {

	Upcoming upcomingMovies = given().when().get("https://apiproxy.paytm.com/v2/movies/upcoming").as(Upcoming.class);
	int size = get("https://apiproxy.paytm.com/v2/movies/upcoming").path("upcomingMovieData.size()");
	
	@Test
	public void assertReleaseDate() {

		Date today = new Date(2020, 05, 04);
		for (int i = 0; i < size; i++) {
			assertTrue(today.before(upcomingMovies.getUpcomingMovieData().get(i).getReleaseDate()));
			/*
			 * using JUnit
			 * assertThat(today.After(upcomingMovies.getUpcomingMovieData().get(i).
			 * getReleaseDate()), is(true));
			 */
		}
	}
}
	/*
	@Test
	public void verify_paytmMovieCode_isUnique() {
		for (int i = 0; i < size; i++) {
			String code = upcomingMovies.getUpcomingMovieData().get(i).getPaytmMovieCode();
			Assert.assertTrue(isASCIIString(code));
		*/
