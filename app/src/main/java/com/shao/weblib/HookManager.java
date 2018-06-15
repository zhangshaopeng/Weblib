package com.shao.weblib;



public class HookManager {



    public static WebUtils hookAgentWeb(WebUtils agentWeb, WebUtils.AgentBuilder agentBuilder) {
        return agentWeb;
    }

    public static boolean permissionHook(String url,String[]permissions){
        return true;
    }




}
