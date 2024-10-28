package org.program.Hibernate_ORM.model;

import jakarta.persistence.*;

@Entity
@Table
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;
    private String cohortName;

    public Cohort() {
    }

    public Cohort(int cohortId, String cohortName) {
        this.cohortId = cohortId;
        this.cohortName = cohortName;
    }

    public int getCohortId() {
        return cohortId;
    }

    public void setCohortId(int cohortId) {
        this.cohortId = cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }
}
