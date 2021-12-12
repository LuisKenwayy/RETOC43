package co.luis.kenway.ciclo4.reto33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;



//@EntityScan(basePackages = {"co.usa.edu.ciclo4.reto2.Documents"})
@SpringBootApplication
public class Reto2Application  {

	// @Autowired
    // private productCrudRepository productCrudRepository;
    // @Autowired
    // private UserCrudRepository userCrudRepository;
    // @Autowired
    // private orderCrudRepository orderCrudRepository;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	// SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
    //     // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     productCrudRepository.deleteAll();
    //     userCrudRepository.deleteAll();
    //     orderCrudRepository.deleteAll();
	// }
	


}
