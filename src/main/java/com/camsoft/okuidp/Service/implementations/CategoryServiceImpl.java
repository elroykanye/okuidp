package com.camsoft.okuidp.Service.implementations;

import java.util.List;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camsoft.okuidp.Service.CategoryService;
import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Interest;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.repository.CategoryRepository;
import com.camsoft.okuidp.repository.InterestRepository;
import com.camsoft.okuidp.repository.ProblemRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
      
	  @Autowired
      public CategoryRepository catRepos;
      
      @Autowired
      public InterestRepository intRepos;
      
      @Autowired
      public ProblemRepository probRepos;
	
	@Override
	public Category createCategory(String catName, Long catId) {
		Category categoryFromDbByName = catRepos.findByNameIgnoreCase(catName);
		if(catId > 0) {
			if (!catName.isBlank()) {
				Category categoryFromDbById = catRepos.getReferenceById(catId);
				categoryFromDbById.setName(catName);
				
				catRepos.save(categoryFromDbById);
			}
			
		}else if(categoryFromDbByName != null) {
			return categoryFromDbByName;
		}else {
			if(!catName.isBlank()) {
			    return catRepos.save(new Category(catName));
			}
		}
		return null;
	}

	@Override
	public Category getCategory(Long id) {
		return catRepos.getReferenceById(id);
	}

	@Override
	public Category getCategory(String name) {
		return catRepos.findByNameIgnoreCase(name);
	}

	@Override
	public List<Category> getcategorys() {
		return catRepos.findAll();
	}

	@Override
	public List<Interest> getInterests(Category cat) {
		return intRepos.findByCategory(cat);
	}

	@Override
	public List<Problem> getProblems(Category cat) {
		return probRepos.findByCategory(cat) ;
	}

	@Override
	public void deleteCategorys(List<Long> id) {
		catRepos.deleteAllByIdInBatch(id);;
		
	}

	@Override
	public void deleteCategory(Long id) {
		catRepos.deleteById(id);
	}

	@Override
	public void deleteCategory(String name) {
		catRepos.deleteByNameIgnoreCase(name);
	}

}
