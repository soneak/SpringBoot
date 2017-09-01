package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello-world-service")

public class Controller {

	@Autowired
	public ModelService modelservice;

	@RequestMapping(value = "/Hello1", method = RequestMethod.GET)
	public ResponseEntity<List<Model>> getAllModel()
	{
		 List<Model> model = modelservice.getAllModel();
		    if (model.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		        return new ResponseEntity<List<Model>>(model, HttpStatus.OK);


	}

	@RequestMapping(value = "/Hello1", method = RequestMethod.POST)
	//public void addModel(@RequestBody Model model) {
	public ResponseEntity<Model> createModel(@RequestBody Model model) {
		modelservice.addmodel(model);
		if ((model.equals(model.getId()))) {
       	 return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		 else
		 {
		return  new ResponseEntity<Model>(HttpStatus.OK); 

	}

	}
	@RequestMapping(value="/Hello1/{id}",method = RequestMethod.GET)
	//public Model getmodel(@PathVariable int id) {
		 public ResponseEntity<Model> getModel(@PathVariable("id") String id) {
		Model model = modelservice.getmodel(id);
		 if (!(id.equals(model.getId()))) {
        	 return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
         }
		 else
		 {
         return new ResponseEntity<Model>(model, HttpStatus.OK);
     }
       
}

	@RequestMapping(value = "/Hello1/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<?> updateModel(@PathVariable("id") String id, @RequestBody Model model) {
	    Model Model = modelservice.getmodel(id);
		 
	        if (!(id.equals(model.getId()))) {
	        	System.out.println("SSS");
	        	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        	
	        }
	        else
	        {
	        	modelservice.updateModel(id, model);
		        return new ResponseEntity<Model>(HttpStatus.OK);
	        }
	        
	 
	        }
	 /*@RequestMapping(value = "/Hello1/{id}", method = RequestMethod.PUT)
	 
	 public void updateModel(@RequestBody Model model,@PathVariable("id") String id){
	  modelservice.addmodel(model);
}*/

	@RequestMapping(value = "/Hello1/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<String> deleteModel(@PathVariable("id") String id) {
		 Model model = modelservice.getmodel(id);
		 
		 if (!(id.equals(model.getId()))) {
		         return new ResponseEntity<String>("Id is not present",HttpStatus.INTERNAL_SERVER_ERROR);
		        }else{
		  modelservice.deleteModelById(id);
		
		  return new ResponseEntity<String>("Id is deleted successfully",HttpStatus.OK);
	    }}
	 
}

