package co.simplon.hippopocrate.service;

import java.util.List;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.dto.CommentaryDTO;
import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.repository.CommentaryRepository;
import co.simplon.hippopocrate.repository.PatientRepository;
import co.simplon.hippopocrate.repository.UserRepository;

@Service
public class CommentaryServiceImpl implements CommentaryService {

	@Autowired
	private CommentaryRepository cr;

	@Autowired
	private PatientRepository pr;

	@Autowired
	private UserRepository ur;

	@Override
	public void saveCommentary(CommentaryDTO commentaryDTO) {
		Commentary commentary = new Commentary();
		commentary.setId(commentaryDTO.getId());
		commentary.setCommentary(commentaryDTO.getCommentary());
		commentary.setPatient(pr.findById(commentaryDTO.getPatientId()).get());
		commentary.setUser(ur.findById(commentaryDTO.getUserId()).get());
		System.out.println(commentary);
		cr.save(commentary);
	}

	@Override
	public List<Commentary> fetchCommentaryList() {
		return cr.findAll();
	}

	@Override
	public Commentary updateCommentary(Commentary commentary, int id) {
		return null;
	}

	@Override
	public void deleteCommentaryById(int id) {
	}

}