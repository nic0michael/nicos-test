package za.co.nico.testapp.controllers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import za.co.nico.testapp.businesslogic.NicosThingsLogicProcessor;
import za.co.nico.testapp.businesslogic.EmployeeServiceManager;
import za.co.nico.testapp.dtos.NicosThingRequest;
import za.co.nico.testapp.model.NicosThing;
import za.co.nico.testapp.model.NicosThing;
import za.co.nico.testapp.model.Employee;
import za.co.nico.testapp.utils.RequestResponseUtils;

@Controller
@RequestMapping("/nicos-app/nicosthings")
public class NicosThingController {
	private static final Logger log = LoggerFactory.getLogger(NicosThingController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	


	@Autowired
	NicosThingsLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<NicosThing> nicosThings = processor.listAllNicosThingsSortedByName();
		model.addAttribute("nicosThingsList", nicosThings);
		return "nicosthings/list-nicosthings";
		
	}
	

	@GetMapping(value = "/new")
	public String newNicosThings(Model model) {		
		NicosThingRequest request =processor.newNicosThing();
		model.addAttribute("nicosThingsRequest", request);
		return "nicosthings/new-nicosthing";		
	}

	@PostMapping(value = "/save")
	public String saveNicosThings(NicosThingRequest request,Model model) {
		List<NicosThing> nicosThings =processor.save(request);
		model.addAttribute("nicosThingsList", nicosThings);
		return "nicosthings/list-nicosthings";
	}
	


	@PostMapping(value = "/update")
	public String updatesaveNicosThings(NicosThingRequest request,Model model) {		
		List<NicosThing> nicosThings = processor.update(request);
		model.addAttribute("nicosThingsList", nicosThings);
		return "nicosthings/list-nicosthings";
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long nicosThingsId,Model model) {
		NicosThingRequest request = processor.verander(nicosThingsId);
		List<NicosThing> nicosThings = processor.listAllNicosThingsSortedByName();
		model.addAttribute("nicosThingsRequest", request);
		model.addAttribute("supplierList", nicosThings);
		return "nicosthings/edit-nicosthing";
	}
	
	
	@GetMapping("/maakdood")
	public String deleteNicosThings(@RequestParam(value = "id") Long nicosThingsId,Model model) {
		processor.deleteNicosThings(nicosThingsId);
		return listall(model) ;		
	}
}
