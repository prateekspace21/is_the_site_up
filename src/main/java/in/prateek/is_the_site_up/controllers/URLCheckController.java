package in.prateek.is_the_site_up.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLCheckController {
    public final String site_is_up="Site is Up";
    public final String site_is_down="Site is Down";
    public final String site_is_Wrong="Site is Wrong";
    @GetMapping("/check")
    public String getURLMessage(@RequestParam String url){
        String returnmessage=site_is_up;
        try {
            URL urlobj=new URL(url);
            HttpURLConnection conn=(HttpURLConnection) urlobj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(conn.getResponseCode()/100!=2&&conn.getResponseCode()/100!=3){
                returnmessage=site_is_down;

            }
        } catch (MalformedURLException e) {
            returnmessage=site_is_Wrong;
        } catch (IOException e) {
            returnmessage=site_is_down;
        }

        return returnmessage;
    }
    
}
