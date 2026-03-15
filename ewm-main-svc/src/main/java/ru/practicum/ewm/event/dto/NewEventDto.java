package ru.practicum.ewm.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.location.dto.LocationDto;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewEventDto {

    @NotBlank
    @Size(min = 20, max = 2000, message = "Длина аннотации должна не больше 2000 символов и не меньше 20")
    String annotation;

    @NotNull(message = "Категория не может быть null")
    Long category;

    @NotBlank
    @Size(min = 20, max = 7000, message = "Длина описания должна не больше 7000 символов и не меньше 20")
    String description;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    @NotNull(message = "Дата события не может быть null")
    LocalDateTime eventDate;

    @NotNull(message = "Локация не может быть null")
    LocationDto location;

    Boolean paid = false;

    @Min(value = 0, message = "Лимит участников не может быть отрицательным")
    Integer participantLimit = 0;

    Boolean requestModeration = true;

    @Size(min = 3, max = 120, message = "Длина аннотации должна не больше 120 символов и не меньше 3")
    @NotBlank
    String title;
}