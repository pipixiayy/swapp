package com.yh.swaggerpro.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @program: swagger-pro
 * @Date: 2021/8/13 21:56
 * @Author: YH
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AspectValidate {
    /**
     * 注解切入点
     */
    @Pointcut("@annotation(com.yh.swaggerpro.annotation.OperationAop)")
    public void operationValidate() {}

    @Around("operationValidate()")
    public Object doBeforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // System.out.println("业务方法处理" + joinPoint.getArgs());
        //Map<String, String> params = JSONObject.parseObject((String) args[0], new TypeReference<Map<String, String>>(){});
        /*if (params.get("id").equals("133204")) {
            return new DataResponse(StatusCode.Fail);
        }*/
        // 参数值
        /*Object[] args = joinPoint.getArgs();
        JdComputer jdComputer = (JdComputer)args[0];
        int id = jdComputer.getId();
        if (id == 10254) {
            return new DataResponse(StatusCode.Fail);
        }*/
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // 参数值
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];
        for (int k = 0; k < args.length; k++) {
            if (!args[k].getClass().isPrimitive()) {
                // 获取的是封装类型而不是基础类型
                String result = args[k].getClass().getName();
                Class s = map.get(result);
                classes[k] = s == null ? args[k].getClass() : s;
            }
        }
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        // 获取指定的方法，第二个参数可以不传，但是为了防止有重载的现象，还是需要传入参数的类型
        Method method = Class.forName(classType).getMethod(methodName, classes);
        // 参数名
        String[] parameterNames = pnd.getParameterNames(method);
        // 通过map封装参数和参数值
        HashMap<String, Object> paramMap = new HashMap();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return joinPoint.proceed();
    }

    private static HashMap<String, Class> map = new HashMap<String, Class>() {
        {
            put("java.lang.Integer", int.class);
            put("java.lang.Double", double.class);
            put("java.lang.Float", float.class);
            put("java.lang.Long", long.class);
            put("java.lang.Short", short.class);
            put("java.lang.Boolean", boolean.class);
            put("java.lang.Char", char.class);
        }
    };

}
