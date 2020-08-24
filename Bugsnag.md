
![GitHub Logo](/images/bugsnag.png)


Bugsnag Installation
====================


Add Bugsnag as a dependency in your  `pom.xml`:


```
<dependency>
  <groupId>com.bugsnag</groupId>
  <version>[3.0,4.0)</version>
  <artifactId>bugsnag-spring</artifactId>
</dependency>
```

Install the library:

```
mvn install
```

The simplest way to start capturing exceptions is to create a new class which exposes `Bugsnag` as a Spring Bean, and imports the `BugsnagSpringConfiguration` class:

```
@Configuration
@Import(BugsnagSpringConfiguration.class)
public class BugsnagConfig {
    @Bean
    public Bugsnag bugsnag() {
        return new Bugsnag("xxxxxxxxxxxxxxxxxxxxxxx");
    }
}
```

Alternatively, you can configure a `Bugsnag` Bean via XML:

```
<context:annotation-config />

<bean id="bugsnag" class="com.bugsnag.Bugsnag">
  <constructor-arg name="apiKey" value="xxxxxxxxxxxxxxxxxxxxxxx"/>
</bean>

<bean id="bugsnagSpringConfiguration" class="com.bugsnag.BugsnagSpringConfiguration" />
```

Test your integration
To verify that your integration is working, call `Bugsnag.notify` in your application:
```
@Autowired
Bugsnag bugsnag;

bugsnag.notify(new RuntimeException("Test error"));
```

An error should appear in your dashboard after testing this stuff
