package space.eliseev.iplatform.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.eliseev.iplatform.entity.Data;
import space.eliseev.iplatform.repository.DataRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class DataServiceImpl implements DataService {

    private DataRepository dataRepository;

    @Override
    public Optional<Data> findDataBySource(String source) {
        return dataRepository.findDataBySource(source);
    }

    @Override
    public List<Data> findAll() {
        return dataRepository.findAll();
    }

    @Override
    public void updateData(Data newData) {
        Optional<Data> optData = dataRepository.findById(newData.getId());
        optData.ifPresent(dataForDb -> {
                    dataForDb = Data
                            .builder()
                            .dataField(newData.getDataField())
                            .source(newData.getSource())
                            .dateOfDownload(newData.getDateOfDownload())
                            .build();
                    dataRepository.save(dataForDb);
                }
        );
        dataRepository.save(optData.orElse(newData));
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
