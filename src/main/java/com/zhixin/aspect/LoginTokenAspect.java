package com.zhixin.aspect;

import com.zhixin.consts.Const;
import com.zhixin.service.SysUserService;
import com.zhixin.vo.common.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yutiantang
 * @create 2021/6/15 15:18
 */
@Slf4j
@Aspect
@Component
public class LoginTokenAspect {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.zhixin.annotation.LoginRequired)")
    private void loginCheck() {
    }

    @Around("loginCheck()")
    public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        String token = request.getHeader(Const.HEADER_TOKEN);
        if (ObjectUtils.isEmpty(token)) {
            return ResponseEntity.error("请先登录!");
        }
        ResponseEntity checkRes = sysUserService.checkToken(token);
        if (!checkRes.getSuccess()) {
            return checkRes;
        }

        return joinPoint.proceed();
    }
}
