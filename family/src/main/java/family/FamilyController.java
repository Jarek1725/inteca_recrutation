package family;

import clients.FamilyMemberResponse;
import clients.database.FamilyRequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/family")
public record FamilyController(FamilyService familyService) {

    @GetMapping(path = "test")
    public FamilyMemberResponse test() {
        return new FamilyMemberResponse(false);
    }

    @PostMapping(path = "test")
    public String testPost(@RequestBody FamilyRequestBody familyRequestBody) {
        familyService.register(familyRequestBody);
        return "TESTXD";
    }
}
