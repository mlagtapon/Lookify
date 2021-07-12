package mari.lookify.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import mari.lookify.Models.Lookify;
import mari.lookify.Services.LookifyService;

@RestController
public class LookifyApi {
	
	private final LookifyService lookifyService;
	
	public LookifyApi(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/api/songs")
    public List<Lookify> all() {
        return lookifyService.allSongs();
    }
	
	
	//SEARCH
//	@RequestMapping("/api/songs/search/")
//    public List<Lookify> searchSong() {
//        return lookifyService.search(String search);
//    }
	//SEARCH ENDS
	
    @RequestMapping(value="/api/songs", method=RequestMethod.POST)
    public Lookify create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
        Lookify song = new Lookify(title, artist, rating);
        return lookifyService.createSong(song);
    }

    @RequestMapping("/api/songs/{id}")
    public Lookify show(@PathVariable("id") Long id) {
        Lookify showOne = lookifyService.findOne(id);
        return showOne;
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.PUT)
    public Lookify update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
        Lookify edit = lookifyService.update(id, title, artist, rating);
        return edit;
    }
    
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public Lookify delete(@PathVariable("id") Long id) {
        Lookify delete = lookifyService.delete(id);
        return delete;
    }
    
//    @RequestMapping("/api/songs/delete/{id}")
//    public Lookify deleteThis(@PathVariable("id") Long id) {
//        Lookify delete = lookifyService.delete(id);
//        return delete;
//    }
}
