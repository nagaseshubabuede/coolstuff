package com.example.springboottesting.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories(basePackages = {"com.example.springboottesting"})
public class CassandraConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConfig.class);

    @Value("${cassandra.contactpoints}")
    private String cassandraContactpoint;

    @Value("${cassandra.port}")
    private Integer cassandraPort;

    @Value("${cassandra.keyspace}")
    private String cassandraKeyspace;

    @Value("${cassandra.username}")
    private String cassandraUsername;

    @Value("${cassandra.password}")
    private String cassandraPassword;


    /**
     * @return CassandraClusterFactoryBean
     */
    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(cassandraContactpoint);
        cluster.setPort(cassandraPort);
        cluster.setUsername(cassandraUsername);
        cluster.setPassword(cassandraPassword);
        return cluster;
    }

    /**
     * @return CassandraMappingContext
     */
    @Bean
    public CassandraMappingContext mappingContext() {
        CassandraMappingContext mappingContext = new CassandraMappingContext();
        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), cassandraKeyspace));
        return mappingContext;
    }

    /**
     * @return CassandraConverter
     */
    @Bean
    public CassandraConverter converter() {
        return new MappingCassandraConverter(mappingContext());
    }

    /**
     * @return CassandraSessionFactoryBean
     * @throws Exception
     */
    @Bean
    public CassandraSessionFactoryBean session() {
        CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
        session.setCluster(cluster().getObject());
        session.setKeyspaceName(cassandraKeyspace);
        session.setConverter(converter());
        session.setSchemaAction(SchemaAction.NONE);
        return session;
    }

    /**
     * @return CassandraOperations
     * @throws Exception
     */
    @Bean
    public CassandraOperations cassandraTemplate() throws Exception {
        return new CassandraTemplate(session().getObject());
    }

    protected String getKeySpace() {
        return cassandraKeyspace;
    }

}
