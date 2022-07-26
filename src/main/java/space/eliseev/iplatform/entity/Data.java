package space.eliseev.iplatform.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document
@Builder()
public class Data {
    @Id
    private String id;

    private Object dataField;
    private String source;
    private int dateOfDownload;
}