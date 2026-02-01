package model;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "job_appliation")




public class JobApplication {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column(nullable = false)
	private String companyName;
	
	
	@Column(nullable = false)
	private String jobRole;
	
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private JobApplicationStatus status;

	
	private LocalDate appliedDate;

	
	public JobApplication() {
		
	}

}
