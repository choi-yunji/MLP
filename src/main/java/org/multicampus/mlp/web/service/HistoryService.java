package org.multicampus.mlp.web.service;

import lombok.RequiredArgsConstructor;
import org.multicampus.mlp.config.dto.SessionUser;
import org.multicampus.mlp.domain.entity.history.HistoryRepository;
import org.multicampus.mlp.domain.entity.history.TbHistory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryRepository historyRepository;

    public List<TbHistory> findAllByUserIdOrderByHistoryCreateDesc(String userId) {
            return historyRepository.findAllByUserIdOrderByHistoryCreateDesc(userId);
    }
}
