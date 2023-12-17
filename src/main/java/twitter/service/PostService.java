package twitter.service;


import twitter.models.Post;
import twitter.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter.reposetory.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void blogPostAdd(User author, String content,  Date data) {
        Post post = new Post(author, content, data);
        postRepository.save(post);
    }

    public void blogPostDelete(long id){
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
    }

    public void blogPostUpdate(long id, User author, String content,  Date data) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setAuthor(author);
        post.setContent(content);
        post.setData(data);
        postRepository.save(post);
    }

    public List<Post> findAll() {

        return postRepository.findAll();
    }



}
