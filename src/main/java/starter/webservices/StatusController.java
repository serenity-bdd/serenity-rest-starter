package starter.webservices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api("status")
public class StatusController {

    @RequestMapping(value = "/api/status", method = GET)
    @ApiOperation("Check the status of the API")
    public String status() {
        return "Serenity REST Starter project up and running";
    }
}
