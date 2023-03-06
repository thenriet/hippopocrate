package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.dto.CommentaryDTO;
import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.repository.CommentaryRepository;
import co.simplon.hippopocrate.repository.PatientRepository;
import co.simplon.hippopocrate.repository.UserRepository;

/**
 * @author Caroline, Ondine
 * File that contained the methods used for the commentaries' management on our website
 *
 */
@Service
public class CommentaryServiceImpl implements CommentaryService {

	@Autowired
	private CommentaryRepository cr;

	@Autowired
	private PatientRepository pr;

	@Autowired
	private UserRepository ur;

	/**
	 * Method to save a commentary from a commentaryDTO object
	 * @param commentaryDTO
	 *
	 */
	@Override
	public void saveCommentary(CommentaryDTO commentaryDTO) {
		Commentary commentary = new Commentary();
		commentary.setId(commentaryDTO.getId());
		commentary.setCommentary(commentaryDTO.getCommentary());
		if(pr.findById(commentaryDTO.getPatientId()).isPresent()) {
			commentary.setPatient(pr.findById(commentaryDTO.getPatientId()).get());
		}
		if(ur.findById(commentaryDTO.getUserId()).isPresent()) {
			commentary.setUser(ur.findById(commentaryDTO.getUserId()).get());
		}
		cr.save(commentary);
	}

	/**
	 * Method to fetch all the commentaries
	 * @return the list of commentaries
	 *
	 */
	@Override
	public List<Commentary> fetchCommentaryList() {
		return cr.findAll();
	}

	/**
	 * Method to update a commentary by its id
	 * @param commentary
	 * @param id
	 *
	 */
	@Override
	public Commentary updateCommentary(Commentary commentary, int id) {
		return null;
	}

	@Override
	public void deleteCommentaryById(int id) {
   // TODO Method is empty because we do not use it but it is mandatory
 }

}