package mts.city.register.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "cr_street")
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "street_code")
    private int streetCode;
    @Column (name = "street_name")
    private  String streetName;


    @Override
    public String toString() {
        return "Street{" +
                "streetCode=" + streetCode +
                ", streetName='" + streetName + '\'' +
                '}';
    }

    public int getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(int streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
