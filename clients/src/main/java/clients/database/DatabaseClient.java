package clients.database;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value="database-server",
        path = "api/v1/database"
)
public interface DatabaseClient {
    @PostMapping(path = "/create-family")
    boolean createFamily(@RequestBody FamilyRequestBody familyRequestBody);
}
