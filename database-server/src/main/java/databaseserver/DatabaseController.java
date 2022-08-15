package databaseserver;

import clients.database.FamilyMemberRequestBody;
import databaseserver.family.FamilyRepository;
import clients.database.FamilyRequestBody;
import databaseserver.family.FamilyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/database")
public record DatabaseController(FamilyService familyService) {

    @PostMapping(path = "/create-family")
    public Integer createFamilyDB(@RequestBody FamilyRequestBody familyRequestBody){
        return familyService.saveFamily(familyRequestBody);
    };

    @PostMapping(path = "/create-member")
    public boolean createMembers(@RequestBody List<FamilyMemberRequestBody> familyMembers, @RequestParam Integer familyId){
        familyService.saveMembers(familyMembers, familyId);
        return false;
    }
}
