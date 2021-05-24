package edu.project.yevhenaudit.repository;

import edu.project.yevhenaudit.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query(value = "select * from reports where owner_id = ?1", nativeQuery = true)
    List<Report> getByUserId(long userId);
}
