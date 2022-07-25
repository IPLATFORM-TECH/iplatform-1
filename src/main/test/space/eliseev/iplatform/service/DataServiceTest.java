package space.eliseev.iplatform.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import space.eliseev.iplatform.entity.Data;

@SpringBootTest
class DataServiceTest {

    @Autowired
    private DataService ds;
    private final Data someData = new Data("some text for save", "sourceNameCom", 12042006);

    @BeforeEach
    void setUp() {
        ds.saveData(someData);
    }

    @AfterEach
    void tearDown() {
        for (Data data: ds.findAll()) {
            ds.deleteData(data);
        }
    }

    @Test
    void findAll() {
        Assertions.assertEquals(someData, ds.findAll().get(0));
        Assertions.assertNotEquals(new Data("false text", "strangeCom", 99889977), ds.findAll().get(0));
    }

    @Test
    void findDataBySource() {
        Assertions.assertEquals(someData, ds.findDataBySource("sourceNameCom"));
        Assertions.assertNotEquals(new Data("false text", "strangeCom", 12042006), ds.findDataBySource("sourceNameCom"));
    }

    @Test
    void updateData() {
        Data data = ds.findAll().get(0);
        Data newData = new Data("other text for save", "sourceNameCom", 12042006);
        newData.setId(data.getId());
        ds.updateData(newData);
        Assertions.assertEquals(newData, ds.findAll().get(0));
        Assertions.assertNotEquals(data, ds.findAll().get(0));
    }

    @Test
    void saveData() {
        Data newData = new Data("saveDataTextTest", "sourceNameTest", 23041993);
        ds.saveData(newData);
        Assertions.assertEquals(newData, ds.findAll().get(1));
        Assertions.assertNotEquals(newData, ds.findAll().get(0));
    }

    @Test
    void deleteData() {
        Data newData = new Data("saveDataTextTest2", "sourceNameTest2", 23041993);
        ds.saveData(newData);
        Assertions.assertTrue(ds.findAll().contains(newData));
        ds.deleteData(ds.findDataBySource("sourceNameTest2"));
        Assertions.assertFalse(ds.findAll().contains(newData));
    }
}