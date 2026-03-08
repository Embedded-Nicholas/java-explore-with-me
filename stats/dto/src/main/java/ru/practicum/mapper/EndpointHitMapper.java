package ru.practicum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.dto.EndpointHit;
import ru.practicum.dto.EndpointHitDto;

@Mapper(componentModel = "spring")
public interface EndpointHitMapper {

    EndpointHitMapper INSTANCE = Mappers.getMapper(EndpointHitMapper.class);

    EndpointHitDto toDto(EndpointHit hit);

    EndpointHit toHit(EndpointHitDto hitDto);
}

