package family;

import clients.FamilyMemberResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/family")
public record FamilyController(FamilyService familyService) {

    @GetMapping(path = "test")
    public FamilyMemberResponse test() {
        return new FamilyMemberResponse("Test123");
    }

    @PostMapping(path = "test")
    public String testPost(@RequestBody FamilyRequest familyRequest) {
        System.out.println("TESTSTTTTSTTSTS");
        familyService.register(familyRequest);
        return "TESTXD";
    }
}
