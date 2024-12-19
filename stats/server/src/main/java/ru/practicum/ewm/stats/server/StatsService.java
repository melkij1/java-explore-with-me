package ru.practicum.ewm.stats.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import ru.practicum.ewm.stats.dto.EndpointHitDto;
import ru.practicum.ewm.stats.dto.ViewStats;
import ru.practicum.ewm.stats.server.model.EndpointHitMapper;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StatsService {
    private final StatsRepository statsRepository;

    public void saveHit(EndpointHitDto hit) {
        log.debug("Save hit: {}", hit);
        statsRepository.save(EndpointHitMapper.toHit(hit));
    }

    @Transactional(readOnly = true)
    public List<ViewStats> getStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {
        if (start.isAfter(end)) {
            log.debug("Wrong timestamp.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong timestamp.");
        }
        if (unique) {
            if (uris != null) {
                log.debug("Found unique uris.");
                return statsRepository.findHitsWithUniqueIpWithUris(uris, start, end);
            }
            log.debug("No unique uris.");
            return statsRepository.findHitsWithUniqueIpWithoutUris(start, end);
        } else {
            if (uris != null) {
                log.debug("Found uris.");
                return statsRepository.findAllHitsWithUris(uris, start, end);
            }
            log.debug("No uris.");
            return statsRepository.findAllHitsWithoutUris(start, end);
        }
    }
}
