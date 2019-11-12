package telranJava30.post.dto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostNotExistsByAuther extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostNotExistsByAuther(String auther) {
		super("post with id "+auther+"not found");
	}
}
