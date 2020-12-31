package com.tpblog.main.service.oam;

import com.tpblog.oam.api.entity.BlackList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "blog-oam-service",path = "blacklist")
public interface BlackListMainService {
    @GetMapping("find")
    List<BlackList> findBlackListAll();
}
