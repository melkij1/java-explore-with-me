package ru.practicum.ewm.stats.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewm.stats.dto.EndpointHitDto;
import ru.practicum.ewm.stats.dto.ViewStats;
import ru.practicum.ewm.stats.server.model.EndpointHit;
import ru.practicum.ewm.stats.server.model.EndpointHitMapper;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StatsService {
    private final StatsRepository statsRepository;

    public EndpointHitDto saveHit(EndpointHitDto hit) {
        log.debug("Save hit {}", hit);
        EndpointHit endpointHit = statsRepository.save(EndpointHitMapper.toHit(hit));
        return EndpointHitMapper.toEndpointHitDto(endpointHit);
    }

    @Transactional(readOnly = true)
    public List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        if (start.isAfter(end)) {
            throw new DateTimeException("Wrong timestamp.");
        }
        if (unique) {
            if (uris != null) {
                return statsRepository.findHitsWithUniqueIpWithUris(uris, start, end);
            }
            return statsRepository.findHitsWithUniqueIpWithoutUris(start, end);
        } else {
            if (uris != null) {
                return statsRepository.findAllHitsWithUris(uris, start, end);
            }
            return statsRepository.findAllHitsWithoutUris(start, end);
        }
    }
}
