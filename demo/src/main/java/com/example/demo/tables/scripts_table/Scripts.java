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

    public String getPath_to_picture() {
        return path_to_picture;
    }

    public void setPath_to_picture(String pathToPicture) {
        this.path_to_picture = pathToPicture;
    }

    public String getPath_to_file() {
        return path_to_file;
    }

    public void setPath_to_file(String pathToFile) {
        this.path_to_file = pathToFile;
    }

    public String getYoutube_video_id() {
        return youtube_video_id;
    }

    public void setYoutube_video_id(String youtube_video_id) {
        this.youtube_video_id = youtube_video_id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price", columnDefinition = "DOUBLE PRECISION")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "name")
    private Authors author;

    @Column(name = "path_to_picture", columnDefinition = "TEXT")
    private String path_to_picture;

    @Column(name = "path_to_file", columnDefinition = "TEXT")
    private String path_to_file;

    @Column(name = "youtube_video_id", columnDefinition = "TEXT")
    private String youtube_video_id;
}
