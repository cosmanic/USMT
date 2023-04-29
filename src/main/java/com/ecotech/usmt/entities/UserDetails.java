package com.ecotech.usmt.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="userdetails")
public class UserDetails {
    @Id
    @GeneratedValue
    @NonNull
    @Column(name="userid")
    private long userid;
    @Column(name="FNAME")
    private String fname;
    @Column(name="LNAME")
    private String lname;
    @Column(name="Email")
    private String email;
    @Column(name="DOB")
    private int dob;
    @Column (name="MOBILENUMBER")
    private int mobilenumber;
    @Column (name="GENDER")
    private String  gender;
    @Column (name="APPID")
    private  int appid;
    @Column (name="IMAGEID")
    private int imageid;
    @Column (name="PASSWORD")
    private String password;
    @Column(name="USERTYPE")
    private  String usertype;
    @Column(name="SOCIALID")
    private int socialid;




}
