package org.multicampus.mlp.domain.entity.wishList;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<TbMark, Long> {
    List<TbMark> findAllByUserIdOrderByMarkCreateDesc(String userId);
}
