package mari.lookify.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mari.lookify.Models.Lookify;
import mari.lookify.Services.LookifyService;


@Controller

public class LookifyController {
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
//	@RequestMapping("/dashboard")
//	  public String index(Model model, @ModelAttribute("songs") Lookify songs) {
//	      List<Lookify> allSongs = lookifyService.allSongs();
//	      model.addAttribute("lookify", allSongs);
//	      return "dashboard.jsp";
//	}
	
	//TOP TEN
	
	@RequestMapping("/dashboard")
	  public String index(Model model, @ModelAttribute("songs") Lookify songs, @RequestParam(value = "search", required = false) String search) {
		if (search == null) {
		    List<Lookify> allSongs = lookifyService.allSongs();
		    model.addAttribute("lookify", allSongs);
		} else {
	      model.addAttribute("lookify", lookifyService.countByTitleContaining(search));
		}
	      return "dashboard.jsp";
	}
	//TOP TEN ENDS
	
    @RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("songs") Lookify songs, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } else {
            lookifyService.createSong(songs);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("songs") Lookify songs) {
        return "new.jsp";
    }
    
    @RequestMapping("/songs/topTen")
    public String topTen(@ModelAttribute("songs") Lookify songs) {
        return "topten.jsp";
    }
    
    @RequestMapping("/songs/{id}")
    public String showOne(@PathVariable("id") Long id, HttpServletRequest request, Model model) {
    	Lookify aSong = lookifyService.findOne(id);
        model.addAttribute("asong", aSong);
        return "show.jsp";
    }
    
    @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
    	lookifyService.delete(id);
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/songs/delete/{id}")
    public String deleteThis(@PathVariable("id") Long id) {
        lookifyService.delete(id);
        return "redirect:/dashboard";
    }
    
    @RequestMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
    	List<Lookify> search = lookifyService.countByTitleContaining(keyword);
    		model.addAttribute("search", search);
    		model.addAttribute("keyword", keyword);
    		
    		System.out.println(keyword);
    		System.out.println(search);
    	return keyword;
    	}
    
//  @RequestMapping("/songs/{id}/edit")
//  public String edit(@PathVariable("id") Long id, Model model) {
//  	Lookify editOne = lookifyService.findOne(id);
//      model.addAttribute("asong", editOne);
//      return "edit.jsp";
//  }
    
//    @RequestMapping(value="/songs/{id}", method=RequestMethod.PUT)
//	public String update(@Valid @ModelAttribute("songs") Lookify songs, BindingResult result, @PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
//    if (result.hasErrors()) {
//        return "edit.jsp";
//    } else {
//        lookifyService.update(id, title, artist, rating);
//        return "redirect:/dashboard";
//    	}
//    }
}
