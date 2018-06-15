package com.shao.weblib;


public interface PermissionInterceptor {

    boolean intercept(String url, String[] permissions, String action);

}
