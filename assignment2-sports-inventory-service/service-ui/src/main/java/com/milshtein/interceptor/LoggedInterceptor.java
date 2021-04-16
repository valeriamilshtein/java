package com.milshtein.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@Logged
public class LoggedInterceptor implements Serializable { //Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage

    @AroundInvoke
    public Object logEntryToTheMethod(InvocationContext ctx) throws Exception {
        System.out.println("Method " + ctx.getMethod() + " was called");
        return ctx.proceed();
    }
}
