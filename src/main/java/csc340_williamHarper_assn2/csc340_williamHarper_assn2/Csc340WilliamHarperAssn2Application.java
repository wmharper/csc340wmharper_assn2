package csc340_williamHarper_assn2.csc340_williamHarper_assn2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Csc340WilliamHarperAssn2Application {

	public static void main(String[] args) {
		SpringApplication.run(Csc340WilliamHarperAssn2Application.class, args);
                System.out.print("\n\n\n\n\n");
                try{
            String url = "https://meowfacts.herokuapp.com";
            RestTemplate restTemplate =  new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            
            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);
            
            
            System.out.println("Want to learn a cool cat fact?");
            System.out.println("Fact: " + root.findValue("data"));
            System.out.println("Aren't cats amazing?\n\n");
            
            //prints raw data
            System.out.println(root);
            
           
        }catch (JsonProcessingException ex) {
            Logger.getLogger(Csc340WilliamHarperAssn2Application.class.getName()).log(Level.SEVERE, null, ex);
            
        }

	
	}

}
