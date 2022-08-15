package clients.database;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        value="database-server",
        path = "api/v1/database"
)
public interface FamilyDatabaseClient {
    @PostMapping(path = "/create-family")
    Integer createFamilyDB(@RequestBody FamilyRequestBody familyRequestBody);

    @PostMapping(path = "/create-member")
    boolean createMembers(@RequestBody List<FamilyMemberRequestBody> familyMembers, @RequestParam("familyId") Integer familyId);
}
