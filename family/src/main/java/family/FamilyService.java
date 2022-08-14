package family;

import clients.FamilyMemberClient;
import clients.FamilyMemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record FamilyService(FamilyRepository familyRepository, RestTemplate restTemplate, FamilyMemberClient familyMemberClient) {

    public void register(FamilyRequest familyRequest) {
        Family family = new Family(
                familyRequest.familyName(),
                familyRequest.adultsNumber(),
                familyRequest.childrenNumber(),
                familyRequest.infantsNumber()
        );

        familyRepository.save(family);

        FamilyMemberResponse familyMemberResponse = familyMemberClient.testGet();

        System.out.println(familyMemberResponse.test());
    }
}
