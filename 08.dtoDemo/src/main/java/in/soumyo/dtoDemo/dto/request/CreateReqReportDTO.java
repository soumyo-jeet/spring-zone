package in.soumyo.dtoDemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateReqReportDTO {
    @NotBlank(message = "Title can not be blank.")
    @Size(min = 2, max = 10, message = "Title must be greater than 2 and less than 10 characters.")
    private String title;

    @NotBlank(message = "Content can not be blank.")
    private String content;

    @NotEmpty(message = "Author can not be empty")
    private String author;


    private Long lines;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getLines() {
        return lines;
    }

    public void setLines(Long lines) {
        this.lines = lines;
    }
}
