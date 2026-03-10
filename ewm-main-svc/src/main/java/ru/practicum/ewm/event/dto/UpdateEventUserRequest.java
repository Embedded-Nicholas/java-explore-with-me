package ru.practicum.ewm.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.enums.UserStateAction;
import ru.practicum.ewm.location.dto.LocationDto;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEventUserRequest {

    @Size(min = 20, max = 2000, message = "Длина аннотации должна не больше 2000 символов и не меньше 20")
    String annotation;

    Long category;

    @Size(min = 20, max = 7000, message = "Длина описания должна не больше 7000 символов и не меньше 20")
    String description;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime eventDate;

    LocationDto location;
    Boolean paid;

    @Min(value = 0, message = "Лимит участников не может быть отрицательным")
    Integer participantLimit;

    Boolean requestModeration;
    UserStateAction stateAction;

    @Size(min = 3, max = 120, message = "Длина аннотации должна не больше 120 символов и не меньше 3")
    String title;
}