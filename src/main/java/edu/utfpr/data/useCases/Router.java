package edu.utfpr.data.useCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.utfpr.domain.model.Message;
import edu.utfpr.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class Router {



    public static void route(Message message) throws JsonProcessingException {
        switch(message.getEvent()) {
            case "login": {

                break;
            }

            case "register": {
                ObjectMapper mapper = new ObjectMapper();
                Register usecase = new Register();

                User user = mapper.readValue(message.getData().toString(), User.class);
                System.out.println(user.toString());
                usecase.perform(user);

                break;
            }

            default: {
                System.out.println("Evento não conhecido" );
            }
        }
    }
}
