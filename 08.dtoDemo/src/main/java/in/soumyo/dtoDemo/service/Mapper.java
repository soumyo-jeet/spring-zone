package in.soumyo.dtoDemo.service;

import in.soumyo.dtoDemo.dto.request.CreateReqReportDTO;
import in.soumyo.dtoDemo.dto.response.CreateResReportDTO;
import in.soumyo.dtoDemo.entity.Report;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Mapper {
    protected Report mapToCreateEntity(CreateReqReportDTO createReqReportDTO) {
        Report newReport = new Report();

        newReport.setAuthor(createReqReportDTO.getAuthor());
        newReport.setContent(createReqReportDTO.getContent());
        newReport.setCreatedAt(LocalDateTime.now());
        newReport.setDeleted(false);
        newReport.setLines(createReqReportDTO.getLines());
        newReport.setTitle(createReqReportDTO.getTitle());

        return newReport;
    }

    protected CreateResReportDTO mapToCreateDTO(Report report) {
        CreateResReportDTO createResReportDTO = new CreateResReportDTO();

        createResReportDTO.setAuthor(report.getAuthor());
        createResReportDTO.setTitle(report.getTitle());
        createResReportDTO.setContent(report.getContent());
        createResReportDTO.setCreatedAt(report.getCreatedAt());
        createResReportDTO.setId(report.getId());
        createResReportDTO.setLines(report.getLines());
        createResReportDTO.setMessage("Report created successfully");

        return createResReportDTO;
    }
}
