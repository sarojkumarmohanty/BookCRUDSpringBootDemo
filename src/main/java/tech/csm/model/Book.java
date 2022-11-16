package tech.csm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
@ToString(exclude = "isDeleted")
@Table(name="books")
public class Book implements Serializable {
	
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	private String title;
	
	@Column(name = "book_image_path")
	private String bookImagePath;
	
	@Column(name="author_name")
	private String authorName;
	
	@Column(name = "publisher_id")
	private Integer publisherId;
	
	@Column(name="publication_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date publicationDate;
	
	private Double price;
	@Column(name="is_deleted")
	private String isDeleted;
}
