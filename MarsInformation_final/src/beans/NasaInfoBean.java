package beans;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import clients.RestClientMarsCuriosity;
import modelMars.Photo;

@ManagedBean
@ViewScoped
public class NasaInfoBean {

	private RestClientMarsCuriosity marsClient = new RestClientMarsCuriosity();
	private Photo marsPhoto = new Photo();
	private Integer photoIndexInput = 0;
	private Integer solInput = 1000;
	private Integer photosAmountForSol = 0;
	private List<Photo> photoInfoList = new ArrayList<Photo>();
	
	
	@PostConstruct
	public void init() {
		System.out.println("init..");
		showSelectedPhoto();
	}
	
	public Integer getPhotoIndexInput() {
		return photoIndexInput;
	}
	public void setPhotoIndexInput(Integer photoIndexInput) {
		this.photoIndexInput = photoIndexInput;
	}
	public Photo getMarsPhoto() {
		return marsPhoto;
	}
	public void setMarsPhoto(Photo marsPhoto) {
		this.marsPhoto = marsPhoto;
	}

	public List<Photo> getPhotoInfoList() {
		return photoInfoList;
	}

	public void setPhotoInfoList(List<Photo> photoInfoList) {
		this.photoInfoList = photoInfoList;
	}

	public Integer getSolInput() {
		return solInput;
	}

	public void setSolInput(Integer solInput) {
		this.solInput = solInput;
	}
	
	public Integer getPhotosAmountForSol() {
		return photosAmountForSol;
	}

	public void setPhotosAmountForSol(Integer photosAmountForSol) {
		this.photosAmountForSol = photosAmountForSol;
	}

	public void showSelectedPhoto() {
		marsPhoto = marsClient.createMarsImage(solInput, photoIndexInput);
		photoInfoList.add(marsPhoto);
	}
	
	public void showPhotosForSol() {
		photosAmountForSol = marsClient.createMarsCuriosity(solInput).getPhotos().size();	
	}

	
}
