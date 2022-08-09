package space.eliseev.iplatform.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(name = "api-service", url = "${stock.urls.0}")
public interface ApiService {
    @GetMapping(value = "/stocks")
    Object getStocks();

}
