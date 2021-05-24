package edu.project.yevhenaudit.service.impl;

import edu.project.yevhenaudit.exception.NullEntityReferenceException;
import edu.project.yevhenaudit.model.Report;
import edu.project.yevhenaudit.repository.ReportRepository;
import edu.project.yevhenaudit.service.ReportService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("reportServiceImpl")
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report create(Report report) {
        if (report != null) {
            return reportRepository.save(report);
        }
        throw new NullEntityReferenceException("Report cannot be 'null'");
    }

    @Override
    public Report readById(long id) {
        return reportRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Report with id " + id + " not found"));
    }

    @Override
    public Report update(Report report) {
        if (report != null) {
            readById(report.getId());
            return reportRepository.save(report);
        }
        throw new NullEntityReferenceException("Report cannot be 'null'");
    }

    @Override
    public void delete(long id) {
        Report report = readById(id);
        reportRepository.delete(report);
    }

    @Override
    public List<Report> getByUserId(long userId) {
        return reportRepository.getByUserId(userId);
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }
}
