package com.blipkart.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.blipkart.dao.BlipkartDao;
import com.blipkart.dto.AdminDto;
import com.blipkart.dto.CartDto;
import com.blipkart.dto.CustomerDto;
import com.blipkart.dto.ProductDto;
import com.blipkart.dto.SellerDto;

public class BlipkartController {
	public static void main(String[] args) {

		BlipkartDao dao = new BlipkartDao();
		Scanner sc = new Scanner(System.in);
		int welcomeChoice = 0;
		do {
			System.out.println("-----------------------------------------------------");
			System.out.println(
					"		Welcome to BLIPKART...\n1. To access Admin Panel\n2. To Access Seller Panel\n3. To access Customer Panel\n0. To exit");
			welcomeChoice = sc.nextInt();
			switch (welcomeChoice) {

			case 1: {
//					Admin Panel
				System.out.println("---------------Admin Panel--------------\n1. To login\n0. To exit");
				int adminChoice = sc.nextInt();
				switch (adminChoice) {
				case 1: {
//					login panel(admin)
					System.out.println("---------------Login(Admin)--------------");
					System.out.println("Enter email: ");
					String adminEmail=sc.next();
					System.out.println("Enter password: ");
					String adminPass=sc.next();

//					AdminDto valid = dao.authenticateAdminLoginDao("admin", "admin");
					AdminDto valid = dao.authenticateAdminLoginDao(adminEmail,adminPass);
					if (valid != null) {
//						Welcome [Admin Name]
						System.out.println("Welcome Back " + valid.getName() + "...");
						int ch = -1;
						do {
							System.out.println("-----------------------------------------------------");
							System.out.println(
									"1. Verify Seller\n2. Display all products\n3. Display all product owner\n4.Display all customer\n5. Logout");
							ch = sc.nextInt();
							switch (ch) {
							case 1: {
//							Verify Seller
								System.out.println("---------------Verify Seller--------------");
								ArrayList<SellerDto> sellers = dao.displayAllSellerDao();
								if (sellers != null) {
									for (SellerDto seller : sellers) {
										System.out.println(seller);
									}
								}
								System.out.println("Enter id to verify seller: ");
								int adminVerify = sc.nextInt();
								int veri = dao.verifySellerDao(adminVerify);
								if (veri != 0) {
									System.out.println("Seller Verified...");
								} else {
									System.out.println("Seller not verified...");
								}

							}
								break;

							case 2: {
//							Display all products
								System.out.println("---------------Display all products--------------");
								ArrayList<ProductDto> products = dao.displayAllProductDao();
								if (products != null) {
									for (ProductDto product : products) {
										System.out.println(product);
									}
								}

							}
								break;

							case 3: {
//							display all sellers
								System.out.println("---------------Display all sellers--------------");
								ArrayList<SellerDto> sellers = dao.displayAllSellerDao();
								if (sellers != null) {
									for (SellerDto seller : sellers) {
										System.out.println(seller);
									}
								}

							}
								break;

							case 4: {
//							display all customer
								System.out.println("---------------Display all customers--------------");
								ArrayList<CustomerDto> customers = dao.displayAllCustomerDao();
								if (customers != null) {
									for (CustomerDto customer : customers) {
										System.out.println(customer);
									}
								}

							}
								break;
							}
						} while (ch != 5);
					} else {
//						Invalid Id or Password
						System.out.println("Invalid admin Id or Password...");
					}

				}
					break;

				case 0: {
//					break(admin)
					break;
				}
				}
			}
				break;

			case 2: {
//					Seller Panel
				System.out
						.println("---------------Seller Panel--------------\n1. To login\n2. To Register\n0. To exit");
				int sellerChoice = sc.nextInt();
				switch (sellerChoice) {

				case 1: {
					System.out.println("---------------Login(Seller)--------------");
					System.out.println("Enter email: ");
					String adminEmail=sc.next();
					System.out.println("Enter password: ");
					String adminPass=sc.next();

//					SellerDto valid = dao.authenticateSellerLoginDao("googlesilicon@gmail.inc", "sundar");
					SellerDto valid=dao.authenticateSellerLoginDao(adminEmail,adminPass);
					if (valid != null) {
//						Welcome [Seller Name]
						System.out.println("Welcome Back " + valid.getName() + "...");
						int ch = -1;
						do {
							System.out.println("-----------------------------------------------------");
							System.out.println(
									"1. Add Product\n2. Display your products\n3. Delete your product \n4. Update your product \n5. Logout");
							 ch = sc.nextInt();

							switch (ch) {
							case 1: {
//							Add Product
								System.out.println("---------------Add Product--------------");
								System.out.println("Enter Product Name: ");					
								String name = sc.next();
								System.out.println("Enter Product Price: ");
								float price = sc.nextFloat();
								System.out.println("Enter Product MFD (YYYY-MM-DD): ");
								String mfd = sc.next();
								String seller = valid.getName();
								ProductDto product = new ProductDto(name, price, LocalDate.parse(mfd), seller);
								ProductDto product2 = dao.addProductDao(product);
								if(product2!=null) {
									System.out.println("Product added...");
								}
								else {
									System.out.println("Product not added...");
								}

							}
								break;

							case 2: {
//							Display your products
								System.out.println("---------------Display your products--------------");
								ArrayList<ProductDto> products = dao.getProductBySellerDao(valid.getName());
								if (products != null) {
									for (ProductDto product : products) {
										System.out.println(product);
									}
								}

							}
								break;

							case 3: {
//							Delete your product
								System.out.println("---------------Delete your products--------------");
								ArrayList<ProductDto> products = dao.getProductBySellerDao(valid.getName());
								if (products != null) {
									for (ProductDto product : products) {
										System.out.println(product);
									}
									System.out.println("Enter product id you want to delete: ");
									int id = sc.nextInt();
									int value = dao.deleteProductBySellerAndIdDao(id, valid.getName());
									if (value == 1) {
										System.out.println("Data Deleted...");
									} else {
										System.out.println("Data Not Updated...");
									}
								}

							}
								break;

							case 4: {
//							Update your product
								System.out.println("---------------Update your product--------------");
								ArrayList<ProductDto> products = dao.getProductBySellerDao(valid.getName());
								if (products != null) {
									for (ProductDto product : products) {
										System.out.println(product);
									}
								}

								System.out.println("-----------------------------------------------------");
								System.out.println("Enter product id to update student record ");
								int id = sc.nextInt();
								System.out.println(
										"1. To update name\n2. To update price\n3. To update mfd");
								int upCh = sc.nextInt();
								switch (upCh) {
								case 1: {
									System.out.println("Enter new name: ");
									String name = sc.next();

//								check product seller name == seller name whose changing.. only then update data.
									int value = dao.updateProductDetailsByIdDao(name, id, upCh,valid.getName() );
									if (value == 1) {
										System.out.println("Product name updated...");
									} else {
										System.out.println("Product name not updated...");
									}

								}
									break;
								case 2: {
									System.out.println("Enter new price: ");
									String email = sc.next();

									int value = dao.updateProductDetailsByIdDao(email, id, upCh,valid.getName());
									if (value == 1) {
										System.out.println("Product price updated...");
									} else {
										System.out.println("Product price not updated...");
									}

								}
									break;
								case 3: {
									System.out.println("Enter new mfd (YYYY-MM-DD): ");
									String phone = sc.next();

									int value = dao.updateProductDetailsByIdDao(phone, id, upCh,valid.getName());
									if (value == 1) {
										System.out.println("Product mfd updated...");
									} else {
										System.out.println("Product mfd not updated...");
									}

								}
									
								default: {
									System.out.println("Wrong choice...");
								}
									break;

								}

							}
								break;
							

							}
						} while (ch != 5);

					} else {
//						Invalid Id or Password
						System.out.println("Invalid seller Id or Password...");
					}
				}
					break;

				case 2: {
//					register panel(seller)
					System.out.println("---------------Register(Seller)--------------");
					System.out.println("Enter your name: ");					
					String name = sc.next();
					System.out.println("Enter your email: ");
					String email = sc.next();
					System.out.println("Enter your password: ");
					String pass = sc.next();
					SellerDto seller = new SellerDto(name, email, pass, "no");
					SellerDto valid = dao.saveSellerDao(seller);

					if (valid != null) {
						System.out.println("Your account has been created...");
					} else {
						System.out.println("Invalid signup\nTry again...");
					}

				}
					break;

				case 0: {
//					break(seller)
					break;
				}

				}
			}
				break;

			case 3: {
//					Customer Panel
				System.out.println(
						"---------------Customer Panel--------------\n1. To login\n2. To Register \n0. To exit");
				int customerChoice = sc.nextInt();
				switch (customerChoice) {

				case 1: {
//					login panel(customer)

					System.out.println("---------------Login(Customer)--------------");
					System.out.println("Enter email: ");
					String adminEmail=sc.next();
					System.out.println("Enter password: ");
					String adminPass=sc.next();

//					CustomerDto valid = dao.authenticateCustomerDao("r.shiw019@gmail.com", "strong");
					CustomerDto valid=dao.authenticateCustomerDao(adminEmail,adminPass);
					if (valid != null) {
//						Welcome [Customer Name]
						System.out.println("Welcome Back " + valid.getName() + "...");
						int ch=-1;
						do {
							System.out.println("-----------------------------------------------------");
							System.out.println("1. To Display all products \n2. To add product to cart (by ID) \n3. View Your Cart\n5. Logout");
							ch=sc.nextInt();
							switch (ch) {
							case 1:{
//								display product(customer)
								System.out.println("---------------BLIPKART Marketplace--------------");
								ArrayList<ProductDto> products = dao.displayAllProductDao();
								for (ProductDto product : products) {
									if (product != null) {
										System.out.println(product);
									}
								}
								
							}break;
							case 2:{
								
								System.out.println("---------------Add to Cart by ID--------------");
								ArrayList<ProductDto> products = dao.displayAllProductDao();
								if (products != null) {
									for (ProductDto product : products) {
										System.out.println(product);
									}
								}
								System.out.println("Enter product id to add: ");
								int productId=sc.nextInt();
								String buyer=valid.getName();
								ProductDto product= dao.getProductByIdDao(productId);
								if(product!=null) {
									
//									further sending it to customer's cart.
									ProductDto cart=dao.saveIntoCartDao(product, buyer);
									
									if(cart!=null) {
										System.out.println("Product added to your cart...");
									}else {
										System.out.println("Product not added to your cart...");
									}
									
									
									
								}else {
									System.out.println("Product not found...");
								}

								
							}break;
							case 3:{
								System.out.println("---------------View Your Cart--------------");
								ArrayList<CartDto> cart = dao.getCustomerCartDao(valid.getName());
								if (cart != null) {
									for (CartDto product : cart) {
										System.out.println(product);
									}
								}
								
								
							}break;
							}
							
						}while(ch!=5);

					} else {
//						Invalid Id or Password
						System.out.println("Invalid Customer Id or Password...");
					}
				}
					break;

				case 2: {
//					register panel(customer)
					System.out.println("---------------Register(Customer)--------------");
					System.out.println("Enter your name: ");					
					String name = sc.next();
					System.out.println("Enter your email: ");
					String email = sc.next();
					System.out.println("Enter your password: ");
					String pass = sc.next();
					CustomerDto seller = new CustomerDto(name, email, pass);
					CustomerDto valid = dao.saveCustomerDao(seller);

					if (valid != null) {
						System.out.println("Your account has been created...");
					} else {
						System.out.println("Invalid signup\nTry again...");
					}
				}
					break;

				

				case 0: {

					break;
				}

				}
			}
				break;

			}
		} while (welcomeChoice != 0);
		System.out.println("Thankyou for visiting...\nExiting");
		System.out.println("-----------------------------------------------------");
	}

}
