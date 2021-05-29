package com.zhixin.mapper;

import com.zhixin.entity.ModuleType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ModuleTypeMapper {

    int save(@RequestParam("moduleType") ModuleType moduleType);

    int update(@RequestParam("moduleType") ModuleType moduleType);

    int delete(@RequestParam("id") Long id);
}
