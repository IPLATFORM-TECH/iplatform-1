package space.eliseev.iplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.eliseev.iplatform.client.ApiService;
import space.eliseev.iplatform.entity.Data;
import space.eliseev.iplatform.service.DataService;

@RestController
public class DataController implements ApiService {

    private final DataService dataService;
    private final ApiService apiService;

    @Autowired
    public DataController(DataService dataService, ApiService apiService) {
        this.dataService = dataService;
        this.apiService = apiService;
    }

    @GetMapping("/stocks")
    public Object getStocks() {
        //dataService.getFinancialData(data);
        return apiService.getStocks();
    }

    @GetMapping("getNonFinancialData")
    public void getNonFinancialData(Data data) {
        //dataService.getNonFinancialData(data);
    }


}
