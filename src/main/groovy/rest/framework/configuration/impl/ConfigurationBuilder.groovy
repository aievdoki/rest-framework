package rest.framework.configuration.impl

import rest.framework.configuration.api.ApplicationConfiguration
import rest.framework.configuration.api.UserConfiguration

/**
 * @author andrii.ievdokimov
 */

class ConfigurationBuilder {

    private UserConfiguration userConfiguration
    private ApplicationConfiguration applicationConfiguration

    ConfigurationBuilder user(UserConfiguration userConfiguration) {
        this.userConfiguration = userConfiguration
        this
    }

    ConfigurationBuilder uri(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration
        this
    }

    Configuration build() {
        new Configuration(
                baseURL: applicationConfiguration ? applicationConfiguration.baseURL : Configuration.DEFAULT.baseURL,
                userName: userConfiguration ? userConfiguration.userName : Configuration.DEFAULT.userName,
                password: userConfiguration ? userConfiguration.password : Configuration.DEFAULT.password,
        )
    }

}
