package org.multicampus.mlp.web.service;

import lombok.RequiredArgsConstructor;
import org.multicampus.mlp.domain.entity.history.HistoryRepository;
import org.multicampus.mlp.domain.entity.history.TbHistory;
import org.multicampus.mlp.domain.entity.wishList.MarkRepository;
import org.multicampus.mlp.domain.entity.wishList.TbMark;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarkService {
    private final MarkRepository markRepository;

    public List<TbMark> findAllByUserIdOrderByMarkCreateDesc(String userId) {
        return markRepository.findAllByUserIdOrderByMarkCreateDesc(userId);
    }
}
