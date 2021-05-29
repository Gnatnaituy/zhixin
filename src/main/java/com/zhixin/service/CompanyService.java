package com.zhixin.service;

import com.zhixin.vo.request.RequestCompanySaveVo;
import com.zhixin.vo.response.ResponseCompanyVo;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:16
 */
public interface CompanyService {

    void save(RequestCompanySaveVo saveVo);

    void delete(Long id);

    List<ResponseCompanyVo> list();
}
