package pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "upcomingMovieData", "keys", "languageScored" })
public class Upcoming {

	@JsonProperty("upcomingMovieData")
	private List<UpcomingMovieDatum> upcomingMovieData = null;
	@JsonProperty("keys")
	private List<String> keys = null;
	@JsonProperty("languageScored")
	private List<String> languageScored = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("upcomingMovieData")
	public List<UpcomingMovieDatum> getUpcomingMovieData() {
		return upcomingMovieData;
	}

	@JsonProperty("upcomingMovieData")
	public void setUpcomingMovieData(List<UpcomingMovieDatum> upcomingMovieData) {
		this.upcomingMovieData = upcomingMovieData;
	}

	@JsonProperty("keys")
	public List<String> getKeys() {
		return keys;
	}

	@JsonProperty("keys")
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	@JsonProperty("languageScored")
	public List<String> getLanguageScored() {
		return languageScored;
	}

	@JsonProperty("languageScored")
	public void setLanguageScored(List<String> languageScored) {
		this.languageScored = languageScored;
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