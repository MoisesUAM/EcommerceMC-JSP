package net.mcoto.app.models;

import lombok.Data;

@Data
public class PN_Model {
	
	private String pageName;
	private String contentPage;
	private String lessonName;
	
	public PN_Model(String pageName, String contentPage, String lessonName) {
		this.pageName = pageName;
		this.contentPage = contentPage;
		this.lessonName = lessonName;
	}
	

}
