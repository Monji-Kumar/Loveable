package com.monji.projects.lovable_clone.repository.usagelog;

import com.monji.projects.lovable_clone.entity.usagelogs.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UsageLogRepository extends JpaRepository<UsageLog, Long> {
    Optional<UsageLog> findByUserIdAndDate(Long userId, LocalDate today);
}
