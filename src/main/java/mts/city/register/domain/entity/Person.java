package mts.city.register.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "cr_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private long personId;
    @Column(name = "sur_name")
    private String surName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "patronymic_name")
    private String patronymicName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "passport_seria")
    private String passportSeria;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "passport_date")
    private LocalDate passportDate;
    @Column(name = "certificate_number")
    private String certificateNumber;
    @Column(name = "certificate_date")
    private LocalDate certificateDate;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "person")
    private List<AdressPerson> adresses;


    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", surName='" + surName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", passportSeria='" + passportSeria + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportDate=" + passportDate +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", certificateDate=" + certificateDate +
                '}';
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportSeria() {
        return passportSeria;
    }

    public void setPassportSeria(String passportSeria) {
        this.passportSeria = passportSeria;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(LocalDate passportDate) {
        this.passportDate = passportDate;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }

    public List<AdressPerson> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<AdressPerson> adresses) {
        this.adresses = adresses;
    }
}
