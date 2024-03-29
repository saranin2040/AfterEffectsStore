package com.example.demo.tables.author_id;

import com.example.demo.tables.scripts_table.Scripts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    Authors findByName(String name);
}
