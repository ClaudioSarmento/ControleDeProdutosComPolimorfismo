package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	/*
	 * Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final,
	 * mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.
	 * Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e 
	 * produtos usados possuem data de fabricação. estes dados específicos devem ser acrescentados 
	 * na etiqueta de preço. Para produtos importados, a taxa e alfândega deve ser acrescentada ao preço 
	 * final do produto.
	 */

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Product> product = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #"+(i+1) +" data:");
			System.out.print("Coomon, used or imported (c/u/i)? ");
			char imp = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (imp == 'c') {
				product.add(new Product(name,price));
			}else if(imp == 'i') {
				System.out.print("Customs fee: ");
				Double customsFree = sc.nextDouble();
				product.add(new ImportedProduct(name,price,customsFree));
			}else {
				System.out.print("Manufacture data (DD/MM/YYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, manufactureDate));
			}
		}
		for (Product prod : product) {
			System.out.println("Item: "+prod.priceTag());
		}
		sc.close();
	}

}
