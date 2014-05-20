package com.hp.it.spring_security_test.beans;

/**
 * Created with IntelliJ IDEA.
 * User: Bruce jia (chen-wei.jia@hp.com)
 * Date: 14-5-6
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
public class DbUser {
    private String username;
    private String password;
    private Integer access;

    @Override
    public String toString() {
        return "DbUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", access=" + access +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }
}
