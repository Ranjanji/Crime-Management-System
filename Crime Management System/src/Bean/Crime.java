package Bean;

import java.sql.Date;

public class Crime {

	private int areaId;
	private String description;
	private int policeStationId;
	private String detailDescription;
	private String status;
	private Date date;
	
	public Crime(){
		
	}

	public Crime(int areaId, String description, int policeStationId, String detailDescription, String status,
			Date date) {
		super();
		this.areaId = areaId;
		this.description = description;
		this.policeStationId = policeStationId;
		this.detailDescription = detailDescription;
		this.status = status;
		this.date = date;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoliceStationId() {
		return policeStationId;
	}

	public void setPoliceStationId(int policeStationId) {
		this.policeStationId = policeStationId;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Crime [areaId=" + areaId + ", description=" + description + ", policeStationId=" + policeStationId
				+ ", detailDescription=" + detailDescription + ", status=" + status + ", date=" + date + "]";
	}
	
}
