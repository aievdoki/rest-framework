package rest.framework.configuration.impl

/**
 * @author andrii.ievdokimov
 */

enum SysProperties {

    BASE_URI("rest.framework.application.url", "https://google.com"),
    USER_NAME("rest.framework.user", ""),
    USER_PASSWORD("rest.framework.password", "")

    private final String property
    private final String value

    SysProperties(String property, String value){
        this.property = property
        this.value = value
    }

    String getProperty(){
        return property
    }

    String getDefaultValue(){
        return value
    }

}
