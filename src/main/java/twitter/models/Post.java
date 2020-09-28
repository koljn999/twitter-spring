package twitter.models;

import javax.persistence.*;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_username", nullable = false)
    private UserTest author;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Instant dataPostsCreated;

    public Post() {
    }

    public UserTest getAuthor() {
        return author;
    }

    public void setAuthor(UserTest author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getDataPostsCreated() {
        return dataPostsCreated;
    }

    public void setDataPostsCreated(Instant data) {
        this.dataPostsCreated = data;
    }

    public Long getId() {
        return id;
    }

    public Post(UserTest author, String content, Instant data) {
        this.author=author;
        this.content=content;
        this.dataPostsCreated =data;
    }


}
