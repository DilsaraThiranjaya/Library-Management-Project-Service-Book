package lk.ijse.eca.bookservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookRequestDTO {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    
    @NotBlank(message = "Author cannot be blank")
    private String author;
    
    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;
    
    @Min(value = 0, message = "Stock cannot be negative")
    private Integer stock;
}
