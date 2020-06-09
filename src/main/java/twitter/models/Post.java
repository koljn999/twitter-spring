package twitter.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date data = new Date();

    public Post() {
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }




    public Post(User author, String content, Date data) {
        this.author=author;
        this.content=content;
        this.data=data;
    }


}
