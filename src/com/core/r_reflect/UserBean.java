package com.core.r_reflect;

public class UserBean {

    private String username = "默认用户名";
    protected String password = "默认密码";
    public String email = "默认电子邮箱";


    public UserBean() {
    }

    public UserBean(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void doSomething() {
        System.out.println("做一些事情 嘿嘿 执行了方法 真开心");
    }

    public void getUsername() {
        System.out.println("username = " + username);
    }

    public void getPassword() {
        System.out.println("password = " + password);
    }
}
