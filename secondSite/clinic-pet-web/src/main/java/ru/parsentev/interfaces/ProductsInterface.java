package ru.parsentev.interfaces;

import ru.parsentev.models.Brands;
import ru.parsentev.models.Products;

import java.util.LinkedList;

/**
 * Created by ainur on 16.11.16.
 */
public interface ProductsInterface {

    public LinkedList<Products>  getlatestProducts ();
    public LinkedList<Brands>  getBrands ();
    public LinkedList<Products>  getAllProducts ();
    public LinkedList<Products>  getProductForSlider ();
    public LinkedList<Products>  getSecondCatProducts (int idSecondCat);
    public void deleteProduct (int id);
    public void updatePruduct (Products product);
    public int   AddProduct (Products product);
    int getCountOfProducts (int idSecondCat);
    Products getProductById (int id);
    public String getImageById (int idproducts, int size);


}
