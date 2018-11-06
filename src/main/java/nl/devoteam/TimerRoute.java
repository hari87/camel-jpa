package nl.devoteam;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		
		/*
		The below code is supposed to work according to documentation, but is not. 
		
		from("timer://anotherTImer?repeatCount=1")
		.to("jpa://nl.devoteam.User?consumer.nativeQuery=select * from devoteam.users where user_id = 1")
		.log("message from second body is ${body}");*/
		//the route below calls UserService to create User & populate object
		from("timer:new-order?repeatCount=10")
        .routeId("generate-user")
        .bean("userService", "generateUser")
        .to("jpa:nl.devoteam.User")
        .log("Inserted new user ${body.id}");
		
		//The route below reads the data from the database.
		
		from("timer:get-user?repeatCount=1&delay=12s")
		.log("route to get message is started.")
		.routeId("readData")
		.bean(Database.class, "findUsers")
		.log("the body is ${body}");
		
		
	}

}
