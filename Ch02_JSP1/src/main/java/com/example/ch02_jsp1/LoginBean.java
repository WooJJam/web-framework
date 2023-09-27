package com.example.ch02_jsp1;

public class LoginBean {
    private String login;
    private String passwd;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswd() {
        return passwd;
    }

    public boolean checkUser() {
        if(login.equals("홍길동") && passwd.equals("1234"))
            return true;
        else
            return false;
    }
}
