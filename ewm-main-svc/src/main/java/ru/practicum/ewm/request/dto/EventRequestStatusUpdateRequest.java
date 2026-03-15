package ru.practicum.ewm.request.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.enums.RequestStatus;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestStatusUpdateRequest {

    @NotEmpty(message = "Have not requests to update")
    List<Long> requestIds;

    @NotNull(message = "Have not new status for requests to update")
    RequestStatus status;
}