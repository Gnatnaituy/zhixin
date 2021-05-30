package com.zhixin.controller;

import com.zhixin.service.CompanyService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestCompanySaveVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:18
 */
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestCompanySaveVo> saveVos) {
        return companyService.save(saveVos);
    }

    @GetMapping(value = "/list")
    public ResponseEntity list() {
        return companyService.listAll();
    }
}
