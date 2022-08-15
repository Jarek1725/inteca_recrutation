package familymember;

import clients.FamilyMemberResponse;
import clients.database.FamilyMemberRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/family-member")
@Slf4j
public record FamilyMemberController(FamilyMemberService familyMemberService) {

    @PostMapping(path = "create")
    public boolean create(@RequestBody List<FamilyMemberRequestBody> familyMembers, Integer familyId){
        familyMemberService.createMembers(familyMembers, familyId);
        return true;
    }
}
