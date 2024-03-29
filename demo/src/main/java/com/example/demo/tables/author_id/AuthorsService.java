package com.example.demo.tables.author_id;

import com.example.demo.tables.author_id.Authors;
import com.example.demo.tables.author_id.AuthorsRepository;
import com.example.demo.tables.scripts_table.Scripts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
    @Autowired
    private AuthorsRepository authorRepository;

    public Authors addAuthor(String authorName) {
        Authors newAuthor = new Authors();
        newAuthor.setName(authorName);

        return authorRepository.save(newAuthor);
    }
}
