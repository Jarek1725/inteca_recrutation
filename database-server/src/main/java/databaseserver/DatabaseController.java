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

    @PostMapping(path = "/family/create")
    public Integer createFamilyDB(@RequestBody FamilyRequestBody familyRequestBody){
        return familyService.saveFamily(familyRequestBody);
    };

    @PostMapping(path = "/family-members/create")
    public boolean createMembers(@RequestBody List<FamilyMemberRequestBody> familyMembers, @RequestParam Integer familyId){
        familyService.saveMembers(familyMembers, familyId);
        return false;
    }

    @GetMapping(path = "/family/{id}")
    FamilyRequestBody getFamily(@PathVariable(value = "id") Integer familyId){
        return familyService.getFamily(familyId);
    }
}
