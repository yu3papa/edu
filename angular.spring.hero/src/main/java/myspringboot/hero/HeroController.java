package myspringboot.hero;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/heroes")
public class HeroController {
	private List<Hero> heroes = new ArrayList<>();

	HeroController() {
		buildHeros();
	}

	void buildHeros() {
		heroes.add(new Hero(11L, "정환열"));
		heroes.add(new Hero(12L, "김주희"));
		heroes.add(new Hero(13L, "정유곤"));
		heroes.add(new Hero(14L, "John Doe"));
		heroes.add(new Hero(15L, "Jon Smith"));
		heroes.add(new Hero(16L, "Will Craig"));
		heroes.add(new Hero(17L, "Sam Lernorad"));
		heroes.add(new Hero(18L, "Ross Doe"));
		heroes.add(new Hero(19L, "졍유은"));
		heroes.add(new Hero(20L, "정유민"));
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Hero> getHeros() {
		return this.heroes;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Hero getHero(@PathVariable("id") Long id) {
		return this.heroes.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Hero saveHero(@RequestBody Hero user) {
		Long nextId = 0L;
		if (this.heroes.size() != 0) {
			Hero lastHero = this.heroes.stream().skip(this.heroes.size() - 1).findFirst().orElse(null);
			nextId = lastHero.getId() + 1;
		}
		user.setId(nextId);
		this.heroes.add(user);
		return user;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Hero updateHero(@RequestBody Hero hero) {
		Hero modifiedHero = this.heroes.stream().filter(u -> u.getId() == hero.getId()).findFirst().orElse(null);
		modifiedHero.setName(hero.getName());
		return modifiedHero;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteHero(@PathVariable Long id) {
		Hero deleteHero = this.heroes.stream().filter(hero -> hero.getId() == id).findFirst().orElse(null);
		if (deleteHero != null) {
			this.heroes.remove(deleteHero);
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public List<Hero> searchHero(@PathVariable String name){
		System.out.println("검색요청 값 = " + name);
		return this.heroes.stream()
		.filter(hero -> hero.getName().contains(name))
		.collect(Collectors.toList());
	}
}
