package com.zhixin.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author yutiantang
 * @create 2021/5/30 21:17
 */
@Data
public class ResponseBaseVo {

    private Long id;

    @JsonIgnore
    private LocalDateTime createTime;

    @JsonIgnore
    private LocalDateTime updateTime;

    private Long createTimestamp;

    private Long updateTimestamp;

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        this.createTimestamp = createTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        this.updateTimestamp = updateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }
}
