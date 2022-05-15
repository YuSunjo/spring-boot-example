package com.platform.domain.alarm.repository;

import com.platform.domain.alarm.AlarmLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlarmLogRepository extends JpaRepository<AlarmLog, Long> {
}
