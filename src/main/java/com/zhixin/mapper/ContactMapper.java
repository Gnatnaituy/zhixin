package com.zhixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhixin.entity.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ContactMapper extends BaseMapper<Contact> {
}
