package br.com.academy;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

@ApplicationScoped
public class CamelRouter extends EndpointRouteBuilder {

	@Override
	public void configure() throws Exception {

		from(platformHttp("/camel/hello")).setBody().simple("Nesomar").to(slack("#quarkus-e-camel")
				.webhookUrl("https://hooks.slack.com/services/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"));

	}

}
