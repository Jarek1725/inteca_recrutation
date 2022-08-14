package databaseserver;

import databaseserver.family.FamilyRepository;
import clients.database.FamilyRequestBody;
import databaseserver.family.FamilyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/database")
public record DatabaseController(FamilyService familyService) {

    @PostMapping(path = "/create-family")
    public boolean createFamily(@RequestBody FamilyRequestBody familyRequestBody){
        System.out.println(familyService.saveFamily(familyRequestBody));
        return true;
    }
}
