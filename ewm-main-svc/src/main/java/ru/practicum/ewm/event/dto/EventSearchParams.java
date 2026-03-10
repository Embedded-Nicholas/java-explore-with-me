package ru.practicum.ewm.event.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import ru.practicum.ewm.enums.EventState;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventSearchParams {
    String text;
    List<Long> categories;
    Boolean paid;

    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime rangeStart;

    @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime rangeEnd;

    Boolean onlyAvailable;
    String sort;

    @PositiveOrZero
    int from = 0;

    @Positive
    int size = 10;

    List<Long> users;
    List<EventState> states;
}