package com.zhixin.service.impl;

import com.zhixin.mapper.CompanyMapper;
import com.zhixin.service.CompanyService;
import com.zhixin.vo.request.RequestCompanySaveVo;
import com.zhixin.vo.response.ResponseCompanyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/5/28 22:17
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void save(RequestCompanySaveVo saveVo) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ResponseCompanyVo> list() {
        return null;
    }
}
