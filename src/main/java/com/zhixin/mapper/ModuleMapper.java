package com.zhixin.mapper;

import com.zhixin.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ModuleMapper {

    int save(@RequestParam("module") Module module);

    int update(@RequestParam("module") Module module);

    int delete(@RequestParam("id") Long id);
}
