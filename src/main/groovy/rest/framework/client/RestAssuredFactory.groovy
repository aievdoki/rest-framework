package rest.framework.client

import com.jayway.restassured.builder.RequestSpecBuilder
import com.jayway.restassured.filter.log.LogDetail
import com.jayway.restassured.specification.RequestSpecification
import rest.framework.configuration.api.UserConfiguration

import static com.jayway.restassured.RestAssured.basic
import static com.jayway.restassured.RestAssured.given

/**
 * @author andrii.ievdokimov
 */
class RestAssuredFactory {

    private final RequestSpecBuilder specification = new RequestSpecBuilder()

    RestAssuredFactory(final String uri) {
        specification.setBaseUri(new URI(uri))
        if (uri.startsWith("https"))
            specification.setRelaxedHTTPSValidation()
    }

    RestAssuredFactory user(final UserConfiguration userConfiguration) {
        specification.setAuthentication(basic(userConfiguration.userName, userConfiguration.password))
        this
    }

    RestAssuredFactory user(final String userName, final String password) {
        specification.setAuthentication(basic(userName, password))
        this
    }

    RequestSpecification create() {
        given(specification.log(LogDetail.ALL).build())
    }

}
