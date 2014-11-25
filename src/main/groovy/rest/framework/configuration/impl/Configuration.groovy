package rest.framework.configuration.impl

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable
import groovy.transform.ToString
import rest.framework.configuration.api.ApplicationConfiguration
import rest.framework.configuration.api.UserConfiguration
import static rest.framework.configuration.impl.SysProperties.BASE_URI
import static rest.framework.configuration.impl.SysProperties.USER_NAME
import static rest.framework.configuration.impl.SysProperties.USER_PASSWORD

/**
 * @author andrii.ievdokimov
 */

@Immutable
@EqualsAndHashCode
@ToString
class Configuration implements ApplicationConfiguration, UserConfiguration{

    final String baseURL
    final String userName
    final String password

    final static Configuration DEFAULT = new Configuration(
            baseURL: System.getProperty(BASE_URI.property, BASE_URI.defaultValue),
            userName: System.getProperty(USER_NAME.property, USER_NAME.defaultValue),
            password: System.getProperty(USER_PASSWORD.property, USER_PASSWORD.defaultValue),
    )

}
