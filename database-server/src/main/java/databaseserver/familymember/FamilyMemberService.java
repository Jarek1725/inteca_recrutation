package databaseserver.familymember;

import org.springframework.stereotype.Service;

@Service
public record FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
}
