package peter.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping(value="/")
public class CreepyController {
	private Logger logger = Logger.getLogger(CreepyController.class.getName());

	@RequestMapping(value="/creepy", method=RequestMethod.GET)
	public String showCreepy() {	
		logger.info("show creepy");
		return "creepy";
	}
}
