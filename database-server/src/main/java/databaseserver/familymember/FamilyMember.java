package databaseserver.familymember;

import javax.persistence.*;

@Entity
@Table(name = "family_member")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer familyMemberId;

    @Column(name = "family_id")
    private Integer familyId;

    @Column(name = "age")
    private Integer age;

    @Column(name = "given_name")
    private String givenName;

    public FamilyMember() {
    }

    public FamilyMember(Integer familyId, Integer age, String givenName) {
        this.familyId = familyId;
        this.age = age;
        this.givenName = givenName;
    }

    public Integer getFamilyMemberId() {
        return familyMemberId;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public String getGivenName() {
        return givenName;
    }
}