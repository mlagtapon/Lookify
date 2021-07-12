package mari.lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mari.lookify.Models.Lookify;
import mari.lookify.Repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
	}
	
	public List<Lookify> allSongs(){
		return lookifyRepository.findAll();
	}
	
	public List<Lookify> countByTitleContaining(String search) {
        return lookifyRepository.findByTitleContaining(search);
	}
	
	
	public Lookify createSong(Lookify song) {
		return lookifyRepository.save(song);
	}
	
	public Lookify findOne(Long id) {
		Optional<Lookify> song = lookifyRepository.findById(id);
			if(song.isPresent()) {
				return song.get();
			} else {
				return null;
			}
	}
	
	public Lookify update(Long id, String title, String artist, int rating) {
		Lookify editSong = lookifyRepository.findById(id).get();
			editSong.setTitle(title);
			editSong.setArtist(artist);
			editSong.setRating(rating);
			return lookifyRepository.save(editSong);
	}
	
	public Lookify delete(Long id) {
		lookifyRepository.deleteById(id);
		return null;
	}
}
