package com.zhixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixin.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ModuleMapper extends BaseMapper<Module> {

    @Update("update module set sort = ${sort} where id = ${id};")
    int updateSort(@Param("id") Long id, @Param("sort") Integer sort);
}
