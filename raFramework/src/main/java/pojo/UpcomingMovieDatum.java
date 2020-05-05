package pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import utilities.DateConverter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "provider_moviename", "moviePosterUrl", "movieTitle", "movie_name", "language", "genre",
		"releaseDate", "rank", "paytmMovieCode", "isContentAvailable", "contentId", "MovieCode" })
public class UpcomingMovieDatum {

	@JsonProperty("provider_moviename")
	private String providerMoviename;
	@JsonProperty("moviePosterUrl")
	private String moviePosterUrl;
	@JsonProperty("movieTitle")
	private String movieTitle;
	@JsonProperty("movie_name")
	private String movieName;
	@JsonProperty("language")
	private String language;
	@JsonProperty("genre")
	private List<String> genre = null;
	@JsonProperty("releaseDate")
	private Date releaseDate;
	@JsonProperty("rank")
	private Integer rank;
	@JsonProperty("paytmMovieCode")
	private String paytmMovieCode;
	@JsonProperty("isContentAvailable")
	private Integer isContentAvailable;
	@JsonProperty("contentId")
	private Integer contentId;
	@JsonProperty("MovieCode")
	private String movieCode;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("provider_moviename")
	public String getProviderMoviename() {
		return providerMoviename;
	}

	@JsonProperty("provider_moviename")
	public void setProviderMoviename(String providerMoviename) {
		this.providerMoviename = providerMoviename;
	}

	@JsonProperty("moviePosterUrl")
	public String getMoviePosterUrl() {
		return moviePosterUrl;
	}

	@JsonProperty("moviePosterUrl")
	public void setMoviePosterUrl(String moviePosterUrl) {
		this.moviePosterUrl = moviePosterUrl;
	}

	@JsonProperty("movieTitle")
	public String getMovieTitle() {
		return movieTitle;
	}

	@JsonProperty("movieTitle")
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	@JsonProperty("movie_name")
	public String getMovieName() {
		return movieName;
	}

	@JsonProperty("movie_name")
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("genre")
	public List<String> getGenre() {
		return genre;
	}

	@JsonProperty("genre")
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	@JsonProperty("releaseDate")
	public Date getReleaseDate() {
		return releaseDate;
	}

	@JsonProperty("releaseDate")
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@JsonProperty("rank")
	public Integer getRank() {
		return rank;
	}

	@JsonProperty("rank")
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@JsonProperty("paytmMovieCode")
	public String getPaytmMovieCode() {
		return paytmMovieCode;
	}

	@JsonProperty("paytmMovieCode")
	public void setPaytmMovieCode(String paytmMovieCode) {
		this.paytmMovieCode = paytmMovieCode;
	}

	@JsonProperty("isContentAvailable")
	public Integer getIsContentAvailable() {
		return isContentAvailable;
	}

	@JsonProperty("isContentAvailable")
	public void setIsContentAvailable(Integer isContentAvailable) {
		this.isContentAvailable = isContentAvailable;
	}

	@JsonProperty("contentId")
	public Integer getContentId() {
		return contentId;
	}

	@JsonProperty("contentId")
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	@JsonProperty("MovieCode")
	public String getMovieCode() {
		return movieCode;
	}

	@JsonProperty("MovieCode")
	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}