package com.zhixin.controller;

import com.zhixin.annotation.LoginRequired;
import com.zhixin.service.BannerService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestBannerSaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 23:15
 */
@Api
@RestController
@RequestMapping(value = "/banner")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @LoginRequired
    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestBannerSaveVo> saveVos) {
        return bannerService.save(saveVos);
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return bannerService.listAll();
    }
}
