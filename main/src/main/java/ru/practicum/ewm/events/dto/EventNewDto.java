package ru.practicum.ewm.events.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.locations.LocationDto;

import java.time.LocalDateTime;

import static ru.practicum.ewm.util.DateConstant.DATE_TIME_PATTERN;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventNewDto {

    @Size(min = 20, max = 2000)
    @NotBlank
    String annotation;

    @NotNull
    Long category;

    @Size(min = 20, max = 7000)
    @NotBlank
    String description;

    @NotNull
    @Future
    @JsonFormat(pattern = DATE_TIME_PATTERN)
    LocalDateTime eventDate;

    @NotNull
    @Valid
    LocationDto location;

    boolean paid = false;

    @PositiveOrZero
    int participantLimit = 0;

    boolean requestModeration = true;

    @Size(min = 3, max = 120)
    @NotBlank
    String title;

    public Boolean getPaid() {
        return paid;
    }

    public Boolean getRequestModeration() {
        return requestModeration;
    }
}
