package com.example.demo.tables.scripts_table;
import com.example.demo.tables.author_id.Authors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "scripts")
public class Scripts {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors nameAuthor) {
        this.author = nameAuthor;
    }

    public String getPathToPicture() {
        return pathToPicture;
    }

    public void setPathToPicture(String pathToPicture) {
        this.pathToPicture = pathToPicture;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "script_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", columnDefinition = "DOUBLE PRECISION")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "name_author", referencedColumnName = "name")
    private Authors author;

    @Column(name = "path_to_picture", columnDefinition = "TEXT")
    private String pathToPicture;

    @Column(name = "path_to_file", columnDefinition = "TEXT")
    private String pathToFile;
}
