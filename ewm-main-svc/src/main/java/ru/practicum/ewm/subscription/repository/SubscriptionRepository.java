package ru.practicum.ewm.subscription.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.ewm.enums.FriendshipsStatus;
import ru.practicum.ewm.subscription.model.Subscription;
import ru.practicum.ewm.user.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findByFollowerAndOwner(User follower, User owner);

    List<Subscription> findByFollower(User follower);

    List<Subscription> findByOwner(User owner, Pageable pageable);

    long countByOwnerAndFriendshipsStatusIn(User owner, List<FriendshipsStatus> friendshipsStatuses);

    @Modifying
    @Query("""
            DELETE FROM Subscription s
            WHERE s.follower = :follower AND s.owner = :owner
            """)
    int deleteByFollowerAndOwner(User follower, User owner);

    @Modifying(clearAutomatically = true)
    @Query("""
            UPDATE Subscription s
            SET s.friendshipsStatus = :newStatus,
                s.unsubscribeTime = :time
            WHERE s.follower = :owner
              AND s.owner = :follower
              AND s.friendshipsStatus = :currentStatus
            """)
    int updateReverseSubscription(User owner,
                                  User follower,
                                  FriendshipsStatus currentStatus,
                                  FriendshipsStatus newStatus,
                                  LocalDateTime time);
}