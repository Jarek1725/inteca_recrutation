package familymember;

import clients.database.FamilyDatabaseClient;
import clients.database.FamilyMemberRequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public record FamilyMemberService(FamilyDatabaseClient databaseClient) {
    public void createMembers(List<FamilyMemberRequestBody> familyMembers, Integer familyId) {
        databaseClient.createMembers(familyMembers, familyId);
    }
}
