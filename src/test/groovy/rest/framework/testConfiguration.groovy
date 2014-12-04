package rest.framework

import com.jayway.restassured.specification.RequestSpecification
import rest.framework.client.RestAssuredFactory
import rest.framework.configuration.impl.Configuration
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author andrii.ievdokimov
 */
class testConfiguration extends Specification {

    RequestSpecification requestSpecification = new RestAssuredFactory(Configuration.DEFAULT.baseURL).create()

    @Unroll
    void "it should find records for text #t"() {
        when:
        def response = requestSpecification.
                param("q", t).
                when().get("search").andReturn()
        then:
        response.statusCode() == 200
        where:
        t << ["Find Me", "And Me"]
    }

}
