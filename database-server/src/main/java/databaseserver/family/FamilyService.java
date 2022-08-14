package databaseserver.family;

import clients.database.FamilyRequestBody;
import org.springframework.stereotype.Service;

@Service
public record FamilyService(FamilyRepository familyRepository) {

    public Integer saveFamily(FamilyRequestBody familyRequestBody) {
        Family family = new Family(familyRequestBody.familyName(),
                familyRequestBody.adultsNumber(),
                familyRequestBody.childrenNumber(),
                familyRequestBody.infantsNumber());
        familyRepository.saveAndFlush(family);
        return family.getFamilyId();
    }
}
