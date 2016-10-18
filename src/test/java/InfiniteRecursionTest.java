import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helibrothers.dico.domain.Delivery;
import com.helibrothers.dico.domain.Order;
import com.helibrothers.dico.domain.User;
import com.helibrothers.dico.domain.enums.DeliveryStatusCd;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by LeeDaebeom-Mac on 2016. 10. 3..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class InfiniteRecursionTest {

    private final static Log LOG = LogFactory.getLog(InfiniteRecursionTest.class);

    @Test
    public void Jackson_write_test() throws JsonProcessingException {
        User user = new User();
        user.setId("2daebong");
        user.setName("대봉");

        String jsonValue = new ObjectMapper().writeValueAsString(user);

        LOG.debug("DAEBONG::" + jsonValue);
    }

    @Test
    public void InfiniteRecursion_test() throws JsonProcessingException {
        Order order = new Order();
        User user = new User();
        Delivery delivery = new Delivery();
        delivery.setStatus(DeliveryStatusCd.DELIVERY);
        order.setUser(user);
        order.setDelivery(delivery);

        String jsonValue = new ObjectMapper().writeValueAsString(order);

        LOG.debug("DAEBONG::" + jsonValue);
    }
}
