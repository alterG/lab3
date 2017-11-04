import model.Country;
import model.Person;
import model.UsualPerson;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    static final String APPLICATION_CONTEXT_XML_FILE_NAME = "resources/application-context.xml";

    private UsualPerson expectedPerson;
    private AbstractApplicationContext context;

    @BeforeAll
    void setUp() throws Exception {
        context = new FileSystemXmlApplicationContext(
                new String[]{APPLICATION_CONTEXT_XML_FILE_NAME});
        expectedPerson = getExpectedPerson();
    }

    @AfterAll
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
