package starter.trades;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Api("trade")
public class TradeController {

    private static AtomicLong tradeIds = new AtomicLong(1);

    @RequestMapping(value = "/api/trade", method = POST)
    @ApiOperation("Record a new trade")
    public Trade recordTrade(@RequestBody Trade newTrade) {
        return new Trade(tradeIds.incrementAndGet(),
                         newTrade.getSecurity(),
                         newTrade.getBuySell(),
                         newTrade.getQuantity(),
                         newTrade.getPriceInCents(),
                newTrade.getQuantity() * newTrade.getPriceInCents() );
    }
}
