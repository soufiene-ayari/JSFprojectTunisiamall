package edu.tunisiamall.biservices;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import edu.tunisiamall.entities.AnonimousRating;
import edu.tunisiamall.entities.Image;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.PromotionSuggest;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.util.Stat;

@Local
public interface IndicatorsServiceLocal {
	public List<Product> getAllProducts();

	public void deleteProd(int id);

	public void addProduct(Product p);

	public HashMap<Product, Integer> getHotProducts();

	public void insertImage(int idProd, String path);

	public List<Product> findProductByLib(String lib);

	public Image getImagesByProduct(int id);

	public void rateProduct(AnonimousRating ar);

	public double getNetGainPercentage(double buyPrice, double sellPrice, double tax);

	public List<Product> getAllPromotionProducts();

	public HashMap<Store, Double> getTopSellingStores();

	public double getTotalIncome();

	public List<Stat> getMonthlyIncome();

	public Product findProductById(int id);

	public Promotion findPromotionById(Long idprom);

	public List<Promotion> getAllPromotions();

	public void createPromotion(Promotion promotion);

	public Store findStoreById(int idStore);

	// report

	public void CreateReport(String name, String mesure, Date startDate, Date endDate);

	public void DeleteReport(String name);

	// promotionsSuggest

	public void createPromotionSuggest(PromotionSuggest promotionSuggest);

	public void deletePromotionSuggest(int idPromotionSuggest);

	public void editPromotionSuggest(PromotionSuggest promotionSuggest);

	public List<PromotionSuggest> getAllPromotionSuggest();

	public PromotionSuggest findPromotionSuggestById(int id);

	public List<PromotionSuggest> findPromotionSuggestByName(String name);

	public void affectPromotionSuggestToProduct(int prod, int prom);

	public void removePromotionSuggestFromProduct(int idproduct);

	public List<Product> getProductsByPromotionSugg(int idSugP);

	public PromotionSuggest findPromotionSuggestByIdProd(int idProd);

}
