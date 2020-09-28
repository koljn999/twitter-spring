package twitter.сontroller;

import org.springframework.web.bind.annotation.*;
import twitter.models.Post;
import twitter.service.PostService;

import java.util.List;

@RestController
@RequestMapping("account")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAllPostCurrentUsers() {
        return postService.findAllPostsCurrentUser();
    }

    @PostMapping("/addpost")
    public Boolean findAllPostCurrentUsers(@RequestBody Post post) {
        return postService.addPostCurrentUser(post);
    }

    @PostMapping("/deletepost")
    public boolean deletePostCurrentUsers(@RequestBody Post post) {
        postService.deletePostCurrentUser(post);
        return true;
    }

    @PostMapping("/updatepost")
    public boolean updatePostCurrentUsers(@RequestBody Post post) {
       return postService.updatePostCurrentUsers(post);
    }

}
