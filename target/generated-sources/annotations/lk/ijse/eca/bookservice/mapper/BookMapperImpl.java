package lk.ijse.eca.bookservice.mapper;

import javax.annotation.processing.Generated;
import lk.ijse.eca.bookservice.dto.BookRequestDTO;
import lk.ijse.eca.bookservice.dto.BookResponseDTO;
import lk.ijse.eca.bookservice.entity.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-25T12:53:17+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setAuthor( requestDTO.getAuthor() );
        book.setIsbn( requestDTO.getIsbn() );
        book.setStock( requestDTO.getStock() );
        book.setTitle( requestDTO.getTitle() );

        return book;
    }

    @Override
    public BookResponseDTO toResponseDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setAuthor( book.getAuthor() );
        bookResponseDTO.setId( book.getId() );
        bookResponseDTO.setImageUrl( book.getImageUrl() );
        bookResponseDTO.setIsbn( book.getIsbn() );
        bookResponseDTO.setStock( book.getStock() );
        bookResponseDTO.setTitle( book.getTitle() );

        return bookResponseDTO;
    }
}
