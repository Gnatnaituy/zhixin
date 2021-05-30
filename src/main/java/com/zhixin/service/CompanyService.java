package com.zhixin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhixin.entity.Company;
import com.zhixin.vo.common.ResponseEntity;
import com.zhixin.vo.request.RequestCompanySaveVo;
import com.zhixin.vo.response.ResponseCompanyVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:16
 */
public interface CompanyService extends IService<Company> {

    ResponseEntity save(List<RequestCompanySaveVo> saveVos);

    ResponseEntity listAll();
}
