package dev.jdwilliams.propertymanagement.converter;

import dev.jdwilliams.propertymanagement.dto.PropertyDTO;
import dev.jdwilliams.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO dto) {
        return PropertyEntity.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .address(dto.getAddress())
                .price(dto.getPrice())
                .ownerName(dto.getOwnerName())
                .ownerEmail(dto.getOwnerEmail())
                .build();
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity entity) {
        return PropertyDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .address(entity.getAddress())
                .price(entity.getPrice())
                .ownerName(entity.getOwnerName())
                .ownerEmail(entity.getOwnerEmail())
                .build();
    }
}
