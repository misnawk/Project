package com.example.shop.signupPage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class SignupPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NO")
    private int no;

    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "age")
    private java.sql.Date age; // SQL의 DATE 타입을 매핑

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    // 기본 생성자
    public SignupPage() {
    }

    // 필드를 초기화하는 생성자
    public SignupPage(String id, String username, String password, java.sql.Date age, String phoneNumber, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter 및 Setter 메서드
    public int getNo() {
        return no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public java.sql.Date getAge() {
        return age;
    }

    public void setAge(java.sql.Date age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
