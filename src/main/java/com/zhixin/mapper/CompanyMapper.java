package com.zhixin.mapper;

import com.zhixin.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface CompanyMapper {

    int save(@RequestParam("company") Company company);

    int update(@RequestParam("company") Company company);

    int delete(@RequestParam("id") Long id);
}
