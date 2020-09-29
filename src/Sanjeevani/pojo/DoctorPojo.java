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
public class DoctorPojo {

    @Override
    public String toString() {
        return "DoctorPojo{" + "userid=" + userid + ", doc_id=" + doc_id + ", qualification=" + qualification + ", specialist=" + specialist + ", active=" + active + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }
    String userid;
    String doc_id;
    String qualification;
    String specialist;
    char active;
}
