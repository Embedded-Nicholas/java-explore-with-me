package ru.practicum.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    EndpointHitMapper INSTANCE = Mappers.getMapper(EndpointHitMapper.class);

    EndpointHitDto toDto(EndpointHit hit);

    EndpointHit toHit(EndpointHitDto hitDto);
}
