package peter.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import peter.dao.IUserDao;
import peter.model.User;

@Component
@RequestMapping(value="/")
public class MainPageController {
	@Autowired
	public IUserDao userDao;
	
	private Logger logger = Logger.getLogger(MainPageController.class.getName());

	@RequestMapping(value="/mainPage", method=RequestMethod.GET)
	public String showMainPage(@RequestParam(value="user", required=false) User user, Model model) {	
		model.addAttribute("user", user!=null?user:new User());
		return "mainPage";
	}
	
	@RequestMapping(value="/mainPage", method=RequestMethod.POST)
	public String register(@ModelAttribute("user")  @Valid User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors();
			for(ObjectError oe : bindingResult.getAllErrors()) {
				logger.info(oe.getObjectName() + " " + oe.getCodes()[0]);
			}
			return "mainPage";
		}
		
		userDao.addUser(user);
		return "redirect:mainPage";
	}
	
	@ModelAttribute("users")
	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}
}
