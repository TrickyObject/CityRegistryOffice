package mts.city.register.domain.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "cr_adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "adress_id")
    private long adressId;
    @Column (name = "district_code")
    private int districtCode;
    @Column (name = "street_code")
    private int streetCode;
    @Column (name = "building")
    private String building;
    @Column (name = "extension")
    private String extension;
    @Column (name = "apartment")
    private String apartment;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "adress")
    private List<AdressPerson> adresses;


    @Override
    public String toString() {
        return "Adress{" +
                "adressId=" + adressId +
                ", districtCode=" + districtCode +
                ", street_code=" + streetCode +
                ", building='" + building + '\'' +
                ", extension='" + extension + '\'' +
                ", apartment='" + apartment +
                '}';
    }

    public long getAdressId() {
        return adressId;
    }

    public void setAdressId(long adressId) {
        this.adressId = adressId;
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public int getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(int streetCode) {
        this.streetCode = streetCode;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public List<AdressPerson> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<AdressPerson> adresses) {
        this.adresses = adresses;
    }
}
