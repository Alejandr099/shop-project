package wszib.project.shop.creator;

import wszib.project.shop.domain.User;

import java.math.BigDecimal;

public class UserCreator {
    public static final String USERNAME = "Testowy";
    public static final String PASSWORD = "longpass1337";
    public static final String FIRST_NAME = "Testowy";
    public static final String LAST_NAME = "Testowy";
    public static final int AGE = 23;
    public static final String EMAIL = "Testowy@example.test";
    public static final String GENDER = "Male";
    public static final BigDecimal BALANCE = new BigDecimal(1000);
    public static final String CITY = "Cracow";

    public static User createTestUser() {
        User testObject = new User();

        testObject.setUsername(USERNAME);
        testObject.setPassword(PASSWORD);
        testObject.setPasswordConfirm(PASSWORD);
        testObject.setFirstName(FIRST_NAME);
        testObject.setLastName(LAST_NAME);
        testObject.setAge(AGE);
        testObject.setEmail(EMAIL);
        testObject.setGender(GENDER);
        testObject.setBalance(BALANCE);
        testObject.setCity(CITY);

        return testObject;
    }
}
