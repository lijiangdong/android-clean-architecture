package com.ljd.architecture.clean.domain;

/**
 * Created by ljd on 5/6/16.
 */
public class Contributor {

    private String login;

    private  Integer contributions;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getContributions() {
        return contributions;
    }

    public void setContributions(Integer contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "login='" + login + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
