package org.multicampus.mlp.web.controller;

import lombok.RequiredArgsConstructor;
import org.multicampus.mlp.config.dto.SessionUser;
import org.multicampus.mlp.domain.entity.history.TbHistory;
import org.multicampus.mlp.domain.entity.wishList.TbMark;
import org.multicampus.mlp.web.service.HistoryService;
import org.multicampus.mlp.web.service.MarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
@RequiredArgsConstructor
@RestController
public class MarkController {
    private final MarkService markService;
    private final HttpSession httpSession;
    @GetMapping("api/history/findall")
    public List<TbMark> findAllByUserIdOrderByMarkCreateDesc() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        return markService.findAllByUserIdOrderByMarkCreateDesc(sessionUser.getUserName());
    }
}
