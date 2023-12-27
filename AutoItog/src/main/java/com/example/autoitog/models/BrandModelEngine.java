package com.example.autoitog.models;

import com.example.autoitog.service.Identifiable;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
public class BrandModelEngine implements Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Positive
    private float VolumeEngine;

    @Positive
    private int CountHorsepower;

    @ManyToOne
    @JoinColumn(name = "Model_Brand_ID")
    private ModelBrand modelBrand;

    @ManyToOne
    @JoinColumn(name = "Type_Fuel_ID")
    private TypeFuel typeFuel;

    public BrandModelEngine () {}
    public BrandModelEngine (int Id, float VolumeEngine, int CountHorsepower, ModelBrand modelBrand, TypeFuel typeFuel){
        this.Id = Id;
        this.VolumeEngine = VolumeEngine;
        this.CountHorsepower = CountHorsepower;
        this.modelBrand = modelBrand;
        this.typeFuel = typeFuel;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public float getVolumeEngine() {
        return VolumeEngine;
    }

    public void setVolumeEngine(float volumeEngine) {
        VolumeEngine = volumeEngine;
    }

    public int getCountHorsepower() {
        return CountHorsepower;
    }

    public void setCountHorsepower(int countHorsepower) {
        CountHorsepower = countHorsepower;
    }

    public ModelBrand getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(ModelBrand modelBrand) {
        this.modelBrand = modelBrand;
    }

    public TypeFuel getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(TypeFuel typeFuel) {
        this.typeFuel = typeFuel;
    }
}
