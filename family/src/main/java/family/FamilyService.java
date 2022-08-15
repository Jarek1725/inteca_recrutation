package family;

import clients.FamilyMemberClient;
import clients.database.FamilyDatabaseClient;
import clients.database.FamilyMemberRequestBody;
import clients.database.FamilyRequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public record FamilyService(RestTemplate restTemplate, FamilyMemberClient familyMemberClient,
                            FamilyDatabaseClient databaseClient) {

    public boolean createFamily(FamilyRequestBody familyRequest) {

//        CHECK IF NUMBER OF PEOPLE IS CORRECT
        if (familyRequest.adultsNumber() + familyRequest.childrenNumber() + familyRequest.infantsNumber() ==
                familyRequest.familyMembers().size()) {

            if (validateFamilyData(familyRequest.familyMembers(), familyRequest.infantsNumber(),
                    familyRequest.childrenNumber(), familyRequest.adultsNumber())) {
                Integer familyId = databaseClient.createFamilyDB(familyRequest);
                databaseClient.createMembers(familyRequest.familyMembers(), familyId);
                return true;
            }

        } else {
            throw new BadRequestException("Wrong number of family members. In array gets " + familyRequest.familyMembers().size() +
                    " expected " + (familyRequest.adultsNumber() + familyRequest.childrenNumber() + familyRequest.infantsNumber()));
        }
        return false;
    }

    private static boolean validateFamilyData(
            List<FamilyMemberRequestBody> familyMembers, int infantsNumber,
            int childrenNumber, int adultsNumber) {

        int numberOfInfants = 0;
        int numberOfChildren = 0;
        int numberOfAdults = 0;

//        GET NUMBER OF AGE GROUPS
        for (FamilyMemberRequestBody familyMember : familyMembers) {
            if (familyMember.age() >= 0 && familyMember.age() <= 4) {
                numberOfInfants++;
            } else if (familyMember.age() > 4 && familyMember.age() <= 16) {
                numberOfChildren++;
            } else if (familyMember.age() > 16) {
                numberOfAdults++;
            }
        }

//        IF NUMBER OF PEOPLE IN AGE GROUP IS INCORRECT THROW ERROR
        if (numberOfInfants != infantsNumber) {
            throw new BadRequestException(
                    "Invalid number of infants. Infants age should be between 0 and 4");
        } else if (numberOfChildren != childrenNumber) {
            throw new BadRequestException(
                    "Invalid number of children. Children age should be between 5 and 16");
        } else if (numberOfAdults != adultsNumber) {
            throw new BadRequestException(
                    "Invalid number of adults. adults age should be at least 17");
        } else {
            return true;
        }

    }

    public FamilyRequestBody getFamily(Integer familyId) {

        FamilyRequestBody family = databaseClient.getFamily(familyId);

        if(family==null){
            throw new NotFoundException("Not found family with id "+familyId);
        }

        return family;
    }
}
