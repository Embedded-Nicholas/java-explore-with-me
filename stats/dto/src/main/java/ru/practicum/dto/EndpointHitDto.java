package ru.practicum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
public record EndpointHitDto(
        @NotBlank(message = "App cannot be blank")
        String app,

        @NotBlank(message = "URI cannot be blank")
        String uri,

        @NotBlank(message = "IP cannot be blank")
        String ip,

        @NotNull(message = "Timestamp cannot be null")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timestamp
) {
}
