package twitter.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter.models.Post;
import twitter.service.PostService;

import java.util.List;

@RestController
public class PostController {

    public PostController(PostService postService) {

        this.postService = postService;
    }

    private PostService postService;

    @GetMapping("/api/posts")
    public List<Post> findAllBlogs() {
        return postService.findAll();
    }

}
