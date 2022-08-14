package familymember;

import clients.FamilyMemberResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/family-member")
@Slf4j
public record FamilyMemberController() {

    @PostMapping(path = "test")
    public FamilyMemberResponse test(){
        log.info("Get test");
        return new FamilyMemberResponse("Test123");
    }

    @GetMapping(path = "test")
    public FamilyMemberResponse testGet(){
        return new FamilyMemberResponse("Test123");
    }
}
