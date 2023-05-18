package com.dietcalculator.dto;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class User {
    private String userID;
    private String username;
    private Date dob;
    private String phone;
    private String address;
    private String email;
    private String password;
    private double weight;
    private double height;
    private int gender;
    private int activity;
    private int preference;
    private int goal;
    private double amount;
    private int duration;
    private int main;
    private int side;
    private int session;
    private int rank;
    private Date createdate;

    public User() {
    }

    public User(String userID, String username, Date dob, String phone, String address, String email, String password, double weight, double height, int gender, int activity, int preference, int goal, double amount, int duration, int main, int side, int session, int rank, Date createdate) {
        this.userID = userID;
        this.username = username;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.activity = activity;
        this.preference = preference;
        this.goal = goal;
        this.amount = amount;
        this.duration = duration;
        this.main = main;
        this.side = side;
        this.session = session;
        this.rank = rank;
        this.createdate = createdate;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMain() {
        return main;
    }

    public void setMain(int main) {
        this.main = main;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", dob=" + dob + ", phone=" + phone + ", address=" + address + ", email=" + email + ", password=" + password + ", weight=" + weight + ", height=" + height + ", gender=" + gender + ", activity=" + activity + ", preference=" + preference + ", goal=" + goal + ", amount=" + amount + ", duration=" + duration + ", main=" + main + ", side=" + side + ", session=" + session + ", rank=" + rank + ", createdate=" + createdate + '}';
    }
    
}
