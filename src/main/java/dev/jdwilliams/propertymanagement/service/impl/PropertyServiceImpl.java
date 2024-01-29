package dev.jdwilliams.propertymanagement.service.impl;

import dev.jdwilliams.propertymanagement.converter.PropertyConverter;
import dev.jdwilliams.propertymanagement.dto.PropertyDTO;
import dev.jdwilliams.propertymanagement.entity.PropertyEntity;
import dev.jdwilliams.propertymanagement.repository.PropertyRepository;
import dev.jdwilliams.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO dto) {
        PropertyEntity pe = propertyConverter.convertDTOtoEntity(dto);
        pe = propertyRepository.save(pe);
        return propertyConverter.convertEntitytoDTO(pe);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyList = propertyRepository.findAll();
        return propertyList.stream()
                .map(propertyConverter::convertEntitytoDTO)
                .toList();
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto = null;
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        if(optionalEntity.isPresent()) {
            PropertyEntity entity = optionalEntity.get();
            entity.setTitle(propertyDTO.getTitle());
            entity.setDescription(propertyDTO.getDescription());
            entity.setAddress(propertyDTO.getAddress());
            entity.setPrice(propertyDTO.getPrice());
            entity.setOwnerName(propertyDTO.getOwnerName());
            entity.setOwnerEmail(propertyDTO.getOwnerEmail());
            dto = propertyConverter.convertEntitytoDTO(entity);
            propertyRepository.save(entity);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto = null;
        Optional<PropertyEntity> optionalEntity = propertyRepository.findById(propertyId);
        if(optionalEntity.isPresent()) {
            PropertyEntity entity = optionalEntity.get();
            entity.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntitytoDTO(entity);
            propertyRepository.save(entity);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
