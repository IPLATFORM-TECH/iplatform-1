package space.eliseev.iplatform.service;

import space.eliseev.iplatform.entity.Data;

import java.util.List;
import java.util.Optional;

public interface DataService {

    Optional<Data> findDataBySource(String source);

    List<Data> findAll();

    void updateData(Data newData);

    void saveData(Data data);

    void deleteData(Data data);

    void getFinancialData(Data data);
    void getNonFinancialData(Data data);
}
