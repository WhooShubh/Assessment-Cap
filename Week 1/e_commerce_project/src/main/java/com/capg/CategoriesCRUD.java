package com.capg;

public interface CategoriesCRUD {
	void saveCategory(Categories c);

	void updateCategoryName(int id, String name);

	void deleteCategory(int id);

	void findCategory(int id);

	void findAllCategories();
}
