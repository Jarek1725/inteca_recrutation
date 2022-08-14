package databaseserver.family;

import javax.persistence.*;

@Entity
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer familyId;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "adults_number")
    private Integer adultsNumber;

    @Column(name = "children_number")
    private Integer childrenNumber;

    @Column(name = "infants_number")
    private Integer infantsNumber;

    public Family() {
    }

    public Family(String familyName, Integer adultsNumber, Integer childrenNumber, Integer infantsNumber) {
        this.familyName = familyName;
        this.adultsNumber = adultsNumber;
        this.childrenNumber = childrenNumber;
        this.infantsNumber = infantsNumber;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Integer getAdultsNumber() {
        return adultsNumber;
    }

    public Integer getChildrenNumber() {
        return childrenNumber;
    }

    public Integer getInfantsNumber() {
        return infantsNumber;
    }
}