package edu.project.yevhenaudit.service;

import edu.project.yevhenaudit.model.Report;

import java.util.List;

public interface ReportService {
    Report create(Report report);
    Report readById(long id);
    Report update(Report report);
    void delete(long id);
    List<Report> getByUserId(long userId);
    List<Report> getAll();
}
