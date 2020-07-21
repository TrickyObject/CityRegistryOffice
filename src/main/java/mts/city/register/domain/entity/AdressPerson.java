package mts.city.register.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "cr_adress_person")
public class AdressPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_adress_id")
    private long personAdressId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id")
    private Adress adress;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @Column (name = "start_date")
    private LocalDate startDate;
    @Column (name = "end_date")
    private LocalDate endDate;
    @Column (name = "temporal")
    private boolean temporal;


    @Override
    public String toString() {
        return "AdressPerson{" +
                "personAdressId=" + personAdressId +
                ", adress=" + adress +
                ", person=" + person +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", temporal=" + temporal +
                '}';
    }

    public long getPersonAdressId() {
        return personAdressId;
    }

    public void setPersonAdressId(long personAdressId) {
        this.personAdressId = personAdressId;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }
}
