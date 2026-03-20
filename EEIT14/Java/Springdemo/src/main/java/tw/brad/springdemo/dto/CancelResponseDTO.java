package tw.brad.springdemo.dto;

public record CancelResponseDTO(boolean success, String message, Integer remainingLessons) {}
