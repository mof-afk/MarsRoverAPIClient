package clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelMars.MarsCuriosity;
import modelMars.Photo;

/**
 * GET https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/
 * 
 * @author user
 *
 */
public class RestClientMarsCuriosity {

	Logger log = LogManager.getLogger(RestClientMarsCuriosity.class);
	
	private final static String API_KEY = "NjogGOMJ8j7LoNk5ptOdRxUQTHtrlUMHForogbKC";
	private Client client = ClientBuilder.newClient();
	private WebTarget target = client.target("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/");

	public MarsCuriosity createMarsCuriosity(Integer sol) {

		Response response = target.path("photos").queryParam("sol", sol).queryParam("api_key", API_KEY)
				.request(MediaType.APPLICATION_JSON).get();

		String jsonString = response.readEntity(String.class);

		Gson gson = new GsonBuilder().create();
		MarsCuriosity marsCuriosity = gson.fromJson(jsonString, MarsCuriosity.class);

		return marsCuriosity;
	}

	public Photo createMarsImage(Integer sol, Integer photoIndex) {
		Photo createdPhoto = null;
		try {
			createdPhoto = createMarsCuriosity(sol).getPhotos().get(photoIndex);
		} catch (IndexOutOfBoundsException e) {
			log.error("the photoIndex: " + photoIndex + " is out of bounds -- " + e.getMessage());
		}
		return createdPhoto;
	}

}
