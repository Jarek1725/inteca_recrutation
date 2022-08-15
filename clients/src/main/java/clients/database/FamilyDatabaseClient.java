package clients.database;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value="database-server",
        path = "api/v1/database"
)
public interface FamilyDatabaseClient {
    @PostMapping(path = "/family/create")
    Integer createFamilyDB(@RequestBody FamilyRequestBody familyRequestBody);

    @PostMapping(path = "/family-members/create")
    boolean createMembers(@RequestBody List<FamilyMemberRequestBody> familyMembers, @RequestParam("familyId") Integer familyId);

    @GetMapping(path = "/family/{id}")
    FamilyRequestBody getFamily(@PathVariable(value = "id") Integer familyId);
}
