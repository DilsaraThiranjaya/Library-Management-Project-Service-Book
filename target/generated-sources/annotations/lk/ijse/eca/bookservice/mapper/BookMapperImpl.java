package lk.ijse.eca.bookservice.mapper;

import javax.annotation.processing.Generated;
import lk.ijse.eca.bookservice.dto.BookRequestDTO;
import lk.ijse.eca.bookservice.dto.BookResponseDTO;
import lk.ijse.eca.bookservice.entity.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-16T09:11:31+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 25.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( requestDTO.getTitle() );
        book.setAuthor( requestDTO.getAuthor() );
        book.setIsbn( requestDTO.getIsbn() );
        book.setStock( requestDTO.getStock() );

        return book;
    }

    @Override
    public BookResponseDTO toResponseDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setId( book.getId() );
        bookResponseDTO.setTitle( book.getTitle() );
        bookResponseDTO.setAuthor( book.getAuthor() );
        bookResponseDTO.setIsbn( book.getIsbn() );
        bookResponseDTO.setStock( book.getStock() );

        return bookResponseDTO;
    }
}
