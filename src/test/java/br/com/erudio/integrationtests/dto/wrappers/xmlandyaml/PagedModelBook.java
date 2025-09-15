package br.com.erudio.integrationtests.dto.wrappers.xmlandyaml;

import br.com.erudio.integrationtests.dto.BookDTOV1;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class PagedModelBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "content")
    public List<BookDTOV1> content;

    public PagedModelBook() {}

    public List<BookDTOV1> getContent() {
        return content;
    }

    public void setContent(List<BookDTOV1> content) {
        this.content = content;
    }
}
