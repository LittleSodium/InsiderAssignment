package getRequest;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.io.Files;

import pojo.Upcoming;
import pojo.UpcomingMovieDatum;
import utilities.DateConverter;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetData {

	@BeforeClass
	public static void setupURL() {
		
		// default URL and API base path to use throughout the tests
		RestAssured.baseURI = "https://apiproxy.paytm.com";
		RestAssured.basePath = "/v2/movies/upcoming";
	}

	
	// common
	Upcoming upcomingMovies = given().when().get("https://apiproxy.paytm.com/v2/movies/upcoming").as(Upcoming.class);
	int size = get("https://apiproxy.paytm.com/v2/movies/upcoming").path("upcomingMovieData.size()");

	
	//Status Code Verification
	@Test
	public void testStatusCode() {

		Response resp = get("https://apiproxy.paytm.com/v2/movies/upcoming");
		int code = resp.getStatusCode();
		System.out.println("Status code is " + code);
		Assert.assertEquals(200, code);
	}

	
	//Fetching Test Body and Response Time
	@Test
	public void testBody_ResponseTime() {

		Response resp = get("https://apiproxy.paytm.com/v2/movies/upcoming");
		String upcomingMoviesData = resp.asString();
		// System.out.println("Data code is " + upcomingMoviesData);
		long time = get("https://apiproxy.paytm.com/v2/movies/upcoming").getTime();
		System.out.println("Response time " + time + "ms");
	}

	
	//Movie Name Assertion
	@Test
	public void assertMovieName() {
		Assert.assertEquals("K.G.F. Chapter 2", upcomingMovies.getUpcomingMovieData().get(0).getProviderMoviename());
	}

	
	//Verify all release dates are in the future
	@Test
	public void assertReleaseDate() {

		Date today = new Date(2020, 05, 04);
		for (int i = 0; i < size; i++) {
			assertTrue(today.before(upcomingMovies.getUpcomingMovieData().get(i).getReleaseDate()));
			System.out.println(upcomingMovies.getUpcomingMovieData().get(i).getReleaseDate());
		}
	}
	
	
	//Verify all promo codes are unique
	private static <T> boolean checkForDuplicates(T... array) {
		Set<T> set = new HashSet<>(Arrays.asList(array));

		return array.length != set.size();
	}

	@Test
	public void verify_paytmMovieCode_isUnique() {
		String[] codes = new String[size];
		for (int i = 0; i < size; i++) {
			codes[i] = upcomingMovies.getUpcomingMovieData().get(i).getPaytmMovieCode();
		}
		Assert.assertFalse(checkForDuplicates(codes));
	}
	
	
	//Verify file type is .jpg for movie poster url
	public String getExtensionByGuava(String filename) {
	    return Files.getFileExtension(filename);
	}
	
	@Test
	public void verifyURLFileType() {
			String url = upcomingMovies.getUpcomingMovieData().get(0).getMoviePosterUrl();
			System.out.println(url);
			String fileType = getExtensionByGuava(url);
			System.out.println(fileType);
			Assert.assertEquals("jpg", fileType);
		}
		
	
	public static boolean isASCIIString(String pString) {
		return CharMatcher.ASCII.matchesAllOf(pString);
	}

	//Verify language of promo code
	@Test
	public void verify_paytmMovieCode_isSameLanguage() {
		for (int i = 0; i < size; i++) {
			String code = upcomingMovies.getUpcomingMovieData().get(i).getPaytmMovieCode();
			Assert.assertTrue(isASCIIString(code));
		}	
	}

}
