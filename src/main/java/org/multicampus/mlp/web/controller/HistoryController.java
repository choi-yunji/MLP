package org.multicampus.mlp.web.controller;

import lombok.RequiredArgsConstructor;

import org.multicampus.mlp.config.dto.SessionUser;
import org.multicampus.mlp.domain.entity.history.TbHistory;
import org.multicampus.mlp.web.service.HistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class HistoryController {
    private final HistoryService historyService;
    private final HttpSession httpSession;

    @GetMapping("api/history/findall")
    public List<TbHistory> findAllByUserIdOrderByHistoryCreateDesc() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        return historyService.findAllByUserIdOrderByHistoryCreateDesc(sessionUser.getUserName());
    }



}
