package telranJava30.post.dau;

import org.springframework.data.repository.CrudRepository;


import telranJava30.post.model.Post;


public interface PostRepository extends CrudRepository<Post, String>{
public Post findByAuther(String auther);
}
