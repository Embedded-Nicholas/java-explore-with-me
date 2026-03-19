package ru.practicum.ewm.subscription.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.enums.FriendshipsStatus;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriberData {

    Long userId;
    String ownerName;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime subscribeTime;

    FriendshipsStatus friendshipsStatus;
}