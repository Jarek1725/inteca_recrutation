package clients.database;

import java.util.List;

public record FamilyRequestBody(String familyName,
                                Integer adultsNumber,
                                Integer childrenNumber,
                                Integer infantsNumber,
                                List<FamilyMemberRequestBody> familyMembers
                                ) {
}
