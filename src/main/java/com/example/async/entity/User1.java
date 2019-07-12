package com.example.async.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 彬
 * @Date 2019/7/11
 */
@Entity
@Data
@ToString
public class User1 implements Serializable {
    //自增类型 如果是默认 他会自动把主键保存在 hibernate_sequence 此表 ，这个表是jpa根据这里默认自增类型创建的，这里修改以后不会在创建
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String password;
    @Column(name = "user_name")
    private String userName;

    private String address;

    private String job;

    private Long groupId;

    private Date birthDate;

    private String city;

    private String district;

    private String province;

    private String streetAddress;

    private String state;

    private String type;

    private Date lastLoginDate;
}
