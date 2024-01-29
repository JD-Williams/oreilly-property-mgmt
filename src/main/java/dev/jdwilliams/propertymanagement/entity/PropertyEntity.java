package dev.jdwilliams.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_property")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="property_title", nullable = false)
    private String title;
    private String description;
    private String address;
    private Double price;
    private String ownerName;
    @Column(nullable = false)
    private String ownerEmail;

}
