package clients.database;

public record FamilyRequestBody(String familyName,
                                Integer adultsNumber,
                                Integer childrenNumber,
                                Integer infantsNumber) {
}
