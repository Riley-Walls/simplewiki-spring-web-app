package ca.sheridancollege.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import ca.sheridancollege.beans.Article;
import ca.sheridancollege.beans.Section;
import ca.sheridancollege.dao.DAO;

/*
 * FEATURES:
 * 
 *   - CREATE NEW SECTIONS WITHOUT A PAGE REFRESH WITH JAVASCRIPT!
 *   - DRAG & DROP TO REARRANGE SECTIONS ON THE EDIT PAGE! (BESIDES THE SUMMARY, WHICH IS ALWAYS FIXED)
 *   - CLEAN URLS! %20s ARE INTERCHANGEABLE WITH UNDERSCORES!! (ex. http://localhost:8080/spring/articles/Coral_Castle/view WORKS!)
 *   - VALIDATION CHECKS FOR DUPLICATE ARTICLE NAMES! TRY ENTERING A DUPLICATE ARTICLE NAME!
 */

@Controller
public class HomeController {

	DAO dao = new DAO();

	@GetMapping("/")
	public String home(Model model) {

		List<Article> articles = dao.getAllArticles();
		model.addAttribute("articles", articles);
		return "home";

	}

	@GetMapping("/createNewArticle")
	public String createNewArticle(Model model, @ModelAttribute Article articleFromFailedValidation) {

		if (articleFromFailedValidation.getTitle() == null) {
			// CREATE AN EMPTY OBJECT TO BE USED AS A FORM MODEL
			Article article = new Article();
			Section section = new Section();
			section.setTitle("Summary");

			article.getSections().add(section);

			model.addAttribute("article", article);

		} else {
			model.addAttribute("article", articleFromFailedValidation);
		}
		model.addAttribute("isNew", true);

		return "articleEdit";

	}

	// RedirectAttributes redirectAttributes,
	@PostMapping("/saveArticle")
	public RedirectView saveArticle(Model model, HttpServletRequest req, RedirectAttributes redirectAttributes,
			@ModelAttribute Article article, @RequestParam Optional<ArrayList<Integer>> sectionNum,
			@RequestParam boolean isNew) {

		// VALIDATION--------------------------------------------------------------------

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Article>> constraintViolations = validator.validate(article);

		if (isNew) {
			if (constraintViolations.size() > 0 || dao.getArticleByTitle(article.getTitle()) != null) {
				System.out.println("CONSTRAING VIOLATIONS------------");
				for (ConstraintViolation<Article> violation : constraintViolations) {
					redirectAttributes.addFlashAttribute(
							"error_" + violation.getPropertyPath().toString().replace(".", "_"),
							violation.getMessage().substring(0, 1).toUpperCase() + violation.getMessage().substring(1));
					System.out.println("error_" + violation.getPropertyPath().toString().replace(".", "_"));
				}
				if (dao.getArticleByTitle(article.getTitle()) != null) {
					redirectAttributes.addFlashAttribute("error_title", "An article with this title already exists :(");
				}

				redirectAttributes.addFlashAttribute("article", article);
				return new RedirectView(req.getContextPath() + "/createNewArticle");
			}
		} else {
			// JUST CHECK THE REGULAR CONSTRAINTS - DON'T LOOK FOR DUPLICATE ARTICLES
			if (constraintViolations.size() > 0) {
				System.out.println("CONSTRAING VIOLATIONS------------");
				for (ConstraintViolation<Article> violation : constraintViolations) {
					redirectAttributes.addFlashAttribute(
							"error_" + violation.getPropertyPath().toString().replace(".", "_"),
							violation.getMessage().substring(0, 1).toUpperCase() + violation.getMessage().substring(1));
					System.out.println("error_" + violation.getPropertyPath().toString().replace(".", "_"));
				}
				redirectAttributes.addFlashAttribute("article", article);
				return new RedirectView(
						req.getContextPath() + "/articles/" + article.getTitle().replace(" ", "_") + "/edit");
			}
		}

		// ADD/UPDATE--------------------------------------------------------------------------------

		// EACH SECTION ON THE PAGE HAS A SPRINGFORMS ID.
		// WHEN THE USER SUBMITS, THE SECTIONS WILL BE ADDED TO THE MODEL ORDERED BY
		// THEIR SPRING ID REGARDLESS OF THEIR POSITION ON THE PAGE
		// I HAVE GIVEN EACH SECTION A sectionNum AS WELL. THE SECTIONNUMS MATCH THE
		// SPRING FORMS ID, BUT ARE RETURNED IN THE ORDER THEY APPEARD ON THE PAGE

		// COPY SECTIONS TO A TEMPORARY LIST
		ArrayList<Section> tempSections = new ArrayList<Section>();
		for (Section section : article.getSections()) {
			tempSections.add(section);
		}
		article.getSections().clear();

		// RE-ADD SECTIONS IN THE ORDER OF sectionNumList
		try {
			List<Integer> sectionNumList = sectionNum.get();
			for (Integer num : sectionNumList) {
				article.getSections().add(tempSections.get(num));
			}
		} catch (Exception e) {
		}

		if (isNew) {
			dao.insertArticle(article);
		} else {
			dao.updateArticle(article);
		}

		// model.addAttribute("article", article);

		return new RedirectView(req.getContextPath() + "/articles/" + article.getTitle().replace(" ", "_") + "/view");

	}

	// VIEW OR EDIT ARTICLE
	@GetMapping("/articles/{title}/{mode}")
	public String getArticle(Model model, @PathVariable String title, @PathVariable String mode,
			@ModelAttribute Article articleFromFailedValidation) {

		title = title.replace('_', ' ');
		articleFromFailedValidation.setTitle(articleFromFailedValidation.getTitle().replace('_', ' '));

		try {
			Article article = dao.getArticleByTitle(title);
			model.addAttribute("article", article);

			if (mode.equals("view")) {
				return "articleDisplay";
			} else if (mode.equals("edit")) {
				model.addAttribute("isNew", false);
				if (articleFromFailedValidation.getSections().size() > 0) {
					model.addAttribute("article", articleFromFailedValidation);
				}
				return "articleEdit";
			}

		} catch (Exception e) {
		}

		// IF THE ARTICLE_ID IS INVALID, RETURN TO THE HOME PAGE
		List<Article> articles = dao.getAllArticles();
		model.addAttribute("articles", articles);
		model.addAttribute("isNew", false);
		return "home";
	}

	@GetMapping("/deleteArticle/{title}")
	public RedirectView deleteArticle(Model model, HttpServletRequest req, @PathVariable String title) {

		title = title.replace('_', ' ');

		dao.deleteArticle(title);

		List<Article> articles = dao.getAllArticles();
		// model.addAttribute("articles", articles);
		return new RedirectView(req.getContextPath() + "/");
	}

}
