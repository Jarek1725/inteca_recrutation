package familymember;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping
public record FamilyMemberService(FamilyMemberRepository familyMemberRepository) {

}
