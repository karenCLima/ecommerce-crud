package br.ada.customer.crud.model;

import java.math.BigDecimal;

/**
 * Representação de um item do pedido
 */
public class OrderItem implements Comparable<OrderItem>{

    private Long id;
    private Product product;
    private BigDecimal saleValue;
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

	@Override
	public int compareTo(OrderItem o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);
	}
}
