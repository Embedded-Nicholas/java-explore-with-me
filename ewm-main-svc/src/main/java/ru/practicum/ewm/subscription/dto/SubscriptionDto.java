package ru.practicum.ewm.subscription.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.enums.FriendshipsStatus;
import ru.practicum.ewm.user.dto.UserDto;
import ru.practicum.ewm.util.Constants;

import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDto {

    Long id;
    Long followerId;
    UserDto owner;

    @NotNull
    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime subscribeTime;

    @JsonFormat(pattern = Constants.DATE_TIME_FORMAT)
    LocalDateTime unsubscribeTime;

    FriendshipsStatus friendshipsStatus;
}
