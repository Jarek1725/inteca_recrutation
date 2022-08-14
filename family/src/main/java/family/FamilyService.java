package family;

import clients.FamilyMemberClient;
import clients.FamilyMemberResponse;
import clients.database.DatabaseClient;
import clients.database.FamilyRequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record FamilyService(RestTemplate restTemplate, FamilyMemberClient familyMemberClient, DatabaseClient databaseClient) {

    public void register(FamilyRequestBody familyRequest) {
        databaseClient.createFamily(familyRequest);
    }
}
