package com.tushar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
//@Table(name="UID_PRODUCT_TEST")
/*//Upto JAVA7, repeatable annotation not allowed, so use: @NamedQueries  
 * @NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "data_transfer_Product_ProductBKP",  
	        query = "INSERT  INTO PROD_BKP(PID, prodname, price, status, qty)  SELECT  p.PID,  p.prodname, p.price, p.status, p.qty FROM Product p WHERE p.status = ?1"  
	        )  
	    }  
	)  */

/*in XML mapping after class tag closing:
	<query name="data_transfer_Product_ProductBKP">
		<![CDATA[INSERT  INTO PROD_BKP(PID, prodname, price, status, qty)  SELECT  p.PID,  p.prodname, p.price, p.status, p.qty FROM Product p WHERE p.status = ?1]]>
	</querty>
*/


@NamedQuery(name = "data_transfer_Product_ProductBKP",  
								query = "INSERT  INTO PROD_BKP(PID, prodname, price, status, qty)  SELECT  p.PID,  p.prodname, p.price, p.status, p.qty FROM Product p WHERE p.status = ?1"  )


public final class Product  {
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY  )
		private int PID;  */
	
	/*	@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE  )
		private int PID;  */
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.TABLE  )
	private int PID;    */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )
	private int PID; 
	
	//private String PID;  
	@NonNull
	private String prodname;
	@NonNull
	private Double price;
	@NonNull
	private String status;
	@NonNull
	private Integer qty;
	
	public Product() {
		System.out.println("Product ::"+this.hashCode());
	}

	
}