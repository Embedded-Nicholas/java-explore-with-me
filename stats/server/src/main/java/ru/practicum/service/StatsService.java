package ru.practicum.service;

import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.RequestParamDto;
import ru.practicum.dto.ViewStatsDto;

import java.util.List;

public interface StatsService {
    void saveHit(EndpointHitDto hitDto);

    List<EndpointHitDto> getAllHits();

    List<ViewStatsDto> getStats(RequestParamDto requestParamDto);
}