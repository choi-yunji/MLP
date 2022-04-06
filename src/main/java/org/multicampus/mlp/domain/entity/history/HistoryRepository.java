package org.multicampus.mlp.domain.entity.history;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<TbHistory, Long> {
    List<TbHistory> findAllByUserIdOrderByHistoryCreateDesc(String userId);

}
