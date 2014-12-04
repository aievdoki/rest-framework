rest-framework
==============

#HTTP testing is simple

```java
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
```
