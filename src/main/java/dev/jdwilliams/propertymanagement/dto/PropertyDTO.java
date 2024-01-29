package dev.jdwilliams.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String address;
    private Double price;
    private String ownerName;
    private String ownerEmail;

}
