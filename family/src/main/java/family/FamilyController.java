package family;

import clients.FamilyMemberResponse;
import clients.database.FamilyMemberRequestBody;
import clients.database.FamilyRequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/family")
public record FamilyController(FamilyService familyService) {

    @PostMapping(path = "create")
    public Integer create(@RequestBody FamilyRequestBody familyRequestBody) {
        return familyService.createFamily(familyRequestBody);
    }

    @GetMapping(path = "/{id}")
    public FamilyRequestBody getFamily(@PathVariable(value = "id") Integer familyId){
        return familyService.getFamily(familyId);
    }
}
