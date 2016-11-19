package ru.parsentev.store;

import ru.parsentev.interfaces.ProductsInterface;
import ru.parsentev.models.*;
import ru.parsentev.service.Settings;

import java.io.File;
import java.sql.*;
import java.util.LinkedList;

/**
 * Created by ainur on 16.11.16.
 */
public class ProductsStorage implements ProductsInterface {

    private final  int Show_By_Default = 6;
    private final int Show_By_Slider = 4;
    private final Connection connection;

    LinkedList<Products> products ;


    public ProductsStorage() {
        this.products= new LinkedList<>();

        final Settings settings = Settings.getInstance();
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public LinkedList<Products> getlatestProducts() {
        LinkedList<Products> products = new LinkedList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from products WHERE status = 1 ORDER BY idproducts DESC LIMIT "+Show_By_Default+"")) {
            // statement.setInt(1, count);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {


                    products.add(new Products(rs.getInt("idproducts"), rs.getString("name"),
                            rs.getDouble("price"), rs.getString("description"), rs.getString("characteristic"),
                            rs.getInt("is_new") ,rs.getInt("is_recommended"), rs.getInt("status") ,
                            rs.getInt("second_category_idsecond_cat"),rs.getInt("second_category_main_category_idmain_cat"), rs.getString("brand"), rs.getInt("skidka")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public LinkedList<Brands> getBrands() {
        LinkedList<Brands> brands = new LinkedList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from brands limit "+ this.Show_By_Default +"")) {


            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    brands.add(new Brands(rs.getInt("idbrands"),rs.getString("name")));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;

    }

    @Override
    public LinkedList<Products> getAllProducts() {
        LinkedList<Products> products = new LinkedList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from products ")) {

            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {


                    products.add(new Products(rs.getInt("idproducts"), rs.getString("name"),
                            rs.getDouble("price"), rs.getString("description"), rs.getString("characteristic"),
                            rs.getInt("is_new") ,rs.getInt("is_recommended"), rs.getInt("status") ,
                            rs.getInt("second_category_idsecond_cat"),rs.getInt("second_category_main_category_idmain_cat"),
                            rs.getString("brand"), rs.getInt("skidka")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;



    }

    @Override
    public LinkedList<Products> getProductForSlider() {
        LinkedList<Products> products = new LinkedList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from products where is_recommended =1 limit "+ this.Show_By_Slider +"")) {


            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    products.add(new Products(rs.getInt("idproducts"), rs.getString("name"),
                            rs.getDouble("price"), rs.getString("description"), rs.getString("characteristic"),
                            rs.getInt("is_new") ,rs.getInt("is_recommended"), rs.getInt("status") ,
                            rs.getInt("second_category_idsecond_cat"),rs.getInt("second_category_main_category_idmain_cat"),
                            rs.getString("brand"), rs.getInt("skidka")));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public LinkedList<Products> getSecondCatProducts(int idSecondCat) {
        LinkedList<Products> products = new LinkedList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from products where second_category_idsecond_cat=(?) limit "+ this.Show_By_Default +"")) {
            statement.setInt(1, idSecondCat);

            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    products.add(new Products(rs.getInt("idproducts"), rs.getString("name"),
                            rs.getDouble("price"), rs.getString("description"), rs.getString("characteristic"),
                            rs.getInt("is_new") ,rs.getInt("is_recommended"), rs.getInt("status") ,rs.getInt("second_category_idsecond_cat"),rs.getInt("second_category_main_category_idmain_cat"), rs.getString("brand"),rs.getInt("skidka")));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public void deleteProduct(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("delete from products where idproducts=(?)")) {
            statement.setInt(1, id);
            statement.executeUpdate(); // выполняем запрос
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePruduct(Products product) {
        // испоьзуем подготовленный запрос
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE products set  name = (?) , price = (?), description =(?), characteristic=(?),  is_new=(?), is_recommended=(?), status=(?), second_category_idsecond_cat=(?), second_category_main_category_idmain_cat=(?) where idproducts= (?)", Statement.RETURN_GENERATED_KEYS)) {
            // Statement.RETURN_GENERATED_KEYS для автоинкрмента
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getCharacteristic());
            statement.setInt(5, product.getIsNew());
            statement.setInt(6, product.getIsRecommended());
            statement.setInt(7, product.getStatus());
            statement.setInt(8, product.getIdSecond());
            statement.setInt(9, product.getIdMain());
            statement.setInt(10, product.getIdproducts());
            statement.executeUpdate(); // выполняем запрос

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int AddProduct(Products product) {
        // испоьзуем подготовленный запрос
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into products ( name , price, description,characteristic, is_new, is_recommended, status, second_category_idsecond_cat, second_category_main_category_idmain_cat) values (?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            // Statement.RETURN_GENERATED_KEYS для автоинкрмента
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getCharacteristic());
            statement.setInt(5, product.getIsNew());
            statement.setInt(6, product.getIsRecommended());
            statement.setInt(7, product.getStatus());
            statement.setInt(8, product.getIdSecond());
            statement.setInt(9, product.getIdMain());
            statement.executeUpdate(); // выполняем запрос
            // statement.getGeneratedKeys() возвращает id добавленного
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new product");
    }

    @Override
    public int getCountOfProducts(int idSecondCat) {
        LinkedList<Products> products = new LinkedList<>();

        try (final PreparedStatement statement = this.connection.prepareStatement("select count(idproducts) as 'count' from products where second_category_idsecond_cat=(?) ")) {
            statement.setInt(1, idSecondCat);

            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt("count");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;


    }

    @Override
    public Products getProductById(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from products where idproducts=(?)")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return  new Products(rs.getInt("idproducts"), rs.getString("name"),
                            rs.getDouble("price"), rs.getString("description"), rs.getString("characteristic"),
                            rs.getInt("is_new") ,rs.getInt("is_recommended"), rs.getInt("status") ,
                            rs.getInt("second_category_idsecond_cat"),rs.getInt("second_category_main_category_idmain_cat"),
                            rs.getString("brand"),rs.getInt("skidka"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Product %s does not exists", id));


    }

    @Override
    public String getImageById(int idproducts, int size) {

           String noImage = "no-image.jpg";
         String path = "/uploads/images/products";
            // Путь к изображению товара
            switch (size) {
                case 1:
                    path = path+"/big/";
                    break;
                case 2:
                    path = path+"/middle/";
                    break;
                case 3:
                    path = path+"/small/";
                    break;

                default:
                    path = path+"/middle/";
                    break;
            }
        String path_to_image = path + String.valueOf(idproducts+ ".jpg");
                File f = new File("/home/ainur/IdeaProjects/secondSite/clinic-pet-web/src/main/webapp/"+path_to_image);
            if (f.exists()) {
                // Если изображение для товара существует
                // Возвращаем путь изображения товара

                return path_to_image;
            }

            // иначе Возвращаем путь изображения-пустышки
            return path+noImage;


    }
    public void setPathesProductsImages (LinkedList<Products> products, int size) {
        for (Products prod : products
                ) {
            prod.setImagePathes(this.getImageById(prod.getIdproducts(), size));// берем пути для каждого продукта для картинов
        }
    }
}
