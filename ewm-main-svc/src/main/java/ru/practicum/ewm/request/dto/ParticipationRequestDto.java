package ru.practicum.ewm.request.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.enums.RequestStatus;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationRequestDto {

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime created;

    Long event;
    Long id;
    Long requester;
    RequestStatus status;
}