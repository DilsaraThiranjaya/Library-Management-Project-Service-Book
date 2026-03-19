package lk.ijse.eca.bookservice.dto;

import lombok.Data;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer stock;
    private String imageUrl;
}
