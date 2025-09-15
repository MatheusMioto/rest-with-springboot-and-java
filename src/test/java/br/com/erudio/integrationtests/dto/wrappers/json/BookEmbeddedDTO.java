package br.com.erudio.integrationtests.dto.wrappers.json;

import br.com.erudio.integrationtests.dto.BookDTOV1;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class BookEmbeddedDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("books")
    private List<BookDTOV1> book;

    public BookEmbeddedDTO() {}

    public List<BookDTOV1> getBook() {
        return book;
    }

    public void setBook(List<BookDTOV1> book) {
        this.book = book;
    }
}
