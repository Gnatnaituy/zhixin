package com.zhixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixin.entity.ContactItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author yutiantang
 * @create 2021/6/2 00:19
 */
@Mapper
@Component
public interface ContactItemMapper extends BaseMapper<ContactItem> {
}
