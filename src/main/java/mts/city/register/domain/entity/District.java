package mts.city.register.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "cr_district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_code")
    private int districtCode;
    @Column (name = "district_name")
    private String districtName;


    @Override
    public String toString() {
        return "District{" +
                "districtCode=" + districtCode +
                ", districtName='" + districtName + '\'' +
                '}';
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
