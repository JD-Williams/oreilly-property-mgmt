package dev.jdwilliams.propertymanagement.repository;

import dev.jdwilliams.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
}
