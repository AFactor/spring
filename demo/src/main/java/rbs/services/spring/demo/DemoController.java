package rbs.services.spring.demo;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @GetMapping("weather/{city}")
    //public Response Weather(@RequestParam(value="name") String name) {
    public Response Weather(@PathVariable String city) {
        
        return new Response(city);
    }

    @GetMapping("cryptos/")
    public Coin[] GetCoins(@RequestParam(value="name", defaultValue = "") String name)  {
        
        RestTemplate restTemplate = new RestTemplate();

        Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/" + name, Coin[].class);
        return coins;
    }
}
