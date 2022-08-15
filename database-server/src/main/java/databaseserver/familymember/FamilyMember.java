package databaseserver.familymember;

import databaseserver.family.Family;

import javax.persistence.*;

@Entity
@Table(name = "family_member")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer familyMemberId;

    @Column(name = "age")
    private Integer age;

    @Column(name = "given_name")
    private String givenName;

    @ManyToOne
    @JoinColumn(name = "family")
    private Family family;

    public FamilyMember() {
    }

    public FamilyMember(Integer age, String givenName, Family family) {
        this.age = age;
        this.givenName = givenName;
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    public Integer getFamilyMemberId() {
        return familyMemberId;
    }

    public String getGivenName() {
        return givenName;
    }
}