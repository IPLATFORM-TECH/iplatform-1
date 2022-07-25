package space.eliseev.iplatform.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import space.eliseev.iplatform.entity.Data;
import space.eliseev.iplatform.repository.DataRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DataServiceImpl implements DataService {

    private DataRepository dataRepository;

    @Override
    public Data findDataBySource(String name) {
        return dataRepository.findDataBySource(name);
    }

    @Override
    public List<Data> findAll() {
        return dataRepository.findAll();
    }

    @Override
    public Data updateData(Data newData) {
        Optional<Data> optData = dataRepository.findById(newData.getId());
        if(optData.isPresent()) {
            Data dataForDb = optData.get();
            dataForDb.setDataField(newData.getDataField());
            dataForDb.setSource(newData.getSource());
            dataForDb.setDateOfDownload(newData.getDateOfDownload());
            dataRepository.save(dataForDb);
            return dataForDb;
        } else {
            return null;
        }
    }

    @Override
    public void saveData(Data data) {
        dataRepository.insert(data);
    }

    @Override
    public void deleteData(Data data) {
        dataRepository.delete(data);
    }
}
