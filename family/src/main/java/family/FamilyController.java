package family;

import clients.FamilyMemberResponse;
import clients.database.FamilyRequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/family")
public record FamilyController(FamilyService familyService) {

    @PostMapping(path = "create")
    public boolean create(@RequestBody FamilyRequestBody familyRequestBody) {
        return familyService.createFamily(familyRequestBody);
    }
}
