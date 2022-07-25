package space.eliseev.iplatform.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Data {
    @Id
    private String id;

    private Object dataField;

    private String source;
    private int dateOfDownload;
    public Data(Object dataField, String source, int dateOfDownload) {
        this.dataField = dataField;
        this.source = source;
        this.dateOfDownload = dateOfDownload;
    }
}
