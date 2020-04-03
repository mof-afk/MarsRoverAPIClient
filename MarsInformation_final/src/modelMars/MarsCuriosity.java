package modelMars;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MarsCuriosity {

	@SerializedName("photos")
	@Expose
	private List<Photo> photos = null;
	
	@SerializedName("rover")
	@Expose
	private List<Rover> rovers = null;

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Rover> getRovers() {
		return rovers;
	}

	public void setRovers(List<Rover> rovers) {
		this.rovers = rovers;
	}

	@Override
	public String toString() {
		return "MarsCuriosity [photos=" + photos + ", rovers=" + rovers + "]";
	}

	
}