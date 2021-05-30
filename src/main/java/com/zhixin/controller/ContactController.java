package com.zhixin.controller;

import com.zhixin.service.ContactService;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestContactSaveVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:18
 */
@RestController
@RequestMapping(value = "/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody List<RequestContactSaveVo> saveVos) {
        return contactService.save(saveVos);
    }

    @GetMapping(value = "/list/{companyId}")
    public ResponseEntity list(@PathVariable("companyId") Long companyId) {
        return contactService.listByCompanyId(companyId);
    }
}
