package org.multicampus.mlp.domain.entity.wishList;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
@Table(name = "TB_MARK")
@Entity
public class TbMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARK_ID", length = 20, nullable = false)
    private Long markId;

    @Column(name = "USER_ID", length = 256, nullable = false)
    private String userId;

    @Column(name = "HOUSE_ID", length = 256, nullable = false)
    private Long houseId;

    @Column(name = "MARK_CREATE", length = 256, nullable = false)
    private LocalDateTime markCreate;

    @Builder
    public TbMark(
            Long markId,
            String userId,
            Long houseId,
            LocalDateTime markCreate
    ){
        this.markId = markId;
        this.userId = userId;
        this.houseId = houseId;
        this.markCreate = markCreate;
    }

}
