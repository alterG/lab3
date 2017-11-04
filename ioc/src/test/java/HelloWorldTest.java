import model.Country;
import model.UsualPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

    private UsualPerson expectedPerson;
    private BeanFactory context;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        assertEquals(expectedPerson, context.getBean("person"));
    }

    private UsualPerson getExpectedPerson() {
        UsualPerson person = new UsualPerson();
        person.setAge(35);
        person.setName("John Smith");
        Country country = new Country("RU", "Russia", 1);
        person.setCountry(country);
        person.setContacts(Arrays.asList("Impossible", "79118277200"));
        return person;
    }


}
