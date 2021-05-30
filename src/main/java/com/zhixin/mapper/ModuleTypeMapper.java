package com.zhixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixin.entity.ModuleType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ModuleTypeMapper extends BaseMapper<ModuleType> {
}
