/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevani.pojo;

import java.sql.Date;

/**
 *
 * @author Deepak Patidar
 */
public class PatientPojo {

    @Override
    public String toString() {
        return "PatientPojo{" + "p_id=" + p_id + ", f_name=" + f_name + ", s_name=" + s_name + ", opd=" + opd + ", gender=" + gender + ", m_status=" + m_status + ", Address=" + Address + ", city=" + city + ", phone_no=" + phone_no + ", doctor_id=" + doctor_id + ", age=" + age + ", p_date=" + p_date + '}';
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getOpd() {
        return opd;
    }

    public PatientPojo() {
    }

    public PatientPojo(String p_id, String f_name, String s_name, String opd, String gender, String m_status, String Address, String city, String phone_no, String doctor_id, int age, Date p_date) {
        this.p_id = p_id;
        this.f_name = f_name;
        this.s_name = s_name;
        this.opd = opd;
        this.gender = gender;
        this.m_status = m_status;
        this.Address = Address;
        this.city = city;
        this.phone_no = phone_no;
        this.doctor_id = doctor_id;
        this.age = age;
        this.p_date = p_date;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getM_status() {
        return m_status;
    }

    public void setM_status(String m_status) {
        this.m_status = m_status;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getP_date() {
        return p_date;
    }

    public void setP_date(Date p_date) {
        this.p_date = p_date;
    }
    private String  p_id,f_name,s_name,opd,gender,m_status,Address,city,phone_no,doctor_id;
    private int age;
    Date p_date;
    
}
