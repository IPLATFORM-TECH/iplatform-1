package space.eliseev.iplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import space.eliseev.iplatform.entity.Data;
import space.eliseev.iplatform.service.DataService;

@Controller
@RequestMapping("data")
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("getFinancialData")
    public void getFinancialData(Data data) {
        dataService.getFinancialData(data);
    }

    @RequestMapping("getNonFinancialData")
    public void getNonFinancialData(Data data) {
        dataService.getNonFinancialData(data);
    }
}
