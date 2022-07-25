package space.eliseev.iplatform.service;

import space.eliseev.iplatform.entity.Data;

import java.util.List;

public interface DataService {

    Data findDataBySource(String name);

    List<Data> findAll();

    void updateData(Data newData);

    void saveData(Data data);

    void deleteData(Data data);
}
