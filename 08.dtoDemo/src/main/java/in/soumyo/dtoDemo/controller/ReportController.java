package in.soumyo.dtoDemo.controller;

import in.soumyo.dtoDemo.dto.request.CreateReqReportDTO;
import in.soumyo.dtoDemo.dto.response.CreateResReportDTO;
import in.soumyo.dtoDemo.entity.Report;
import in.soumyo.dtoDemo.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {
    ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateResReportDTO> createReport (
            @Valid @RequestBody CreateReqReportDTO reportDTO) {
        CreateResReportDTO newReport = reportService.createReport(reportDTO);
        return ResponseEntity.ok(newReport);
    }
}
