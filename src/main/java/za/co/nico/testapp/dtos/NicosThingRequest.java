package za.co.nico.testapp.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NicosThingRequest {


	private Long nicosThingId;
	private Timestamp dateCreated;
	private String name; 
	private String description; 
	private String emailAddress;
	private String cellPhone;
	public Long getNicosThingId() {
		return nicosThingId;
	}
	public void setNicosThingId(Long nicosThingId) {
		this.nicosThingId = nicosThingId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	@Override
	public String toString() {
		return "NicosThingRequest [nicosThingId=" + nicosThingId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", description=" + description + ", emailAddress=" + emailAddress + ", cellPhone=" + cellPhone + "]";
	}
	
	

}
