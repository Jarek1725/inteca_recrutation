package databaseserver.family;

import clients.database.FamilyMemberRequestBody;
import clients.database.FamilyRequestBody;
import databaseserver.familymember.FamilyMember;
import databaseserver.familymember.FamilyMemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record FamilyService(FamilyRepository familyRepository, FamilyMemberRepository familyMemberRepository) {

    public Integer saveFamily(FamilyRequestBody familyRequestBody) {
        Family family = new Family(familyRequestBody.familyName(),
                familyRequestBody.adultsNumber(),
                familyRequestBody.childrenNumber(),
                familyRequestBody.infantsNumber());
        familyRepository.saveAndFlush(family);
        return family.getFamilyId();
    }

    public void saveMembers(List<FamilyMemberRequestBody> familyMembersRequest, Integer familyId) {
        List<FamilyMember> familyMembers = new ArrayList<>();
        familyMembersRequest.forEach(familyMember->{
            familyMembers.add(new FamilyMember(familyId, familyMember.age(), familyMember.givenName()));
        });

        familyMemberRepository.saveAll(familyMembers);
    }
}
