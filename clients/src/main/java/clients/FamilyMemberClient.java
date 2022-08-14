package clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        value="family-member",
        path = "api/v1/family-member"
)
public interface FamilyMemberClient {
    @GetMapping(path = "test")
    FamilyMemberResponse testGet();
}
