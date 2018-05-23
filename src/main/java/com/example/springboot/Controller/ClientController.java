package com.example.springboot.Controller;

import com.example.springboot.Entity.Client;
import com.example.springboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/clients")
	public String index(Model model){
		Iterable<Client> clients = clientRepository.findAll();
		Iterable<Client> testclients = clientRepository.findByLastName("test");

		model.addAttribute("clients", clients);
		model.addAttribute("testclients", testclients);
		model.addAttribute("client", new Client());

		return "index";
	}

	@PostMapping("/clients")
	public String save(@Valid @ModelAttribute Client client, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "index";
		}
		clientRepository.save(client);
		return "redirect:/clients";
	}
}
