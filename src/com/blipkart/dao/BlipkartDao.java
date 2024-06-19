package com.blipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.blipkart.connection.BlipkartConnection;
import com.blipkart.dto.AdminDto;
import com.blipkart.dto.CartDto;
import com.blipkart.dto.CustomerDto;
import com.blipkart.dto.ProductDto;
import com.blipkart.dto.SellerDto;

public class BlipkartDao {

	// Queries
	private final String ADMIN_AUTH_DATA = "select * from admin where email=? and pass=?";
	private final String SELLER_AUTH_DATA = "select * from seller where email=? and pass=?";
	private final String CUSTOMER_AUTH_DATA = "select * from customer where email=? and pass=?";
	private final String INSERTSELLERQUERY = "insert into seller(name,email,pass,verify) values (?,?,?,?)";
	private final String INSERTCUSTOMERQUERY = "insert into customer(name, email,pass) values(?,?,?)";
	private final String DISPLAYPRODUCTQUERY = "select * from product";
	private final String DISPLAYSELLERQUERY = "select * from seller";
	private final String DISPLAYCUSTOMERQUERY = "select * from customer";
	private final String UPDATEVERIFYSTATUSQUERY = "update seller set verify='yes' where id=?";
	private final String INSERTPRODUCTQUERY = "insert into product(name,price,mfd,seller) values (?,?,?,?)";
	private final String DISPLAYPRODUCTBYSELLERQUERY = "select * from product where seller=?";
	private final String DELETEPRODUCTDATABYSELLER = "delete from product where id=? and seller=?";
	private final String UPDATE_PRODUCT_NAME_BY_PRODUCT_ID = "update product set name=? where id=? and seller=?";
	private final String UPDATE_PRODUCT_PRICE_BY_PRODUCT_ID = "update product set price=? where id=? and seller=?";
	private final String UPDATE_PRODUCT_MFD_BY_PRODUCT_ID = "update product set mfd=? where id=? and seller=?";
	private final String DISPLAY_SINGLE_PRODUCT = "select * from product where id=?";
	private final String INSERTCARTQUERY=" insert into cart(pid,pname,pprice,pmfd,pquan,pbuyer) values (?,?,?,?,?,?)";
	private final String DISPLAYCARTBYCUSTOMERQUERY="select * from cart where pbuyer=?";
	
	
	Connection connection = BlipkartConnection.getBlipkartConnection();
	PreparedStatement ps;

