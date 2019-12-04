package com.wild.on_the_road;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

//Create a Spring project, and make the application into a controller.
@Controller
@SpringBootApplication
public class OnTheRoadApplication {

	public static void main(String[] args) { SpringApplication.run(OnTheRoadApplication.class, args); }

	//Create a route that looks like this: /doctor/<incarnation number>.
	@RequestMapping("/doctor/{incarnationNumber}")
	@ResponseBody
	public ResponseEntity<String> incarnationNumber(@PathVariable String incarnationNumber){

		switch (incarnationNumber){
			// For the other doctors (1 to 8) return a 303 status.
			case "one":
			case "two":
			case "three":
			case "four":
			case "five":
			case "six":
			case "seven":
			case "eight": return responesEoE();
			// For doctors 9 to 13 inclusive, return the details about the incarnation of the corresponding Doctor
			case "nine": return responesTwohundert(incarnationNumber, "Christopher Eccleston");
			case "ten": return responesTwohundert(incarnationNumber, "David Tennant");
			case "eleven": return responesTwohundert(incarnationNumber,"Matt Smith");
			case "twelve": return responesTwohundert(incarnationNumber,"Peter Capaldi");
			case "thirteen": return responesTwohundert(incarnationNumber,"Jodie Whittake");

			default:
				return ResponseEntity.status(404).body("HTTP/1.1 404 Not found. No the incarnation " + incarnationNumber);
		}
	}
	public ResponseEntity<String> responesEoE (){
		return ResponseEntity.status(303).body("HTTP/1.1 303 See other");
	}
	public ResponseEntity<String>responesTwohundert(String incarnationNumber, String name){
		return ResponseEntity.status(200).body("{\"number\": " + incarnationNumber + ", \"name\": "+name+"}");
	}
}
