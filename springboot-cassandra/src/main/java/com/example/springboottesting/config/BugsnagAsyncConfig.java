package com.example.springboottesting.config;

import com.bugsnag.Bugsnag;
import com.bugsnag.BugsnagAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@Configuration
public class BugsnagAsyncConfig extends AsyncConfigurerSupport {
    @Autowired
    private Bugsnag bugsnag;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new BugsnagAsyncExceptionHandler(bugsnag);
    }
}