	public AdminDto authenticateAdminLoginDao(String email, String password) {
		AdminDto adminAuth = null;
		try {
			ps = connection.prepareStatement(ADMIN_AUTH_DATA);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int idTable = resultSet.getInt(1);
				String nameTable = resultSet.getString(2);
				String emailTable = resultSet.getString(3);
				String passTable = resultSet.getString(4);
				adminAuth = new AdminDto(idTable, nameTable, emailTable, passTable);
			}
			return adminAuth;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	public SellerDto authenticateSellerLoginDao(String email, String password) {
		SellerDto sellerAuth = null;
		try {
			ps = connection.prepareStatement(SELLER_AUTH_DATA);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int idTable = resultSet.getInt(1);
				String nameTable = resultSet.getString(2);
				String emailTable = resultSet.getString(3);
				String passTable = resultSet.getString(4);
				String verifyTable = resultSet.getString(5);
				sellerAuth = new SellerDto(idTable, nameTable, emailTable, passTable, verifyTable);
			}
			return sellerAuth;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	public SellerDto saveSellerDao(SellerDto seller) {
		try {
			ps = connection.prepareStatement(INSERTSELLERQUERY);
			ps.setString(1, seller.getName());
			ps.setString(2, seller.getEmail());
			ps.setString(3, seller.getPass());
			ps.setString(4, seller.getVerify());

			ps.execute();
			return seller;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public CustomerDto authenticateCustomerDao(String email, String password) {
		CustomerDto customerAuth = null;
		try {
			ps = connection.prepareStatement(CUSTOMER_AUTH_DATA);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int idTable = resultSet.getInt(1);
				String nameTable = resultSet.getString(2);
				String emailTable = resultSet.getString(3);
				String passTable = resultSet.getString(4);
				customerAuth = new CustomerDto(idTable, nameTable, emailTable, passTable);
			}
			return customerAuth;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

	public CustomerDto saveCustomerDao(CustomerDto customer) {
		try {
			ps = connection.prepareStatement(INSERTCUSTOMERQUERY);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPass());

			ps.execute();
			return customer;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ProductDto> displayAllProductDao() {
		try {
			ps = connection.prepareStatement(DISPLAYPRODUCTQUERY);
			ResultSet resultSet = ps.executeQuery();
			ArrayList<ProductDto> pd = new ArrayList<ProductDto>();
			int i = 0;
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				LocalDate mfd = resultSet.getDate("mfd").toLocalDate(); // this is known as method chaining.
				String seller = resultSet.getString("seller");

				ProductDto product = new ProductDto(id, name, price, mfd, seller);

				pd.add(product);

			}
			return pd;

		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<SellerDto> displayAllSellerDao() {
		try {
			ps = connection.prepareStatement(DISPLAYSELLERQUERY);
			ResultSet resultSet = ps.executeQuery();
			ArrayList<SellerDto> sd = new ArrayList<SellerDto>();
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String pass = resultSet.getString("pass");
				String verify = resultSet.getString("verify");

				SellerDto seller = new SellerDto(id, name, email, pass, verify);

				sd.add(seller);

			}
			return sd;

		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<CustomerDto> displayAllCustomerDao() {
		try {
			ps = connection.prepareStatement(DISPLAYCUSTOMERQUERY);
			ResultSet resultSet = ps.executeQuery();
			ArrayList<CustomerDto> cd = new ArrayList<CustomerDto>();
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String pass = resultSet.getString("pass");

				CustomerDto customer = new CustomerDto(id, name, email, pass);

				cd.add(customer);

			}
			return cd;

		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int verifySellerDao(int id) {
		try {
			ps = connection.prepareStatement(UPDATEVERIFYSTATUSQUERY);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public ProductDto addProductDao(ProductDto product) {
		try {
			ps = connection.prepareStatement(INSERTPRODUCTQUERY);

			ps.setString(1, product.getName());
			ps.setFloat(2, product.getPrice());
			ps.setObject(3, product.getMfd());
			ps.setString(4, product.getSeller());
			ps.execute();
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ProductDto> getProductBySellerDao(String sellerName) {
		try {
			ps = connection.prepareStatement(DISPLAYPRODUCTBYSELLERQUERY);
			ps.setString(1, sellerName);
			ResultSet resultSet = ps.executeQuery();
			ArrayList<ProductDto> pd = new ArrayList<ProductDto>();
			int i = 0;
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				LocalDate mfd = resultSet.getDate("mfd").toLocalDate(); // this is known as method chaining.
				String seller = resultSet.getString("seller");

				ProductDto product = new ProductDto(id, name, price, mfd, seller);

				pd.add(product);

			}
			return pd;

		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int deleteProductBySellerAndIdDao(int id, String sellerName) {
		try {
			ps = connection.prepareStatement(DELETEPRODUCTDATABYSELLER);
			ps.setInt(1, id);
			ps.setString(2, sellerName);
			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int updateProductDetailsByIdDao(String data, int id, int ch, String seller) {
		try {

			switch (ch) {
			case 1: {
				ps = connection.prepareStatement(UPDATE_PRODUCT_NAME_BY_PRODUCT_ID);
				ps.setString(1, data);
				ps.setInt(2, id);
				ps.setString(3, seller);

				return ps.executeUpdate();

			}

			case 2: {
				ps = connection.prepareStatement(UPDATE_PRODUCT_PRICE_BY_PRODUCT_ID);
				float price = Float.parseFloat(data);
				ps.setFloat(1, price);
				ps.setInt(2, id);
				ps.setString(3, seller);

				return ps.executeUpdate();

			}
			case 3: {
				ps = connection.prepareStatement(UPDATE_PRODUCT_MFD_BY_PRODUCT_ID);
				LocalDate mfd = LocalDate.parse(data);
				ps.setObject(1, data);
				ps.setInt(2, id);
				ps.setString(3, seller);
				return ps.executeUpdate();

			}

			default: {
				System.out.println("Wrong input...");
				return 0;
			}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public ProductDto getProductByIdDao(int id) {
		ProductDto product=null;
		try {
			ps = connection.prepareStatement(DISPLAY_SINGLE_PRODUCT);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				int idx = resultSet.getInt("id");
				String name = resultSet.getString("name");
				float price = resultSet.getFloat("price");
				LocalDate mfd = resultSet.getDate("mfd").toLocalDate(); // this is known as method chaining.
				String seller = resultSet.getString("seller");

				product = new ProductDto(id, name, price, mfd, seller);

			}
			return product;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public ProductDto saveIntoCartDao(ProductDto product, String buyer) {
		try {
			
			ps = connection.prepareStatement(INSERTCARTQUERY);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setFloat(3, product.getPrice());
			ps.setObject(4, product.getMfd());
			ps.setInt(5,1);
			ps.setString(6, buyer);

			ps.execute();
			return product;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	public ArrayList<CartDto> getCustomerCartDao(String customerName) {
		try {
			ps = connection.prepareStatement(DISPLAYCARTBYCUSTOMERQUERY);
			ps.setString(1, customerName);
			ResultSet resultSet = ps.executeQuery();
			ArrayList<CartDto> pd = new ArrayList<CartDto>();
			int i = 0;
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				int pid = resultSet.getInt("pid");
				String pname = resultSet.getString("pname");
				float pprice = resultSet.getFloat("pprice");
				LocalDate pmfd = resultSet.getDate("pmfd").toLocalDate(); // this is known as method chaining.
				int pquan = resultSet.getInt("pquan");
				CartDto cart= new CartDto(id, pid,pname,pprice,pmfd, pquan);

				pd.add(cart);

			}
			return pd;

		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	
}