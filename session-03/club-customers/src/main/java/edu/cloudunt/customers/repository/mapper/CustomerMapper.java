package edu.cloudunt.customers.repository.mapper;

import edu.cloudunt.customers.domain.dto.Customer;
import edu.cloudunt.customers.repository.model.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customerId", source = "id")
    Customer toCustomer(CustomerEntity customerEntity);

    @InheritInverseConfiguration
    CustomerEntity toEntity(Customer customer);

    List<Customer> toCustomers(List<CustomerEntity> customerEntity);
}
