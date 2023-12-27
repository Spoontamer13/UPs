package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Car")
public class Car implements Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private UserModel userModel;
    @ManyToOne
    @JoinColumn(name = "Brand_Model_Engine_ID")
    private BrandModelEngine brandModelEngine;
    @ManyToOne
    @JoinColumn(name = "Type_Box_ID")
    private TypeBox typeBox;
    @ManyToOne
    @JoinColumn(name = "Type_Drive_ID")
    private TypeDrive typeDrive;
    @NotBlank
    @Size(min = 1, max = 4)
    private String ReleaseYear;
    @Positive
    private int Mileage;
    private boolean Condition;
    @Positive
    private int Owners;
    private boolean Customs;
    @NotBlank
    @Size(min = 1, max = 11)
    private String NumberTelephone;

    public Car () {}
    public Car (int Id, UserModel userModel, BrandModelEngine brandModelEngine, TypeBox typeBox, TypeDrive typeDrive, String ReleaseYear, int Mileage, boolean Condition,
                int Owners, boolean Customs, String NumberTelephone){
        this.Id = Id;
        this.userModel = userModel;
        this.brandModelEngine = brandModelEngine;
        this.typeBox = typeBox;
        this.typeDrive = typeDrive;
        this.ReleaseYear = ReleaseYear;
        this.Mileage = Mileage;
        this.Condition = Condition;
        this.Owners = Owners;
        this.Customs = Customs;
        this.NumberTelephone = NumberTelephone;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public UserModel getUser() {
        return userModel;
    }

    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }

    public BrandModelEngine getBrandModelEngine() {
        return brandModelEngine;
    }

    public void setBrandModelEngine(BrandModelEngine brandModelEngine) {
        this.brandModelEngine = brandModelEngine;
    }

    public TypeBox getTypeBox() {
        return typeBox;
    }

    public void setTypeBox(TypeBox typeBox) {
        this.typeBox = typeBox;
    }

    public TypeDrive getTypeDrive() {
        return typeDrive;
    }

    public void setTypeDrive(TypeDrive typeDrive) {
        this.typeDrive = typeDrive;
    }

    public String getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        ReleaseYear = releaseYear;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    public boolean isCondition() {
        return Condition;
    }

    public void setCondition(boolean condition) {
        Condition = condition;
    }

    public int getOwners() {
        return Owners;
    }

    public void setOwners(int owners) {
        Owners = owners;
    }

    public boolean isCustoms() {
        return Customs;
    }

    public void setCustoms(boolean customs) {
        Customs = customs;
    }

    public String getNumberTelephone() {
        return NumberTelephone;
    }

    public void setNumberTelephone(String numberTelephone) {
        NumberTelephone = numberTelephone;
    }
}
