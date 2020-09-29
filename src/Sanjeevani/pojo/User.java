/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.pojo;

/**
 *
 * @author Deepak Patidar
 */
public class User {

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", password=" + password + ", usertype=" + usertype + '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userid) {
        this.userId = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    private String userId;
    private String password;
    private String usertype;
}
