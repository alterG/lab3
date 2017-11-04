import model.Country;
import model.Person;
import model.UsualPerson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

    private UsualPerson expectedPerson;
    private AbstractApplicationContext context;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @AfterEach
    void tearDown() throws Exception {
        if (context != null) {
            context.close();
        }
    }

    @Test
    void testInitPerson() {
        UsualPerson person = (UsualPerson) context.getBean("person", Person.class);
        assertEquals(expectedPerson, person);
        System.out.println(person);
    }

    private UsualPerson getExpectedPerson() {
        UsualPerson person = new UsualPerson();
        person.setAge(35);
        person.setName("John Smith");

        Country country = new Country("RU", "Russia", 1);
        person.setCountry(country);

        return person;
    }


}
