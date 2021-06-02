package com.zhixin.controller;

import com.zhixin.service.ContactService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestContactSaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:18
 */
@Api
@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ApiOperation(value = "xxx")
    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestContactSaveVo> saveVos) {
        return contactService.save(saveVos);
    }

    @ApiOperation(value = "xxx")
    @GetMapping(value = "/list/{companyId}")
    public ResponseEntity list(@PathVariable("companyId") Long companyId) {
        return contactService.listByCompanyId(companyId);
    }
}
