package br.com.academy;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.camel.ProducerTemplate;

@Path("/hello")
public class GreetingResource {

	@Inject
	private ProducerTemplate producer;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("nome") String nome) {
    	producer.sendBody("slack:#quarkus-e-camel?"
    			+ "webhookurl=https://hooks.slack.com/services/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", 
    			"Enviando mensagem do Quarkus: " + nome);
        return "Hello RESTEasy";
    }
}