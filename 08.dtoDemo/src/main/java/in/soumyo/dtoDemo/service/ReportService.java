package in.soumyo.dtoDemo.service;

import in.soumyo.dtoDemo.dto.request.CreateReqReportDTO;
import in.soumyo.dtoDemo.dto.response.CreateResReportDTO;
import in.soumyo.dtoDemo.entity.Report;
import in.soumyo.dtoDemo.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    ReportRepository reportRepository;
    Mapper mapper;

    public ReportService(ReportRepository reportRepository, Mapper mapper) {
        this.reportRepository = reportRepository;
        this.mapper = mapper;
    }

    public CreateResReportDTO createReport (CreateReqReportDTO reportDTO) {
        Report report = mapper.mapToCreateEntity(reportDTO);
        Report newReport = reportRepository.save(report);

        CreateResReportDTO response = mapper.mapToCreateDTO(newReport);
        return response;
    }
}
