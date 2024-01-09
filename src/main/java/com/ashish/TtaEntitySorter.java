package com.ashish;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ashish.tickettracker.TtaEntity;

public class TtaEntitySorter {
    public static List<TtaEntity> sortEntitiesByStatus(List<TtaEntity> entities) {
        return entities.stream()
                .sorted(Comparator.comparing((TtaEntity e) -> {
                    if ("created".equalsIgnoreCase(e.getStatus())) {
                        return 0; 
                    } else {
                        return 1; 
                    }
                }).thenComparing(TtaEntity::getStatus, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}

