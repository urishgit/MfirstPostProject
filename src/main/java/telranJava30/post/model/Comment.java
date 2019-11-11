package telranJava30.post.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Comment {
String user;
@Setter
String message;
LocalDate createDate;
int likes;
}
