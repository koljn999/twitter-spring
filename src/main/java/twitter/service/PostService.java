package twitter.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import twitter.models.Post;
import twitter.models.UserTest;
import twitter.repository.PostRepository;
import twitter.repository.UserRepository;
import twitter.util.CurrentUserHelper;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository=userRepository;
    }

    public boolean addPostCurrentUser(Post post) {
        post.setAuthor(userRepository.findUserByUsername(CurrentUserHelper.getCurrentUser()));
        post.setDataPostsCreated(Instant.now());
        if (postRepository.save(post) instanceof Post) return true;
        else return false;
    }

    public void deletePostCurrentUser(Post post){
        postRepository.delete(post);
    }

    public boolean updatePostCurrentUsers(Post post) {
        if (postRepository.save(post) instanceof Post) return true;
        else return false;
    }

    public List<Post> findAllPostsCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserTest user = userRepository.findUserByUsername(authentication.getName());
        return user.getPosts();
    }
//


}
