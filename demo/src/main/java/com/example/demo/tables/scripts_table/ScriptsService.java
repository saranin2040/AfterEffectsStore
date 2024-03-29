package com.example.demo.tables.scripts_table;

import com.example.demo.tables.author_id.Authors;
import com.example.demo.tables.author_id.AuthorsRepository;
import com.example.demo.tests.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScriptsService {

    @Autowired
    private ScriptsRepository scriptRepository;

    @Autowired
    private AuthorsRepository authorRepository;
    public Scripts addScriptToStore(String name,String description,double price,String authorName,String pathToPicture) {

        Authors author = authorRepository.findByName(authorName);

        Scripts newScript = new Scripts();
        newScript.setName(name);
        newScript.setDescription(description);
        newScript.setPrice(price);
        newScript.setAuthor(author);
        newScript.setPathToPicture(pathToPicture);

        return scriptRepository.save(newScript);
    }

    public void printAllScripts() {
        List<Scripts> scripts = scriptRepository.findAll();
        for (Scripts script : scripts) {
            System.out.println("Name: " + script.getName() +
                    ", Description: " + script.getDescription() +
                    ", Price: " + script.getPrice() +
                    ", NameAuthor: " + (script.getAuthor() != null ? script.getAuthor().getName() : "No author") +
                    ", PathToPicture: " + script.getPathToPicture());
        }
    }

    public String getPrices() {
        List<Scripts> courses = scriptRepository.findAll();
        String s="";
        for(Scripts scripts : courses) {
            s=s+scripts.getPrice()+" ";
            //System.out.println(scripts.getPrice());
        }
        return s;
    }

    public List<Scripts> getAllScripts() {
        return scriptRepository.findAll();
    }
}