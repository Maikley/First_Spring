package worlds;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	final VisitsRepository visitsRepository;
	
	public IndexController(VisitsRepository visitsRepository) {
		this.visitsRepository=visitsRepository;
	}
@GetMapping("/")
public ModelAndView index() {
	Map<String, String> model=new HashMap<>();
	model.put("name", "Mikhail");
	
	Visit visit=new Visit();
	visit.Description=String.format("Visited at %s", LocalDateTime.now());
	visitsRepository.save(visit);
	return new ModelAndView("index",model);
}
}
