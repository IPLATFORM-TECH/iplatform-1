package space.eliseev.iplatform.config;

import liquibase.pro.packaged.S;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import space.eliseev.iplatform.config.StockConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(value = StockConfig.class)
class StockConfigTest {
    @Autowired
    private StockConfig stockConfig;

    @Test
    void simpleYamlTest() {
        assertEquals(10, stockConfig.getUrls().size());
    }

}