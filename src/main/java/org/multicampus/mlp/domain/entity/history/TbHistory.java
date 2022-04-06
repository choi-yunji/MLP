package org.multicampus.mlp.domain.entity.history;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.multicampus.mlp.domain.entity.user.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
@Table(name = "TB_HISTORY")
@Entity
public class TbHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_ID", length = 20, nullable = false)
    private Long historyId;

    @Column(name = "HISTORY_CREATE",  nullable = false)
    private LocalDateTime historyCreate;

    @Column(name = "HISTORY_UPDATE")
    private LocalDateTime historyUpdate;

    @Column(name = "BOOKING_ID", length = 20, nullable = false)
    private Long bookingId;

    @Column(name = "USER_ID", length = 256, nullable = false)
    private String userId;

    @Builder
    public TbHistory(
            String userId,
            Long historyId,
            Long bookingId,
            LocalDateTime historyCreate,
            LocalDateTime historyUpdate

    ){
        this.userId = userId;
        this.historyId = historyId;
        this.bookingId = bookingId;
        this.historyCreate = historyCreate;
        this.historyUpdate = historyUpdate;
    }

}
