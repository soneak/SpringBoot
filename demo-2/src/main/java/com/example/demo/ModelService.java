package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ModelService {

	private List<Model> obj = new ArrayList<>(Arrays.asList(new Model("1", "HelloWorld!"),
			
			new Model("2", "how r u doing"),
			new Model("3", "hi how u doing")));
	

	public List<Model> getAllModel() {
		// TODO Auto-generated method stub
		return obj;
	}

	public void addmodel(Model model) {
		// TODO Auto-generated method stub
		obj.add(model);

	}

	public Model getmodel(String id) {
	
		// TODO Auto-generated method stub
	return obj.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//return obj.get(id);
	}

	/*public Model updateModel(Model currentModel) {
		// TODO Auto-generated method stub
		return Model;
	
	}*/
	public String deleteModelById(String id) {
		// TODO Auto-generated method stub
		//return obj.get((int) id);
		
	obj.removeIf(t -> t.getId().equals(id));
	return id+" Deleted Successfully";
	
	
	
	}

	public void updateModel(String id,Model model) {
		// TODO Auto-generated method stub
		for(int i=0; i < obj.size(); i++)
		{
			Model m=obj.get(i);
			if(m.getId().equals(id)){
				obj.set(i,model);
		
			return;
			
		}
		
	}
	
		
		
	}
	}

	
