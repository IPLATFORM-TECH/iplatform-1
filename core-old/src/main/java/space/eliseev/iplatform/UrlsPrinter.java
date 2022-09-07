package space.eliseev.iplatform;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import space.eliseev.iplatform.config.StockConfig;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class UrlsPrinter {
    private final StockConfig stockConfig;

    @PostConstruct
    public void print(){
        System.out.println(stockConfig.getUrls());
    }
}
