package SocialMediaRestAPI.Leon.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class errorDetails {
	private LocalDateTime timeStemp;
	private String message;
	private String details;
	
	public errorDetails(LocalDateTime timeStemp, String message, String details) {
		super();
		this.timeStemp = timeStemp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimeStemp() {
		return timeStemp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
	
}
