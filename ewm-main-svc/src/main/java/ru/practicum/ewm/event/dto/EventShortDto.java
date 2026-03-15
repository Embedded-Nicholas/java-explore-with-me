package ru.practicum.ewm.event.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.category.dto.CategoryDto;
import ru.practicum.ewm.user.dto.UserShortDto;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventShortDto {
    Long id;
    String annotation;
    CategoryDto category;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime eventDate;

    UserShortDto initiator;
    Boolean paid;
    String title;

    @Builder.Default
    long views = 0L;

    @Builder.Default
    long confirmedRequests = 0L;
}