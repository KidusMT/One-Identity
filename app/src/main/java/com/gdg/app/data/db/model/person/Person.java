
package com.gdg.app.data.db.model.person;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user")
public class Person {

    @Id()
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("mname")
    @Expose
    private String mname;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("citizenship")
    @Expose
    private String citizenship;
    @SerializedName("residence")
    @Expose
    private String residence;
    @SerializedName("hometown")
    @Expose
    private String hometown;
    @SerializedName("marital_status")
    @Expose
    private String maritalStatus;
    @SerializedName("photo_url")
    @Expose
    private String photoUrl;
    @SerializedName("finger_print")
    @Expose
    private String fingerPrint;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("sub_city")
    @Expose
    private String subCity;
    @SerializedName("woreda")
    @Expose
    private String woreda;
    @SerializedName("house_no")
    @Expose
    private String houseNo;
    @SerializedName("Created_date")
    @Expose
    private String createdDate;
    @SerializedName("__v")
    @Expose
    private Integer v;

    @Generated(hash = 110228493)
    public Person(String id, String fname, String mname, String lname, String dob,
            String gender, String citizenship, String residence, String hometown,
            String maritalStatus, String photoUrl, String fingerPrint,
            String phoneNumber, String region, String city, String subCity,
            String woreda, String houseNo, String createdDate, Integer v) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.dob = dob;
        this.gender = gender;
        this.citizenship = citizenship;
        this.residence = residence;
        this.hometown = hometown;
        this.maritalStatus = maritalStatus;
        this.photoUrl = photoUrl;
        this.fingerPrint = fingerPrint;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.city = city;
        this.subCity = subCity;
        this.woreda = woreda;
        this.houseNo = houseNo;
        this.createdDate = createdDate;
        this.v = v;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubCity() {
        return subCity;
    }

    public void setSubCity(String subCity) {
        this.subCity = subCity;
    }

    public String getWoreda() {
        return woreda;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
