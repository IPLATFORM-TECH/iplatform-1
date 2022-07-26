package space.eliseev.iplatform.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import space.eliseev.iplatform.entity.Data;

@SpringBootTest
class DataServiceTest {

    @Autowired
    private DataService ds;
    Data someData1 = Data
            .builder()
            .dataField("some text1 for save")
            .source("sourceName1Com")
            .dateOfDownload(12042006)
            .build();

    @BeforeEach
    void setUp() {
        ds.saveData(someData1);
        for (int i = 2; i <= 10; i++) {
            StringBuilder dataField = new StringBuilder("some text ");
            dataField.append(i).append("sourceName");
            StringBuilder source = new StringBuilder("sourceName");
            source.append(i).append("com");
            ds.saveData(Data
                    .builder()
                    .dataField(dataField.toString())
                    .source(source.toString())
                    .dateOfDownload(12042006)
                    .build());
        }
    }

    @AfterEach
    void tearDown() {

        for (Data data : ds.findAll()) {
            ds.deleteData(data);
        }
    }

    @Test
    void findAll() {
        Assertions.assertEquals(someData1, ds.findAll().get(0));
        Assertions.assertNotEquals(Data
                        .builder()
                        .dataField("false text")
                        .source("strangeCom")
                        .dateOfDownload(99889977)
                        .build()
                , ds.findAll().get(0));
    }

    @Test
    void findDataBySource() {
        Assertions.assertTrue(ds.findDataBySource("sourceName1Com").isPresent());
        Assertions.assertFalse(ds.findDataBySource("sourceNameCom").isPresent());
    }

    @Test
    void updateData() {
        Data dataFromDb = ds.findAll().get(3);
        String oldSource = dataFromDb.getSource();
        dataFromDb.setSource("sourceNameCom");
        ds.updateData(dataFromDb);
        Assertions.assertTrue(ds.findDataBySource("sourceNameCom").isPresent());
        Assertions.assertFalse(ds.findDataBySource(oldSource).isPresent());
    }

    @Test
    void saveData() {
        Data newData = Data
                .builder()
                .dataField("saveDataTextTest")
                .source("sourceNameTest")
                .dateOfDownload(23041993)
                .build();
        ds.saveData(newData);
        Assertions.assertTrue(ds.findAll().contains(newData));
    }

    @Test
    void deleteData() {
        Data newData = Data
                .builder()
                .dataField("saveDataTextTest2")
                .source("sourceNameTest2")
                .dateOfDownload(23041993)
                .build();
        ds.saveData(newData);
        Assertions.assertTrue(ds.findAll().contains(newData));
        ds.deleteData(ds.findDataBySource("sourceNameTest2").get());
        Assertions.assertFalse(ds.findAll().contains(newData));
    }
}