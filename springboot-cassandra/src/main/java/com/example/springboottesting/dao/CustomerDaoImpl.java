package com.example.springboottesting.dao;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.querybuilder.Delete;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.example.springboottesting.dao.bean.Customer;
import com.example.springboottesting.utils.DAOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.EntityWriteResult;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.data.cassandra.core.UpdateOptions;
import org.springframework.data.cassandra.core.cql.QueryOptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @Value("${cassandra.readconsistency}")
    private String cassandraReadConsistency;

    @Value("${cassandra.writeconsistency}")
    private String cassandraWriteConsistency;

    /**
     * Build Cassandra QueryOptions e.g READ consistency, TTL , Retry Options
     * @return QueryOptions
     */
    protected QueryOptions getQueryOptions() {
        return QueryOptions.builder().consistencyLevel(ConsistencyLevel.valueOf(getCassandraReadConsistency())).build();
    }

    /**
     * Build Cassandra InsertOptions e.g READ consistency, TTL , Retry Options
     * @return WriteOptions
     */
    protected InsertOptions getInsertOptions() {
        return InsertOptions.builder().consistencyLevel(ConsistencyLevel.valueOf(getCassandraWriteConsistency())).build();
    }

    public String getCassandraReadConsistency() {
        return cassandraReadConsistency;
    }

    public String getCassandraWriteConsistency() {
        return cassandraWriteConsistency;
    }

    /**
     * Build Cassandra UpdateOptions e.g WRITE consistency, TTL , Retry Options
     * @return WriteOptions
     */
    protected UpdateOptions getUpdateOptions() {
        return UpdateOptions.builder().consistencyLevel(ConsistencyLevel.valueOf(getCassandraWriteConsistency())).build();
    }

    @Autowired
    private CassandraOperations cassandraOps;


    @Override
    public List<Customer> findAllCustomers() {
        Select selectStatement = QueryBuilder.select().from(DAOUtils.toTableName(Customer.class));
        selectStatement.setConsistencyLevel(ConsistencyLevel.valueOf(getCassandraReadConsistency()));

        return cassandraOps.select(selectStatement, Customer.class);
    }

    @Override
    public Customer findCustomerById(UUID customerId) {
        Select selectStatement = QueryBuilder.select().from(DAOUtils.toTableName(Customer.class));
        selectStatement.setConsistencyLevel(ConsistencyLevel.valueOf(getCassandraReadConsistency()));
        selectStatement.where(QueryBuilder.eq("id", customerId));

        return cassandraOps.selectOne(selectStatement, Customer.class);
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        EntityWriteResult<Customer> customerEntityWriteResult
                = cassandraOps.insert(customer, getInsertOptions());

        return customerEntityWriteResult.getEntity();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        EntityWriteResult<Customer> customerEntityWriteResult
                = cassandraOps.update(customer, getUpdateOptions());

        return customerEntityWriteResult.getEntity();
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        Delete deleteStatement = QueryBuilder.delete().from(DAOUtils.toTableName(Customer.class));
        deleteStatement.where(QueryBuilder.eq("id", customerId))
                .setConsistencyLevel(ConsistencyLevel.valueOf(getCassandraReadConsistency()));

        cassandraOps.getCqlOperations().execute(deleteStatement);
    }

}
