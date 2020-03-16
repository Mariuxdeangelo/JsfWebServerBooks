package Books;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class CategoryEditor implements Serializable {
    private static final Logger _logger = Logger.getLogger("CategoryEditor");

    @Inject CategoryService _categoryService;

    @PostConstruct
    private void init() {
        _categories = new ArrayList<>();
        _categories.add(new Category(){{setId(1); setName("Java");}});
        _categories.add(new Category(){{setId(2); setName("Web");}});
    }

    private List<Category> _categories;

    public List<Category> getCategories() {
        return _categories;
    }

    public void setCategories(List<Category> categories) {
        _categories = categories;
    }

    public String addCategory() {
        _categories.add(new Category());
        return "";
    }

    public String deleteCategory(Category category) {
        _categories.remove(category);
        return "";
    }

    public String save(){
        String categories = _categories
                .stream()
                .filter(cat -> !cat.getName().isEmpty())
                .map(cat -> cat.toString())
                .collect(Collectors.joining(", "));
        _logger.log(Level.INFO, "Save categories: {0}", categories);
        return "";
    }
}
