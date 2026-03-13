package lk.ijse.eca.bookservice.service.impl;

import lk.ijse.eca.bookservice.dto.BookRequestDTO;
import lk.ijse.eca.bookservice.dto.BookResponseDTO;
import lk.ijse.eca.bookservice.entity.Book;
import lk.ijse.eca.bookservice.exception.BookNotFoundException;
import lk.ijse.eca.bookservice.exception.DuplicateBookException;
import lk.ijse.eca.bookservice.mapper.BookMapper;
import lk.ijse.eca.bookservice.repository.BookRepository;
import lk.ijse.eca.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toResponseDTO)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found."));
    }

    @Override
    public BookResponseDTO saveBook(BookRequestDTO bookRequestDTO) {
        if (bookRepository.findByIsbn(bookRequestDTO.getIsbn()).isPresent()) {
            throw new DuplicateBookException("Book with ISBN " + bookRequestDTO.getIsbn() + " already exists.");
        }
        Book book = bookMapper.toEntity(bookRequestDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponseDTO(savedBook);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO) {
        return bookRepository.findById(id).map(existingBook -> {
            
            // Check if changing ISBN to one that already exists
            if (!existingBook.getIsbn().equals(bookRequestDTO.getIsbn()) 
                    && bookRepository.findByIsbn(bookRequestDTO.getIsbn()).isPresent()) {
                throw new DuplicateBookException("Book with ISBN " + bookRequestDTO.getIsbn() + " already exists.");
            }

            existingBook.setTitle(bookRequestDTO.getTitle());
            existingBook.setAuthor(bookRequestDTO.getAuthor());
            existingBook.setIsbn(bookRequestDTO.getIsbn());
            existingBook.setStock(bookRequestDTO.getStock());
            
            Book updatedBook = bookRepository.save(existingBook);
            return bookMapper.toResponseDTO(updatedBook);
            
        }).orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found. Cannot update."));
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with ID " + id + " not found. Cannot delete.");
        }
        bookRepository.deleteById(id);
    }
}
