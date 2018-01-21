package com.coderkysu.springboot.hsqlexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderkysu.springboot.hsqlexample.model.User;
import com.coderkysu.springboot.hsqlexample.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping(value="/registration")
	public ModelAndView registration() {
		return new ModelAndView("registration", "userForm", new User());
	}
	
	/*
	 * RedirectAttributes
	 * It is a preferred way to pass attributes to redirect target.
	 Using Model attributes for passing redirection data is not always desirable as it may conflict some attributes used for rendering purposes.
	 */
	@PostMapping(value="/registration")
	public ModelAndView registration(@ModelAttribute("userForm") User userForm, RedirectAttributes redirectAtt) {
		userServiceImpl.save(userForm);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/welcome");
		/*
		 - addFlashAttribute() actually stores the attributes in a flashmap
		 (which is internally maintained in the users session and removed once the next redirected request gets fulfilled)

		 - addAttribute() essentially constructs request parameters out of your attributes and redirects to the desired page with the request parameters.

		 So the advantage of addFlashAttribute() will be that you can store pretty much any object in your flash attribute
		 (as it is not serialized into request params at all, but maintained as an object), whereas with addAttribute()
		 since the object that you add gets transformed to a normal request param, you are pretty limited to the object types like String or primitives.
		 * */
		redirectAtt.addFlashAttribute("username", userForm.getUsername());
		return modelAndView;
	}
	
    @GetMapping(value = {"/welcome"})
    public ModelAndView welcome(@ModelAttribute("username") String username) {
        return new ModelAndView("welcome", "username", username);
    }
}
