package br.com.erudio.unittests.mapper.mocks;

import br.com.erudio.data.dto.v1.BookDTOV1;
import br.com.erudio.data.dto.v1.PersonDTOV1;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }
    
    public BookDTOV1 mockDTO() {
        return mockDTO(0);
    }
    
    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTOV1> mockDTOList() {
        List<BookDTOV1> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }
    
    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setId(number.longValue());
        book.setTitle("Title Test" + number);
        book.setAuthor("Autor Test" + number);
        book.setPrice(17.65);
        book.setLaunchDate(new Date());
        return book;
    }

    public BookDTOV1 mockDTO(Integer number) {
        BookDTOV1 book = new BookDTOV1();
        book.setId(number.longValue());
        book.setTitle("Title Test" + number);
        book.setAuthor("Autor Test" + number);
        book.setPrice(17.65);
        book.setLaunchDate(new Date());
        return book;
    }

}