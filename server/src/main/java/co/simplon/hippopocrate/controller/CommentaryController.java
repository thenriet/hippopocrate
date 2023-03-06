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

import co.simplon.hippopocrate.dto.CommentaryDTO;
import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.service.CommentaryService;
import co.simplon.hippopocrate.service.CommentaryServiceImpl;
import co.simplon.hippopocrate.service.UserService;

/**
 * @author Caroline
 *
 */
@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")

public class CommentaryController {

	@Autowired
	private CommentaryServiceImpl csi;
	
	/**
	 * Method to associate a commentary to a Patient files
	 * @param commentaryDTO
	 */
	@PostMapping("suivipatient")
	void addCommentary(@RequestBody CommentaryDTO commentaryDTO) {
		csi.saveCommentary(commentaryDTO);
	}
}