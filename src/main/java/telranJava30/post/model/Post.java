package telranJava30.post.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "id")
@Document(collation = "posts")
public class Post {
	@Id
String id;
	@Setter
String title;
	@Setter
String content;
	@Setter
String auther;
LocalDate created;
@Setter
Map<String, String>tags;
@Setter
int likes;
@Setter
List<Comment>comments;
public Post( String title, String content, Map<String, String>tags) {
	this.title = title;
	this.content = content;
this.tags=new HashMap<String, String>();
	comments =new ArrayList<>();
	auther="";
}

public int addlike(int likes)
{
	return likes++;
}

public List<Comment>  addComment(Comment comment)
{
	comments.add(comment);
    return comments;
}

}
