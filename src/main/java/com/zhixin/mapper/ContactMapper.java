package com.zhixin.mapper;

import com.zhixin.entity.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yutiantang
 * @create 2021/5/28 22:20
 */
@Mapper
@Component
public interface ContactMapper {

    int save(@RequestParam("contact") Contact contact);

    int update(@RequestParam("contact") Contact contact);

    int delete(@RequestParam("id") Long id);
}
