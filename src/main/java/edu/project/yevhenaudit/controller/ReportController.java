package edu.project.yevhenaudit.controller;

import edu.project.yevhenaudit.dto.Indicator;
import edu.project.yevhenaudit.model.Report;
import edu.project.yevhenaudit.model.User;
import edu.project.yevhenaudit.service.IndicatorService;
import edu.project.yevhenaudit.service.ReportService;
import edu.project.yevhenaudit.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final UserService userService;
    private final ReportService reportService;
    private final IndicatorService indicatorService;

    public ReportController(UserService userService, ReportService reportService, IndicatorService indicatorService) {
        this.userService = userService;
        this.reportService = reportService;
        this.indicatorService = indicatorService;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and authentication.details.id == #ownerId")
    @GetMapping("/create/users/{owner_id}")
    public String create(@PathVariable("owner_id") long ownerId, Model model) {
        model.addAttribute("indicator", new Indicator());
        model.addAttribute("user", userService.readById(ownerId));
        return "create-report";
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and authentication.details.id == #ownerId")
    @PostMapping("/create/users/{owner_id}")
    public String create(@PathVariable("owner_id") long ownerId,
                         @Validated @ModelAttribute("indicator") Indicator indicator, BindingResult result) {
        if (result.hasErrors()) {
            return "create-report";
        }
        Report report = indicatorService.calculate(indicator);
        report.setAddress(indicator.getAddress());
        report.setOwner(userService.readById(ownerId));
        reportService.create(report);
        return "redirect:/reports/" + report.getId() + "/read";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable long id, Model model) {
        Report report = reportService.readById(id);
        model.addAttribute("report", reportService.readById(id));
        model.addAttribute("user", report.getOwner());
        return "read-report";
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and authentication.details.id == #ownerId")
    @GetMapping("/{report_id}/delete/users/{owner_id}")
    public String delete(@PathVariable("report_id") long reportId, @PathVariable("owner_id") long ownerId) {
        reportService.delete(reportId);
        return "redirect:/reports/all/users/" + ownerId;
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER') and authentication.details.id == #userId")
    @GetMapping("/all/users/{user_id}")
    public String getAll(@PathVariable("user_id") long userId, Model model) {
        List<Report> reports = reportService.getByUserId(userId);
        model.addAttribute("reports", reports);
        model.addAttribute("user", userService.readById(userId));
        return "reports-list";
    }
}
