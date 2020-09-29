
package Sanjeevani.pojo;

public class UserPojo {

    @Override
    public String toString() {
        return "UserPojo{" + "userid=" + userid + ", empId=" + empId + ", userName=" + userName + ", password=" + password + ", userType=" + userType + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    private String userid;
    private String empId;
    private String userName;
    private String password;
    private String userType;
    
}
