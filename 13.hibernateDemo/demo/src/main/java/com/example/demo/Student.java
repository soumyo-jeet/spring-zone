package com.example.demo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    private long id;

    @Column(
            unique = true,
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            nullable = false
    )
    private String pass;

    @Column(
            precision = 5,
            scale = 2
    )
    private BigDecimal percentage;

    private LocalDate DOB;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Transient // col for this field will not be made
    private String displayName;

    @Convert(converter = BoolToStrConverter.class)
    private Boolean isMonitor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNo",
                    column = @Column(name = "current_house_no")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "current_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "current_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "current_state")
            ),
            @AttributeOverride(
                    name = "pincode",
                    column = @Column(name = "current_pincode")
            )
    })
    private Address currAddress;

    @ElementCollection
    @CollectionTable(
            name = "skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

    @ElementCollection
    @CollectionTable(
            name = "addresses",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Address> addresses;


    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
