package br.com.erudio.integrationtests.dto.wrappers.xmlandyaml;

import br.com.erudio.integrationtests.dto.PersonDTOV1;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class PagedModelPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "content")
    public List<PersonDTOV1> content;

    public PagedModelPerson() {}

    public List<PersonDTOV1> getContent() {
        return content;
    }

    public void setContent(List<PersonDTOV1> content) {
        this.content = content;
    }
}
