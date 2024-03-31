package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {

	@Id
	private int Id;
}
