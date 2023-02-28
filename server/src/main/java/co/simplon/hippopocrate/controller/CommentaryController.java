package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.service.CommentaryServiceImpl;


@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")

public class CommentaryController {
	
	@Autowired
	private CommentaryServiceImpl csi;

	@GetMapping("suivipatient/{id}")
	public List<Commentary> fetchCommentaryList() {
		return csi.fetchCommentaryList();
	}

	@PostMapping("suivipatient/{id}")
	void addCommentary(@RequestBody Commentary commentary) {
		csi.saveCommentary(commentary);
	}
	
	@GetMapping("suivipatient/{id}")
	public Commentary findById(@PathVariable int id) {
		return csi.findCommentaryById(id);
	}
//	
//	@GetMapping("suivipatient/:id")
//	public Commentary updateById(@PathVariable long id) {
//		return csi.findCommentaryById(id);
//	}
	
//	@PutMapping("suivipatient/:id")
//	void updateCommentary(@RequestBody Patient patient, @PathVariable long patientId) {
//		System.out.println("je suis là!");
//		psi.updatePatient(patient, patientId);
//	}
}
