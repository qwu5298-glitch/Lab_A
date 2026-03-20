package tw.brad.springdemo.dto;
public record PackageResponseDTO(
	    Long orderId,
	    String courseName,
	    Integer totalLessons,
	    Integer usedLessons,
	    Integer remainingLessons,
	    Byte status
	) {}